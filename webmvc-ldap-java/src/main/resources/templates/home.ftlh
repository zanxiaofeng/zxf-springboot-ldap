<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
<h1>Home</h1>
<h2>Welcome to this page!</h2>
<h1>Principal</h1>
<h2>Username: ${principal.getUsername()}</h2>
<h2>Dn: ${principal.getDn()}</h2>
<h1>Authorities</h1>
<#list authorities as authority>
<h2>Role: ${authority.getAuthority()}</h2>
</#list>
<body>
</html>