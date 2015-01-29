<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Asynchronous file Upload in Java Web Application</title>
<script src="js/jquery-1.4.1.min.js" type="text/javascript"></script>
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<script src="jQuery.AjaxFileUpload.js"></script>


<script lang="Javascript">
$(document).ready(function() {
	
  $('input[type="file"]').ajaxfileupload({
  'action' : 'Upload2',
  'onComplete' : function(response) {
		debugger;
      $('#upload').hide();
      $('#message').show();
                        
      var statusVal = JSON.stringify(response.status);

     if(statusVal == "false")
     {
     $("#message").html("<font color='red'>"+JSON.stringify(response.message)+"</font>");
     }  
     if(statusVal == "true")
     {
     $("#message").html("<font color='green'>"+JSON.stringify(response.message)+"</font>");
     }                  
},
'onStart' : function() {
	debugger;
        $('#upload').show();
        $('#message').hide();
}
});
});
</script>
<style type="text/css">
.centered {
        width: 100%;
        margin-left: auto;
        margin-right: auto;
        text-align: center;
}
</style>
</head>
<body>
<form>
<div class="centered">
        <h4>AJAX Style File upload in Java Web Application</h4>
        <input type="file" name="file" /><br />
        <div id="upload" style="display: none;">Uploading..</div>
        <div id="message"></div>
</div>
</form>
</body>
</html>