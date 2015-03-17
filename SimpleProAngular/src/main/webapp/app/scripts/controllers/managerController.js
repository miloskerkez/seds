(function () {

    angular.module('thisApp').controller('ManagerCtrl', ManagerCtrl);

    ManagerCtrl.$inject = ['$scope', '$location', '$routeParams', 'Service', '$route'];

    function ManagerCtrl($scope, $location, $routeParams, Service, $route) {

        getBanks();
        getManagers();

        $scope.addManager = addManager;
        //$scope.allbanks = null;
        $scope.managers = null;


        function getBanks() {
            Service.getAllData('getViewBank').then(
                function (data) {
                    $scope.allbanks = data;
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        function addManager(m, b) {
            var r = JSON.parse(b);
            $scope.pera = {
                managerFirstName: m.firstName,
                managerLastName: m.lastName,
                managerNationality: m.managerNationality,
                managerMoney: m.managerMoney,
                managerBank: {"bankName": r.bankvmName, "bankId": r.bankvmId}
            };

            Service.setDataCRUD($scope.pera, 'setManager').then(
                function (data) {
                    $scope.managerToAdd = data;
                    $location.path('first');
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        function getManagers() {
            Service.getAllData('getViewManager').then(
                function (data) {
                    $scope.managers = data;
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }


    }

}());
