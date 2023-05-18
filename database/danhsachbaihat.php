<?php
	require "connect.php";
    
    class Baihat {
        function Baihat($idbaihat,$tenbaihat,$hinhbaihat,$casi,$linkbaihat,$luotthich){
            $this->Idbaihat = $idbaihat;
			$this->Tenbaihat = $tenbaihat;
            $this->Hinhbaihat = $hinhbaihat;
            $this->Casi = $casi;
            $this->Linkbaihat = $linkbaihat;
            $this->Luotthich =  $luotthich;
        }
    }

    $arraydanhsachbaihat = array();
    
    if(isset($_POST['idalbum'])){
        $idalbum = $_POST['idalbum'];
        $query = "SELECT * FROM baihat WHERE FIND_IN_SET('$idalbum',IdAlbum)";
    }
    
    if(isset($_POST['idtheloai'])){
        $idtheloai = $_POST['idtheloai'];
        $query = "SELECT * FROM baihat WHERE FIND_IN_SET('$idtheloai',IdTheLoai)";
    }

    if(isset($_POST['idplaylist'])){
        $idplaylist = $_POST['idplaylist'];
        $query = "SELECT * FROM baihat WHERE FIND_IN_SET('$idplaylist',IdPlaylist)";
    }

    if(isset($_POST['idquangcao'])){
        $idquangcao = $_POST['idquangcao'];
        $queryquangcao = "SELECT * FROM quangcao WHERE Id = '$idquangcao'";
        $dataquangcao = mysqli_query($con,$queryquangcao);
        $rowquangcao = mysqli_fetch_assoc($dataquangcao);
        $id = $rowquangcao['Idbaihat'];
        $query = "SELECT * FROM baihat WHERE IdBaiHat = '$id'";
    }

    $data = mysqli_query($con,$query);
    while($row = mysqli_fetch_assoc($data)){
        array_push($arraydanhsachbaihat, new BaiHat($row['IdBaiHat']
                                            ,$row['TenBaiHat']
                                            ,$row['HinhBaiHat']
                                            ,$row['Casi']
                                            ,$row['LinkBaiHat']
                                            ,$row['LuotThich']));
    }
    echo json_encode($arraydanhsachbaihat);
?>
