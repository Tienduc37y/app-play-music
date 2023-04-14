<?php
	$hostname= "localhost";
	$username= "id20567998_ducandroid1";
	$password= "Tienduc2002#";
	$databasename= "id20567998_musicplay";

	$con = mysqli_connect($hostname,$username,$password,$databasename);
	mysqli_query($con,"SET NAME 'utf8'");
?>