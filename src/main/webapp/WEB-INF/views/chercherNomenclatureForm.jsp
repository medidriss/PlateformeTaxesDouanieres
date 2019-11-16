<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>service</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>

<f:form method="get" modelAttribute="SimulationModel" action="chercherNomenclature">

    <div class="form-group">
        <label>Reherche par NDP :</label>
        <f:input path="rechercheNDP"/>
    </div>

    <div class="form-group">
        <label>Reherche par Mot Cl� :</label>
        <f:input path="rechercheMotCle"/>
    </div>
    <f:button value="chercher" class="btn btn-info">chercher</f:button>
</f:form>

</body>
</html>