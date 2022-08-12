<?php mysql_connect('localhost', 'root', '');
mysql_select_db('carRental');


$sql = "SELECT * FROM car where name like '%".$_POST['src']."%';";
$res = mysql_query($sql);

/////

?>