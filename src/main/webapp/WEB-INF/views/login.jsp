<%@ include file="taglibs.jspf"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authentification</title>
</head>
 <body>
<div class="col-md-6 col-md-offset-3" >
<div class="panel panel-primary">
<div class="panel-heading">Authentification </div>
<div  class="panel-body">
<c:if test="${param.error != null}">  
		<p>
		<label  class="control-label" >Invalid username and password.</label>	
		</p>
	</c:if>
	<c:if test="${param.logout != null}"> 
		<p>
		<label  class="control-label" >	You have been logged out.</label>	
		
		</p>
	</c:if>

<form action="/login" method="post">
<div class="form-group">
<label class="control-label">username : </label>
<input type="text" name="username"/>
	
	
</div>
<div class="form-group">
<label class="control-label">password : </label>
<input type="password" name="password"/>
	<sec:csrfInput/>
</div>

<input type="submit" class="btn btn-primary" value="login"/>
</form>

 </div></div>
 </div>
 
</body>
</html>
