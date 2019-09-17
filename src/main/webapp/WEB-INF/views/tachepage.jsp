<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@include file="header.jsp"%>
<%@include file="sidenave.jsp"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/utility.js"></script>

<div class="row">
	<div class="col s12 l12">
		<div class="row">
			<f:form class="col s12 m12 l6 offset-l2 white" modelAttribute="tache"
				action="saveTache" method="post">
				<legend>
					<h4>Listes des Taches</h4>
				</legend>
				<div class="row">
					<div class="input-field col s12 m8 l8">
						<f:input path="tacheId" type="text" class="validate"
							readonly="true" />
						<label for="tacheId">Tache Id</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12 m8 l8">
						<f:input path="tacheName" type="text" class="validate" />
						<label for="tacheName">Tache Name</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12 m8 l8">
						<f:input path="description" type="text" class="validate" />
						<label for="description">Description</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12 m8 l8">
						<f:input path="dateTache" type="date" class="validate" />
						<label for="dateTache">Date </label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12 m8 l8">
						<f:checkbox path="accomplie" style="left:0px;opacity:100" />
						Validate
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
					<h5>Liste des Tâches</h5>
				</legend>
				<div class="col s12 m12 l12">
					<div id='loadingmessage' style='display: none ;text-align:center'>
						<img alt="Isep"
							src="<%=request.getContextPath()%>/resources/img/loadinggraphic.gif">
					</div>
					<table class="bordered highlight white centered">
						<thead>
							<tr>
								<th>Id Liste des Tâches</th>
								<th>Nom</th>
								<th>Description</th>
								<th>Date</th>
								<th><input type="checkbox"></th>
								<th>Action</th>
							</tr>
						</thead>
						<c:forEach items="${tachelist}" var="roleutilisateurlis">
							<tr>
								<td>${roleutilisateurlis.tacheId}</td>
								<td>${roleutilisateurlis.tacheName}</td>
								<td>${roleutilisateurlis.description}</td>
								<td>${roleutilisateurlis.dateTache}</td>
								<td><input type="checkbox"
									id="tskChk${roleutilisateurlis.tacheId}"
									onchange="this.checked = !this.checked" class="filled-in"
									<c:if test = "${roleutilisateurlis.accomplie == true}"> checked="checked"</c:if> />
									<label for="tskChk${roleutilisateurlis.tacheId}"></label></td>
								<td><a
									href="editTache?tacheId=${roleutilisateurlis.tacheId}">Modification</a></td>
								<td><a
									href="deleteTache?tacheId=${roleutilisateurlis.tacheId}">Suppression</a></td>
								<td><a href="javascript:void(0)"
									onclick="checkTask('${roleutilisateurlis.tacheId}')">Validate</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</f:form>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>