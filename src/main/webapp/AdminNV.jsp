<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page language="java" import="model.BEAN.*" %>
    <%@ page language="java" import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./assets/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700;800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./assets/css/grid.css">
</head>
<body>
	<%  User user = (User)session.getAttribute("user");
		String role = (String) session.getAttribute("role");
		List<User> listUser= (List<User>) session.getAttribute("listuser");
	%>
    <div id="main">
        <div id="header">
            <div class="header-container">
                <div class="header-logo">
                    <img src="./assets/img/logo.png" alt="">
                </div>
                <span class="text-heading text-name">HI3PUG COFFEE SHOP</span>
                <li class="header-item header-user">
                    <img src="./assets/img/user.png" alt="" class="header-user-img">
                    <div class="header-user-name">
                        <span><%= user.getName() %></span>
                        <span><%= role %></span>
                    </div>
                
                    <ul class="header-user-menu">
                        <li class="header-user-item">
                            <a href="">ACCOUNT</a>
                        </li>
                        <li class="header-user-item header-user-item--separate">
                            <a href="">SIGN IN</a>
                        </li>
                    </ul>
                </li>
            </div>
        </div>

        <div class="content  p-0">
            <div class="content-nav">
                <a href="" class="btn content-btn m-t-60">MENU</a><br>
                <a href="" class="btn content-btn center">EMPLOYEE</a>
            </div>

            <div class="content-form">
                
                <div class="content-search m-t-60">
                    <a href="" class="btn content-btn">ADD</a>
                    <form action="" method>
                        <div class="drink content-menu">
                            <select name="typeSearch" class="select_drink">
                                <option value="1">MaNhanVien</option>
                                <option value="2">Ten</option>
                                <option value="3">SDT</option>
                            </select>
                            <input class="content-input" type="text" name="search" id="" placeholder="Enter drink?">
                            <input type="submit" value="SEARCH" name="search" class="btn content-btn">
                        </div>
                    </form>
                </div>


                <div class="container">
                    <% for(int i = 0; i < Math.ceil(listUser.size()/4); i++){ %>
                	<div class="row m-t-60">
                <% for(int j = i*4; j < (i+1)*4; j++) {
                	if(j >= listUser.size()) break;
                %>
                	<div class="col">
                            <a class="home-product-item" href="#">
                                <div class="home-product-item__img" style="background-image: url(./assets/img/<%= listUser.get(j).getIMG() %>); "></div>
                                <h4 class="home-product-item__name"><%= listUser.get(j).getName()%></h4>
                                <div class="home-product-item-btn">
                                    <a href="" class="btn content-btn btn-small">UPDATE</a>
                                    <a href="" class="btn content-btn btn-small">DELETE</a>
                                </div>
                            </a>
                        </div>
                <%} %>
					</div>
                <% } %>  
                </div>
            </div>
        </div>
    </div>
</body>
</html>