'use strict';

/**
 * @ngdoc overview
 * @name thisApp
 * @description
 * # thisApp
 *
 * Main module of the application.
 */
angular
    .module('thisApp', [
        'ngAnimate',
        'ngCookies',
        'ngResource',
        'ngRoute',
        'ngSanitize',
        'ngTouch',
        'toaster'
    ])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/first', {
                templateUrl: 'views/first.html',
                controller: 'FirstCtrl'
            })
            .when('/second', {
                templateUrl: 'views/second.html',
                controller: 'SecondCtrl'
            })
            .when('/json', {
                templateUrl: 'views/json.html',
                controller: 'JsonCtrl'
            })
            .when('/dog', {
                templateUrl: 'views/dogs.html',
                controller: 'DogCtrl'
            })
            .when('/person', {
                templateUrl: 'views/displayPerson.html',
                controller: 'PersonCtrl'
            })
            .when('/addPerson', {
                templateUrl: 'views/createPerson.html',
                controller: 'PersonCtrl'
            })
            .when('/addDog', {
                templateUrl: 'views/addDog.html',
                controller: 'DogCtrl'
            })
            .when('/updPerson', {
                templateUrl: 'views/updatePerson.html',
                controller: 'PersonCtrl'
            })
            .when('/updDog', {
                templateUrl: 'views/updateDog.html',
                controller: 'DogCtrl'
            }).when("/bank", {
                templateUrl: 'views/addBank.html',
                controller: 'BankCtrl'
            }).when('/competition',{
                templateUrl: 'views/addCompetition.html',
                controller: 'CompetitionCtrl'
            }).when('/club', {
                templateUrl: 'views/addClub.html',
                controller: 'ClubCtrl'
            }).when('/getBanks',{
                templateUrl: 'views/allBanks.html',
                controller: 'BankCtrl'
            }).when('/getClubs',{
                templateUrl: 'views/allClubs.html',
                controller: 'ClubCtrl'
            }).when('/getCompetitions',{
                templateUrl: 'views/allCompetitions.html',
                controller: 'CompetitionCtrl'
            }).when('/manager', {
                templateUrl: 'views/addManager.html',
                controller: 'ManagerCtrl'
            }).when('/getManagers',{
                templateUrl: 'views/allManagers.html',
                controller: 'ManagerCtrl'
            }).when('/getPlayers', {
                templateUrl: 'views/allPlayers.html',
                controller: 'PlayerCtrl'
            }).when('/player',{
                templateUrl: 'views/addPlayer.html',
                controller: 'PlayerCtrl'
            }).when('/contract', {
                templateUrl: 'views/addContract.html',
                controller: 'ContractCtrl'
            }).when('/updBank', {
                templateUrl: 'views/updateBank.html',
                controller: 'BankCtrl'
            })

            .otherwise('/first');
    });
