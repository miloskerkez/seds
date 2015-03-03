(function(){

    angular.module('thisApp').controller('JsonCtrl', JsonCtrl);

    JsonCtrl.$inject = ['$scope', 'toaster', '$routeParams', 'Service'];

    function JsonCtrl($scope, toaster, $routeParams, Service){

        getData2();

        /**
         * get parameter from url and take list of books from json file
         * @param param
         */
        function getData2(){
            Service.getFromModule().then(
                function (data) {
                    $scope.person = data;
                },
                function (error) {
                    $scope.noMessage = "error!!!!" +error;
                });
        }

    }

}());
