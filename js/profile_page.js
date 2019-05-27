$(document).ready(function(){

	/*$('#header').accordion({
		collapsible:true,
		animate:300,
		event:'mouseover',
		active:'none',
		heightStyle:true
		icons:{header:'ui-icon-plus',activeHeader:'ui-icon-minus'}
		
	});*/

	$('#home').click(function(){
		window.location.href = "HomePage.jsp";
	});

	$('#custom-button').change(function(){
		readURL(this);
	});

	$('#photo').change(function(){
		readURL(this);
	});	

});

function readURL(input) {

  if (input.files && input.files[0]) {
    var reader = new FileReader();

    reader.onload = function(e) {
      $('#blah').attr('src', e.target.result);
    }

    reader.readAsDataURL(input.files[0]);
  }
}