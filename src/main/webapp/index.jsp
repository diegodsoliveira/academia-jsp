<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Elegant Dashboard | Sign In</title>
    <!-- Favicon -->
    <link rel="shortcut icon" href="<%= request.getContextPath()%>/assets/img/svg/logo.svg" type="image/x-icon">
    <!-- Custom styles -->
    <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/style.min.css">
</head>

<body>
<div class="layer"></div>
<main class="page-center">
    <article class="sign-up">
        <h1 class="sign-up__title">Seja bem vindo!</h1>
        <p class="sign-up__subtitle">Faça login para continuar</p>
        <form class="sign-up-form form" action="<%= request.getContextPath()%>/ServletLogin" method="post">
            <input type="hidden" value="<%= request.getParameter("url") %>" name="url" />
            <label class="form-label-wrapper">
                <p class="form-label">Login</p>
                <input class="form-input" type="text" placeholder="Insira seu login" required name="login">
            </label>
            <label class="form-label-wrapper">
                <p class="form-label">Senha</p>
                <input class="form-input" type="password" placeholder="Insira sua senha" required name="password">
            </label>
            <!-- <a class="link-info forget-link" href="##">Forgot your password?</a>
            <label class="form-checkbox-wrapper">
                <input class="form-checkbox" type="checkbox" required>
                <span class="form-checkbox-label">Lembrar de mim</span>
            </label>-->
            <button type="submit" class="form-btn primary-default-btn transparent-btn">Fazer login</button>

            <p class="sign-up__subtitle">${msg}</p>
        </form>
    </article>
</main>
<!-- Chart library -->
<script src="<%= request.getContextPath()%>/assets/plugins/chart.min.js"></script>
<!-- Icons library -->
<script src="plugins/feather.min.js"></script>
<!-- Custom scripts -->
<script src="js/script.js"></script>
</body>

</html>