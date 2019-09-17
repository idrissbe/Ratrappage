<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@include file="header.jsp"%>
<%@include file="sidenave.jsp"%>

<div class="row">
	<div class="col s12 l12">
		<div class="row">
			<f:form class="col s12 m12 l6 offset-l2 white"
				modelAttribute="roleutilisateur" action="saveRoleUtilisateur"
				method="post">
				<legend>
					<h4>Information Utilisateur</h4>
				</legend>
				<div class="row">
					<div class="input-field col s12 m8 l8">
						<f:input path="roleName" type="text" class="validate" />
						<label for="roleName">Role Name</label>
					</div>
				</div>
				<div class="row">
					<div class="col s12 m7 l5">
						<button class="btn waves-effect waves-light " type="submit"
							name="action">
							Sauvegarder<i class="material-icons right">done</i>
						</button>
					</div>
					<div class="col s12 m7 l5 ">
						<button class="btn waves-effect waves-light red lighten-1 right"
							type="reset" name="action">
							Annuler<i class="material-icons right">replay</i>
						</button>
					</div>
				</div>
			</f:form>
		</div>
		<div class="row">
			<f:form class="col s12 m12 l12  white">
				<legend>
					<h5>Liste Roles Utilisateurs</h5>
				</legend>
				<div class="col s12 l12">
					<table class="bordered highlight white centered">
						<thead>
							<tr>
								<th>Id Role Utilisateur</th>
								<th>Lib Role Utilisateur</th>
								<th>Action</th>
							</tr>
						</thead>
						<c:forEach items="${roleutilisateurlist}" var="roleutilisateurlis">
							<tr>
								<td>${roleutilisateurlis.roleId}</td>
								<td>${roleutilisateurlis.roleName}</td>
								<td><a
									href="editRoleUtilisateur?roleId=${roleutilisateurlis.roleId}">Modification</a></td>
								<td><a
									href="deleteRoleUtilisateur?roleId=${roleutilisateurlis.roleId}">Suppression</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</f:form>
		</div>

	</div>
</div>
<%@include file="footer.jsp"%>
