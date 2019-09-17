// copy
balapaCop("3D Hover Interaction", "rgba(255,255,255,.5)");
$('#hovertableau tr').hover(function() {
	$(this).addClass('hover');
}, function() {
	$(this).removeClass('hover');
});
