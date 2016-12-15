app.controller('navbarController', function($scope, $translate) {
    $scope.hello = "hello navbar";
    $scope.setLang = function(lang) {
        $translate.use(lang);
    };

});