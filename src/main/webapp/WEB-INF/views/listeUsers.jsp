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

<f:form method="get" modelAttribute="UserModel" > 

<table  class="table table-striped table-bordered table-sm"  >
  <thead>
  
    <tr>
      <th class="th-sm">User Name

      </th>
      <th class="th-sm">Role

      </th>
      
      
        <th class="th-sm"> Etat Activation

      </th> 
       <th class="th-sm"> Nom

      </th>
        <th class="th-sm"> Prénom 

      </th>
        <th class="th-sm"> Email

      </th> 
      
  
 
        <th class="th-sm"> Modifier

      </th>  
      
  
        <th class="th-sm"> Supprimer

      </th> 
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${UserModel.listeUsers }" var="item">
    <tr>
      <td> ${item.username }  </td>   
      <td> ${item.role }  </td>     <td> ${item.etatActivation }  </td>     <td> ${item.nom }  </td>     <td> ${item.prenom }  </td>     <td> ${item.email }  </td>     
        
        
              <td> <a href="modifierUserForm?username=${item.username }" class="btn btn-info" role="button">Modifier</a> </td>
        
      <td> <a href="supprimerUser?username=${item.username}" class="btn btn-info" role="button">Supprimer</a> </td>

    </tr>
    </c:forEach>
 <tfoot>
        <tr>
      <th class="th-sm">User Name

      </th>
      <th class="th-sm">Role

      </th>
      
      
        <th class="th-sm"> Etat Activation

      </th> 
       <th class="th-sm"> Nom

      </th>
        <th class="th-sm"> Prénom 

      </th>
        <th class="th-sm"> Email

      </th> 
      
      
   
      
        <th class="th-sm"> Modifier

      </th>  
      
      
        <th class="th-sm"> Supprimer

      </th> 
    </tr>
  </tfoot>
</table>

</f:form>


</body>
</html>