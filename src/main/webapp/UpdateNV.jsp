<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <div id="main">
        <div id="header">
            <div class="header-container">
                <a href="./NhanVien.html" class="header-logo">
                    <img src="./assets/img/logo.png" alt="">
                </a>
                <span class="text-heading text-name">HI3PUG COFFEE SHOP</span>
                <li class="header-item header-user">
                    <img src="./assets/img/user.png" alt="" class="header-user-img">
                    <div class="header-user-name">
                        <span>Do Nho</span>
                        <span>Admin</span>
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

        <div class="content p-t-80">
            <form action=""  class="info">
                <div class="upload">
                    <div class="upload-file">
                        <img id="output"/>
                    </div>
                    <input type="file" accept="image/*" onchange="loadFile(event)">
                </div>
                <div>
                    <table>
                        <tr>
                            <td><label for="">ID Employee:</label></td>
                            <td class="p-t-20"><input type="text" name="id" id="" class="info-input"></td>
                        </tr>
                        <tr>
                            <td><label for="">Name:</label></td>
                            <td class="p-t-20"><input type="text" name="name" id="" class="info-input"></td>
                        </tr>
                        <tr>
                            <td><label for="">Phone:</label></td>
                            <td class="p-t-20"><input type="text" name="phone" id="" class="info-input"></td>
                        </tr>
                        <tr>
                            <td><label for="">Date of birth:</label></td>
                            <td class="p-t-20">
                                <input type="date" name="day" id="" class="info-input"><br>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td class="p-t-20"><input type="submit" value="UPDATE" class="btn content-btn m-t-20"></td>
                        </tr>
                    </table>
                    
                </div>
            </form>
        </div>
    </div>

    <script>
        const form = document.querySelector("form"),
        fileInput = document.querySelector(".file-input"),
        progressArea = document.querySelector(".progress-area"),
        uploadedArea = document.querySelector(".uploaded-area");
        form.addEventListener("click", () =>{
        fileInput.click();
        });
        fileInput.onchange = ({target})=>{
        let file = target.files[0];
        if(file){
            let fileName = file.name;
            if(fileName.length >= 12){
            let splitName = fileName.split('.');
            fileName = splitName[0].substring(0, 13) + "... ." + splitName[1];
            }
            uploadFile(fileName);
        }
        }
        function uploadFile(name){
        let xhr = new XMLHttpRequest();
        xhr.open("POST", "php/upload.php");
        xhr.upload.addEventListener("progress", ({loaded, total}) =>{
            let fileLoaded = Math.floor((loaded / total) * 100);
            let fileTotal = Math.floor(total / 1000);
            let fileSize;
            (fileTotal < 1024) ? fileSize = fileTotal + " KB" : fileSize = (loaded / (1024*1024)).toFixed(2) + " MB";
            let progressHTML = `<li class="row">
                                <i class="fas fa-file-alt"></i>
                                <div class="content">
                                    <div class="details">
                                    <span class="name">${name} • Uploading</span>
                                    <span class="percent">${fileLoaded}%</span>
                                    </div>
                                    <div class="progress-bar">
                                    <div class="progress" style="width: ${fileLoaded}%"></div>
                                    </div>
                                </div>
                                </li>`;
            uploadedArea.classList.add("onprogress");
            progressArea.innerHTML = progressHTML;
            if(loaded == total){
            progressArea.innerHTML = "";
            let uploadedHTML = `<li class="row">
                                    <div class="content upload">
                                    <i class="fas fa-file-alt"></i>
                                    <div class="details">
                                        <span class="name">${name} • Uploaded</span>
                                        <span class="size">${fileSize}</span>
                                    </div>
                                    </div>
                                    <i class="fas fa-check"></i>
                                </li>`;
            uploadedArea.classList.remove("onprogress");
            uploadedArea.insertAdjacentHTML("afterbegin", uploadedHTML);
            }
        });
        let data = new FormData(form);
        xhr.send(data);
        }
    </script>
</body>
</html>