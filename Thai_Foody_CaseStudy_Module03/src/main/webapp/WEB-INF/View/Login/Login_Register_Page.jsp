<%--
  Created by IntelliJ IDEA.
  User: Thai
  Date: 5/8/2023
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>

    <title>Login And Register Page</title>
<%--    Đây là cách dẫn link file css và thư viện css vào File JSP--%>
    <link rel="stylesheet" href="<c:url value = '/resource/css/Login.css'/>">
    <link rel="stylesheet" href="<c:url value = 'https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css'/>">
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" >--%>
</head>
<body>
<div class="thai">
    <div class="card">
        <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
            <li class="nav-item text-center">
                <a class="nav-link active btl" id="pills-home-tab" data-toggle="pill" href="#pills-login" role="tab" aria-controls="pills-home" aria-selected="true">Login</a>
            </li>
            <li class="nav-item text-center">
                <a class="nav-link btr" id="pills-profile-tab" data-toggle="pill" href="#pills-register" role="tab" aria-controls="pills-profile" aria-selected="false">Register</a>
            </li>
        </ul>

        <div class="tab-content" id="pills-tabContent">
            <div class="tab-pane fade show active" id="pills-login" role="tabpanel" aria-labelledby="pills-home-tab">

                <form action="${pageContext.request.contextPath}/user/logged" method="post">
                    <div class="form px-4 pt-5">

                        <input type="text" name="nameAccount" class="form-control" placeholder="Email or Phone">

                        <input type="password" name="passWord" class="form-control" placeholder="Password">

                        <button class="btn btn-dark btn-block">Login</button>

                        <c:if test="${messageForLoginPage != null}">
                            <p class="bg-danger text-white">${messageForLoginPage}</p>
                        </c:if>

                        <p class="string" > not a member? <a href="${pageContext.request.contextPath}/user/login">Please SignUp </a></p>

                    </div>
                </form>
            </div>

            <div class="tab-pane fade" id="pills-register" role="tabpanel" aria-labelledby="pills-profile-tab">

                <form action="${pageContext.request.contextPath}/user/register" method="post">
                    <div class="form px-4">
                        <input type="text" name="userName"  class="form-control" placeholder="Name" required>

                        <input type="email" name="email" class="form-control" placeholder="Email" required
                                    pattern="^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$">

                        <input type="tel" name="phoneNumber" class="form-control" placeholder="Phone" required
                               pattern="^(84|0[3|5|7|8|9])+([0-9]{8})$"
                               title="Nhập đúng định dạng số điện thoại - có 10 số">

                        <input type="password" name="passWord" class="form-control" placeholder="Password" required>

                        <button class="btn btn-dark btn-block">Signup</button>

                        <c:if test="${messageForRegisterPage != null}">
                            <p class="bg-danger text-white">${messageForRegisterPage}</p>
                        </c:if>

                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%--<link rel="stylesheet" href=" <c:url value = 'https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'/>">--%>
<%--<link rel="stylesheet" href="<c:url value = 'https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js'/>">--%>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
