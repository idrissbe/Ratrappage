function checkTask(taskId){
	
	$('#loadingmessage').show(); 
	if ($('#tskChk'+taskId).is(":checked"))
	{
		$("#tskChk"+taskId).prop( "checked", false );
	}else{
		$("#tskChk"+taskId).prop( "checked", true );
	}
	var tskChk=$('#tskChk'+taskId).is(":checked") ? true : false;
	console.log(tskChk);
	var jsonobject = {}
	jsonobject["tacheId"] = taskId;
	jsonobject["accomplie"] = tskChk;
	
	$.ajax({
	    type: "post",
	    url: "updateAccomplie", //your valid url
	    contentType: "application/json", //this is required for spring 3 - ajax to work (at least for me)
	    data: JSON.stringify(jsonobject), //json object or array of json objects
	    success: function(result) {
	    	$('#loadingmessage').hide();
	    	console.log(result);
	    },
	    error: function(){
	        alert("Something is wrong, Please contact administrator!!!!");
	    }
	});
}

