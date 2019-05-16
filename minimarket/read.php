<?php
require_once 'koneksi.php';
$query = "SELECT * FROM tbl_minimarket ORDER BY alamat";
$result = mysqli_query($konek,$query);

$array = array();
while ($row = mysqli_fetch_assoc($result)){
$array[] = $row;
}

echo ($result) ?
json_encode(array("kodemini" => 1, "result"=>$array)) :
json_encode(array("kodemini" => 0, "pesan"=>"data tidak ditemukan"));
?>