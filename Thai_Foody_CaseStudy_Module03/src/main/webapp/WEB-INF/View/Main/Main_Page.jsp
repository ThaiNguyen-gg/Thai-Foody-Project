<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thai
  Date: 5/8/2023
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Main Page </title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value = 'https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css'/>">
    <link rel="stylesheet" href="<c:url value = 'https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css'/>">

    <style>
        body {
            /*background-color: #22254b;*/
            background-color: #ffffff;
        }
        nav {
            /*background-color: #363b69;*/
            background-color: #ff4500;
        }
        .message {
            color: #EEEEEE;
            font-size: 2rem;
            font-family: "Cormorant Garamond", serif;
        }
        .h-75 {
            color: #EEEEEE;
        }
        .custom-btn {
            color: #fff;
            border-radius: 5px;
            padding: 10px 25px;
            font-family: 'Lato', sans-serif;
            font-weight: 500;
            background: transparent;
            cursor: pointer;
            transition: all 0.3s ease;
            position: relative;
            display: inline-block;
            box-shadow:inset 2px 2px 2px 0 rgba(255,255,255,.5),
            7px 7px 20px 0 rgba(0,0,0,.1),
            4px 4px 5px 0 rgba(0,0,0,.1);
            outline: none;
        }
        .btn-14 {
            background: rgb(255,151,0);
            border: none;
            z-index: 1;
        }
        .btn-14:after {
            position: absolute;
            content: "";
            width: 100%;
            height: 0;
            top: 0;
            left: 0;
            z-index: -1;
            border-radius: 5px;
            background-color: #eaf818;
            background-image: linear-gradient(315deg, #eaf818 0%, #f6fc9c 74%);
            box-shadow:inset 2px 2px 2px 0 rgba(255,255,255,.5),
            7px 7px 20px 0 rgba(0,0,0,.1),
            4px 4px 5px 0 rgba(0,0,0,.1);
            transition: all 0.3s ease;
        }
        .btn-14:hover {
            color: #000;
        }
        .btn-14:hover:after {
            top: auto;
            bottom: 0;
            height: 100%;
        }
        .btn-14:active {
            top: 2px;
        }
    </style>
</head>
<body>
<%@include file="/WEB-INF/View/Main/Header.jsp"%>
<main>
    <div id="carouselBasicExample" class="carousel slide carousel-fade" data-mdb-ride="carousel">
        <!-- Indicators -->
        <div class="carousel-indicators">
            <button
                    type="button"
                    data-mdb-target="#carouselBasicExample"
                    data-mdb-slide-to="0"
                    class="active"
                    aria-current="true"
                    aria-label="Slide 1"
            ></button>
            <button
                    type="button"
                    data-mdb-target="#carouselBasicExample"
                    data-mdb-slide-to="1"
                    aria-label="Slide 2"
            ></button>
            <button
                    type="button"
                    data-mdb-target="#carouselBasicExample"
                    data-mdb-slide-to="2"
                    aria-label="Slide 3"
            ></button>
        </div>

        <!-- Inner -->
        <div class="carousel-inner">
            <!-- Single item -->
            <div class="carousel-item active">
<%--                <img src="https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/banner%2F1.jpg?alt=media&token=93ccc929-e6ec-4db5-b078-14eeab13c260"--%>
<%--                <img src="https://img.freepik.com/free-vector/flat-design-fast-food-sale-banner_23-2149165450.jpg"--%>
                <img src="https://i.pinimg.com/originals/0c/53/cb/0c53cb7edb13952b34c9760aeba4728f.jpg"
                     class="d-block w-100 h-75" alt="Banner phim Con mót nhót chồng"/>
            </div>

            <!-- Single item -->
            <div class="carousel-item">
<%--                <img src="https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/banner%2F4.jpg?alt=media&token=f5046a20-746b-4780-afe2-e6cbdea2298a"--%>
<%--                <img src="https://intphcm.com/data/upload/mau-banner-dep-quan-an.jpg"--%>
                <img src="https://amthucvanho.com.vn/wp-content/uploads/2019/02/imgpsh_fullsize_anim.jpg"
                     class="d-block w-100 h-75" alt="Banner phim Anh em super mario"/>
            </div>

            <!-- Single item -->
            <div class="carousel-item">
<%--                <img src="https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/banner%2F3.jpg?alt=media&token=0e9d932c-9019-47f8-b2ce-635baae5bf9f"--%>
<%--                <img src="https://treobangron.com.vn/wp-content/uploads/2022/12/banner-quang-cao-nha-hang-32.jpg"--%>
                <img src="https://luxagency.vn/wp-content/uploads/2022/03/837c012cce0c3a52631d.jpg"
                     class="d-block w-100 h-75" alt="Banner phim Khắc tinh của quỷ"/>
            </div>

        </div>


        <!-- Inner -->

        <!-- Controls -->
        <button class="carousel-control-prev" type="button" data-mdb-target="#carouselBasicExample"
                data-mdb-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-mdb-target="#carouselBasicExample"
                data-mdb-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
    <div class="container-fluid col-10">
        <c:if test="${requestScope.get('messageBySearch') != null}">
            <h5 style="color: black; text-align: center" class="message">${requestScope.get('messageBySearch')}</h5>
        </c:if>
        <form action="${pageContext.request.contextPath}/store/detail" method="get" >
            <c:forEach items='${requestScope.get("storeList")}' var="store">
                <div class="card col-3 float-left mt-5 bg-image hover-zoom" style="background-color: #FF5733;">
<%--                                        Nhét trong thẻ button 1 cái img thì có thể click--%>
                    <button class="card-header p-0 border-0" style="height: 50vh" name="id" value="${store.getId()}">
                        <img class="col-12 mt-2" style="height: 47vh" src="${store.getImageURL()}" alt='${store.getName()}'>
                    </button>

                    <div class="card-body" style="height: 18vh" >
                        <div class="h-75" style="color: black">
                            <h5 class="card-title"> ${store.getName()}</h5>
                            <p class="card-text">Quận: ${store.getDistrict()}</p>
                        </div>
                        <div class="frame">
                            <button  class="btn custom-btn btn-14" style="margin-left: 30%"
                                    name="id" value="${store.getId()}">Chi tiết</button>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </form>
    </div>




</main>
<%@include file="/WEB-INF/View/Main/Footer.jsp"%>
</body>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.js"></script>
</html>
