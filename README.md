```
<?php

$servername = "127.0.0.1"; 
$username = "root"; 
$password = ""; 
$dbname = "my_databases"; 


$conn = new mysqli($servername, $username, $password, $dbname);


if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} else {
    echo "Connected successfully";
}


$name = $_GET['n'];
$email = $_GET['e'];
$phone = $_GET['p'];


$sql = "INSERT INTO user_table (name, email, phone) VALUES ('$name', '$email', '$phone')";

$result = mysqli_query($conn, $sql);

if($result){
    echo "<br> Databage Connected!!";
}else echo "Databage connect error!";

?>
