app = angular.module('appointment', []);

app.controller("AppointmentsController", function ($scope, $http) {

    $scope.successGetAppointmentsCallback = function (response) {
         $scope.appointmentList = response.data;
        $scope.errormessage="";
    };

    $scope.errorGetAppointmentsCallback = function (error) {
        console.log(error);
        $scope.errormessage="Unable to get list of appointments";
    };

   $scope.getAppointments = function () {
        $http.get('/public/rest/appointment').then($scope.successGetAppointmentsCallback, $scope.errorGetAppointmentsCallback);
    };


    $scope.successDeleteAppointmentCallback = function (response) {
        for (var i = 0; i < $scope.appointmentList.length; i++) {
            var j = $scope.appointmentList[i];
            if (j.id === $scope.deletedId) {
                $scope.appointmentList.splice(i, 1);
                break;
            }
        }
        $scope.errormessage="";
        $http.get('/public/rest/appointment').then($scope.successGetAppointmentsCallback, $scope.errorGetAppointmentsCallback);
    };

    $scope.errorDeleteAppointmentCallback = function (error) {
        console.log(error);
        $scope.errormessage="Unable to delete appointment; check if there are any related records exist. Such records should be removed first";
    };

    $scope.deleteAppointment = function (id) {
        $scope.deletedId = id;
        $http.delete('/public/rest/appointment/' + id).then($scope.successDeleteAppointmentCallback, $scope.errorDeleteAppointmentCallback);
    };

    $scope.successGetAppointmentCallback = function (response) {
        $scope.appointmentList.splice(0, 0, response.data);
        $scope.errormessage="";
    };

    $scope.errorGetAppointmentCallback = function (error) {
        console.log(error);
        $scope.errormessage="Unable to get information on appointment";
    };

    $scope.successAddAppointmentCallback = function (response) {
        $http.get('/public/rest/appointment').then($scope.successGetAppointmentsCallback, $scope.errorGetAppointmentsCallback);
        $scope.errormessage="";
    };

    $scope.errorAddAppointmentCallback = function (error) {
        console.log(error);
        $scope.errormessage="Impossible to add new appointment;";
    };

    $scope.addAppointment = function () {
        $http.post('/public/rest/appointment/'+$scope.inputdoctorName + "/" + $scope.inputpatientName + "/" + $scope.inputappointmentTime).then($scope.successAddAppointmentCallback, $scope.errorAddAppointmentCallback);
    };

});
