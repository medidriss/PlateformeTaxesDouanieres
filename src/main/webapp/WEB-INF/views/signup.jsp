
<%@ include file="taglibs.jspf"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signup</title>
</head>
<body>



<div class="col-md-6 col-md-offset-3" >
<div class="panel panel-primary">
<div class="panel-heading">Sign Up </div>
<div  class="panel-body">
 
<f:form action="/accounts/new" method="post" modelAttribute="user">
		  <div class="form-group">
    <label >User Name:</label>
     <f:input path="username" class="form-control" />
   <span>
     <f:errors  class="text-danger" path="username" ></f:errors>
     </span>
  </div>

	
   <div class="form-group">
    <label>Password:</label>
     <f:password path="password" class="form-control" />
     <span>
     <f:errors  class="text-danger" path="password" ></f:errors>
     </span>
     <sec:csrfInput />
    </div>
   <div class="form-group">
    <label >Nom:</label>
     <f:input path="nom" class="form-control" />
      <span>
     <f:errors class="text-danger" path="nom" ></f:errors>
     </span>
  </div>
   <div class="form-group">
    <label >Prénom:</label>
     <f:input path="prenom" class="form-control" />
      <span>
     <f:errors  class="text-danger" path="prenom" ></f:errors>
     </span>
  </div>
 
   <div class="form-group">
    <label for="email">Email address:</label>
     <f:input path="email" class="form-control" />
      <span>
     <f:errors  class="text-danger" path="email" ></f:errors>
     </span>
  </div>
   <button type="submit" class="btn btn-primary">Submit</button>

</f:form>
</div></div></div>
</body>
</html>
