<#import '../macros/page_tmp.ftlh' as page_tmp>
<#import '../macros/forms_tmp.ftlh' as forms>

<@page_tmp.page>
    <p>
        <a class="btn btn-success mt-5"
           data-bs-toggle="collapse"
           href="#add" role="button"
           aria-expanded="true"
           aria-controls="collapseExample">
            Add new
        </a>
        <a class="btn btn-success mx-3 mt-5"
           data-bs-toggle="collapse"
           href="#delete" role="button"
           aria-expanded="true"
           aria-controls="collapseExample">
            Delete
        </a>
    </p>
    <div class="collapse mt-5" id="add">
        <@forms.post_form "/healthServices/add">
            <div class="row">
                <div class="col-2">
                    <input type="text" class="form-control" placeholder="name" name="name">
                </div>
                <div class="col-2">
                    <input type="number" step="1" class="form-control" placeholder="consultation price" name="consultationPrice">
                </div>
                <div class="col-2">
                    <input type="number" step="1" class="form-control" placeholder="treatment price" name="treatmentPrice">
                </div>
                <div class="col-2">
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </div>
        </@forms.post_form>
    </div>
    <div class="collapse mt-5" id="delete">
        <@forms.post_form "/healthServices/deleteByName">
            <div class="row">
                <div class="col-2">
                    <input type="text" class="form-control" placeholder="name" name="name">
                </div>
                <div class="col-2">
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </div>
        </@forms.post_form>
    </div>

    <table class="table table-primary table-striped mt-5"
           style="width: 50%;
           border-collapse:separate;
           border-radius: 20px">
        <thead>
        <tr>
            <th scope="col" style="border-radius: 20px; width: 40%"><i>NAME</i></th>
            <th scope="col" style="border-radius: 20px"><i>CONSULTATION PRICE</i></th>
            <th scope="col" style="border-radius: 20px"><i>TREATMENT PRICE</i></th>
        </tr>
        </thead>
        <tbody>
        <#list medicalThings as medicalThing>
            <tr>
                <th scope="row" style="border-radius: 20px"><i>${medicalThing.name}</i></th>
                <th style="border-radius: 20px"><i>${medicalThing.consultationPrice}</i></th>
                <td style="border-radius: 20px"><i><b>${medicalThing.treatmentPrice}</b></i></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@page_tmp.page>