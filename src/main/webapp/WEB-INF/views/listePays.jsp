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
<body>

<f:form method="get" modelAttribute="PaysOrigineModel" > 

<table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
  <thead>
  
    <tr>
      <th class="th-sm">Nom de Pays

      </th>
      <th class="th-sm">Pourcentage Droit Douane % 

      </th>
       <th class="th-sm"> Mettre à jour D.D

      </th>
        <th class="th-sm"> Confirmer la modification

      </th>
        <th class="th-sm"> Supprimer Pays

      </th> 
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${PaysOrigineModel.listePays }" var="item">
    <tr>
      <td> ${item.nomPays }  </td>   
      <td> ${item.droitDouane }</td>
   
        
        
              <td> <a href="modifierPaysOrigineForm?nomPays=${item.nomPays }" class="btn btn-info" role="button">Modifier</a> </td>
        
      <td> <a href="supprimerPaysOrigine?nomPays=${item.nomPays}" class="btn btn-info" role="button">Supprimer</a> </td>

    </tr>
    </c:forEach>
 <tfoot>
     <tr>
      <th class="th-sm">Nom de Pays

      </th>
      <th class="th-sm">Pourcentage Droit Douane % 

      </th>
       <th class="th-sm"> Mettre à jour D.D

      </th>
        <th class="th-sm"> Confirmer la modification

      </th>
        <th class="th-sm"> Supprimer Pays

      </th> 
    </tr>
  </tfoot>
</table>

</f:form>
<c:if test="${(PaysOrigineModel.submitted ==true) && (PaysOrigineModel.verif==true)  }">
 <div class="form-row">
 <div class="col-md-4 mb-3">
    
      <div class="alert alert-success">
    <strong>Success!</strong>
  </div>

</div> </div>
</c:if>
<c:if test="${(PaysOrigineModel.submitted ==true) && (PaysOrigineModel.verif==false)  }">
 <div class="form-row">
 <div class="col-md-4 mb-3">
    
      <div class="alert alert-danger">
    <strong>Erreur!!</strong>
  </div>
</div> </div>

</c:if>
 

</body>
</html>