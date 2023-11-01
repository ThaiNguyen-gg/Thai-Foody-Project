<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thai
  Date: 5/11/2023
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail of store</title>
    <link rel="stylesheet" href="<c:url value = 'https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value = 'https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css'/>">
    <link rel="stylesheet" href="<c:url value = 'https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css'/>">


    <link rel="stylesheet" href="<c:url value = 'https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css'/>">

    <link rel="stylesheet" href="<c:url value = 'https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css'/>">
    <link href="" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="<c:url value='https://fonts.googleapis.com/css?family=Calibri:400,300,700'/>">
    <link rel="stylesheet" href="<c:url value='/resource/css/Comment.css'/>">


    <style>
        body {
            background-color: #ffffff;
        }
        nav {
            /*background-color: #363b69;*/
            background-color: #ff4500;
        }

        .list-group-item {
            background-color: #ffffff;
        }


        .custom-btn {
            width: 130px;
            height: 40px;
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
            box-shadow: inset 2px 2px 2px 0px rgba(255, 255, 255, .5),
            7px 7px 20px 0px rgba(0, 0, 0, .1),
            4px 4px 5px 0px rgba(0, 0, 0, .1);
            outline: none;
        }

        .btn-7 {
            background: linear-gradient(0deg, rgba(255, 151, 0, 1) 0%, rgba(251, 75, 2, 1) 100%);
            line-height: 42px;
            padding: 0;
            border: none;
        }

        .btn-7 span {
            position: relative;
            display: block;
            width: 100%;
            height: 100%;
        }

        .btn-7:before,
        .btn-7:after {
            position: absolute;
            content: "";
            right: 0;
            bottom: 0;
            background: rgba(251, 75, 2, 1);
            box-shadow: -7px -7px 20px 0px rgba(255, 255, 255, .9),
            -4px -4px 5px 0px rgba(255, 255, 255, .9),
            7px 7px 20px 0px rgba(0, 0, 0, .2),
            4px 4px 5px 0px rgba(0, 0, 0, .3);
            transition: all 0.3s ease;
        }

        .btn-7:before {
            height: 0%;
            width: 2px;
        }

        .btn-7:after {
            width: 0%;
            height: 2px;
        }

        .btn-7:hover {
            color: rgba(251, 75, 2, 1);
            background: lightpink;
        }

        .btn-7:hover:before {
            height: 100%;
        }

        .btn-7:hover:after {
            width: 100%;
        }

        .btn-7 span:before,
        .btn-7 span:after {
            position: absolute;
            content: "";
            left: 0;
            top: 0;
            background: rgba(251, 75, 2, 1);
            box-shadow: -7px -7px 20px 0px rgba(255, 255, 255, .9),
            -4px -4px 5px 0px rgba(255, 255, 255, .9),
            7px 7px 20px 0px rgba(0, 0, 0, .2),
            4px 4px 5px 0px rgba(0, 0, 0, .3);
            transition: all 0.3s ease;
        }

        .btn-7 span:before {
            width: 2px;
            height: 0%;
        }

        .btn-7 span:after {
            height: 2px;
            width: 0%;
        }

        .btn-7 span:hover:before {
            height: 100%;
        }

        .btn-7 span:hover:after {
            width: 100%;
        }
        img.img {
            max-width: 100px;
        }
        table {
            width: 100%;
            color: black;
        }


        li.list-group-item.text-black {
            border: 1px solid black;
        }

        #productList td {
            border: 1px solid black;
        }

        .modal-header{
            background:#F7941E ;
            color: #fff;
        }

    </style>
</head>
<body style="background-color: #D32F2F;" >
<%@include file="/WEB-INF/View/Main/Header.jsp"%>
<main>
<div class="card border-light container border-0" style="background-color: #FF5733;">
<%--    Này là để hình cái store--%>
    <div class="row col-12">
        <div class="col-5 pl-5 card-img-left">
            <img src="${requestScope.get('store').getImageURL()}" alt="${requestScope.get('store').getName()}"
                 class="img-fluid m-2 ml-5 pl-3 bg-image hover-zoom" style="height: 55vh">
        </div>
        <div class="card-body col-6 text-black pt-5">
            <h5 class="card-title">${requestScope.get('store').getName()}</h5>
            <div class="card border-0 col-12 bg-transparent mt-5">
                <ul class="list-group list-group-flush"  >
                    <li class="list-group-item text-black">Name: ${requestScope.get('store').getName()}</li>
                    <li class="list-group-item text-black">Type: ${requestScope.get('store').getType()}</li>
                    <li class="list-group-item text-black">Quality: ${requestScope.get('store').getQualityIndex()}</li>
                    <li class="list-group-item text-black">Phone Number: ${requestScope.get('store').getPhoneNumber()}</li>
                    <li class="list-group-item text-black">District: ${requestScope.get('store').getDistrict()}</li>
                    <li class="list-group-item text-black">Open-Closed: ${requestScope.get('store').getOpenHours()} - ${requestScope.get('store').getClosedHours()} </li>
