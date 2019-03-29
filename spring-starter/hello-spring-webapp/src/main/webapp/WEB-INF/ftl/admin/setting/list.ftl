<!DOCTYPE html>
<html>
<head>
<#include "/includes/html-head.ftl">
</head>
<body>
<#include "/includes/header.ftl">
<div class="container">
    <div class="app-content">
        <h1>Setting List View</h1>

        <#if message??>
            <p class="alert alert-success">${message}</p>
        </#if>

        <p>
            <a href="${app.contextPath}/admin/setting/create"><span title="Create" class="glyphicon glyphicon-plus" aria-hidden="true"></span> Create</a>
        </p>

        <table class="table">
            <tr>
                <td>ID</td>
                <td>Category</td>
                <td>Name</td>
                <td>Value</td>
                <td>Type</td>
                <td>Actions</td>
            </tr>
            <#list plist.list as setting>
                <tr>
                    <td>${setting.settingId!''}</td>
                    <td>${setting.category!''}</td>
                    <td>${setting.name!''}</td>
                    <td>${setting.value!''}</td>
                    <td>${setting.type!''}</td>
                    <td>
                        <a href="${app.contextPath}/admin/setting/detail/${setting.settingId}"><span title="Detail" class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span> View</a>
                        <a href="${app.contextPath}/admin/setting/edit/${setting.settingId}"><span title="Edit" class="glyphicon glyphicon-edit" aria-hidden="true"></span> Edit</a>
                        <a href="${app.contextPath}/admin/setting/delete/${setting.settingId}"><span title="Delete" class="glyphicon glyphicon-remove" aria-hidden="true"></span> Delete</a>
                    </td>
                </tr>
            </#list>
        </table>

        <!-- Pagination -->
        <ul class="pager">
            <#if plist.paging.offset gt 0 && plist.prevPageOffset gte 0><li><a href="?offset=${plist.prevPageOffset}">Previous Page</a></li></#if>
            <#if plist.more><li><a href="?offset=${plist.nextPageOffset}">Next Page</a></li></#if>
        </ul>
    </div>
<#include "/includes/footer.ftl">
</div>

<#include "/includes/html-tail.ftl">
</body>
</html>
