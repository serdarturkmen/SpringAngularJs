angular.module('app')
    .controller('StudentDetailController', StudentDetailController);

StudentDetailController.$inject = ['Student', '$routeParams'];

function StudentDetailController (Student, $routeParams) {
    var vm = this;
    
    vm.init = function () {
        Student.get({'sId' : $routeParams.id}, function (response) {
            vm.student = response;
        })
    }

    vm.init();
}
