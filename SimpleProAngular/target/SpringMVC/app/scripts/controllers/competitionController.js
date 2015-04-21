(function () {

    angular.module('thisApp').controller('CompetitionCtrl', CompetitionCtrl);

    CompetitionCtrl.$inject = ['$scope', '$location', '$routeParams', '$route', "Service"];

    function CompetitionCtrl($scope, $location, $routeParams, $route, Service) {

        getCompetition();
        $scope.addCompetition = addCompetition;
        $scope.competitions = null;
        $scope.deleteCompetition = deleteCompetition;
        $scope.getThisCompetition = getThisCompetition;
        $scope.updateCompetition = updateCompetition;
        $scope.competitionsClubs = competitionsClubs;
        $scope.removeClub = removeClub;
        $scope.addNewClub = addNewClub;

        $scope.competitionToUpdate = $routeParams.param;
        $scope.compClubs = $routeParams.param5;
        $scope.cid = $routeParams.cid;

        function addCompetition(obj) {
            Service.setDataCRUD(obj, 'setCompetition').then(
                function (data) {
                    $scope.competitionToAdd = data;
                    $location.path('first');
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

        function deleteCompetition(c) {
            Service.setDataCRUD(c, 'delCompetition').then(
                function (data) {
                    $scope.competitionToDelete = data;
                    $route.reload();
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        function getThisCompetition(id) {
            Service.setDataCRUD(id, 'getCompetitionWithId').then(
                function (data) {
                    $scope.competitionToUpd = data;
                    $location.path('updCompetition').search({param: $scope.competitionToUpd})
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        function updateCompetition(c) {
            Service.setDataCRUD(c, 'updCompetition').then(
                function (data) {
                    $scope.competitionToUpde = data;
                    $location.path('getCompetitions');
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

        function removeClub(id, cid){
            $scope.rem = {
                coid: cid,
                clid: id
            };
            Service.setDataCRUD($scope.rem, 'removeClub').then(
                function (data) {
                    $scope.competitionClubs = data;
                    $location.path('getCompetitionsClubs').search({param5: $scope.competitionClubs});
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        function addNewClub(cid){
            Service.setDataCRUD(cid, 'remainClubs').then(
                function (data) {
                    $scope.clubsToInsert = data;
                    $location.path('clubToCompetition').search({param6: cid, clubstoinsert: $scope.clubsToInsert});
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });

        }

    }

}());
