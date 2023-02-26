<#import '../macros/page_tmp.ftlh' as page_tmp>
<#import '../macros/forms_tmp.ftlh' as forms>

<@page_tmp.page>
    <p>
        <a class="btn btn-success mt-5"
           data-bs-toggle="collapse"
           href="#add" role="button"
           aria-expanded="true"
           aria-controls="collapseExample">
            Update Full Name
        </a>
    </p>
    <div class="collapse mt-5" id="add">
        <@forms.post_form "/client/add">
            <div class="row">
                <div class="col-2">
                    <input type="text" class="form-control" placeholder="name" name="name">
                </div>
                <div class="col-2">
                    <input type="text" class="form-control" placeholder="surname" name="surname">
                </div>
                <div class="col-2">
                    <input type="text" class="form-control" placeholder="middleName" name="middleName">
                </div>
                <div class="col-2">
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </div>
        </@forms.post_form>
    </div>
    <img src="https://i.ibb.co/YdxTBN7/image.png"
            <#--src="https://ltdfoto.ru/images/2022/06/11/photo_2022-06-11_01-19-32.jpg"-->
         alt=" "
         style="width: 100px; height: 100px"
         class="rounded-circle"
    />
    <table class="table table-primary table-striped mt-5"
           style="width: 50%;
           border-collapse:separate;
           border-radius: 20px"
        >
        <thead>
        <tr>
            <th scope="col" style="border-radius: 20px; width: auto"><i>Login</i></th>
            <th scope="col" style="border-radius: 20px"><i>Password</i></th>
            <th scope="col" style="border-radius: 20px"><i>Name</i></th>
            <th scope="col" style="border-radius: 20px"><i>SurName</i></th>
            <th scope="col" style="border-radius: 20px"><i>MiddleName</i></th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <th scope="row" style="border-radius: 20px"><i> ${user.username}</i></th>
                <th style="border-radius: 20px"><i>${user.password}</i></th>
                <th style="border-radius: 20px">
                        <#if user.name??>
                            <i>${user.name}</i>
                        <#else>
                            <i>None</i>
                        </#if>
                    </th>
                <th style="border-radius: 20px">
                    <#if user.surname??>
                        <i>${user.surname}</i>
                    <#else>
                        <i>None</i>
                    </#if>
                    </th>
                <th style="border-radius: 20px">
                    <#if user.middleName??>
                        <i>${user.middleName}</i>
                    <#else>
                        <i>None</i>
                    </#if>
                </th>
            </tr>
        </tbody>
    </table>

</@page_tmp.page>