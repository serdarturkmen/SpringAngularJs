angular.module('app')
    .controller('StudentController', StudentController);

StudentController.$inject = ['Student', '$location'];

function StudentController (Student, $location) {
    var vm = this;
    vm.headingTitle = "User List";
     Student.query(function (response) {
         vm.students = response;
         Student.get({'sId' : response[0].id}, function (response) {
             console.log(response);
         })
     });

    vm.deleteStudent = function (student) {
        Student.delete({sId : student.id},function (response) {
            var index = vm.students.indexOf(student);
            vm.students.splice(index, 1);
            console.log("deleted")
        })
    }

    vm.addNew = function(){
        $location.path("students/new");
    }
}
