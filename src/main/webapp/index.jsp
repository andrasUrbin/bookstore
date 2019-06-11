<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:url value="/style.css" var="styleUrl"/>
    <c:url value="/index.js" var="indexScriptUrl"/>
    <c:url value="/registration.js" var="registrationScriptUrl"/>
    <c:url value="/login.js" var="loginScriptUrl"/>
    <c:url value="/books.js" var="booksScriptUrl"/>
    <c:url value="/profile.js" var="profileScriptUrl"/>
    <c:url value="/back-to-profile.js" var="backToProfileScriptUrl"/>
    <c:url value="/logout.js" var="logoutScriptUrl"/>
    <link rel="stylesheet" type="text/css" href="${styleUrl}">
    <script src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
    <script src="${indexScriptUrl}"></script>
    <script src="${registrationScriptUrl}"></script>
    <script src="${loginScriptUrl}"></script>
    <script src="${booksScriptUrl}"></script>
    <script src="${profileScriptUrl}"></script>
    <script src="${backToProfileScriptUrl}"></script>
    <script src="${logoutScriptUrl}"></script>
    <title>App</title>
</head>
<body>
<div id="topnav-customer" class="hidden content">
    <a id="logout-menu-button" class="active" href="javascript:void(0);">Logout</a>
    <a href="javascript:void(0);" onclick="onListBooksClicked();">Browse Books</a>
    <a href="javascript:void(0);" onclick="onListBooksClicked();">Cart</a>
    <a href="javascript:void(0);" onclick="onListBooksClicked();">My Profile</a>
    <a href="javascript:void(0);" onclick="onBackToProfileClicked();">Back to profile</a>
</div>

<div id="topnav-admin" class="hidden content">
    <a id="logout-menu-button" class="active" href="javascript:void(0);">Logout</a>
    <a href="javascript:void(0);" onclick="onListSchedulesClicked();">Browse Books</a>
    <a href="javascript:void(0);" onclick="onListBooksClicked();">Add books</a>
    <a href="javascript:void(0);" onclick="onListBooksClicked();">Manage users</a>
    <a href="javascript:void(0);" onclick="onListBooksClicked();">My Profile</a>
    <a href="javascript:void(0);" onclick="onBackToProfileClicked();">Back to profile</a>
</div>

<div id="reg-content" class="hidden content">
    <h1>Customer registration</h1>
    <form id="reg-form" onsubmit="return false;">
        <h3>Email: </h3>
        <input type="text" name="email">
        <h3>Password: </h3>
        <input type="password" name="password">
        <h3>Full name: </h3>
        <input type="text" name="fullname">
        <h3>Address: </h3>
        <input type="text" name="address">
        <button id="reg-button" onclick="onRegistrationButtonClicked();">Registration</button>
    </form>
</div>

<div id="login-content" class="hidden content">
    <h1>Login as administrator</h1>
    <form id="login-form" onsubmit="return false;">
        <input type="text" name="email">
        <input type="password" name="password">
        <button id="login-button">Login</button>
    </form>
    <button onclick="onLoginAsCustomerClicked();">Login as customer</button>
</div>

<div id="login-content-customer" class="content">
    <h1>Login as customer</h1>
    <form id="login-form-customer" onsubmit="return false;">
        <input type="text" name="email">
        <input type="password" name="password">
        <button id="login-button-customer">Login</button>
    </form>
        <button onclick="onLoginAsAdministratorClicked();">Login as administrator</button>
        <button onclick="onRegistrationClicked();">Registration</button>

</div>

<div id="books-content" class="hidden content">
    
</div>

<div id="cart-content" class="hidden content">
    Items in your cart:
    Total value of the items:
    <a href="#">Proceed to checkout</a>
</div>

<div id="back-to-profile-content" class="hidden content">
    <br>
    <button onclick="onBackToProfileClicked();">Back to profile</button>
</div>

<div id="logout-content" class="hidden content">
    <button id="logout-button">Logout</button>
</div>
</body>
</html>
