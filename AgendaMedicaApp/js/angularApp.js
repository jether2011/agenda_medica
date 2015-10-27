var app = angular.module('agendaMedicaApp', []);

//var urlPath = "http://192.168.0.5:9090/DWM2015/api/consulta/";
var urlPath = "http://localhost:8080/agenda_medica/";
// var urlPath = "http://172.16.21.234:8080/DWM2015/api/consulta/all";

app.controller('consultaCtrl', function ($scope, $http, $timeout) {
    $scope.consultas = [];
    $scope.loadConsultaApp = function () {
        $http.get(urlPath, {cache: false})
                .success(function (response) {
                    //console.log(response);
                    $scope.consultas = response;
                });
        $scope.config = {
            itemsPerPage: 5,
            fillLastPage: true
        }
    };

    $scope.delete = function (idConsulta) {
        console.log("tentar delete em: "+idConsulta);
        $http({            
            url: urlPath+idConsulta,             
            method: 'DELETE'            
        }).success(function(status) {
            console.log("Success: ");
            console.log(status);            
        }).error(function(status) {
            console.log("Error: ");
            console.log(status);
        });
    };

    var interval = setInterval(function(){
       $scope.loadConsultaApp()
    }, 2000);
    //$scope.loadConsultaApp();
});

app.controller('formCtrl', function($scope, $http, $timeout) {    
    $scope.save = function(consulta) {  
        var values = JSON.stringify(consulta);     
        console.log(values);
        $http({            
            url: 'http://localhost:8080/agenda_medica/',             
            // url: 'http://172.16.21.234:8080/DWM2015/api/consulta/',
            method: 'POST',         
            data: values,
            headers: {'Content-Type':'application/json; charset=utf-8'}           
        }).success(function(status) {
            console.log("Success: ");
            console.log(status);
            $scope.consulta.nome="";
            $scope.consulta.email="";            
        }).error(function(status) {
            console.log("Error: ");
            console.log(status);
        });
    };
});