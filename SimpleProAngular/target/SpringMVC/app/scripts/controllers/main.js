'use strict';

/**
 * @ngdoc function
 * @name thisApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the thisApp
 */
angular.module('thisApp')
  .controller('MainCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
