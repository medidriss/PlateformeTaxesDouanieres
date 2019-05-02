<%@ include file="taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mes Simulations</title>
 
</head>
<body>
<%@ include file="menuSimulation.jspf"%>
<f:form method="get"  modelAttribute="simulations"> 

<table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
  <thead>
  
    <tr>
      <th class="th-sm">Numéro Simulation

      </th>
      <th class="th-sm"> Nom Simulation

      </th>
       <th class="th-sm"> Date création

      </th>
        <th class="th-sm"> Montant total

      </th>
        <th class="th-sm"> Modifier

      </th> 
       <th class="th-sm"> Supprimer

      </th> 
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${simulations.mesSimulations }" var="item">
    <tr>
      <td> ${item.idSimulation }  </td>   
      <td> ${item.nomSimulation }</td>
      <td> ${item.dateSimulation }</td>
        <td> ${item.montantTotale }</td>
        
        
              <td>  <a href="chercherNomenclature?simulation.idSimulation=${item.idSimulation }"  class="btn btn-primary" role="button">Modifier Simulation </a>     
               </td>
        
      <td> <a href="#" class="btn btn-info" role="button">Supprimer</a> </td>

    </tr>
    </c:forEach>
 
 
</tbody>
</table>
</f:form>
</body>
</html>