<%--                    <li class="list-group-item text-white">  </li>--%>
                </ul>
            </div>
        </div>
    </div>
    <div align="center" >
        <table class="table table-bordered border-black text-black" id="productList">
            <c:forEach var="product" items="${productListByIdStore}">
                <tr>
                    <td><img src="<c:out value="${product.imageURL}"/>" alt="acb" class="img"> </td>
                    <td><c:out value="${product.name}"/></td>
                    <td><c:out value="${product.price}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<c:choose>
    <c:when test="${sessionScope.get('user') == null}">
        <div class="container mt-5">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal01">Review</button>
            <div class="modal" id="myModal01">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 style="text-align: center" >Please login to review!</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>
                        <div class="modal-body">
                            <form action="${pageContext.request.contextPath}/user/login" method="get" >
                                <button type="submit" class="btn btn-primary" style="text-align: center">Login</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:when>

    <c:when test="${sessionScope.get('user') != null}">
<%-- Bắt đầu Nút review--%>
    <div class="container mt-5">
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">Review</button>
        <div class="modal" id="myModal">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5>Bình luận của bạn</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>
                    <div class="modal-body">
                        <form name="myform" >
                            <div class="mb-3">
                                <label class="form-label" >Viết bình luận</label>
                                <input type="hidden" required name="idUser" value="${sessionScope.get('user').getId()}">
                                <input type="hidden" name="idStore" value="${requestScope.get('store').getId()}">
                                <textarea class="form-control" name="review_text" rows="10" cols="35" ></textarea>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" onclick="Review()">submit</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
<%--Két thúc nút review--%>
    </c:when>
</c:choose>
    <div id="mycomment"> <br>
        <div class="container d-flex justify-content-center mt-100 mb-100 ">
            <div class="row w-100">
                <div class="col-md-12">

                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Recent Comments</h4>
                            <h6 class="card-subtitle">Latest Comments section by users</h6> </div>
                        <c:forEach var="listReview" items="${listReview}">
                        <div class="comment-widgets m-b-20 " >

                            <div class="d-flex flex-row comment-row">
                                    <%--            <div class="p-2"><span class="round"><img src="https://i.imgur.com/uIgDDDd.jpg" alt="user" width="50"></span></div>--%>
                                <div class="p-2"><span class="round"><img src="<c:out value="${listReview.getUserImage_URL()}"/>" alt="user" width="50"></span></div>
                                <div class="comment-text w-100">
                                    <h5><c:out value="${listReview.getUserName()}"/></h5>
                                    <div class="comment-footer">
                                        <span class="date"><c:out value="${listReview.getCreated_at()}"/></span>
                                        <span class="label label-success">10.0</span> <span class="action-icons">
                                                          <a href="#" data-abc="true"><i class="fa fa-pencil"></i></a>
                                                          <a href="#" data-abc="true"><i class="fa fa-rotate-right"></i></a>
                                                          <a href="#" data-abc="true"><i class="fa fa-heart"></i></a>
                                                      </span>
                                    </div>
                                    <p class="m-b-5 m-t-10"><c:out value="${listReview.getReview_text()}"/></p>
                                </div>
                            </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</main>

<script type="text/javascript">
    function Review()  {
        // var url= "ReviewServlet?content"+content+"&idUserAccount="+idUserAccount+"&idStore"+idStore;
        var idUserAccount = document.myform.idUser.value;
        var content = document.myform.review_text.value;
        var idStore = document.myform.idStore.value;
        var url = "ReviewServlet?content=" + content + "&idUserAccount=" + idUserAccount + "&idStore=" + idStore;
        if(content.trim()=="") {
            alert("All fields are Required");
            return false;
        }
        var xhttp;
        if(window.XMLHttpRequest) {
            //code for chrome,firefox,IE+7,Opera,Safari
            xhttp = new XMLHttpRequest() ;
        } else  {
            xhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xhttp.onreadystatechange = function () {
            if(xhttp.readyState == 4){
                var data = xhttp.responseText;
                document.getElementById("mycomment").innerHTML = data;
            }
        }
        xhttp.open("POST",url,true);
        xhttp.send();
        window.location.reload();
    }

</script>
<%@include file="/WEB-INF/View/Main/Footer.jsp"%>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
