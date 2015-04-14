(function () {

    angular.module('thisApp').controller('FirstCtrl', FirstCtrl);

    FirstCtrl.$inject = ['$scope', '$location'];

    function FirstCtrl($scope, $location) {



        $scope.message = "This is first page";
        //$scope.loadData = loadData;
        $scope.goToAddBank = goToAddBank;
        $scope.goToAddCompetition = goToAddCompetition;
        $scope.goToAddClub = goToAddClub;
        $scope.goToViewBanks = goToViewBanks;
        $scope.goToViewClubs = goToViewClubs;
        $scope.goToViewCompetitions = goToViewCompetitions;
        $scope.goToAddManager = goToAddManager;
        $scope.goToViewManagers = goToViewManagers;
        $scope.goToViewPlayers = goToViewPlayers;
        $scope.goToAddPlayer = goToAddPlayer;
        $scope.goToAddContract = goToAddContract;
        $scope.goToAddClubToCompetition = goToAddClubToCompetition;


        function goToAddBank() {
            $location.path('bank')
        }

        function goToAddCompetition(){
            $location.path('competition')
        }

        function goToAddClub(){
            $location.path('club')
        }

        function goToViewBanks(){
            $location.path('getBanks')
        }

        function goToViewClubs(){
            $location.path('getClubs')
        }

        function goToViewCompetitions(){
            $location.path('getCompetitions')
        }

        function goToAddManager(){
            $location.path('manager')
        }

        function goToViewManagers(){
            $location.path('getManagers')
        }

        function goToViewPlayers(){
            $location.path('getPlayers')
        }

        function goToAddPlayer(){
            $location.path('player')
        }

        function goToAddContract(){
            $location.path('contract')
        }

        function goToAddClubToCompetition(){
            $location.path('clubToCompetition')
        }


    }

}());
