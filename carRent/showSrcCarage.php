<?php mysql_connect('localhost', 'root', '');
mysql_select_db('carRental');


$sql = "SELECT * FROM Carage where name like '%".$_POST['src']."%';";
$res = mysql_query($sql);

$xml = new XMLWriter();

$xml->openURI("php://output");
$xml->startDocument();
$xml->setIndent(true);

$xml->startElement('carages');

while ($row = mysql_fetch_assoc($res)) {
  $xml->startElement("Carage");

$xml->startElement('id');
    $xml->writeRaw($row['id']);
 $xml->endElement();
$xml->startElement('name');

    $xml->writeRaw($row['name']);
	 $xml->endElement();
	 $xml->startElement('region');
    $xml->writeRaw($row['region']);
	 $xml->endElement();

  $xml->endElement();
}

$xml->endElement();

header('Content-type: text/xml');
$xml->flush();

?>