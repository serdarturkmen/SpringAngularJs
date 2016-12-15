app.controller('dashboardController', function($scope, $translate) {

    $scope.setLang = function(lang) {
        $translate.use(lang);
    };

});
