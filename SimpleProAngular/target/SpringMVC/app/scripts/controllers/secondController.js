(function(){

  angular.module('thisApp').controller('SecondCtrl', SecondCtrl);

  SecondCtrl.$inject = ['$scope', 'toaster', '$routeParams', 'Service'];

  function SecondCtrl($scope, toaster, $routeParams, Service){

    $scope.allBooks = null;
    $scope.searchBook = searchBook;
    $scope.deleteBook = deleteBook;
    $scope.addBook = addBook;
    $scope.clearText = clearText;

    getData($routeParams.witchBook);

    /**
     * Model for storing data from html to addBook()
     * @param name
     * @param year
     * @param author
     * @param pages
     * @param category
     * @param price
     * @constructor
     */
    function BookModel(name, year, author, pages, category, price){
      this.name = name;
      this.year = year;
      this.author = author;
      this.pages = pages;
      this.category = category;
      this.price = price;
    }

    $scope.book = new BookModel();

    /**
     * take book's name from html page and search if book with that name exist, and return book if exist.
     * @param scName
     */
/*    function searchBook(scName){
      for(var i=0; i<$scope.allBooks.length; i++){
        if($scope.allBooks[i].name == scName){
          $scope.bookSearched = $scope.allBooks[i];
          $scope.everything = false;
          $scope.oneThing = true;
          $scope.scName= "";
          $scope.noMessage="We found your book";
          break;
        }else{
          $scope.noMessage = "There is no book with that name!!!";
        }
      }
    }*/

    /**
     * Doesn't search for book, just return toast message when user click search button on html
     * @param word
     */
    function searchBook(word){
      toaster.pop('info', "Message", "That's all books which contains chars "+"'"+word+"'")
    }

    /**
     * take book's name from html page and delete it from collection
     * @param title
     */
    function deleteBook(title){
      var index = $scope.allBooks.indexOf(title);
      $scope.allBooks.splice(index, 1);
      toaster.pop('warning', "Notification", "Book with name "+title.name+" was deleted");
    }


    /**
     * add book in collection with object which receive from html page
     * @param obj
     */
    function addBook(obj){
      $scope.allBooks.push(obj);
      $scope.book = new BookModel();
      toaster.pop('success', "Notification", "Book "+obj.name+" was successfully added!!");
    }

    /**
     * get parameter from url and take list of books from json file
     * @param param
     */
    function getData(param){
      Service.getFromServer(param).then(
        function (data) {
            $scope.allBooks = data.books;
        },
        function (error) {
          $scope.noMessage = "error!!!!" +error;
        });
    }

      /**
       * clear text from search input
       */
    function clearText(){
      $scope.scName = "";
    }
  }

}());
