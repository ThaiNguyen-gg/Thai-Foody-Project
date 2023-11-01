<%--
  Created by IntelliJ IDEA.
  User: Thai
  Date: 6/8/2023
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Comment page</title>
    <link rel="stylesheet" href="<c:url value = 'https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css'/>">
  <link rel="stylesheet" href="<c:url value = 'https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css'/>">
  <link rel="stylesheet" href="<c:url value = 'https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css'/>">
<%--    <link rel="stylesheet" href="<c:url value='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'/>">--%>

    <link rel="stylesheet" href="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'/>">
    <link rel="stylesheet" href="<c:url value='https://fonts.googleapis.com/css?family=Calibri:400,300,700'/>">
    <link rel="stylesheet" href="<c:url value='/resource/css/Comment.css'/>">
</head>
<body style="background-color: #D32F2F;" >

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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>


</body>
</html>
