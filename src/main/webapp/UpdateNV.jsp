<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page language="java"  import="model.BEAN.*"%>
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
		User userupdate = (User) session.getAttribute("userupdate");
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
                        <li class="header-user-item header-user-item--separate">
                            <a href="UserControllerServlet?logout=1">SIGN OUT</a>
                        </li>
                    </ul>
                </li>
            </div>
        </div>


        <div class="content p-t-80">
            <form action="UserControllerServlet"  class="info" method="post">
                <div class="upload">

                    <div class="upload-file">
                        <img id="output" src="./assets/img/<%=userupdate.getIMG()%>"/>
                    </div>
                    <input type="file" accept="image/*" onchange="loadFile(event)" name="img">
                </div>
                <div>
                    <table>
                        <tr>
                            <td><label for="">ID Employee:</label></td>
                            <td class="p-t-20"><input type="text" name="id" id="" class="info-input" value="<%= userupdate.getID_User()%>"></td>
                        </tr>
                        <tr>
                            <td><label for="">Name:</label></td>
                            <td class="p-t-20"><input type="text" name="name" id="" class="info-input" value="<%= userupdate.getName()%>"></td>
                        </tr>
                        <tr>
                            <td><label for="">Date of birth:</label></td>
                            <td class="p-t-20">
                                <input type="date" name="date" id="" class="info-input" value="<%= userupdate.getDateOfBirth()%>"><br>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="">Email:</label></td>
                            <td class="p-t-20"><input type="email" name="email" id="" class="info-input" value="<%=userupdate.getEmail()%>"></td>
                        </tr>
                        <tr>
                            <td><label for="">Phone:</label></td>
                            <td class="p-t-20"><input type="text" name="phone" id="" class="info-input" value="<%=userupdate.getPhone()%>"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td class="p-t-20"><input type="submit" value="UPDATE" class="btn content-btn m-t-20" name="update1"></td>
                        </tr>
                    </table>
                    <input type="text" value="<%= user.getID_User() %>" name="iduser" style="width: 0; height: 0; visibility: hidden;">
                         <input type="text" value="<%= role %>" name="role" style="width: 0; height: 0; visibility: hidden;">
                </div>
            </form>
        </div>
    </div>

    <script>
    var loadFile = function(event) {
        var output = document.getElementById('output');
        output.src = URL.createObjectURL(event.target.files[0]);
        output.value = event.target.files[0].name;
        console.log(output.src);
        output.onload = function() {
        	URL.revokeObjectURL(output.src) // free memory
        }
    };
    </script>
</body>
</html>