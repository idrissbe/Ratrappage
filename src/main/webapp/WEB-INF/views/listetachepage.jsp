<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@include file="header.jsp"%>
<%@include file="sidenave.jsp"%>
<div class="row">
	<span>${erreur} ${succes}</span>
	<div class="col s12 l12">
		<div class="row">

			<div id='loadingmessage' style='display: none ;text-align:center'>
			<img alt="Isep"
					src="<%=request.getContextPath()%>/resources/img/loadinggraphic.gif">
			</div>

			<f:form class="col s12 m12 l6 offset-l2 white"
				modelAttribute="listetache" action="saveListeTache" method="post">
				<legend>
					<h4>Listes des Taches</h4>
				</legend>
				<div class="row">
					<div class="input-field col s12 m8 l8">
						<f:input path="listeTacheId" type="text" class="validate"
							readonly="true" />
						<label for="listeTacheId">Liste Tache Id</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12 m8 l8">
						<f:input path="listeTacheName" type="text" class="validate" />
						<label for="listeTacheName">Tache Name</label>
					</div>
				</div>

				<div class="input-field col s12 m8 l8">
					<f:select path="utilisateur.userId" items="${utilisateurlist}"
						itemValue="userId" itemLabel="login"></f:select>
					<label>Utilisateur</label>
				</div>
				<div class="input-field col s12 m8 l8">
					<f:select path="tache.tacheId" items="${tachelist}"
						itemValue="tacheId" itemLabel="tacheName"></f:select>
					<label>Tache</label>
				</div>
				<div class="row">
					<div class="col s12 m18 l8">
						<button class="btn waves-effect waves-light " type="submit"
							name="action">
							Sauvegarder<i class="material-icons right">done</i>
						</button>
					</div>
					<div class="col s12 m18 l8 ">
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
					<h5>Liste des Tâches</h5>
				</legend>
				<div class="col s12 m12 l12">
					<table class="bordered highlight white centered">
						<thead>
							<tr>
								<th>Id Liste des Tâches</th>
								<th>Nom</th>
								<th>Tache</th>
								<th>Utilisateur</th>
								<th>Action</th>
							</tr>
						</thead>
						<c:forEach items="${listetachelist}" var="roleutilisateurlis">
							<tr>
								<td>${roleutilisateurlis.listeTacheId}</td>
								<td>${roleutilisateurlis.listeTacheName}</td>
								<td>${roleutilisateurlis.tache.tacheName}</td>
								<td>${roleutilisateurlis.utilisateur.login}</td>
								<td><a
									href="editListeTache?listeTacheId=${roleutilisateurlis.listeTacheId}">Modification</a></td>
								<td><a
									href="deleteListeTache?listeTacheId=${roleutilisateurlis.listeTacheId}">Suppression</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</f:form>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>