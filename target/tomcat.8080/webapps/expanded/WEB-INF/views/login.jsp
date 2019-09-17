<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<html>
<head>
<title>GESTION RESSOURCES HUMAINES</title>
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/materialize.min.css"
	media="screen,projection" />
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap-material-datetimepicker.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="<%=request.getContextPath()%>/resources/css/materialdesignicons.min.css" />
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/dataTables.material.min.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta charset="utf-8" />

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

</head>
<body>
	<header>
		<div class="row">
			<div class="col s6 m8 l3">
				<img alt="sarylogo"
					src="<%=request.getContextPath()%>/resources/img/grh.svg">
			</div>
		</div>
	</header>
	<main>
	<div class="row">
		<div id="content" class="span">
			<form class="col s12 m12 l4 offset-l4 white"
				action="j_spring_security_check" method="post">
				<div class="row">
					<legend>
						<h5>Connexion</h5>
					</legend>
					<div class="input-field col s10">
						<i class="material-icons prefix">account_circle</i> <input
							id="icon_prefix" type="text" class="validate" name="j_username">
						<label for="icon_prefix">User Name</label>
					</div>
					<div class="input-field col s10">
						<i class="material-icons prefix">lock</i> <input id="icon_lock"
							type="password" class="validate" name="j_password" id="password">
						<label for="icon_lock">Password</label>
					</div>
				</div>
				<div class="row">
					<div class="col s5">
						<button class="btn waves-effect waves-light red lighten-1 right"
							type="reset" name="action">
							Reset<i class="material-icons right">replay</i>
						</button>
					</div>
					<div class="col s5">
						<button class="btn waves-effect waves-light " type="submit"
							name="action">
							AUTHENTIFICATION<i class="material-icons right">done</i>
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<%@include file="footer.jsp"%>