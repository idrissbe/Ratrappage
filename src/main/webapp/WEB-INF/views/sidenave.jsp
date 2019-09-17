
<a href="<c:url value ="/j_spring_security_logout"/>"></a>


<div id="modal1" class="modal">
	<div class="row">
		<form class="col s12 m10 l8 offset-l3">
			<div class="row">
				<div class="col s12 m10 l8">
					<div class="input-field col s10 m10 l12">
						<i class="material-icons prefix">account_circle</i> <input
							id="icon_prefix" type="text" class="validate"> <label
							for="icon_prefix">User Name</label>${user}
					</div>
				</div>
			</div>
			
	
			<div class="row">
				<div class="col s12 m10 l8">
					<div class="input-field col s10 m10  l12">
						<i class="material-icons prefix">lock</i> <input id="icon_lock"
							type="password" class="validate"> <label for="icon_lock">Password</label>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col s12 m8 l6">
					<button class="btn waves-effect waves-light " type="submit"
						name="action">
						AUTHENTIFICATION<i class="material-icons right">done</i>
					</button>
				</div>
				<div class="col s12 m8 l6">
					<button class="btn waves-effect waves-light red lighten-1 right"
						type="reset" name="action">
						Reset<i class="material-icons right">replay</i>
					</button>
				</div>
			</div>
		</form>
	</div>
</div>
<ul id="slide-out" class="side-nav">
	
	<!-- Modal Structure -->

	<li><a class="waves-effect red lighten-1"
		href="<%=request.getContextPath()%>/login"><i
			class="material-icons left">power_settings_new</i>Déconnexion</a></li>
			<li><a href ="<%=request.getContextPath()%>/ListeTache/index">Assigner des tâches</a></li>
					<li><a href ="<%=request.getContextPath()%>/Tache/index">Ajouter des tâches</a></li>
					<li><a href ="<%=request.getContextPath()%>//RoleUtilisateur/index">Ajouter un rôle</a></li>
					<li><a href ="<%=request.getContextPath()%>//Utilisateur/index">Compte</a></li>
</ul>