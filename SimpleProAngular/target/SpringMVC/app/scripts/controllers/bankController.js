(function () {

    angular.module('thisApp').controller('BankCtrl', BankCtrl);

    BankCtrl.$inject = ['$scope', '$location', '$routeParams', '$route', "Service"];

    function BankCtrl($scope, $location, $routeParams, $route, Service) {

        $scope.addBank = addBank;

        function addBank(obj) {
            Service.setDataCRUD(obj, 'setBank').then(
                function (data) {
                    $scope.bankToAdd = data;
                    $location.path('first');
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

    }

}());
