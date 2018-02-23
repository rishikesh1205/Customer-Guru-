<?php
// define variables and set to empty values
$nameErr = $dbn = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
   $un = test_input($_POST["un"]); 
   $email = test_input($_POST["email"]);
   $pwd = test_input($_POST["pwd"]);
   $mobno = test_input($_POST["mobno"]);
   $city = test_input($_POST["city"]);
   
}

function test_input($data) {
   $data = trim($data);
   $data = stripslashes($data);
   $data = htmlspecialchars($data);
   return $data;
}
?>


<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "deeks";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "INSERT INTO login (username, password, email, phone, city)
VALUES ('$un', '$pwd', '$email', '$mobno', '$city')";

if ($conn->query($sql) === TRUE) {
    echo "Sign Up Successful, now you can login to your account.";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>
