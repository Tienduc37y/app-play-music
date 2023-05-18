<?php
	require "connect.php";
    $query = "SELECT * FROM baihat ORDER BY LuotThich DESC LIMIT 10";
	class BaiHat {
		function BaiHat($idbaihat,$tenbaihat,$hinhbaihat,$casi,$linkbaihat,$luotthich){
			$this->Idbaihat = $idbaihat;
			$this->Tenbaihat = $tenbaihat;
            $this->Hinhbaihat = $hinhbaihat;
            $this->Casi = $casi;
            $this->Linkbaihat = $linkbaihat;
            $this->Luotthich =  $luotthich;
		}
	}

    $arraycasi = array();
    $data = mysqli_query($con,$query);
    while($row = mysqli_fetch_assoc($data)){
        array_push($arraycasi, new BaiHat($row['IdBaiHat']
                                            ,$row['TenBaiHat']
                                            ,$row['HinhBaiHat']
                                            ,$row['Casi']
                                            ,$row['LinkBaiHat']
                                            ,$row['LuotThich']));
    }
    echo json_encode($arraycasi);
?>