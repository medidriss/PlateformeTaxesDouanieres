<%@ include file="taglibs.jspf"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter Nomenclature</title>

</head>

<header  align =center> <h3>Spécifier les informations   </h3> </header>
<body>

<div class="col-md-6 col-md-offset-3">
<div class="panel panel-primary">
<div class="panel-heading">Ajouter Nomenclature </div>
<div  class="panel-body">
<table class="table"  >
<tr>
 

<f:form method="post" modelAttribute="nomenclature" action="ajouterNomenclature" >
  <div class="form-group">
    <label >Numéro Chapitre :</label>
      <f:select path="chapitre" value="${nomenclature.chapitre}">
          <c:forEach items="${listeChapitres}" var="item">
          <f:option value="${item }"> ${item.numChapitre }</f:option>
            </c:forEach>
        </f:select>
     
  </div>
  
      <span>
     <f:errors  class="text-danger" path="chapitre" ></f:errors>
     </span>
     <br>
    <label >NDP:</label>
     <f:input path="ndp" class="form-control" />
      <div class="valid-feedback">
      contient 11 chiffres
     
      </div>
      
     <span>
     <f:errors  class="text-danger" path="ndp" ></f:errors>
     </span>
     <br>
   <div class="form-group">
    <label>Désignation:</label>
     <f:textarea path="designation" class="form-control" rows="5" />
     
      <div class="valid-feedback">
      description de Nomenclature
      </div>

  </div>
 
   <span>
     <f:errors  class="text-danger" path="designation" ></f:errors>
     </span>
 <br>
    
  <f:button class="btn btn-primary">Submit</f:button>

 
</f:form>
</tr>
</table>
</div></div></div>
</body>
</html>