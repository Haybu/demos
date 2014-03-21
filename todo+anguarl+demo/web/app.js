var app = angular.module("app", [
    'ngRoute',
    'TodoController'
]);

app.config(['$routeProvider', function ($routeProvider) {

    $routeProvider.when("/",
        {
            templateUrl: "web/partials/listTodos.html",
            controller: "listController"
        }
    );
}]);
