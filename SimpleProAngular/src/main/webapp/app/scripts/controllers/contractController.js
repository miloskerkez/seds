(function () {

    angular.module('thisApp').controller('ContractCtrl', ContractCtrl);

    ContractCtrl.$inject = ['$scope', '$location', '$routeParams', 'Service', '$route'];

    function ContractCtrl($scope, $location, $routeParams, Service, $route) {

        getPlayers();

        $scope.addContract = addContract;




        function addContract(c, p) {
            var pl = JSON.parse(p);
            $scope.oneContract = {
                contractSalary: c.contractSalary,
                contractDuration: c.contractDuration,
                contractPlayer: {"playerId": pl.playervmId}
            };

            Service.setDataCRUD($scope.oneContract, 'setContract').then(
                function (data) {
                    $scope.contractToAdd = data;
                    $location.path('first');
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
