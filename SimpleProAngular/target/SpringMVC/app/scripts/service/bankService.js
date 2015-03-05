(function () {

    angular.module('thisApp').factory('BankService', BankService);

    BankService.$inject = ['$http', '$q'];

    function BankService($http, $q) {

        var baseUrl = "/api/";
        var services = {
            getAllBanks: getAllBanks,
            setDataCRUD: setDataCRUD
        };

        return services;

        /**
         * return list of persons from db
         * @returns {*}
         */
        function getAllBanks() {
            var deferred = $q.defer();
            $http.get(baseUrl + 'getViewBank')
                .success(function (data) {
                    deferred.resolve(data);
                })
                .error(function () {
                    deferred.reject("couldn't pull data from module!");
                });
            return deferred.promise;
        }

        function setDataCRUD(requestObject, urlPath) {
            var deferred = $q.defer();
            var url = baseUrl + urlPath;
            $http({
                method: 'POST',
                url: url,
                data: JSON.stringify(requestObject),
                headers: {'Content-Type': 'application/json'}
            })
                .success(function (data) {
                    deferred.resolve(data);
                })
                .error(function () {
                    deferred.reject("Request error.");
                });
            return deferred.promise;
        }

    }

}());