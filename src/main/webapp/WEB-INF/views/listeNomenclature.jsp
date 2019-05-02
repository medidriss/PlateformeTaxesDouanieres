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
 
</head>
<body>
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
<li  > <a href="listeNomenclature?page=${item}&size=${size}"> ${item }  </a> </li>
 </c:forEach>

</ul>

</div>
</div>
</body>
</html>