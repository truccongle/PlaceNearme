<?php

	include"connect.php";

	$page= $_GET['page'];

	$iddiadiem=$_POST['idloaidiadiem'];

	$space=5;

	$limit=($page - 1)* $space;

	$mangdiadiem=array();

	$query = "SELECT *FROM diadiem WHERE idloaidiadiem = $iddiadiem LIMIT $limit,$space";

	$data= mysqli_query($conn,$query);

	while ($row = mysqli_fetch_assoc($data)) {

		array_push($mangdiadiem, new DiaDiem(

			$row['ma'],

			$row['ten'],

			$row['hinhanh'],

			$row['diachi'],

			$row['thoigian'],

			$row['sdt'],

			$row['danhgia'],

			$row['latlng'],

			$row['idloaidiadiem']));

	

 }

	echo json_encode($mangdiadiem);

	class DiaDiem{

	function DiaDiem($ma,$ten,$hinhanh,$diachi,$thoigian,$sdt,$danhgia,$latlng,$idloaidiadiem){

		$this->ma=$ma;

		$this->ten=$ten;

		$this->hinhanh=$hinhanh;

		$this->diachi=$diachi;

		$this->thoigian=$thoigian;

		$this->sdt=$sdt;

		$this->danhgia=$danhgia;

		$this->latlng=$latlng;

		$this->idloaidiadiem=$idloaidiadiem;


	}

}

?>