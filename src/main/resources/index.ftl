<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <title>Validity - Duplicate Finder</title>
</head>
<body>
    <h1>Duplicates</h1>
    <ul>
        <#list duplicates as group>
            <#if group?size gt 1>
                <#list group as duplicate>
                    <li>${duplicate}</li>
                </#list>
            </#if>
        </#list>
    </ul>
    <h1>Non Duplicates</h1>
    <ul>
        <#list duplicates as group>
            <#if group?size == 1>
                <#list group as duplicate>
                    <li>${duplicate}</li>
                </#list>
            </#if>
        </#list>
    </ul>
</body>
</html>
