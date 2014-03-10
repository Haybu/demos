'use strict';


var CitiesModel = require('../models/index'),
    request = require("request"),
    http = require('http');


module.exports = function (app) {

    var cities = new CitiesModel();


    app.get('/', function (req, res) {

        console.log("*** cities object has: " + JSON.stringify(cities));

        res.render('index', cities);

    });

    app.post('/displayWeather', function (req, res) {

        console.log("calling displayWeather method")

        var selectedIndex = req.body.selectedIndex;

        console.log("city index select is " + selectedIndex);

        // read the selected city index
        cities.selected_id = parseInt(selectedIndex);

        // clear the weather data from the model
        if (cities.hasOwnProperty("observation")) {
            delete cities["observation"];
        }

        // get the weather info via wunderground API
        if (cities.selected_id !== 0) {
            var weatherResultObject = undefined;

            var options = cities["options"];
            var cityOption = findCityOption(options, selectedIndex); // {id:"x", value:"city, state"}
            var cityOptionValue = JSON.stringify(cityOption["value"]);  // "city, State"
            var city = stripOptionValue(cityOptionValue, 0).trim();
            var state = stripOptionValue(cityOptionValue, 1).trim();

            console.log("selected city name = " + city);
            console.log("selected state name = " + state);


            var weatherUrl =
                "http://api.wunderground.com/api/109e5d3c081bf0d2/geolookup/conditions/q/"+state+"/"+city+".json";

            console.log("wunderground URL: " + weatherUrl);

            request(weatherUrl, function(err, resp, body) {
                weatherResultObject = JSON.parse(body);
                console.log("retrieve the weather observation from the JSON result object");
                var currentObservation = weatherResultObject["current_observation"];
                console.log("current observation json object contains " + JSON.stringify(currentObservation));
                console.log("adding weather current observation object to the model");
                cities.observation = currentObservation;
                res.redirect('/');
            });

        } else {
		console.log("no city selected. weather data should cleared from the model/screen");
		res.redirect('/');
	}

    });

    function stripOptionValue(cityOption, index) {
        var cityArray = cityOption.split(",");
        return cityArray[index];
    }

    function findCityOption (optionsArray, index) {
        console.log("search for city with index " + index + " in array " + JSON.stringify(optionsArray));
        for (var i =0; i< optionsArray.length; i++) {
            var option = optionsArray[i];
            console.log("inspecting option " + JSON.stringify(option));
            var id = parseInt(option["id"]);
            console.log("ID for this option = " + id);
            if (id === parseInt(index)) {
                console.log("option found " + JSON.stringify(option));
                return option;
            }
        }

        return undefined;
    }

};
