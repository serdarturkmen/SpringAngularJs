app.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: '/dashboard.html',
            controller: 'dashboardController'
        })
        .when('/users', {
            templateUrl: '/app/user/users.html',
            controller: 'usersController'
        })
        .when('/roles', {
            templateUrl: '/views/roles.template',
            controller: 'rolesController'
        })
        .otherwise(
            {redirectTo: '/'}
        );
});

