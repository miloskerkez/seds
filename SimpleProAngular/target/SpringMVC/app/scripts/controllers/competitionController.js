(function () {

    angular.module('thisApp').controller('CompetitionCtrl', CompetitionCtrl);

    CompetitionCtrl.$inject = ['$scope', '$location', '$routeParams', '$route', "Service"];

    function CompetitionCtrl($scope, $location, $routeParams, $route, Service) {

        getCompetition();
        $scope.addCompetition = addCompetition;
        $scope.competitions = null;
        $scope.deleteCompetition = deleteCompetition;

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

    }

}());
