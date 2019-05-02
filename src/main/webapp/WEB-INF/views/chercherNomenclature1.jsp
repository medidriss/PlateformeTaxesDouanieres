<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
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
<div class="col-md-6">
<f:form method="get"  modelAttribute="SimulationModel" action="chercherNomenclature" > 

<div class="form-group">
    <label >Reherche par NDP :</label>
    <f:input path="rechercheNDP"/>
  </div>
  
<div class="form-group">
    <label >Reherche par Mot Clé  :</label>
     <f:input path="rechercheMotCle"/>
  </div>
  <f:button value="chercher" class="btn btn-info">chercher</f:button>
</f:form>

 <c:if test="${SimulationModel.notnull==true }">
  <table class="table table-striped table-bordered table-sm">
   <thead>
  
    <tr>
      <th class="th-sm">Nomenclature (NDP)

      </th>
      <th class="th-sm">Designation

      </th>
       <th class="th-sm">Supprimer 

      </th>
       
    </tr>
    </thead>
 <c:forEach  items="${SimulationModel.selectedSimulationsUnitaires }"  var="item"  >

<tr>
<td id="ndpSimulation"> ${item.ndp} </td>
<td id="designationSimulation" > ${item.designation }</td> 
<td><a href="supprimerNdpDuListe?ndp=${item.ndp}" class="btn btn-info" role="button">Supprimer</a> </td>
</tr>


 </c:forEach>
  </table>
 
 </c:if>
</div>
<div class="col-md-6">
<div class="container">
<f:form  > 

<table id="dtBasicExample" class="table table-striped table-bordered table-sm" >
  <thead>
  
    <tr>
      <th class="th-sm">NDP

      </th>
      <th class="th-sm">Désignation

      </th>
     
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${pages}" var="item">
    <tr>
      <td> ${item.ndp }  </td>   
      <td> ${item.designation }</td>
   
        
        
        

    </tr>
    </c:forEach>

</table>

</f:form>
<div>
<ul class="nav nav-pills" >

  <c:forEach items="${nbPages}" var="item"  >
<li  > <a href="chercherNomenclature?rechercheNDP=${SimulationModel.rechercheNDP }&rechercheMotCle=${SimulationModel.rechercheMotCle }&page=${item}&size=${size}"> ${item }  </a> </li>
 </c:forEach>

</ul>

</div>
</div>




</div>
</body>
</html>