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

    <div>
        ${user.username}
    </div>
    <div>
        ${user.password}
    </div>
    <div>
        <#if user.name??>
            <i>${user.name}</i>
        <#else>
            <i>None</i>
        </#if>
    </div>
    <div>
        <#if user.surname??>
            <i>${user.surname}</i>
        <#else>
            <i>None</i>
        </#if>
    </div>
    <div>
        <#if user.middleName??>
            <i>${user.middleName}</i>
        <#else>
            <i>None</i>
        </#if>
    </div>

</@page_tmp.page>