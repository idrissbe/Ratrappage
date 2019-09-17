function calcDate() {
	var jq = jQuery.noConflict();
	jq(function() {
		jq.post("/grh/Mission/index", {
			setDateDeb : jq("#setDateDeb").val(),
			setDateFin : jq("#setDateFin").val()
		}, function(data) {
			jq("#sum").replaceWith('<span id="sum">' + data + '</span>');
			alert("mande")
		});
	});
}

function add() {
	var jq = jQuery.noConflict();
	jq(function() {
		jq.post("/grh/DemandeConge/index", {
			setDateDeb : jq("#setDateDeb").val(),
			setDateFin : jq("#setDateFin").val(),
		}, function(data) {
			jq("#sum").replaceWith('<span id="sum">' + data + '</span>');
		});
	});
}
function selectionChel() {
	var table = $('#example').DataTable({
		'ajax' : 'https://api.myjson.com/bins/1us28',
		'columnDefs' : [ {
			'targets' : 0,
			'checkboxes' : {
				'selectRow' : true
			}
		} ],
		'select' : {
			'style' : 'multi'
		},
		'order' : [ [ 1, 'asc' ] ]
	});

	// Handle form submission event
	$('#frm-example').on(
			'submit',
			function(e) {
				var form = this;

				var rows_selected = table.column(0).checkboxes.selected();

				// Iterate over all selected checkboxes
				$.each(rows_selected, function(index, rowId) {
					// Create a hidden element
					$(form).append(
							$('<input>').attr('type', 'hidden').attr('name',
									'id[]').val(rowId));
				});

				// FOR DEMONSTRATION ONLY
				// The code below is not needed in production

				// Output form data to a console
				$('#example-console-rows').text(rows_selected.join(","));

				// Output form data to a console
				$('#example-console-form').text($(form).serialize());

				// Remove added elements
				$('input[name="id\[\]"]', form).remove();

				// Prevent actual form submission
				e.preventDefault();
			});
}

//
function makaSelection() {

	var jq = jQuery.noConflict();
	var obj = document.getElementById("nbPeriode");

	var value = obj.options[obj.selectedIndex].value;

	jq(function() {
		jq.post("/grh/Employe/index/", {
			nbPeriode : value
		}, function(data) {
			jq("#mois").replaceWith('<span id="mois">' + data + '</span>');
		});

	});
}

// conge restant

function congeRestant() {
	var jq = jQuery.noConflict();
	var obj = document.getElementById("congeTypeId");
	var obj1 = document.getElementById("employeMatricule");

	var value = obj.options[obj.selectedIndex].value;
	var value1 = obj1.options[obj1.selectedIndex].value1;
	jq(function() {
		jq.post("/grh/DemandeConge/index/", {
			congeTypeId : value,
			employeMatricule : value1,
		}, function(data) {
			jq("#cngerestant").replaceWith(
					'<span id="cngerestant">' + data + '</span>');
		});
	});
}
// fonction prenom

function volana() {
	var jq = jQuery.noConflict();
	jq(function() {
		jq.post("/grh/Employe/index", {
			setDateDebContrat : jq("#setDateDebContrat").val(),
			nbPeriode : jq("#nbPeriode").val(),
		}, function(data) {
			jq("#mois").replaceWith('<span id="mois">' + data + '</span>');
		});
	});
}

function prenom() {

	var jq = jQuery.noConflict();
	var obj = document.getElementById("personnelId");
	var date = document.getElementById("date");

	var value = obj.options[obj.selectedIndex].value;

	jq(function() {
		jq.post("/grh/Employe/index/", {
			personnelId : value
		}, function(data) {
			jq("#prenom").replaceWith('<span id="prenom">' + data + '</span>');
		});
	});
}

function showB() {
	document.getElementById('show').style.display = "block";
}

// Ajout formulaire
function submitForms() {
	$.post($("#formpersonnel").attr("action"), $("#formpersonnel").serialize(),
			function(data) {
				$("#msg").append(data);
				$.post($("#formpersonne").attr("action"), $("#formpersonne")
						.serialize(), function(data) {
					$("#msg").append(data);
				});
			});
}

