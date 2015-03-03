(function () {

    angular.module('thisApp').factory('Service', Service);

    Service.$inject = ['$http', '$q'];

    function Service($http, $q) {

        var urlPrefix = "scripts/data/";
        var urlSuffix = ".json";
        var baseUrl = "/api/";
        var service = {
            getFromServer: getFromServer,
            getDogs: getDogs,
            setDataCRUD: setDataCRUD
        };
        return service;

        /**
         * receive parameter for url and return data from that url
         * @param url
         * @returns {jQuery.promise|promise.promise|d.promise|promise|.ready.promise|jQuery.ready.promise|*}
         */
        function getFromServer(param) {
            var deferred = $q.defer();
            $http.get(urlPrefix + param + urlSuffix)
                .success(function (data) {
                    deferred.resolve(data);
                })
                .error(function () {
                    deferred.reject("bad");
                });
            return deferred.promise;
        }

        /**
         * return list of dogs from db
         * @returns {*}
         */
        function getDogs() {
            var deferred = $q.defer();
            $http.get(baseUrl + 'getDogs')
                .success(function (data) {
                    deferred.resolve(data);
                })
                .error(function () {
                    deferred.reject("couldn't pull data from module!");
                });
            return deferred.promise;
        }

        /**
         * send data to server and get response, work for CRUD operations with post methods
         * @param requestObject
         * @param urlPath
         * @returns {*}
         */
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
