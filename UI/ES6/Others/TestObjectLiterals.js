//ES5
function getLaptop(make, model, year) {
    return {
        make: make,
        model: model,
        year: year
    }
}

getLaptop("Apple", "MacBook", "2015");// {make: "Apple", model: "MacBook", year: "2015"}

//ES6
/* So in the above function, the object that is being returned is created using object literals. 
The properties of this object are created by assigning the value of the parameters passed 
to their corresponding keys. Did you notice the repetition there? I did too. ES6 removes all 
of that repetition. Here's how we will write our getLaptop function; */

function getLaptop(make, model, year) {
    return {
        make,
        model,
        year
    }
}

getLaptop("Apple", "MacBook", "2015"); // {make: "Apple", model: "MacBook", year: "2015"}

//Shorthand for writing Methods
//ES5
function getLaptop(make, model, year) {
    return {
       sayModel : function() {
            return model;
        }
    }
}

getLaptop("Apple", "MacBook", "2015").sayModel(); //"MacBook"

//ES6
    function getLaptop(make, model, year) {
        return{
            sayModel() {
                return model;
            }
        }
    }

    getLaptop("Apple", "MacBook", "2015").sayModel(); //"MacBook"

    // Did you notice the difference? The : and function are no longer necessary to define a method. 
    // So ES6 makes the syntax for creating methods concise.
