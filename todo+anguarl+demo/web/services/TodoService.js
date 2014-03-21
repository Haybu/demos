var TodoFactory = angular.module("TodoFactory", ["ngResource"]);

TodoFactory.factory("TodoAPI", ['$resource',function ($resource){

    return $resource(
        'https://api.mongolab.com/api/1/databases/todo/collections/demoTodo/:_id?apiKey=L1BOjPy43DeKn6oTEa_yV6hGEiqeJnWQ',
        { _id: '@_id' },
        {update: { method : 'PUT'}}
    );

}]);