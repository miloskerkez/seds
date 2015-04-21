(function () {

    angular.module('thisApp').controller('ClubCtrl', ClubCtrl);

    ClubCtrl.$inject = ['$scope', '$location', '$routeParams', '$route', "Service"];

    function ClubCtrl($scope, $location, $routeParams, $route, Service) {

        $scope.addClub = addClub;
        $scope.deleteClub = deleteClub;
        getClub();
        getCompetition();
        $scope.clubs = null;
        $scope.getThisClub = getThisClub;
        $scope.updateClub = updateClub;
        $scope.addClubToCompetition = addClubToCompetition;

        $scope.clubToUpdate = $routeParams.param;
        $scope.compid = $routeParams.param6;
        $scope.clubsToInsert = $routeParams.clubstoinsert;

        function addClub(clubb) {
            Service.setDataCRUD(clubb, 'setClub').then(
                function (data) {
                    $scope.clubToAdd = data;
                    $location.path('first');
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

        function getCompetition() {
            Service.getAllData('getViewCompetitions').then(
                function (data) {
                    $scope.competitions = data;
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        function deleteClub(c) {
            Service.setDataCRUD(c, 'delClub').then(
                function (data) {
                    $scope.clubToDelete = data;
                    $route.reload();
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        function getThisClub(id) {
            Service.setDataCRUD(id, 'getClubWithId').then(
                function (data) {
                    $scope.clubToUpd = data;
                    $location.path('updClub').search({param: $scope.clubToUpd})
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        function updateClub(c) {
            Service.setDataCRUD(c, 'updClub').then(
                function (data) {
                    $scope.clubToUpde = data;
                    $location.path('getClubs');
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        function addClubToCompetition(coid,clid){
            $scope.ovo = {
                coid: coid,
                clid: clid
            };
            Service.setDataCRUD($scope.ovo, 'addClubToCompetition').then(
                function (data) {
                    $scope.clubComp = data;
                    if($scope.clubComp.messageBuy=="This club is already in that competition"){
                        $scope.noMessage = $scope.clubComp.messageBuy;
                    }else{
                    $location.path('first');
                    }
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }



    }

}());
