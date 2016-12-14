app.config(function ($routeProvider) {
    $routeProvider
        .when('/users', {
            templateUrl: '/views/users.template',
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

