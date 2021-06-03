// Objects in JS can be created inline (without some template defining their structure)
let inlineObj = {

    field1: 'a',
    field2: true,

    'nested object': {
        nestedField1: 'a'
    },

    doTheThing: function () {
        console.log('did the thing');
    },

    doBurrito() {
        console.log('burrito done');
    }

}

inlineObj.newProperty = 1;

console.log(inlineObj);

let counter = (function() {
    let privateNum = 0;

    function changeBy(value) {
        privateNum += value;
    }

    return {
        increment: function() {
            changeBy(1);
        },

        decrement: function() {
            changeBy(-1);
        },
        getNum: function() {
            return privateNum;
        }
    };

})();

console.log(counter);
console.log(counter.getNum()); // 0

counter.increment();
console.log(counter.getNum()); // 1

counter.decrement();
console.log(counter.getNum()); // 0

// counter.changeBy(5);
console.log(counter.getNum()); // 

counter.privateNum = 10;
console.log(counter.getNum()); // 0
console.log(counter);

function CounterCreator(startingValue) {
    this.value = startingValue;
    this.increment = function() {
        this.value += 1;
    }
    this.decrement = function() {
        this.value -= 1;
    }
}

let counter2 = new CounterCreator(10);
console.log(counter2);

counter2.increment();
console.log(counter2.value); // 1

counter2.decrement();
counter2.decrement();
counter2.decrement();
counter2.decrement();
console.log(counter2.value); // 7

let counter3 = new CounterCreator(93);
console.log(counter3.value);

// console.log(CounterCreator(0).value);

CounterCreator.prototype.toString = function() {
    console.log('The value of this counter is: ' + this.value);
}

counter3.toString();
console.log(counter3);

counter2.toString();

function Car(model) {
    this.model = model;
    this.color = 'silver';
    this.year = 2021;
    this.changeColor = function(newColor) {
        this.color = newColor;
    }
}

let myCar = new Car('Nissan Rogue');
console.log(myCar);
myCar.changeColor('red');
console.log(myCar);

// ES6 class syntax (sugar syntax)
class Vehicle {
    beep = function() {
        console.log("BEEP!");
    }
}

class Truck extends Vehicle {

    that = this;

    // only one constructor is allowed in ES6 class syntax
    constructor(model, year, color = 'silver') {
        super();
        this.model = model;
        this.year = year;
        this.color = color;
    }

    clunk() {
        console.log(this == this.that); // the meaning of the "this" keyword did not change
        console.log("CLUNK!");
    }

    // beep = function() {
    //     console.log(this == this.that); // the meaning of the "this" keyword did not change
    //     console.log("BEEP!");
    // }

    honk = () => {
        console.log(this == this.that); // the meaning of the "this" keyword did not change
        console.log("HONK!");
    }
}

let myTruck = new Truck('Toyota Tocoma', 2021, 'green');
console.log(myTruck);
myTruck.clunk();
myTruck.beep();
myTruck.honk();

let yourTruck = new Truck('Chevy Silverado', 2020);
console.log(yourTruck);


doThing();
function doThing() {
    console.log('The things is done');
}

// Destructuring objects
let a, b, rest;
[a, b] = ['hello', 'goodbye'];
console.log(a);
console.log(b);

let user = {
    id: 93,
    firstName: 'Wezley',
    lastName: 'Singleton'
}

let notUser = {
    a: 3,
    b: 4
}

function whoIs({firstName, lastName}) {
    return firstName + " " + lastName;
}

let fullName = whoIs(user);
console.log(fullName);

let wontWork = whoIs(notUser);
console.log(wontWork);

let stringifiedUser = JSON.stringify(user);
console.log(stringifiedUser);

let parsedUser = JSON.parse(stringifiedUser);
console.log(parsedUser);