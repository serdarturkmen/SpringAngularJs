app.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: '/dashboard.html',
            controller: 'dashboardController'
        })
        .when('/students', {
            templateUrl: '/app/student/student.template',
            controller: 'StudentController',
            controllerAs: 'vm'
        })
        .when('/students/:id', {
            templateUrl: '/app/student/studentDetail.template',
            controller: 'StudentDetailController',
            controllerAs: 'vm'
        })
        .when('/students/new', {
            templateUrl: '/app/student/studentDetail.template',
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

