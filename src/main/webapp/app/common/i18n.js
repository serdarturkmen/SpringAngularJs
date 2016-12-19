var translationsTR = {
    'COMMON' : {
        'ADMIN' : 'YÖNETİCİ',
        'ARCHIVE_SELECTED' : 'Seçilenleri Arşivle',
        'UNARCHIVE_SELECTED' : 'Seçilenleri Arşivden Kaldır',
        'FIRSTNAME' : 'Ad',
        'LASTNAME' : 'Soyad',
        'EMAIL' : 'E-posta',
        'SAVE' : 'Kaydet',
    },
    'ERROR' : {
        'INTEGRITY' : 'Bağlı kayıt bulunduğundan silinemedi'
    }
}

var translationsEN = {
    'COMMON' : {
        'ADMIN' : 'ADMIN',
        'ARCHIVE_SELECTED' : 'Archive Selected',
        'UNARCHIVE_SELECTED' : 'Unarchive Selected',
        'FIRSTNAME' : 'First Name',
        'LASTNAME' : 'Last Name',
        'EMAIL' : 'E-mail',
        'SAVE' : 'Save',
    },
    'ERROR' : {
        'INTEGRITY' : 'Cannot perform delete because of related resources'
    }
}

var TRANSLATE = new function() {

    var THIS = this;

    this.defaultLang = "tr";

    this.detectLanguage = function() {

        angular.injector([ 'ng', 'ngCookies' ]).invoke(
            [
                "$cookies",
                "$window",
                function($cookies, $window) {
                    var lang = $window.navigator.language || $window.navigator.browserLanguage
                        || $window.navigator.systemLanguage || $window.navigator.userLanguage;
                    if (lang == "tr_TR")
                        lang = "tr";
                    if (lang != "tr") {
                        lang = "en";
                    }

                    if ($cookies.lang) {
                        lang = $cookies.lang;
                    }
                    THIS.defaultLang = lang;
                } ]);

        moment.locale(this.defaultLang);

    };

    this.detectLanguage();

    function index(obj, i) {
        return obj[i];
    }

    this.translate = function(key, lang) {
        if (!lang) {
            lang = this.defaultLang;
        }
        var langObject = translationsTR;
        if (lang == "en") {
            langObject = translationsEN;
        }
        return key.split('.').reduce(index, langObject);
    };

};

var i18n = angular.module('serdar.i18n', [ 'pascalprecht.translate' ]);

i18n.config([ '$translateProvider', function($translateProvider) {

    // add translation tables
    $translateProvider.translations('tr', translationsTR);
    $translateProvider.translations('en', translationsEN);
    $translateProvider.preferredLanguage(TRANSLATE.defaultLang);
    $translateProvider.fallbackLanguage('tr');

    $translateProvider.useSanitizeValueStrategy('escaped');
} ]);

var RecaptchaOptions = {
    theme : 'clean',
    lang : TRANSLATE.defaultLang
};

// access cookie using $COOKIE['lang']
var $COOKIE = (document.cookie || '').split(/;\s*/).reduce(function(re, c) {
    var tmp = c.match(/([^=]+)=(.*)/);
    if (tmp)
        re[tmp[1]] = unescape(tmp[2]);
    return re;
}, {});
