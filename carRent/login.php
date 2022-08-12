<?php 
mysql_connect('localhost', 'root', '');
mysql_select_db('carfinal');

$sql = "SELECT * FROM user where username='".$_GET['nm']."'and password='".$_GET['ps']."';";
//echo "$sql";
$res = mysql_query($sql);
  $num    = mysql_num_rows($res) ;
  
  if($num >0)
    echo "1";
	else
	echo "0";


?>



