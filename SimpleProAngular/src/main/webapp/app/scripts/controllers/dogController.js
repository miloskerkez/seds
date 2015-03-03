(function () {

    angular.module('thisApp').controller('DogCtrl', DogCtrl);

    DogCtrl.$inject = ['$scope', '$location', '$routeParams', 'Service', 'PersonService', '$route'];

    function DogCtrl($scope, $location, $routeParams, Service, PersonService, $route) {

        getData();
        getPersons();


        $scope.addDog = addDog;
        $scope.deleteDog = deleteDog;
        $scope.updateDog = updateDog;
        $scope.getThisDog = getThisDog;
        $scope.dog = null;
        $scope.persons = null;

        $scope.dogToUpdate = $routeParams.param;


        /**
         * get all persons from server and store them in persons variable
         */
        function getPersons() {
            PersonService.getAllPersons().then(
                function (data) {
                    $scope.persons = data;
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        function DogModel(name) {
            this.name = name
        }

        $scope.newDog = new DogModel();


        function PersonM(person) {
            this.person = person;
        }

        $scope.newPers = new PersonM();


        /**
         * get list of dogs from server and store them in dog variable
         */
        function getData() {
            Service.getDogs().then(
                function (data) {
                    $scope.dog = data;
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }


        /**
         * receive dog name d and person p who is owner of the dog and save that dog to db
         * @param d
         * @param p
         */
        function addDog(d, p) {
            var r = JSON.parse(p);
            $scope.pera = {
                name: d.name,
                person: {"name": r.personName, "age": r.personAge, "dogs": r.dogs, "id": r.personId}
            };

            Service.setDataCRUD($scope.pera, 'setDog').then(
                function (data) {
                    $scope.dogToAdd = data;
                    $location.path('first');
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        /**
         * receive dog's id and remove from db dog with that id
         * @param d
         */
        function deleteDog(d) {
            Service.setDataCRUD(d, 'delDog').then(
                function (data) {
                    $scope.dogToDelete = data;
                    $route.reload();
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

        /**
         * receive dog's id and return dog's data of dog with that id
         * @param id
         */
        function getThisDog(id) {
            Service.setDataCRUD(id, 'getDogWithId').then(
                function (data) {
                    $scope.dToUpd = data;
                    $location.path('updDog').search({param: $scope.dToUpd})
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });

        }

        /**
         * receive data of dog who need to be updated and update information of that dog
         * @param d
         */
        function updateDog(d) {
            Service.setDataCRUD(d, 'updDog').then(
                function (data) {
                    $scope.dToUpde = data;
                    $location.path('dog');
                },
                function (error) {
                    $scope.noMessage = "error!!!!" + error;
                });
        }

    }

}());
