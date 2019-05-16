<?php

require_once 'koneksi.php';
if($_SERVER['REQUEST_METHOD'] == 'POST'){

$nama = $_POST['kode'];
$usia = $_POST['nama'];
$domisili = $_POST['alamat'];

$query = "INSERT INTO tbl_minimarket (kode, nama, alamat) VALUES ('$kode','$nama','$alamat')";

$exeQuery = mysqli_query($konek, $query);

echo ($exeQuery) ? json_encode(array('kodemini' =>1, 'pesan' => 'berhasil menambahkan data'))
:	json_encode(array('kodemini' =>2, 'pesan' => 'data gagal ditambahkan'));

} else{
	echo json_encode(array('kodemini' =>101, 'pesan' => 'request tidak valid'));

}

?>

