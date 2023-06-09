package ru.rkondako.course_work.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;


@Entity

@Getter
@Setter
@NoArgsConstructor

public class Appointment implements Serializable {
    @Serial
    private static final long serialVersionUID = 110;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private LocalTime time;
    //отношения в таблицах
    @ManyToOne
            (
                    fetch = FetchType.LAZY,
                    cascade = {
                            CascadeType.MERGE,
                            CascadeType.DETACH,
                            CascadeType.REFRESH,
                    }
            )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MedicalThing medicalThing;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH,
            }
    )
    private User user;

}
