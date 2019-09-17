<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@include file="header.jsp"%>
<%@include file="sidenave.jsp"%>

<div class="row">

	<span>${erreur} ${succes}</span>
	<div class="col s12 l12 ">
		<div class="row">
			<f:form class="col s12 m8 l5 offset-l4 white"
				modelAttribute="utilisateur" action="saveUtilisateur" method="post">
				<legend>
					<h4>Information Utilisateur</h4>
				</legend>
				<div class="row">
					<f:input path="userId" type="text" style="display : none" />
					<div class="input-field col s12 m8 l6">
						<f:input path="login" type="text" class="validate" />
						<label for="login">Login</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12 m8 l6">
						<f:input path="pwd" type="password" class="validate" />
						<label for="pwd">Password</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12 m8 l6">
						<f:select path="roleutilisateur.roleId"
							items="${roleutilisateurlist}" itemValue="roleId"
							itemLabel="roleName"></f:select>
						<label>Type Utilisateur</label>
					</div>

					<div class="input-field col s12 m8 l2">
						<f:select path="actived" type="text" class="validate">
							<f:option value="true">True</f:option>
							<f:option value="false">False</f:option>
						</f:select>
						<label for="activate">Activate</label>
					</div>
				</div>
				<div class="row">
					<div class="col s12 m7 l5 ">
						<button class="btn waves-effect waves-light red lighten-1 right"
							type="reset" name="action">
							Annuler<i class="material-icons right">replay</i>
						</button>
					</div>
					<div class="col s12 m7 l5">
						<button class="btn waves-effect waves-light " type="submit"
							name="action">
							Sauvegarder<i class="material-icons right">done</i>
						</button>
					</div>

				</div>
			</f:form>
		</div>
	</div>
	<div class="row">
		<f:form class="col s12 m12 l12 white">
			<h4>Liste Utilisateur</h4>
			<table class="highlight bordered centered">
				<thead>
					<tr>
						<th>Action</th>
						<th>User Id</th>
						<th>LOGIN</th>
						<th>Password</th>
						<th>Role ID</th>
						<th>Activate</th>
					</tr>
				</thead>
				<c:forEach items="${utilisateurlist}" var="utilisateurlis">
					<tr>

						<td><a href="editUtilisateur?userId=${utilisateurlis.userId}"><i
								class="material-icons">mode_edit</i></a>&nbsp;<a
							href="deleteUtilisateur?userId=${utilisateurlis.userId}"><i
								class="material-icons">delete</i></a></td>
						<td>${utilisateurlis.userId}</td>
						<td>${utilisateurlis.login}</td>
						<td></td>
						<td>${utilisateurlis.roleutilisateur.roleId}</td>
						<td>${utilisateurlis.actived}</td>
					</tr>
				</c:forEach>

			</table>
		</f:form>
	</div>
</div>

<%@include file="footer.jsp"%>