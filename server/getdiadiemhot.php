<?php
	include"connect.php";
	
	$query = "SELECT *FROM diadiem ORDER BY danhgia DESC LIMIT 6";
	$data= mysqli_query($conn,$query);
	$mangdiadiemhot=array();
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangdiadiemhot, new DiaDiemHot(
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
	echo json_encode($mangdiadiemhot);
	class DiaDiemHot{
	function DiaDiemHot($ma,$ten,$hinhanh,$diachi,$thoigian,$sdt,$danhgia,$latlng,$idloaidiadiem){
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