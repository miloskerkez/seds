(function () {

    angular.module('thisApp').factory('PersonService', PersonService);

    PersonService.$inject = ['$http', '$q'];

    function PersonService($http, $q) {

        var baseUrl = "/api/";
        var services = {
            getAllPersons: getAllPersons
        };

        return services;

        /**
         * return list of persons from db
         * @returns {*}
         */
        function getAllPersons() {
            var deferred = $q.defer();
            $http.get(baseUrl + 'getViewPerson')
                .success(function (data) {
                    deferred.resolve(data);
                })
                .error(function () {
                    deferred.reject("couldn't pull data from module!");
                });
            return deferred.promise;
        }

    }

}());