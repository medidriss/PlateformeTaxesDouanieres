<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link type="text/css" href="<c:url value='css/style.css' />" rel="stylesheet" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script src='<c:url value="static/script.js"></c:url>'></script>
 <link type="text/css" href="<c:url value='css/style.css' />" rel="stylesheet" />
</head>
<body>
<f:form modelAttribute="SimulationModel"   action="calculer" method="post">
<header> Welcome to Our Service</header>

  code : <f:input path="ndp"/>  </br> 
  quantité :  <f:input path="quantite"/> </br>
  prix :  <f:input path="prix"/>
    pays d'Origine :  <f:input path="paysOrigine"/>
  </br>

  <f:button>Submit </f:button>

</f:form>
<div>
${ SimulationModel.montant} </br>

</div>




</body>
</html>