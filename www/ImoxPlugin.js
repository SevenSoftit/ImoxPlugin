var exec = require('cordova/exec');

module.exports.startSdk = function (arg0, success, error) {
    exec(success, error, 'ImoxPlugin', 'startSdk', [arg0]);
};

module.exports.forceRecolec = function (arg0, success, error) {
    exec(success, error, 'ImoxPlugin', 'forceRecolec', [arg0]);
};