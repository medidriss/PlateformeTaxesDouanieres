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
<f:form modelAttribute="PaysOrigineModel" method="post" action="savePaysModification">
  <div class="form-group">
    <label >Nom Pays:</label>
    <f:input path="nomPays"  id="nomPays" readonly="true" value="${PaysOrigineModel.nomPays }" class="form-control" />
    <label >Droit Douane:</label>
     <f:input path="droitDouane" id="droitDouane"  value="${PaysOrigineModel.droitDouane }"  class="form-control" />
  </div>
 
   
  <button type="submit" class="btn btn-primary">Submit</button>

 
</f:form>
</tr>
</table>

</body>
</html>
