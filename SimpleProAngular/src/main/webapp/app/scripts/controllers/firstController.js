(function () {

    angular.module('thisApp').controller('FirstCtrl', FirstCtrl);

    FirstCtrl.$inject = ['$scope', '$location'];

    function FirstCtrl($scope, $location) {



        $scope.message = "This is first page";
        $scope.loadData = loadData;
        $scope.goToAddPerson = goToAddPerson;
        $scope.goToAddDog = goToAddDog;
        $scope.goToSeePerson = goToSeePerson;
        $scope.goToSeeDog = goToSeeDog;
        $scope.goToAddBank = goToAddBank;
        $scope.goToAddCompetition = goToAddCompetition;
        $scope.goToAddClub = goToAddClub;
        $scope.goToViewBanks = goToViewBanks;
        $scope.goToViewClubs = goToViewClubs;
        $scope.goToViewCompetitions = goToViewCompetitions;

        /**
         * send parameter via url to retrieve wanted data depending of which checkbox is checked
         */
        /*function loadData(){
         if($scope.chFirst && $scope.chSecond){
         $scope.noMessage="Chose only one file!!!"
         }else if($scope.chFirst){
         $location.path('/second').search({param: "Books1"});
         }else if($scope.chSecond){
         $location.path('/second').search({param: "Books2"});
         }else{
         $scope.noMessage="Chose one data!!!";
         }
         }*/

        /**
         * send parameter via url to retrieve wanted data depending of which collection is selected
         */
        function loadData(par) {
            if (!par) {
                $scope.noMessage = "Please select one collection!!!";
            } else {
                $location.path('second').search({witchBook: par})
            }
        }

        /**
         * go to page for adding a person
         */
        function goToAddPerson() {
            $location.path('addPerson')
        }

        /**
         * go to page to add a dog
         */
        function goToAddDog() {
            $location.path('addDog')
        }

        /**
         * go to page where is list of all persons
         */
        function goToSeePerson() {
            $location.path('person')
        }

        /**
         * go to page where is list of all dogs
         */
        function goToSeeDog() {
            $location.path('dog')
        }

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


    }

}());
