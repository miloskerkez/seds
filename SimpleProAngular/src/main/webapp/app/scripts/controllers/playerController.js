(function () {

    angular.module('thisApp').controller('PlayerCtrl', PlayerCtrl);

    PlayerCtrl.$inject = ['$scope', '$location', '$routeParams', 'Service', '$route'];

    function PlayerCtrl($scope, $location, $routeParams, Service, $route) {

        getManagers();
        getPlayers();
        getClub();

        $scope.addPlayer = addPlayer;




        function addPlayer(p, m, c) {
            var me = JSON.parse(m);
            var cl = JSON.parse(c);
            $scope.onePlayer = {
                playerFirstName: p.playerFirstName,
                playerLastName: p.playerLastName,
                playerYearOfBirth: p.playerYearOfBirth,
                playerNationality: p.playerNationality,
                playerPrice: p.playerPrice,
                playerClub: {"clubId": cl.clubvmId, "clubName": cl.clubvmName, "clubBirthYear": cl.clubvmBirthYear, "clubCountry": cl.clubvmCountry, "clubCity": cl.clubvmCity, "clubCompetition": cl.clubvmCompetition},
                playerManager:{"managerId": me.managervmId, "managerFirstName": me.managervmFirstName, "managerLastName": me.managervmLastName, "managerNationality": me.managervmNationality, "managerMoney": me.managervmMoney, "managerBank": me.managervmBank}
            };

            Service.setDataCRUD($scope.onePlayer, 'setPlayer').then(
                function (data) {
                    $scope.playerToAdd = data;
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

        function getPlayers(){
            Service.getAllData('getViewPlayer').then(
                function (data) {
                    $scope.players = data;
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        function getClub() {
            Service.getAllData('getViewClub').then(
                function (data) {
                    $scope.clubs = data;
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }


    }

}());
