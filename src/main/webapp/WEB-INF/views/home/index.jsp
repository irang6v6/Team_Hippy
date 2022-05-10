<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${R}style.css">
    <script src="https://kit.fontawesome.com/92bb2bf275.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@1,300&family=Source+Sans+Pro&display=swap"
        rel="stylesheet">
    <script src="main.js" defer></script>
    <title>Document</title>
</head>

<body>


    <body>
        <header class="logobar">
            <div class="logo">
                <i class="fa-solid fa-hippo"></i>
                <span class="logo">HIPPI</span>
            </div>

            <ul class="list">
                <li><a href="#">HOME</a></li>
                <li><a href="/article/list?bd=1">List</a></li>
                <li><a href="#">Map</a></li>
                <li><a href="#">Mypage</a></li>
            </ul>

            <div class="login">
                <img src="./img/1-2.jpg">
                <button>NICKNAME</button>
            </div>
        </header>

        <div class="welcome">
            <span><b>힙한 장소 추천</b></span>
            <p>놀기 좋은 장소 추천 사이트</p>
        </div>
        <div class="totalcontainer" style="overflow: hidden;">
            <div class="container">
                <div class="inner"><img src="img/1-2.jpg" alt=""></div>
                <div class="inner"><img src="img/1-3.jpg" alt=""></div>
                <div class="inner"><img src="img/1-4.jpg" alt=""></div>
            </div>
        </div>
        <div class="sliderBtn">
            <button class="prev"><i class="fa-solid fa-angles-left"></i></button>&nbsp&nbsp&nbsp&nbsp
            <button class="next"><i class="fa-solid fa-angles-right"></i></button>
        </div>

        <div class="checkbox">
            <div class="mycheck">
                체크내용
            </div>

            <div class="check_list">
                <ul>
                    <li><button>#샵</button></li>
                    <li><button>#클럽</button></li>
                    <li><button>#맛집</button></li>
                    <li><button>#전시</button></li>
                    <li><button>#공연</button></li>
                </ul>
            </div>
            <button class="result"><i class="fa-solid fa-arrow-down"></i></button>
            <div class="mycheck2">
                체크내용2
            </div>
            <div class="check_list2">
                <ul>
                    <li>
                        <button1>#차분한</button1>
                    </li>
                    <li>
                        <button2>#활기찬</button2>
                    </li>
                    <li>
                        <button3>#밝은</button3>
                    </li>
                    <li>
                        <button4>#어두운</button4>
                    </li>
                    <li>
                        <button5>#조용한</button5>
                    </li>
                </ul>
            </div>
            <button class="result2"><i class="fa-solid fa-arrow-down"></i></button>
            <div class="mycheck3">
                체크내용3
            </div>
            <div class="check_list3">
                <ul>
                    <li>
                        <button1>#혼자</button1>
                    </li>
                    <li>
                        <button2>#둘이서</button2>
                    </li>
                    <li>
                        <button3>#여럿이</button3>
                    </li>
                </ul>
            </div>
            <button class="result3"><i class="fa-solid fa-arrow-down"></i></button>
        </div>
        </div>



        <div class="input">
            <input type="text">&nbsp&nbsp
            <button class="text">검색</button>
        </div>
        <div class="search">
            <table>
                <tr>
                    <td><img src="img/1-2.jpg" alt=""><br><span>제주도</span></td>
                    <td><img src="img/1-3.jpg" alt=""><br><span>제주도</span></td>
                    <td><img src="img/1-4.jpg" alt=""><br><span>제주도</span></td>
                    <td><img src="img/1-5.jpg" alt=""><br><span>제주도</span></td>
                </tr>
                <tr>
                    <td><img src="img/1-2.jpg" alt=""><br><span>제주도</span></td>
                    <td><img src="img/1-3.jpg" alt=""><br><span>제주도</span></td>
                    <td><img src="img/1-4.jpg" alt=""><br><span>제주도</span></td>
                    <td><img src="img/1-5.jpg" alt=""><br><span>제주도</span></td>
                </tr>
                <tr>
                    <td><img src="img/1-2.jpg" alt=""><br><span>제주도</span></td>
                    <td><img src="img/1-3.jpg" alt=""><br><span>제주도</span></td>
                    <td><img src="img/1-4.jpg" alt=""><br><span>제주도</span></td>
                    <td><img src="img/1-5.jpg" alt=""><br><span>제주도</span></td>
                </tr>
                <tr>
                    <td><img src="img/1-2.jpg" alt=""><br><span>제주도</span></td>
                    <td><img src="img/1-3.jpg" alt=""><br><span>제주도</span></td>
                    <td><img src="img/1-4.jpg" alt=""><br><span>제주도</span></td>
                    <td><img src="img/1-5.jpg" alt=""><br><span>제주도</span></td>
                </tr>
                <tr>
                    <td><img src="img/1-2.jpg" alt=""><br><span>제주도</span></td>
                    <td><img src="img/1-3.jpg" alt=""><br><span>제주도</span></td>
                    <td><img src="img/1-4.jpg" alt=""><br><span>제주도</span></td>
                    <td><img src="img/1-5.jpg" alt=""><br><span>제주도</span></td>
                </tr>
                <tr>
                    <td><img src="img/1-2.jpg" alt=""><br><span>제주도</span></td>
                    <td><img src="img/1-3.jpg" alt=""><br><span>제주도</span></td>
                    <td><img src="img/1-4.jpg" alt=""><br><span>제주도</span></td>
                    <td><img src="img/1-5.jpg" alt=""><br><span>제주도</span></td>
                </tr>
                <tr>
                    <td><img src="img/1-2.jpg" alt=""><br><span>제주도</span></td>
                    <td><img src="img/1-3.jpg" alt=""><br><span>제주도</span></td>
                    <td><img src="img/1-4.jpg" alt=""><br><span>제주도</span></td>
                    <td><img src="img/1-5.jpg" alt=""><br><span>제주도</span></td>
                </tr>
            </table>
        </div>
    </body>

</html>