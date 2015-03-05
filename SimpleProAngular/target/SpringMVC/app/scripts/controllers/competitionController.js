(function () {

    angular.module('thisApp').controller('CompetitionCtrl', CompetitionCtrl);

    CompetitionCtrl.$inject = ['$scope', '$location', '$routeParams', '$route', "Service"];

    function CompetitionCtrl($scope, $location, $routeParams, $route, Service) {

        $scope.addCompetition = addCompetition;

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

    }

}());
