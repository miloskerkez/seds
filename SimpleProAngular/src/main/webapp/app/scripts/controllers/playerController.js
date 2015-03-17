(function () {

    angular.module('thisApp').controller('PlayerCtrl', PlayerCtrl);

    PlayerCtrl.$inject = ['$scope', '$location', '$routeParams', 'Service', '$route'];

    function PlayerCtrl($scope, $location, $routeParams, Service, $route) {

        getManagers();
        getPlayers();




        /*function addManager(m, b) {
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
        }*/

        function getManagers() {
            Service.getAllData('getViewManager').then(
                function (data) {
                    $scope.managers = data;
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        function getPlayers(){
            Service.getAllData('getViewPlayer').then(
                function (data) {
                    $scope.players = data;
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }


    }

}());
