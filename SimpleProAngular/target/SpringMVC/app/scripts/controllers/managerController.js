(function () {

    angular.module('thisApp').controller('ManagerCtrl', ManagerCtrl);

    ManagerCtrl.$inject = ['$scope', '$location', '$routeParams', 'Service', '$route'];

    function ManagerCtrl($scope, $location, $routeParams, Service, $route) {

        getBanks();
        getManagers();

        $scope.addManager = addManager;
        $scope.managers = null;
        $scope.deleteManger = deleteManger;
        $scope.getThisManager = getThisManager;
        $scope.updateManager = updateManager;

        $scope.managerToUpdate = $routeParams.param;


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

        function deleteManger(m) {
            Service.setDataCRUD(m, 'delManager').then(
                function (data) {
                    $scope.managerToDelete = data;
                    $route.reload();
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        function getThisManager(id) {
            Service.setDataCRUD(id, 'getManagerWithId').then(
                function (data) {
                    $scope.managerToUpd = data;
                    $location.path('updManager').search({param: $scope.managerToUpd})
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        function updateManager(m) {
            Service.setDataCRUD(m, 'updManager').then(
                function (data) {
                    $scope.managerToUpde = data;
                    $location.path('getManagers');
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }



    }

}());
