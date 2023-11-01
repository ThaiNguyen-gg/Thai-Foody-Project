<%--
  Created by IntelliJ IDEA.
  User: Thai
  Date: 5/10/2023
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-dark h-25 container-fluid">
    <div class="nav-item navbar-brand float-left ml-4">
        <div class="nav-item navbar-brand">
            <form action="${pageContext.request.contextPath}/home" method="get">
                <button type="submit" class="btn btn-outline-dark" data-mdb-ripple-color="dark"
                        style="background-color: antiquewhite">Trang chủ
                </button>
            </form>
        </div>
        <form class="d-flex input-group w-auto" action="${pageContext.request.contextPath}/store/search" method="get">
            <input type="search"
                   class="form-control rounded"
                   placeholder="Search Store"
                   aria-label="Search"
                   aria-describedby="search-addon"
                   name="search"
                   style="background-color: antiquewhite;"/>
            <span class="input-group-text text-white border-0" id="search-addon">
        <button style="border: none" class="bg-transparent">
            <i class="fas fa-search" style="color: antiquewhite"></i>
        </button>
      </span>
        </form>
    </div>
    <div class="nav-item navbar-brand float-right">
        <c:choose>
            <c:when test="${sessionScope.get('user') == null}">
                <form action="${pageContext.request.contextPath}/user/login" method="get">
                    <div class="nav-item navbar-brand">
                        <button type="submit"
                                class="btn btn-outline-dark"
                                data-mdb-ripple-color="dark"
                                style="background-color: antiquewhite">
                            Đăng nhập/Đăng ký
                        </button>
                    </div>
                </form>
            </c:when>
            <c:when test="${sessionScope.get('user') != null}">
                <div style="color: black" class="nav-item navbar-brand h6 mb-0">
                     xin chào ${sessionScope.get('user').getName()}!
                </div>
                <div class="nav-item navbar-brand ml-3">
                    <form action="${pageContext.request.contextPath}/user/logout" method="get">
                        <button type="submit" class="btn btn-outline-dark" data-mdb-ripple-color="dark"
                                style="background-color: antiquewhite">Đăng xuất
                        </button>
                    </form>
                </div>
            </c:when>
        </c:choose>
    </div>
</nav>

