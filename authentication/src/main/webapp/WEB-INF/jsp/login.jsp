<%@ page pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.staticfile.org/angular.js/1.7.9/angular.min.js"></script>
</head>
<body>
<form class="form-horizontal" role="form" ng-app="myLogin" ng-controller="loginCtrl">
    <div class="form-group">
        <label for="Username" class="control-label">用户名</label>
        <input type="text" class="form-control" id="Username" placeholder="请输入用户名">
    </div>
    <div class="form-group">
        <label for="Password" class="control-label">密码</label>
        <input type="text" class="form-control" id="Password" placeholder="请输入密码">
    </div>
    <input type="hidden" id="response_type" value="code">
    <input type="hidden" id="scope" value="all">
    <input type="hidden" id="client_id" value="user-client">
    <input type="hidden" id="redirect_uri" value="http://localhost:8081">
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button ng-click="login()" class="btn btn-default">登录</button>
        </div>
    </div>
</form>
<script>

    var app = angular.module("myLogin", []);

    app.controller("loginCtrl", function($scope, $http) {
    });
    function login($scope, $http) {
        $http({
            method:'POST',
            url:'/oauth/authorize'
        }).then(function successCallback(response) {
            console.log(response.data);
        }, function errorCallback(response) {
            console.log(response.data);
        });
    }
</script>
</body>
</html>
