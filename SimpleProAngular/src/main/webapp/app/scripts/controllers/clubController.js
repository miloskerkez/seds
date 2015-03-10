(function () {

    angular.module('thisApp').controller('ClubCtrl', ClubCtrl);

    ClubCtrl.$inject = ['$scope', '$location', '$routeParams', '$route', "Service"];

    function ClubCtrl($scope, $location, $routeParams, $route, Service) {

        $scope.addClub = addClub;
        getClub();
        $scope.clubs = null;

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
