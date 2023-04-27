<?php
	require "connect.php";

    
	class Album {
        function Album($idalbum,$tenalbum,$tencasialbum,$hinhalbum){
            $this->IdAlbum = $idalbum;
			$this->TenAlbum = $tenalbum;
            $this->TencasiAlbum = $tencasialbum;
            $this->HinhanhAlbum = $hinhalbum;
		}
	}
    
    $arrayalbum = array();
    $query = "SELECT * FROM album";
    $data = mysqli_query($con,$query);
    while($row = mysqli_fetch_assoc($data)){
        array_push($arrayalbum, new Album($row['IdAlbum']
                                            ,$row['TenAlbum']
                                            ,$row['TenCaSiAlbum']
                                            ,$row['HinhAlbum']));
    }
    echo json_encode($arrayalbum);
?>