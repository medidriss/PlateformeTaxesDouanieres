<%@ include file="taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter Simulation</title>

 
</head>
<body>
<%@ include file="menuSimulation.jspf"%>
<sec:authorize access="isAuthenticated()">
<div class="col-md-4">


 

  

<div class="panel panel-primary">
<div class="panel-heading"><h2>Recherche de Nomenclature</h2> </div>
<div  class="panel-body">
<div>
<f:form action="chercherNomenclature" modelAttribute="SimulationModel" method="get">
<div class="form-group">
    <label >Reherche par NDP :</label>
    <f:input path="rechercheNDP"/>
  </div>
 
<f:hidden path="simulation.idSimulation" value="${SimulationModel.simulation.idSimulation }" readonly="true" /> 
<div class="form-group">
    <label >Reherche par Mot Clé  :</label>
     <f:input path="rechercheMotCle"/>
  </div>
  <f:button value="chercher" class="btn btn-info">chercher</f:button>
  </f:form>
  </div>
 </div>
</div>
</div>
<div class="col-md-6">

<div class="container">
<div class="panel panel-primary">
<div class="panel-heading"><h2>Liste des Nomenclatures </h2> </div>
<div  class="panel-body">


<f:form > 

<table id="dtBasicExample" class="table table-striped table-bordered table-sm" >
  <thead>
  
    <tr>
      <th class="th-sm">NDP

      </th>
      <th class="th-sm">Désignation

      </th>
      <th class="th-sm">Add

      </th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${pages}" var="item">
    <tr>
      <td> ${item.ndp }  </td>   
      <td> ${item.designation }</td>
     <td>  <a href="chercherNomenclature?simulation.idSimulation=${SimulationModel.simulation.idSimulation }&rechercheNDP=${item.ndp }"  class="btn btn-info far fa-plus-square style='font-size:36px'" role="button"> </a>     
       </td>
        
        
        

    </tr>
    </c:forEach>

</table>

</f:form>




<div>
<ul class="nav nav-pills" >

  <c:forEach items="${nbPages}" var="item"  >
<li  > <a href="chercherNomenclature?simulation.idSimulation=${SimulationModel.simulation.idSimulation }&rechercheNDP=${SimulationModel.rechercheNDP }&rechercheMotCle=${SimulationModel.rechercheMotCle }&page=${item}&size=${size}&p=${p}&s=${s}"> ${item }  </a> </li>
 </c:forEach>

</ul>
</div>
</div>


</div>
</div>

</div>








  </sec:authorize>
</body>
</html>