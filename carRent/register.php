<?php
$host="localhost";
$user="root";
$pass="";
$db="carfinal";
$db1=  mysql_connect($host,$user,$pass);
 mysql_select_db($db,$db1);
$nm= $_POST['nm'];
$ps= $_POST['ps'];
$em= $_POST['em'];
$ph= $_POST['ph'];

 $sql="INSERT INTO user(userID, Phone, Email, userName, password ) VALUES (null,'$ph','$em','$nm','$ps');"  ;

echo "$sql";
 mysql_query($sql);
 
 echo "success";
 
 
   





?>