/**
 + * User: Haytham Mohamed
 + * Date: 03/09/14
 + * A request-parameters logger
 + */

'use strict';

var url = require("url");

module.exports = function() {

    return function (req, res, next) {
        var queryObject = url.parse(req.url,true).query;
        console.log("URL Request Parameters : "
            + JSON.stringify(queryObject));

        console.log("Posted Request Body : " + JSON.stringify(req.body));
        next();
    };

};