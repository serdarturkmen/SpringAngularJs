app.controller('NavbarController', NavbarController);

NavbarController.$inject = ['$translate', 'Student'];

function NavbarController ($translate, Student) {
    var vm = this;
    vm.hello = "hello navbar";
    vm.redirectUrl = "dashboard";
    vm.setLang = function(lang) {
        $translate.use(lang);
    };
    vm.students = Student.query();

}