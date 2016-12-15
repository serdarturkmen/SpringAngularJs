app.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: '/dashboard.html',
            controller: 'dashboardController'
        })
        .when('/students', {
            templateUrl: '/app/student/student.html',
            controller: 'StudentController',
            controllerAs: 'vm'
        })
        .when('/students/:id', {
            templateUrl: '/app/student/studentDetail.html',
            controller: 'StudentDetailController',
            controllerAs: 'vm'
        })
        .when('/roles', {
            templateUrl: '/views/roles.template',
            controller: 'rolesController'
        })
        .otherwise(
            {redirectTo: '/'}
        );
});

