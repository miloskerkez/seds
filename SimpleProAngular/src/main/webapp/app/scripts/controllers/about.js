'use strict';

/**
 * @ngdoc function
 * @name thisApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the thisApp
 */
angular.module('thisApp')
  .controller('AboutCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
