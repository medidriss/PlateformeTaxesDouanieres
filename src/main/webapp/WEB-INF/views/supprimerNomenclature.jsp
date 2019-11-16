<%@ include file="taglibs.jspf" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Supprimer Nomenclature</title>

</head>

<header align="center"><h3>Sp�cifier les informations </h3></header>
<body>

<div class="col-md-6 col-md-offset-3">
    <div class="panel panel-primary">
        <div class="panel-heading">Supprimer Nomenclature</div>
        <div class="panel-body">
            <f:form method="post" modelAttribute="nomenclature" action="supprimerNomenclature">
                <div class="form-group">
                    <label>NDP:</label>
                    <f:input path="ndp" value="${nomenclature.ndp }" class="form-control"/>
                    <div class="valid-feedback">
                        contient 11 chiffres
                        <br>
                        <span>
     <f:errors class="text-danger" path="ndp"></f:errors>
     </span>
                    </div>
                    <f:button class="btn btn-primary">Submit</f:button>
                </div>


            </f:form>
            <label> ${message}</label>

        </div>
    </div>
</div>
</body>
</html>