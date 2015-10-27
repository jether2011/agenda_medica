var app = angular.module('dwmApp', []);

app.controller('pessoaCtrl', function ($scope, $http, $timeout) {
    $scope.pessoas = [];
    $scope.loadPessoaApp = function () {
        $http.get("http://localhost:9090/DWM2015/api/pessoa/", {cache: false})
                .success(function (response) {
                    //console.log(response);
                    $scope.pessoas = response;
                });
        $scope.config = {
            itemsPerPage: 5,
            fillLastPage: true
        }
    };
    var interval = setInterval(function(){
       // $scope.loadPessoaApp()
    }, 2000);
    //$scope.loadPessoaApp();
});

app.controller('formCtrl', function($scope, $http, $timeout) {    
    $scope.save = function(pessoa) {  
        var values = JSON.stringify(pessoa);     
        console.log(values);
        $http({            
            url: 'http://localhost:9090/DWM2015/api/pessoa/',             
            method: 'POST',         
            data: values,
            headers: {'Content-Type':'application/json; charset=utf-8'}           
        }).success(function(status) {
            console.log("Success: ");
            console.log(status);            
        }).error(function(status) {
            console.log("Error: ");
            console.log(status);
        });
    };
});