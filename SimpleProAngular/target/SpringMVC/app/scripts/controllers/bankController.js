(function () {

    angular.module('thisApp').controller('BankCtrl', BankCtrl);

    BankCtrl.$inject = ['$scope', '$location', '$routeParams', '$route', "Service"];

    function BankCtrl($scope, $location, $routeParams, $route, Service) {
        $scope.addBank = addBank;
        $scope.deleteBank = deleteBank;
        getBank();
        $scope.banks = null;
        $scope.getThisBank = getThisBank;
        $scope.updateBank = updateBank;

        $scope.bankToUpdate = $routeParams.param;

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

        function getBank() {
            Service.getAllData('getViewBank').then(
                function (data) {
                    $scope.banks = data;
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        function deleteBank(d) {
            Service.setDataCRUD(d, 'delBank').then(
                function (data) {
                    $scope.bankToDelete = data;
                    $route.reload();
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        function getThisBank(id) {
            Service.setDataCRUD(id, 'getBankWithId').then(
                function (data) {
                    $scope.bankToUpd = data;
                    $location.path('updBank').search({param: $scope.bankToUpd})
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        function updateBank(b) {
            Service.setDataCRUD(b, 'updBank').then(
                function (data) {
                    $scope.bankToUpde = data;
                    $location.path('getBanks');
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

    }

}());
