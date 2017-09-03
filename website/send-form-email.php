<?php 
if (isset($_POST["submit"])) {
    $validate = validateInput($_POST["contact-name"], $_POST["contact-subject"], $_POST["contact-message"]);
    if ($validate==FALSE) {
        $error_msg = "Please fill out all information";
        echo '<script type="text/javascript">
            alert("'.$error_msg.'");
            window.location= "send-form-email.php";
        </script>';
    } else {
        $mailcheck = spamcheck($_POST["contact-email"]);
        if ($mailcheck==FALSE) {
            $error_msg = "Invalid email address";
            echo '<script type="text/javascript">
            alert("'.$error_msg.'");
            window.location= "send-form-email.php";
        </script>';
        } else {
        $email = $_REQUEST['contact-email'];
        $subject = $_REQUEST['contact-subject'];
        $message = $_REQUEST['contact-message'];

        mail( "msgembala@crimson.ua.edu", $subject, $message, "From: $contact-email" );
        header( "Location: http://www.thankyou.html" );
        }
    }
}
?>