<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de Login</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">

<h1>Iniciar Sesión</h1>
<form action="/webapp-cookie/login" method="post">
  <div class="row mb-3">
    <label for="username"  class="col-form-label col-sm-2">Username: </label>
    <div class="col-sm-4">
      <input type="text" name="username" id="username" class="form-control" >
    </div>
  </div>
  <div class="row mb-3">
    <label for="password" class="col-form-label col-sm-2">Password: </label>
    <div  class="col-sm-4">
      <input type="text" name="password" id="password" class="form-control">
    </div>
  </div>
  <div class="row mb-3">
    <div class="col col-7">
    <input type="submit" value="Login" class="btn btn-primary">
    </div>
  </div>
</form>
</div>
</body>
</html>