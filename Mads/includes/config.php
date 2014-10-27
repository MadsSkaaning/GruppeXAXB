<?php

// Creating a jsonparser, that reads from file:
$json = file_get_contents("config.json");
$data = json_decode($json, true);

// here depends on the json
$host = $data["host"];
$port = $data["port"];
$username = $data["username"];
$password = $data["password"];
$dbname = $data["dbname"];

echo "This is the host:", " ", $host;
echo "This is the port: ", $port;
echo "This is the username: ", $username; 
echo "The password should be hasehd: ", $password;

/**
 * These are the database login details
 * Getting these informations from our config file.
 */  
define("HOST", "localhost");     // The host
define("USER", "sec_user");    // Database username 
define("PASSWORD", "4Fa98xkHVd2XmnfK");    // Database password
define("DATABASE", "secure_login");    // Database name
 
// define("CAN_REGISTER", "any");
// define("DEFAULT_ROLE", "member");
 
define("SECURE", FALSE);    // This is set, as it is in devloping stage for now.
?>


