<!DOCTYPE html>
<html>
<head>
<#include "/includes/html-head.ftl">
</head>
<body>
<#include "/includes/header.ftl">

<div class="container">
    <div class="app-content">
        <h1>Delete Setting</h1>

        <p>Are you sure you want to delete Setting with ID ${setting.settingId}?</p>

        <form id="setting" class="form-horizontal" method="post" action="${app.contextPath}/admin/setting/delete">
            <input type="hidden" id="settingId" name="settingId" value="${setting.settingId}">
            <div class="form-group">
                <div class="col-sm-12">
                    <button type="submit" class="btn btn-default">Submit</button>
                </div>
            </div>
        </form>
    </div>
<#include "/includes/footer.ftl">
</div>

<#include "/includes/html-tail.ftl">
</body>
</html>
