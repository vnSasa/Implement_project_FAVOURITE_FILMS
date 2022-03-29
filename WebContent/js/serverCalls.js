
$("button.createProduct")
		.click(
				function() {
					
					var name = $("form.createProduct input.filmName").val();
					var genre = $("form.createProduct input.filmGenre").val();
					var alternativegenre = $("form.createProduct input.filmAlternativeGenre").val();
					var release = $("form.createProduct input.filmRelease").val();
				
						var product = {
								name : name,
								genre : genre,
								alternativegenre : alternativegenre,
								release : release
						};
//add validation
						$.post("product", product,
								function(data) {
									if (data == 'Success') {
										alert('Success');
									}
								});
					
				});


$("button.buy-product").click(function() {
	var productId = jQuery(this).attr("product-id");
	
	
	$.post("bucket", {'productId':productId},
			function(data) {
				if (data == 'Success') {
					$("[data-dismiss=modal]").trigger({ type: "click" });
					alert('Success');
				}
			});
});