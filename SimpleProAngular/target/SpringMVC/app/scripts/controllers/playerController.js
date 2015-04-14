(function () {

    angular.module('thisApp').controller('PlayerCtrl', PlayerCtrl);

    PlayerCtrl.$inject = ['$scope', '$location', '$routeParams', 'Service', '$route', 'toaster'];

    function PlayerCtrl($scope, $location, $routeParams, Service, $route, toaster) {

        getManagers();
        getPlayers();
        getClub();

        $scope.addPlayer = addPlayer;
        $scope.deletePlayer = deletePlayer;
        $scope.getThisPlayer = getThisPlayer;
        $scope.updatePlayer = updatePlayer;
        $scope.buyPlayer = buyPlayer;

        $scope.playerToUpdate = $routeParams.param;
        $scope.managerPlayers = $routeParams.param2;
        $scope.allPlayerss = $routeParams.param3;
        $scope.managerToBuy = $routeParams.param4;


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

        function deletePlayer(p) {
            Service.setDataCRUD(p, 'delPlayer').then(
                function (data) {
                    $scope.playerToDelete = data;
                    $route.reload();
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        function getThisPlayer(id) {
            Service.setDataCRUD(id, 'getPlayerWithId').then(
                function (data) {
                    $scope.playerToUpd = data;
                    $location.path('updPlayer').search({param: $scope.playerToUpd})
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        function updatePlayer(p) {
            Service.setDataCRUD(p, 'updPlayer').then(
                function (data) {
                    $scope.playerToUpde = data;
                    $location.path('getPlayers');
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        function buyPlayer(p,m){
            Service.buyPlayerService(p, m, 'ExchangePlayer').then(
                function (data) {
                    $scope.messageFromBuy = data;
                    toaster.pop('info', "Message", $scope.messageFromBuy.messageBuy);
                    console.log($scope.messageFromBuy);
                    //$location.path('getPlayers');
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }


    }

}());
