
<div class="input-field col s12 m8 l8">
	<f:select path="tache.tacheId" items="${tachelist}" itemValue="tacheId"
		itemLabel="tacheId"></f:select>
	<label>Tache</label>
</div>

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
	<f:select path="tache.tacheId" items="${tachelist}" itemValue="tacheId"
		itemLabel="tacheId"></f:select>
	<label>Tache</label>
</div>
<div class="input-field col s12 m8 l8">
	<f:select path="utilisateur.userId" items="${utilisateurlist}"
		itemValue="userId" itemLabel="userId"></f:select>
	<label>Utilisateur</label>
</div>
<div class="row">
	<div class="col s12 m12 l12">
		<button class="btn waves-effect waves-light " type="submit"
			name="action">
			Sauvegarder<i class="material-icons right">done</i>
		</button>
	</div>
	<div class="col s12 m12 l12 ">
		<button class="btn waves-effect waves-light red lighten-1 right"
			type="reset" name="action">
			Annuler<i class="material-icons right">replay</i>
		</button>
	</div>
</div>