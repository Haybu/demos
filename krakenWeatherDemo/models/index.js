'use strict';


module.exports = function CitiesModel() {
    return {
        "selected_id" : 0,
        "options" :
            [
                {id : 0, value : '-- Please select a city --'},
                {id : 1, value : 'Austin, TX'},
                {id : 2, value : 'Campbell, CA'},
                {id : 3, value : 'Omaha, NE'}
            ]
    };
};