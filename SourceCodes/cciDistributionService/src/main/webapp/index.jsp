<html>
<body>
<h2>Hello World Distribution Service!</h2>
<div style="align:centre">
    <form action="http://localhost:8080/cciService/tr/insertEmployee" method="POST">
        <table>
            <tr>
                <td><label for="username">User Name :</label></td>
                <td><input name="username" type="text" /></td>
            </tr>
            <tr>
                <td><label for="password">Password :</label></td>
                <td><input name="password" type="password"/></td>
            </tr>
            <tr>
                <td><label for="firstname">First Name :</label></td>
                <td><input name="firstname" type="text"/></td>
            </tr>
            <tr>
                <td>  <label for="lastname">Last Name :</label></td>
                <td><input name="lastname" type="text"/></td>
            </tr>
            <tr>
                <td>  <label for="email">Email :</label></td>
                <td><input name="email" type="email"/></td>
            </tr>
            <tr>
                <td>  <label for="compnay">Company :</label></td>
                <td><input name="company" type="text"/></td>
            </tr>
        </table>
        <input type="submit" value="Submit" />
    </form>
</div>
</body>
</html>
