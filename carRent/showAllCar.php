<?php mysql_connect('localhost', 'root', '');
mysql_select_db('carfinal');

$sql = "SELECT CarID, CarName, CarModel, CarType, CarNo, carprice, isreserve FROM cars,parking,parking_car WHERE cars.CarID=parking_car.cars_CarID AND parking.ParID=parking_car.parking_ParID and parking.ParID=".$_POST['id'];
$res = mysql_query($sql);

$xml = new XMLWriter();

$xml->openURI("php://output");
$xml->startDocument();
$xml->setIndent(true);

$xml->startElement('cars');
 
while ($row = mysql_fetch_assoc($res)) {
  $xml->startElement("car");

$xml->startElement('CarID');
    $xml->writeRaw($row['CarID']);
 $xml->endElement();
$xml->startElement('CarName');

    $xml->writeRaw($row['CarName']);
	 $xml->endElement();
	 $xml->startElement('CarModel');
    $xml->writeRaw($row['CarModel']);
	 $xml->endElement();
	 $xml->startElement('CarType');
    $xml->writeRaw($row['CarType']);
	 $xml->endElement();
	 
	  $xml->startElement('CarNo');
    $xml->writeRaw($row['CarNo']);
	 $xml->endElement();
	 
	   $xml->startElement('carprice');
    $xml->writeRaw($row['carprice']);
	 $xml->endElement();
	 
	   $xml->startElement('isreserve');
    $xml->writeRaw($row['isreserve']);
	 $xml->endElement();

  $xml->endElement();
}

$xml->endElement();

header('Content-type: text/xml');
$xml->flush();

?>