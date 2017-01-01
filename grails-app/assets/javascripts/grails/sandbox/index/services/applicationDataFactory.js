//= wrapped

angular
    .module("grails.sandbox.index")
    .factory("applicationDataFactory", applicationDataFactory);

function applicationDataFactory($http) {
    return {
        get: function() {
            return $http({method: "GET", url: "application"});
        }
    }
}

