(function () {

    angular.module('thisApp').factory('DogService', DogService);

    DogService.$inject = ['$http', '$q'];

    function DogService($http, $q) {

        var baseUrl = "/api/";
        var services = {
            saveDog: saveDog,
            deleteDog: deleteDog,
            getOneDog: getOneDog,
            updateDog: updateDog
        };
        return services;


        /**
         * receive dog object and store him into db
         * @param requestObject
         * @param urlPath
         * @returns {*}
         */
        function saveDog(requestObject, urlPath) {
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

        /**
         * receive id of a dog and delete him from db
         * @param requestObject
         * @param urlPath
         * @returns {*}
         */
        function deleteDog(requestObject, urlPath) {
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

        /**
         * receive id of a dog, find dog with that id and return him
         * @param requestObject
         * @param urlPath
         * @returns {*}
         */
        function getOneDog(requestObject, urlPath) {
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

        /**
         * receive dog object and update dog with values of that object
         * @param requestObject
         * @param urlPath
         * @returns {*}
         */
        function updateDog(requestObject, urlPath) {
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