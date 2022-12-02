<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page language="java" import="model.BEAN.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thông tin cá nhân</title>
    <link rel="stylesheet" href="./assets/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700;800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./assets/css/grid.css">
</head>
<body>
	<%
		User user = (User)session.getAttribute("user");
		String role = (String)session.getAttribute("role");
		User user1 = (User)request.getAttribute("user");
		Account acc = (Account)request.getAttribute("account");
		int isAdmin = (int)request.getAttribute("isAdmin");
	%>
    <div id="main">
        <div id="header">
            <div class="header-container">
                <a href="./NhanVien.html" class="header-logo">
                    <img src="./assets/img/logo.png" alt="">
                </a>
                <span class="text-heading text-name">HI3PUG COFFEE SHOP</span>
                <li class="header-item header-user">
                    <img src="./assets/img/<%= user.getIMG() %>" alt="" class="header-user-img">
                    <div class="header-user-name">
                        <span><%= user.getName() %></span>
                        <span><%= role %></span>
                    </div>
                
                    <ul class="header-user-menu">
                        <li class="header-user-item">
                            <a href="">ACCOUNT</a>
                        </li>
                        <li class="header-user-item header-user-item--separate">
                            <a href="./NoLogin.html">SIGN OUT</a>
                        </li>
                    </ul>
                </li>
            </div>
        </div>

        <div class="content p-10">
            <form action="UserControllerServlet"  class="info" method="post">
                <div class="upload m-t-80">
                    <div class="upload-file">
                        <img id="output" src="./assets/img/<%=user1.getIMG()%>">
                    </div>
                    <input type="file" accept="image/*" onchange="loadFile(event)" name="img">
                </div>
                <div>
                    <table>
                        <tr>
                            <td><label for="">ID Employee:</label></td>
                            <td class="p-t-20"><input type="text" name="id" id="" class="info-input" value="<%= user1.getID_User()%>"></td>
                        </tr>
                        <tr>
                            <td><label for="">Name:</label></td>
                            <td class="p-t-20"><input type="text" name="name" id="" class="info-input" value="<%= user1.getName()%>"></td>
                        </tr>
                        <tr>
                            <td><label for="">Phone:</label></td>
                            <td class="p-t-20"><input type="text" name="phone" id="" class="info-input" value="<%= user1.getPhone()%>"></td>
                        </tr>
                        <tr>
                            <td><label for="">Email:</label></td>
                            <td class="p-t-20"><input type="email" name="email" id="" class="info-input" value="<%= user1.getEmail()%>"></td>
                        </tr>
                        <tr>
                            <td><label for="">Date of birth:</label></td>
                            <td class="p-t-20">
                                <input type="date" name="date" id="" class="info-input" value="<%= user1.getDateOfBirth()%>"><br>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="">Username:</label></td>
                            <td class="p-t-20">
                                <input type="text" name="username" id="" class="info-input" value="<%= acc.getUsername()%>"><br>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="">Password:</label></td>
                            <td class="p-t-20">
                                <input type="text" name="password" id="" class="info-input" value="<%= acc.getPassword()%>"><br>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="text" value="<%= isAdmin %>" name="isAdmin" style="width: 0; height: 0; visibility: hidden;"></td>
                            <td class="p-t-20"><input type="submit" value="SAVE" class="btn content-btn m-t-20" name="save"></td>
                        </tr>
                    </table>
                    
                </div>
            </form>
        </div>
    </div>

    <script>
        var loadFile = function(event) {
            var output = document.getElementById('output');
            output.src = URL.createObjectURL(event.target.files[0]);
            output.onload = function() {
            URL.revokeObjectURL(output.src) // free memory
            }
        };
     </script>
</body>
</html>