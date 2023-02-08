package ru.sold_out.mynotes.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sold_out.mynotes.dto.AccessRights;
import ru.sold_out.mynotes.dto.AuthorizationInfo;
import ru.sold_out.mynotes.dto.PersonInfo;
import ru.sold_out.mynotes.entities.Person;
import ru.sold_out.mynotes.entities.User;
import ru.sold_out.mynotes.mappingUtils.PersonMappingUtil;
import ru.sold_out.mynotes.mappingUtils.UserMappingUtil;
import ru.sold_out.mynotes.repos.PersonRepo;
import ru.sold_out.mynotes.repos.UserRepo;
import ru.sold_out.mynotes.view_models.UserViewModel;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;
    private final PersonRepo personRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public boolean save(User user, PersonInfo personInfo) {
        if (personInfo.getName().isBlank() ||
                personInfo.getSurname().isBlank() ||
                personInfo.getMiddleName().isBlank()
        ) {
			return false;
        }
        if (user.getPerson() != null) {
            user.getPerson().setName(personInfo.getName());
            user.getPerson().setSurname(personInfo.getSurname());
            user.getPerson().setMiddleName(personInfo.getMiddleName());
            userRepo.save(user);
            return true;
        }
        Person person = PersonMappingUtil.mapToEntity(personInfo);
        Person personUpdated = personRepo.save(person);
        user.setPerson(personUpdated);
        userRepo.save(user);
        return true;
    }

    public boolean save(AuthorizationInfo authorizationInfo, AccessRights accessRights) {
        User userByUsername = userRepo.findByUsername(authorizationInfo.getUsername());
        if (authorizationInfo.getUsername().isBlank()
                || authorizationInfo.getPassword().isBlank()
                || userByUsername != null) {
            return false;
        }
        User user = UserMappingUtil.mapToEntity(authorizationInfo, accessRights);
        user.setActive(true);
        userRepo.save(user);
        return true;
    }

    public boolean save(AuthorizationInfo authorizationInfo) {
        AccessRights accessRights = new AccessRights();
        accessRights.setUSER(true);
        return save(authorizationInfo, accessRights);
    }

    public List<UserViewModel> findAll() {
        return userRepo.findAll()
                .stream()
                .map(UserMappingUtil::mapToViewModel)
                .sorted(Comparator.comparingLong(UserViewModel::getId).reversed())
                .toList();
    }

    public void deleteById(Long id, User user) {
        if (id == null || id.equals(user.getId()))
            return;
        Optional<User> userSearchResult = userRepo.findById(id);
        if (userSearchResult.isEmpty())
            return;
        userRepo.deleteById(id);
    }

    public UserViewModel findByUsername(String username) {
        User user = userRepo.findByUsername(username);
        if (user == null)
            return null;
        return UserMappingUtil.mapToViewModel(user);
    }

    public UserViewModel findById(Long id) {
        if (id == null)
            return null;
        Optional<User> searchResult = userRepo.findById(id);
        if (searchResult.isEmpty())
            return null;
        return UserMappingUtil.mapToViewModel(searchResult.get());
    }

    public void deleteByUsername(String username, User user) {
        User userSearchResult = userRepo.findByUsername(username);
        if (userSearchResult == null || Objects.equals(username, user.getUsername()))
            return;
        userRepo.delete(userSearchResult);
    }

    public UserViewModel mapToViewModel(User user) {
        return UserMappingUtil.mapToViewModel(user);
    }
}
