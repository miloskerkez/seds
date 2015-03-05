(function () {

    angular.module('thisApp').controller('ClubCtrl', ClubCtrl);

    ClubCtrl.$inject = ['$scope', '$location', '$routeParams', '$route', "Service"];

    function ClubCtrl($scope, $location, $routeParams, $route, Service) {

        $scope.addClub = addClub;

        function addClub(obj) {
            Service.setDataCRUD(obj, 'setClub').then(
                function (data) {
                    $scope.clubToAdd = data;
                    $location.path('first');
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

    }

}());
