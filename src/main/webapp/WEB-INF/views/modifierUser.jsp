 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>service</title>
 <link type="text/css" href="<c:url value='css/style.css' />" rel="stylesheet" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script src='<c:url value="static/script.js"></c:url>'></script>
</head>

<header  align =center> <h3>Spécifier les informations  </h3> </header>
<body >
<table>
<tr>
<f:form modelAttribute="UserModel" method="post" action="modifierUser">
  <div class="form-group">
    <label >User Name:</label>
     <f:input path="username" id="username"  value="${UserModel.username }"  class="form-control" />
  </div>
   <div class="form-group">
    <label>Password:</label>
     <f:password path="password"  id="password" value="${userModel.password }"   class="form-control" />
  </div>
   <div class="form-group">
    <label >Nom:</label>
     <f:input path="nom" value="${userModel.nom }"  class="form-control" />
  </div>
   <div class="form-group">
    <label >Prénom:</label>
     <f:input path="prenom" value="${userModel.prenom }"  class="form-control" />
  </div>
  
   <div class="form-group">
    <label for="email">Email address:</label>
     <f:input path="email"  value="${userModel.email }" class="form-control" />
  </div>
  <div class="form-group">
  <label>Sélectione Role:</label>
  <f:select path="role" value="${userModel.role }"  class="form-control">
   <f:option value="ADMIN">ADMIN</f:option>
   <f:option value="CLIENT">CLIENT</f:option>
  
  </f:select>
   
</div>
  <button type="submit" class="btn btn-primary">Submit</button>

 
</f:form>
</tr>
</table>

</body>
</html>
