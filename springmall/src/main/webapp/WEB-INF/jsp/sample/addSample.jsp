<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(()=>{
    $('#sampleId').focus();
    $('#add').click(function()=>{
        if($('#sampleId').val()==""){
            alert("INSERT ID");
            $('#sampleId').focus();
        }
        
        if($('#samplePw').val()==""){
            alert("INSERT PW");
            $('#samplePw').focus();
        }
    }
});
 
</script>
<title>AddSample</title>
</head>
<body>
	<div>
		<h1>AddSample</h1>
		<form action="/sample/addSample" method="post">
			<input type="hidden" name="sampleNo" value="0">
			<table class="table table-responsive table-hover">
				<tr>
					<td>ID :</td>
					<td><input type="text" name="sampleId"></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="samplePw"></td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit">submit</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
