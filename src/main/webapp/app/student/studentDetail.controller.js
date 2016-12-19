angular.module('app')
    .controller('StudentDetailController', StudentDetailController);

StudentDetailController.$inject = ['Student', '$routeParams', '$location'];

function StudentDetailController(Student, $routeParams, $location) {
    var vm = this;

    vm.init = function () {
        console.log($routeParams.id);
        if ($routeParams.id != undefined) {
            if ($routeParams.id == "new") {
                vm.newStudent = true;
            } else {
                Student.get({'sId': $routeParams.id}, function (response) {
                    vm.student = response;
                })
            }
        }
    }
    
    vm.saveStudent = function () {
        Student.save(vm.student, function(response){
            $location.path("/students");
        });
    }


    vm.init();
}
