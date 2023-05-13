<#import '../macros/page_tmp.ftlh' as page_tmp>
<#import '../macros/forms_tmp.ftlh' as forms>


<@page_tmp.page>
    <p>
        <a class="btn btn-success mt-5"
           data-bs-toggle="collapse"
           href="#add" role="button"
           aria-expanded="true"
           aria-controls="collapseExample">
            Add new subject
        </a>
        <a class="btn btn-success mx-3 mt-5"
           data-bs-toggle="collapse"
           href="#delete" role="button"
           aria-expanded="true"
           aria-controls="collapseExample">
            Delete subject
        </a>
    </p>
    <div class="collapse mt-5" id="add">
        <@forms.post_form "/appointment/add">
            <div class="row">
                <div class="col-2">
                    <input type="text" class="form-control" placeholder="health service" name="healthServiceName">
                </div>
                <div class="col-2">
                    <input type="date" class="form-control" placeholder="date" name="data">
                </div>
                <div class="col-2">
                    <input type="time" class="form-control" placeholder="date" name="time">
                </div>
                <div class="col-2">
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </div>
        </@forms.post_form>
    </div>
    <div class="collapse mt-5" id="delete">
        <@forms.post_form "/appointment/deleteById">
            <div class="row">
                <div class="col-2">
                    <input type="number" class="form-control" placeholder="id" name="id">
                </div>
                <div class="col-2">
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </div>
        </@forms.post_form>
    </div>

    <table class="table table-primary table-striped mt-5"
           style="width: 80%;
           border-collapse:separate;
           border-radius: 20px">
        <thead>
        <tr>
            <th scope="col" style="border-radius: 20px; width: 5%"><i style="line-height: 300%">&#x2116;</i></th>
            <th scope="col" style="border-radius: 20px ;width: 20%"><i style="line-height: 300%">Health Service</i>
            </th>
            <th scope="col" style="border-radius: 20px; width: 15%"><i style="line-height: 300%">Login</i></th>
            <th scope="col" style="border-radius: 20px; width: 15%"><i style="line-height: 300%">Name</i></th>
            <th scope="col" style="border-radius: 20px; width: 15%"><i style="line-height: 300%">Surname</i></th>
            <th scope="col" style="border-radius: 20px; width: 15%"><i style="line-height: 300%">MiddleName</i></th>
            <th scope="col" style="border-radius: 20px; width: 15%"><i style="line-height: 300%">Date</i></th>

        </tr>
        </thead>
        <tbody>
        <#list appointments as appointment>
            <tr>
                <td style="border-radius: 20px"><i>${appointment.id}</i></td>
                <th scope="row" style="border-radius: 20px;font-weight: normal"><i>${appointment.medicalThingName}</i>
                </th>
                <th style="border-radius: 20px;font-weight: normal"><i>${appointment.login}</i></th>
                <td style="border-radius: 20px"><i>${appointment.name}</i></td>
                <td style="border-radius: 20px"><i>${appointment.surname}</i></td>
                <td style="border-radius: 20px"><i>${appointment.middleName}</i></td>
                <td style="border-radius: 20px"><i>${appointment.date}</i></td>


            </tr>
        </#list>
        </tbody>
    </table>
</@page_tmp.page>