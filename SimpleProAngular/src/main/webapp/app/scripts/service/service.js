(function () {

    angular.module('thisApp').factory('Service', Service);

    Service.$inject = ['$http', '$q'];

    function Service($http, $q) {

        var baseUrl = "/api/";
        var service = {
            setDataCRUD: setDataCRUD,
            getAllData: getAllData,
            buyPlayerService: buyPlayerService
        };
        return service;


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

        function buyPlayerService(requestObject1, requestObject2, urlPath) {
            var deferred = $q.defer();
            var url = baseUrl + urlPath;
            $http({
                method: 'POST',
                url: url,
                data: {
                    pid: JSON.stringify(requestObject1),
                    mid: JSON.stringify(requestObject2)
                },
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


        function getAllData(url) {
            var deferred = $q.defer();
            $http.get(baseUrl + url)
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
