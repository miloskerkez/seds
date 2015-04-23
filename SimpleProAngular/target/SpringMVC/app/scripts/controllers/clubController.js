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
        $scope.competitionsClubs = competitionsClubs;

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
                    Service.setDataCRUD(coid, 'remainClubs').then(
                        function (data) {
                            $scope.clubsToInsert = data;
                            $location.path('clubToCompetition').search({param6: coid, clubstoinsert: $scope.clubsToInsert});
                        },
                        function (error) {
                            $scope.noMessage = "error!!!!" + error;
                        });

                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }
        function competitionsClubs(cid){
            Service.setDataCRUD(cid, 'getCompetitionsClubs').then(
                function (data) {
                    $scope.competitionClubs = data;
                    $location.path('getCompetitionsClubs').search({param5: $scope.competitionClubs, cid: cid});
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }



    }

}());