(function($) {

	$('#setDateDebContrat').change(function() {
		makaSelection();
		volana();
	});
	$('#nbPeriode').change(function() {

		makaSelection();
		volana();
	}) // pour dataTable

	$('#daty').keyup(function() {
		var nb_car = $(this).val().length;
		if (nb_car == 2 || nb_car == 5) {
			$(this).val($(this).val() + '/');
		}
	});

	$('#employeMatricule').change(function() {
		congeRestant();
	});

	// change id empl
	$('#personnelId').change(function() {
		var jq = jQuery.noConflict();
		prenom();

	});
	// champ date
	$('#insertdate').keyup(function() {
		var nb_car = $(this).val().length;
		if (nb_car == 2 || nb_car == 5) {
			$(this).val($(this).val() + '/');
		}
	});
	// insertion date autom

	$('#setDateDeb').change(function() {
		add();
	});

	$('#setDateFin').change(function() {
		add();
	});

	$(function() {

		var table = $('#recherche').DataTable({
			paging : true,
		});

		// debut hight chart

		$('#container1').highcharts({
			chart : {
				type : 'pie',
				options3d : {
					enabled : true,
					alpha : 45,
					beta : 0
				}
			},
			title : {
				text : 'Browser market shares at a specific website, 2017'
			},
			tooltip : {
				pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
			},
			plotOptions : {
				pie : {
					allowPointSelect : true,
					cursor : 'pointer',
					depth : 35,
					dataLabels : {
						enabled : true,
						format : '{point.name}'
					}
				}
			},

			series : [ {
				type : 'pie',
				name : 'Browser share',
				data : [ [ 'Fox', 45.0 ], [ 'IE', 26.8 ], {
					name : 'Chrome',
					y : 12.8,
					sliced : true,
					selected : true
				}, [ 'Safari', 8.5 ], [ 'Opera', 6.2 ], [ 'Others', 0.7 ] ]
			} ]
		});

		// mand tsara aùmzay le iz hehehe

		var window_width = $(window).width();
		// convert rgb to hex value string
		function rgb2hex(rgb) {
			if (/^#[0-9A-F]{6}$/i.test(rgb)) {
				return rgb;
			}
			rgb = rgb.match(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/);
			if (rgb === null) {
				return "N/A";
			}
			function hex(x) {
				return ("0" + parseInt(x).toString(16)).slice(-2);
			}
			return "#" + hex(rgb[1]) + hex(rgb[2]) + hex(rgb[3]);
		}
		$('.dynamic-color .col')
				.each(
						function() {
							$(this)
									.children()
									.each(
											function() {
												var color = $(this).css(
														'background-color'), classes = $(
														this).attr('class');
												$(this).html(
														rgb2hex(color) + " "
																+ classes);
												if (classes.indexOf("darken") >= 0
														|| $(this).hasClass(
																'black')) {
													$(this)
															.css('color',
																	'rgba(255,255,255,.9');
												}
											});
						});
		// Floating-Fixed table of contents
		setTimeout(function() {
			var tocWrapperHeight = 260; // Max height of ads.
			var tocHeight = $('.toc-wrapper .table-of-contents').length ? $(
					'.toc-wrapper .table-of-contents').height() : 0;
			var socialHeight = 95; // Height of unloaded social media in
			// footer.
			var footerOffset = $('body > footer').first().length ? $(
					'body > footer').first().offset().top : 0;
			var bottomOffset = footerOffset - socialHeight - tocHeight
					- tocWrapperHeight;
			if ($('nav').length) {
				$('.toc-wrapper').pushpin({
					top : $('nav').height(),
					bottom : bottomOffset
				});
			} else if ($('#index-banner').length) {
				$('.toc-wrapper').pushpin({
					top : $('#index-banner').height(),
					bottom : bottomOffset
				});
			} else {
				$('.toc-wrapper').pushpin({
					top : 0,
					bottom : bottomOffset
				});
			}
		}, 100);
		// BuySellAds Detection
		var $bsa = $(".buysellads"), $timesToCheck = 3;

		function checkForChanges() {
			if (!$bsa.find('#carbonads').length) {
				$timesToCheck -= 1;
				if ($timesToCheck >= 0) {
					setTimeout(checkForChanges, 500);
				} else {
					var donateAd = $('<div id="carbonads"><span><a class="carbon-text" href="#!" onclick="document.getElementById(\'paypal-donate\').submit();"><img src="images/donate.png" /> Help support us by turning off adblock. If you still prefer to keep adblock on for this page but still want to support us, feel free to donate. Any little bit helps.</a></form></span></div>');
					$bsa.append(donateAd);
				}
			}
		}
		checkForChanges();
		// Github Latest Commiton
		if ($('.github-commit').length) { // Checks if widget div exists
			// (Index only)
			$
					.ajax({
						url : "https://api.github.com/repos/dogfalo/materialize/commits/master",
						dataType : "json",
						success : function(data) {
							var sha = data.sha, date = jQuery
									.timeago(data.commit.author.date);
							if (window_width < 1120) {
								sha = sha.substring(0, 7);
							}
							$('.github-commit').find('.date').html(date);
							$('.github-commit').find('.sha').html(sha).attr(
									'href', data.html_url);
						}
					});
		}
		// Toggle Flow Text
		var toggleFlowTextButton = $('#flow-toggle');
		toggleFlowTextButton.click(function() {
			$('#flow-text-demo').children('p').each(function() {
				$(this).toggleClass('flow-text');
			});
		});
		// Toggle Containers on page
		var toggleContainersButton = $('#container-toggle-button');
		toggleContainersButton.click(function() {
			$('body .browser-window .container, .had-container').each(
					function() {
						$(this).toggleClass('had-container');
						$(this).toggleClass('container');
						if ($(this).hasClass('container')) {
							toggleContainersButton.text("Turn off Containers");
						} else {
							toggleContainersButton.text("Turn on Containers");
						}
					});
		});
		// Detect touch screen and enable scrollbar if necessary
		function is_touch_device() {
			try {
				document.createEvent("TouchEvent");
				return true;
			} catch (e) {
				return false;
			}
		}
		if (is_touch_device()) {
			$('#nav-mobile').css({
				overflow : 'auto'
			});
		}
		// Set checkbox on forms.html to indeterminate
		var indeterminateCheckbox = document
				.getElementById('indeterminate-checkbox');
		if (indeterminateCheckbox !== null)
			indeterminateCheckbox.indeterminate = true;
		// Plugin initialization
		$('.carousel.carousel-slider').carousel({
			full_width : true
		});
		$('.carousel').carousel();
		$('.slider').slider({
			full_width : true
		});
		$('.parallax').parallax();
		$('.modal-trigger').leanModal();
		$('.scrollspy').scrollSpy();
		$('.button-collapse').sideNav({
			'edge' : 'left'
		});

		// datepicker format
		$('.datepicker').pickadate({
			firstDay : 1,
			selectYears : 30,
			format : 'dd/mm/yyyy',
			formatSubmit : 'dd/mm/yyyy',
		// manao ny date actuelle
		// min : true
		});

		$('select').not('.disabled').material_select();
		$('input.autocomplete').autocomplete({
			data : {
				"Apple" : null,
				"Microsoft" : null,
				"Google" : 'http://placehold.it/250x250'
			}
		});
		$('.chips-initial').material_chip({
			readOnly : true,
			data : [ {
				tag : 'Apple',
			}, {
				tag : 'Microsoft',
			}, {
				tag : 'Google',
			} ]
		});
		$('.chips-placeholder').material_chip({
			placeholder : 'Enter a tag',
			secondaryPlaceholder : '+Tag',
		});
		$('.chips').material_chip();

		var timerIn = 200;
		var timerOut = 200;
		$('ul.nav li.dropdown').hover(
				function() {
					$(this).find('> .dropdown-menu').stop(true, true).fadeIn(
							timerIn);
					$(this).addClass('open');
				},
				function() {
					$(this).find('> .dropdown-menu').stop(true, true).fadeOut(
							timerOut);
					$(this).removeClass('open');
				});
	});
})(jQuery);