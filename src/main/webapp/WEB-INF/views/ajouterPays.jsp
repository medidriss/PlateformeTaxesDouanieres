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

<header  align =center> <h3>Spécifier les informations </h3> </header>
<body >
<br>
<br> <br><br><br><br>
<table class="table"  align ="center" >
<tr>
 

<f:form method="post" modelAttribute="PaysOrigineModel" action="savePays" >
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label >Nom de Pays</label>
        <f:input path="nomPays"  />
      <div class="valid-feedback">
      <f:errors value="PaysOrigineModel.nomPays" class="text-danger" ></f:errors>
      </div>
    </div>
    <div class="col-md-4 mb-3">
      <label>Droit Douane  Préférenciel</label>
     <f:input path="droitDouane"    />
      <div class="valid-feedback">
    
      </div>
    </div>    
  </div> 
    <button class="btn btn-primary" value="Submit">Submit</button>
    
</f:form>
</tr>
</table>
<c:if test="${(PaysOrigineModel.submitted ==true) && (PaysOrigineModel.verif==true)  }">
 <div class="form-row">
 <div class="col-md-4 mb-3">
    
      <div class="alert alert-success">
    <strong>Success!</strong> This alert box could indicate a successful or positive action.
  </div>


</c:if>
<c:if test="${(PaysOrigineModel.submitted ==true) && (PaysOrigineModel.verif==false)  }">
 <div class="form-row">
 <div class="col-md-4 mb-3">
    
      <div class="alert alert-danger">
    <strong>Danger!</strong> This alert box could indicate a dangerous or potentially negative action.
  </div>


</c:if>
 
</body>
</html>
