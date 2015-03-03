(function () {

    angular.module('thisApp').controller('PersonCtrl', PersonCtrl);

    PersonCtrl.$inject = ['$scope', 'PersonService', '$location', '$routeParams', '$route', 'Service'];

    function PersonCtrl($scope, PersonService, $location, $routeParams, $route, Service) {

        getPerson();

        $scope.addPerson = addPerson;
        $scope.deletePerson = deletePerson;
        $scope.updatePerson = updatePerson;
        $scope.viewPersonList = null;
        $scope.getThisPerson = getThisPerson;

        $scope.personToUpdate = $routeParams.param;


        function PersonModel(name, age) {
            this.names = name;
            this.year = age;
        }

        $scope.updPerson = new PersonModel();

        /**
         * receive person object and store him into db
         * @param obj
         */
        function addPerson(obj) {
            Service.setDataCRUD(obj, 'setPerson').then(
                function (data) {
                    $scope.personToAdd = data;
                    $location.path('first');
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        /**
         * return list of all persons and store that list in allPersons variable
         */
        function getPerson() {
            PersonService.getAllPersons().then(
                function (data) {
                    $scope.viewPersonList = data;

                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        /**
         * receive person id and delete person with that id from db
         * @param d
         */
        function deletePerson(d) {
            Service.setDataCRUD(d, 'delPerson').then(
                function (data) {
                    $scope.perToDel = data;
                    $route.reload();
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        /**
         * receive person id and return person with that id
         * @param id
         */
        function getThisPerson(id) {
            Service.setDataCRUD(id, 'getPersonWithId').then(
                function (data) {
                    $scope.perToUpd = data;
                    $location.path('updPerson').search({param: $scope.perToUpd})
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        /**
         * receive person who need to be updated and update information of that person
         * @param per
         */
        function updatePerson(per) {
            Service.setDataCRUD(per, 'updPerson').then(
                function (data) {
                    $scope.perToUpde = data;
                    $location.path('person');
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

    }

}());







