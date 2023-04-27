<?php
	require "connect.php";
	
	$query = "SELECT DISTINCT * FROM album ORDER BY rand(" . date("Ymd") . ") LIMIT 4";
	class Album{
	    function Album($idalbum,$tenalbum,$tencasialbum,$hinhalbum){
	        $this->IdAlbum = $idalbum;
	        $this->TenAlbum = $tenalbum;
	        $this->TencasiAlbum = $tencasialbum;
	        $this->HinhanhAlbum = $hinhalbum;
	    }
	}
	
	$arrayalbum = array();
	$data = mysqli_query($con,$query);
	while ($row = mysqli_fetch_assoc($data)) {
	    array_push($arrayalbum, new Album($row['IdAlbum']
	            ,$row['TenAlbum']
	            ,$row['TenCaSiAlbum']
	            ,$row['HinhAlbum']));
	}
	echo json_encode($arrayalbum);
?>