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

<header  align ="center"> <h3>Spécifier les informations  </h3> </header>
<body>
<br>
<br> <br><br><br><br>
<table class="table"  align ="center" >
<tr>
 

<f:form method="post" modelAttribute="ChapitreModel" action="saveChapitre" >
  <div class="form-group">
    <label >Numéro Chapitre:</label>
     <f:input path="numChapitre" class="form-control" />
      <div class="valid-feedback">
        contient des chiffres
      </div>
  </div>
   <div class="form-group">
    <label>Désignation:</label>
     <f:textarea path="designation" class="form-control" rows="5" />
     
      <div class="valid-feedback">
      description de Chapitre
      </div>
 
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>

 
</f:form>
</tr>
</table>
</body>
</html>