<?php mysql_connect('localhost', 'root', '');
mysql_select_db('carfinal');

$sql = "SELECT * FROM parking";
$res = mysql_query($sql);

$xml = new XMLWriter();

$xml->openURI("php://output");
$xml->startDocument();
$xml->setIndent(true);

$xml->startElement('carags');

while ($row = mysql_fetch_assoc($res)) {
  $xml->startElement("carage");

$xml->startElement('ParID');
    $xml->writeRaw($row['ParID']);
 $xml->endElement();
 
$xml->startElement('name');

    $xml->writeRaw($row['Parking Name']);
	 $xml->endElement();
	 
	 $xml->startElement('reg');
    $xml->writeRaw($row['reg']);
	 $xml->endElement();
	 
	  $xml->startElement('lat');
    $xml->writeRaw($row['lat']);
	 $xml->endElement();

	 
	  $xml->startElement('lon');
    $xml->writeRaw($row['lon']);
	 $xml->endElement();


  $xml->endElement();
}

$xml->endElement();

header('Content-type: text/xml');
$xml->flush();

?>