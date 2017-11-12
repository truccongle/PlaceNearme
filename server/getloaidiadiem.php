<?php
include "connect.php";
$query="SELECT *FROM loaidiadiem";
$data = mysqli_query($conn,$query);
$mangloaidiadiem = array();
while ($row = mysqli_fetch_assoc($data)) {
	array_push($mangloaidiadiem, new LoaiDiaDiem(
		$row['id'],
		$row['loai'],
		$row['hinhanh']	));
}
echo json_encode($mangloaidiadiem);
class LoaiDiaDiem{
	function LoaiDiaDiem($id,$loai,$hinhanh){
		$this->id=$id; 
		$this->loai=$loai;
		$this->hinhanh=$hinhanh;
	
	}
}

?>