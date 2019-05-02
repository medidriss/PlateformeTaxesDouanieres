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




<div class="panel panel-primary">
<div class="panel-heading">Les Informations de Simulation </div>
<div  class="panel-body">


 </div>
</div>


  

<div class="panel panel-primary">
<div class="panel-heading">Compléter les Informations  </div>
<div  class="panel-body">  

<div>


<table id="dtBasicExample" class="table table-striped table-bordered table-sm" >
  <thead>
  
    <tr>
      <th class="th-sm">NDP
     
      </th>
      <th class="th-sm">Désignation

      </th>
      <th class="th-sm"> Prix Hors TAXE   

      </th>
       <th class="th-sm">Quantité

      </th>
       <th class="th-sm">Pays Origine 

      </th>
    </tr>
  </thead>
  <tbody>
    
  <c:forEach items="${ pageSimulationUnitaire }" var="elem" varStatus="i" begin="0">
    <tr>
      <td> ${elem.nomenclature.ndp }  </td>   
      <td> ${elem.nomenclature.designation }</td>
      <td> <f:input value="${elem.nomenclature.prixAchat }" path="pageSimulationUnitaire[${i.index }].prixAchat" /> </td>
      <td></td>  
       <td></td>    
        

    </tr>
    </c:forEach>

</table>
</div>

<div>
<ul class="nav nav-pills" >

  <c:forEach items="${ nbPagesSimulationUnitaire }" var="item"  >
<li  > <a href="chercherNomenclature?idSimulation=${idSimulation }&page=${page}&size=${size}&p=${item}&size=${s}"> ${item }  </a> </li>
 </c:forEach>

</ul>
</div>
 
</div>
</div>





   
   
   
   










</body>
</html>