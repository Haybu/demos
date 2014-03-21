var TodoController = angular.module("TodoController", ['TodoFactory']);

TodoController.controller("listController", ['$scope','$filter','TodoAPI', function($scope, $filter, TodoAPI) {
    $scope.todos = {};
    $scope.sortby = "duedate";
    $scope.is_desc = 1;

    var refresh = function (params) {

        /**
        var params = {};
        // apikey from mongolab
        params.apiKey = "L1BOjPy43DeKn6oTEa_yV6hGEiqeJnWQ";

        if (obj !== 'undefined') {
            $.extend(params,obj);
        }
         */

        console.log("refresh with query string: " + JSON.stringify(params));

        // get all todos
        TodoAPI.query(params,{}).$promise.then(
            // success
            function(data){
                $scope.todos = data;
            },
            // failure
            function(err){
                console.log(err);
            }
        );
    };

    // initializer
    var init = function() {
        refresh();
        $scope.action="add";
    };

    // initialize the todos list;
    init();

    var switchSortOrder = function (val) {
        if (val === 1) {
            return -1;
        } else {
            return 1;
        }
    }

    $scope.sortBy = function (col) {
        console.log("sorting by " + col);
        if (col === $scope.sortby) {
            $scope.is_desc = switchSortOrder($scope.is_desc);
        } else {
            $scope.sortby = col;
        }

        var params = "{\"s\" : {\"" + $scope.sortby + "\" : " + $scope.is_desc + "}}";
        console.log("parameters = " + params);
        refresh(JSON.parse(params));
    };

    $scope.addTodo = function () {

        if (typeof $scope.item == 'undefined') {
            return;
        }

        var dueDateArray = $scope.item.duedate.split("-");
        var year = dueDateArray[0];
        var month = dueDateArray[1];
        var day = dueDateArray[2];

        console.log("year = " + year + " month = " + month + " day = " + day);

        var newDate = new Date(year, month, day, 0, 0, 0, 0);

        $scope.item.duedate = newDate;

        TodoAPI.save($scope.item, function() {
            refresh();
            $scope.item.duedate = "";
            $scope.item.description = "";
        });
    };

    $scope.deleteTodo = function () {
        var rowId = this.todo._id.$oid;
        console.log("deleting row with id = " + rowId);
        TodoAPI.delete({_id : rowId}, function() {
            $("#r_"+rowId).fadeOut();
        });

    };

    $scope.editTodo = function () {
        $scope.action = "update";
        var rowId = this.todo._id.$oid;
        console.log("editing row with id " + rowId);
        // select the record from the database
        var param = {};
        param["_id"] = rowId;

        TodoAPI.get(param, function(data) {
            console.log("retrieving item from db: " + JSON.stringify(data));
            console.log("with id = " + data._id.$oid);
            $scope.item = {};
            var dt = new Date(data.duedate);
            $scope.item.duedate = $filter("date")(dt, 'yyyy-MM-dd');
            $scope.item.description =data.description;
            $scope.item.rowId = data._id.$oid;
        });

    };

    $scope.updateTodo = function () {
        var rowId = $scope.item.rowId;
        console.log("editing item with rowId = " + rowId);
        var param = {};
        param["_id"] = rowId;
        $scope.action = "add";
        TodoAPI.update(param,$scope.item, function(){
            refresh();
            $scope.item.duedate = "";
            $scope.item.description = "";
            $scope.item.rowId = "";
        });
    };

    $scope.cancel = function () {
        $scope.action = "add";
        delete $scope["item"];
    }

}]);