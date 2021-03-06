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
            }).when('/updClub', {
                templateUrl: 'views/updateClub.html',
                controller: 'ClubCtrl'
            }).when('/updCompetition', {
                templateUrl: 'views/updateCompetition.html',
                controller: 'CompetitionCtrl'
            }).when('/updManager', {
                templateUrl: 'views/updateManager.html',
                controller: 'ManagerCtrl'
            }).when('/updPlayer', {
                templateUrl: 'views/updatePlayer.html',
                controller: 'PlayerCtrl'
            }).when('/getManPlayers', {
                templateUrl: 'views/managerPlayers.html',
                controller: 'PlayerCtrl'
            }).when('/getAllPlayers', {
                templateUrl: 'views/getAllPlayers.html',
                controller: 'PlayerCtrl'
            }).when('/getCompetitionsClubs', {
                templateUrl:'views/allCompetitionsClubs.html',
                controller: 'CompetitionCtrl'
            }).when('/clubToCompetition', {
                templateUrl:'views/AddClubToCompetition.html',
                controller: 'ClubCtrl'
            }).when('/optionsToCreate', {
                templateUrl:'views/optionsToCreate.html',
                controller: 'FirstCtrl'
            })

            .otherwise('/first');
    });
