<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./assets/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700;800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./assets/css/grid.css">
    <title>Khách không đăng nhập</title>
</head>
<body>
    <div class="main">
        <div id="header">
            <!-- Bắt đầu phần nav -->
            <ul id="nav">
                <li class="nav-item">
                    <a class="nav-item-link" href="#">HOME</a>
                </li>
                <li class="nav-item">
                    <a class="nav-item-link" href="#menu">MENU</a>
                </li>
                <li class="nav-item">
                    <a class="nav-item-link" href="#location">LOCATION</a>
                </li>
                <li class="nav-item">
                    <a class="nav-item-link" href="#about">ABOUT US</a>
                </li>
                <li class="nav-item">
                    <a class="nav-item-link js-btn-login" href="#">SIGN IN</a>
                </li>
            </ul>
            <!-- End nav -->
        </div>

        <div id="slider">
            <img src="./assets/img/slider.png" alt="" class="slider_img">
        </div>

        <div id="menu">
            <div class="text-content text-content-color">
                <h2 class="text-heading">MENU</h2>
            </div>
            <div class="drink">
                <select name="" class="select_drink">
                    <option value="1">Cà phê</option>
                    <option value="2">Trà sữa</option>
                    <option value="3">Nước ép</option>
                </select>
                <button class="btn">SHOW</button>
            </div>
            <div class="home-product">
                <div class="row sm-gutter">
                    <!-- Product item -->
                    <div class="col l-2-4 m-4 c-6">
                        <a class="home-product-item" href="#">
                            <div class="home-product-item__img" style="background-image: url(./assets/img/cafelatte.png); "></div>
                            <h4 class="home-product-item__name">CAFE LATTE</h4>
                        </a>
                    </div>
                    <div class="col l-2-4 m-4 c-6">
                        <a class="home-product-item" href="#">
                            <div class="home-product-item__img" style="background-image: url(./assets/img/capuchino.png) "></div>
                            <h4 class="home-product-item__name">CAPUCHINO</h4>
                        </a>
                    </div>
                    <div class="col l-2-4 m-4 c-6">
                        <a class="home-product-item" href="#">
                            <div class="home-product-item__img" style="background-image: url(./assets/img/berryyogurt.jpg); "></div>
                            <h4 class="home-product-item__name">BERRY YOUGURT</h4>
                      </a>
                    </div>
                    <div class="col l-2-4 m-4 c-6">
                        <a class="home-product-item" href="#">
                            <div class="home-product-item__img" style="background-image: url(./assets/img/espresso.png); "></div>
                            <h4 class="home-product-item__name">ESPRESSO</h4>
                        </a>
                    </div>         
                    <div class="col l-2-4 m-4 c-6">
                        <a class="home-product-item" href="#">
                            <div class="home-product-item__img" style="background-image: url(./assets/img/kiwipassion.jpg); "></div>
                            <h4 class="home-product-item__name">KIWI PASSION</h4>
                        </a>
                    </div>   
                    <div class="col l-2-4 m-4 c-6">
                        <a class="home-product-item" href="#">
                            <div class="home-product-item__img" style="background-image: url(./assets/img/limejuice.jpg) "></div>
                            <h4 class="home-product-item__name">LIME JUICE</h4>
                        </a>
                    </div>   
                    <div class="col l-2-4 m-4 c-6">
                        <a class="home-product-item" href="#">
                            <div class="home-product-item__img" style="background-image: url(./assets/img/matchalatte.jpg) "></div>
                            <h4 class="home-product-item__name">mATCHA LATTE</h4>
                        </a>
                    </div>   
                    <div class="col l-2-4 m-4 c-6">
                        <a class="home-product-item" href="#">
                            <div class="home-product-item__img" style="background-image: url(./assets/img/mintchocolate.jpg); "></div>
                            <h4 class="home-product-item__name">MINT CHOCOLATE</h4>
                        </a>
                    </div>                                 
                </div>
            </div>

        

        </div>

        <div id="location">
            <h2 class="text-heading">LOCATION</h2>
            <div class="location-slider">
                <h1 class="text-sub-heading">DA NANG</h1>
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" style="width: 80%; margin: 0 auto;">
                    <ol class="carousel-indicators">
                      <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                      <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner" style="height: 600px;">
                      <div class="carousel-item active h-100">
                        <img class="d-block w-100 h-100" src="./assets/img/cfshop_1.png" alt="First slide" >
                      </div>
                      <div class="carousel-item">
                        <img class="d-block w-100 h-100" src="./assets/img/cfshop_2.png" alt="Second slide">
                      </div>
                      <div class="carousel-item">
                        <img class="d-block w-100 h-100" src="./assets/img/cfshop_3.png" alt="Third slide">
                      </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                      <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                      <span class="carousel-control-next-icon" aria-hidden="true"></span>
                      <span class="sr-only">Next</span>
                    </a>
                </div>
                <h3 class="text-sub-heading">Address : 193 Nguyen Luong Bang</h3>
            </div>
        </div>

        <div id="about">
            <h2 class="text-heading">ABOUT US</h2>
            <div class="text">
            	<div class="text-sub">
            		<h1 class="text-sub-heading">WHO ARE WE ?</h1>
                    <p style="width: 60%; margin: 0 auto;" class="text-info"><span style="color: #E09132;">The Hi3Pug Coffee</span> is a chain of coffee shops in Vietnam. Despite being born late, 
                        it is growing faster than many competitors in the coffee market thanks to the company's understanding of the market and good management. 
                        The success of <span style="color: #E09132;">The Hi3Pug Coffee</span> today is also an affirmation of our excellent quality. Come and experience with us!</p>
	            </div>
	            <div class="text-sub">
	            	<div class="text-time">
                        <h1 class="text-sub-heading">COME ON IN</h1>
                        <span style="color: #E09132;font-weight: bold; font-size: 24px;">WEEKDAYS</span>
                        <p class="text-info">07:30 AM - 10:00 PM</p>
                        <span style="color: #E09132;font-weight: bold; font-size: 24px;">WEEKENDS</span>
                        <p class="text-info">08:30 AM - 11:00 PM</p>
                    </div>
                    <div class="text-contact">
                        <h1 class="text-sub-heading">CONTACT US</h1>
                        <div class="text-contact-sub">
                            <i class="fa-solid fa-phone text-img"></i>
                            <p class="text-info">Phone: 0123456789</p>
                        </div>
                        <div class="text-contact-sub" style="margin-left: 40px;">
                            <i class="fa-solid fa-envelope text-img"></i>
                            <p class="text-info">Email: mail@gmail.com</p>
                        </div>
                        <div class="text-contact-sub">
                            <i class="fa-brands fa-facebook text-img"></i>
                            <p class="text-info">Facebook: facebook</p>
                        </div>
                    </div>

	            </div>
            </div>
        </div>

        <div id="footer">
            <div class="socials-list">
                <a href=""><i class="fa-brands fa-facebook-f"></i></a>
                <a href=""><i class="fa-brands fa-instagram"></i></a>
                <a href=""><i class="fa-brands fa-youtube"></i></a>
                <a href=""><i class="fa-brands fa-pinterest"></i></a>
                <a href=""><i class="fa-brands fa-twitter"></i></a>
                <a href=""><i class="fa-brands fa-linkedin"></i></a>
            </div>
        </div>


        <div class="modal js-modal">
            <div class="modal-container js-modal-container">
                <div class="modal-heading js-modal-close">
                    <div class="modal-text-heading">
                        <span >SIGN IN</span>
                    </div>
                    <i class="modal-close fa-solid fa-xmark"></i>
                </div>
                <form action="CheckLoginServlet" align="center" class="modal-login">
                    <label class="modal-login-label" for="">Username</label><br>
                    <input class="modal-login-input" type="text" name="username" id="" placeholder="Enter your ID"><br><br>
                    <label class="modal-login-label" for="">Password</label><br>
                    <input class="modal-login-input" type="password" name="password" id="" placeholder="Enter your password"><br><br>
                    <input type="submit" value="LOGIN" class="modal-login-button"><br><br>
                    <a class="modal-login-forget" href="">Forget password?</a>
                </form>

            </div>
        </div>

        <script>
            const loginBtns = document.querySelectorAll('.js-btn-login')
            var modal = document.querySelector('.js-modal')
            const modalContainer = document.querySelector('.js-modal-container')
            var modalClose = document.querySelector('.js-modal-close')

            for(const loginBtn of loginBtns) {
                loginBtn.addEventListener('click', function(){
                    modal.classList.add('open')
                })
            }

            modalClose.addEventListener('click', function() {
                modal.classList.remove('open')
            })
        </script>
</body>
</html>
  