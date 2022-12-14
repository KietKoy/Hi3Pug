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
        <title>Them Do Uong</title>
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700;800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./assets/css/grid.css">
    </head>
    <body>
    	<% User user = (User)session.getAttribute("user");
    		String role = (String)session.getAttribute("role");
    		List<String> listTypeDrink = (List<String>) session.getAttribute("listTypeDrink"); 
    		int isAdmin = (int)request.getAttribute("isAdmin");
    	%>
        <div id="main">
            <div id="header">
                <div class="header-container">
                    <div class="header-logo">
                        <a href="DrinkControllerServlet?again=1"><img src="./assets/img/logo.png" alt=""></a>
                    </div>
                    <span class="text-heading text-name">HI3PUG COFFEE SHOP</span>
                    <li class="header-item header-user">
                        <img src="./assets/img/<%= user.getIMG()%> "alt="" class="header-user-img">
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

            <div class="content p-t-100">
                <form action="DrinkControllerServlet" class="info">
                    <div class="upload">
                        <div class="upload-file">
                            <img id="output"/>
                        </div>
                        <input type="file" accept="image/*" onchange="loadFile(event)" name="img" required>
                    </div>

                    <div >
                        <table>
                        	<tr>
                                <td><label for="">ID:</label></td>
                                <td><input type="text" name="id" id="" class="info-input"></td>
                            </tr>
                            <tr>
                                <td><label for="">Name:</label></td>
                                <td><input type="text" name="name" id="" class="info-input"></td>
                            </tr>
                            <tr>
                                <td><label for="">Ingredient:</label></td>
                                <td><input type="text" name="ingredient" id="" class="info-input"></td>
                            </tr>
                            <tr>
                                <td><label for="">Type:</label></td>
                                <td>
                                	<select name="typedrink" class="select_drink" style="background-color: #FFEFCD; color: #514236; margin-top: 16px">
		                            <% for(int i = 0; i < listTypeDrink.size(); i++ ) {
		                            %>
		                                <option value="<%=listTypeDrink.get(i)%>"><%=  listTypeDrink.get(i)%></option>
		                             <%} %>
                            		</select>
                            	</td>
                            </tr>
                            <tr>
                                <td><label for="">Price:</label></td>
                                <td><input type="text" name="price" id="" class="info-input"></td>
                                <td><label for="">VND</label></td>
                            </tr>
                            <tr>
                                <td>
                                	<input type="text" value="<%= isAdmin %>" name="isAdmin" style="width: 0; height: 0; visibility: hidden;">
                                </td>
                                <td>
                                    <input type="submit" value="ADD" class="btn content-btn  m-20" name="add">
                                </td>
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
                output.onload = function() {
                	URL.revokeObjectURL(output.src) // free memory
                }
            };
            </script>
    </body>
    </html>