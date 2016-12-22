var csrfInterceptor = angular.module('HttpInterceptor', []);
csrfInterceptor.config([
    '$httpProvider',
    function($httpProvider) {
        $httpProvider.interceptors.push([
            "$q",
            function($q) {
                return {
                    'request' : function(request) {
                        if (!request.ignoreCSRF && request.method != 'GET') {
                            request.headers[$("meta[name='_csrf_header']").attr('content')] = $(
                                "meta[name='_csrf']").attr('content');
                        }
                        return request;
                    }
                };
            } ]);
    } ]);