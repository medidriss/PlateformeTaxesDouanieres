<%@ include file="taglibs.jspf" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ajouter User</title>


</head>

<header align="center"><h3>Sp�cifier les informations </h3></header>
<body>
<br>
<br> <br><br><br><br>
<table class="table" align=center>
    <tr>


        <f:form method="post" modelAttribute="UserModel" action="saveUser">
            <div class="form-group">
                <label>User Name:</label>
                <f:input path="username" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Password:</label>
                <f:password path="password" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Nom:</label>
                <f:input path="nom" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Pr�nom:</label>
                <f:input path="prenom" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="email">Email address:</label>
                <f:input path="email" class="form-control"/>
            </div>

            </div>
            <button type="submit" class="btn btn-primary">Submit</button>


        </f:form>
    </tr>
</table>
</body>
</html>
