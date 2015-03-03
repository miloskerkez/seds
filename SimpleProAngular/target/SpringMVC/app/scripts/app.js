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
            })
            .otherwise('/first');
    });
