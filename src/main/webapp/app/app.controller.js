app.controller('usersController', function($scope,$translate) {
    $scope.headingTitle = "User List";
    $scope.setLang = function(lang) {
        $translate.use(lang);
    };
});

app.controller('rolesController', function($scope) {
    $scope.headingTitle = "Roles Listd";

});
