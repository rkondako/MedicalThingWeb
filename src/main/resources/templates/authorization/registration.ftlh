<#import '../macros/page_tmp.ftlh' as page_tmp>
<#import '../macros/tokens.ftlh' as tokens>

<@page_tmp.page>
    <form method="post" action="/register">
        <div class="col-2 mt-5">
            <input type="text" class="form-control" name="username" placeholder="Enter username">
        </div>
        <div class="col-2 mt-4">
            <input type="text" class="form-control" name="password" placeholder="Enter password">
        </div>
        <div class="col-2 my-4">
            <button type="submit" class="btn btn-success"><i>Sign Up</i></button>
        </div>
        <@tokens.csrf_token/>
    </form>
</@page_tmp.page>
