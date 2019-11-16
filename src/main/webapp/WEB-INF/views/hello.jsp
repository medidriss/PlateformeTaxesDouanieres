<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>service</title>
    <link type="text/css" href="<c:url value='css/style.css' />" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src='<c:url value="static/script.js"></c:url>'></script>
</head>
<body>
<div class="container">


    <f:form method="post" modelAttribute="username">
        ${username}

    </f:form>
</div>


</body>
</html>