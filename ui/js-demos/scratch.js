window.onload = function() {
    console.log("The page has loaded!");
}

// single line comments

/*
    Multi
    line
    comments
*/

/**
 * Documentation comments
 */

/*
    Primitive types:
        - string
        - number
        - bigint
        - boolean
        - undefined
        - null (primitive root value)
        - Symbol (always unique, even if they contain the same value; good for UUIDs)

    Structural types:
        - object
            + Array
            + Set
            + Date
            + ...
            + Function (first-class members! can be assign to variables, returned from other functions, etc.)

*/

// standard function declaration
function a() {
    console.log('This is a named function declaration');
}

a(); // invokes the function named "a"
console.log(a); // simply prints the function's logic as a string; does not invoke!

// anonymous function declaration
let b = function () {
    console.log('This is an anonymous function declaration assigned to a variable named "b"');
}

b(); // invokes the function assigned to variable named "b"


let c = () => {
    console.log('This is an anonymous function declaration expressed using arrow notation assigned to a variable named "c"');
}

c();


function d() {
    console.log(this); // in a browser environment, "this" refers to the global Window object
}

let e = {
    eVal: "hello!",
    eFunction: function() {
        console.log(this); // refers to the containing object "e"
    }
}

let f = {
    fVal: "goodbye!",
    fFunction: () => {
        console.log(this); // still points to the global Window object
    }
}

let g = {
    gVal: "wat",
    gObj: {
        gObjFunction: () => {
            console.log(this); // still points to the global Window object
        }
    }
}

d();
e.eFunction();
f.fFunction();
g.gObj.gObjFunction();

// IIFEs (immediately-invoked function expressions)
(function () {
    console.log("This is an immediately invoked function expression!");
})();

(function (x) {
    console.log("The provided value is: " + x);
})(4);

/*
    Variable declarative keywords: 
        - var (been around forever)
        - let (introduced in ES6)
        - const (introduced in ES6)
        - (lack of a declarative keyword results in binding a variable to the global object)
*/
// location = "https://www.google.com";
// console.log(location);

garbageThatProbablyDoesntExistOnWindow = "Kevin is curious.";
console.log(window);
console.log(garbageThatProbablyDoesntExistOnWindow);

/*
   Variable Scopes
   
    - global
    - function/local
    - block
    - lexical (closures)

*/

function varScope() {
    console.log("line 126: " + greeting); // prints undefined...

    if (true) {
        var greeting = "hello"; // scoped to the function itself
        console.log("line 130: " + greeting); // prints "hello"
    }

    console.log("line 133: " + greeting); // prints "hello"

}

varScope();

function letScope() {
    // console.log("line 140: " + greeting); // throws ReferenceError

    if (true) {
        let greeting = "hello"; // scoped to the block it is declared within
        console.log("line 144: " + greeting); // prints "hello"
    }

    // console.log("line 147: " + greeting); // throws ReferenceError

}

letScope();

// const is basically just the same as Java's final keyword
// const meaningOfLife; // throws SyntaxError
const meaningOfLife = 42;
// meaningOfLife = 43; // throws TypeError

const immutableMaybe = {
    someValue: 10,
    anotherValue: 'test',
    nestedObject: {
        nestedValue: 100
    }
};

console.log(immutableMaybe);

// immutableMaybe = {}; // obviously doesn't work, TypeError
immutableMaybe.someValue = 20;
console.log(immutableMaybe);

let h = {
    a: 'a',
    b: 2,
    c: true,
    d: function() {
        console.log('d');
    },
    e() {
        console.log('e');
    },
    'some property': 'some value'
};

console.log(h.a); // prints 'a';
console.log(h.d()); // invokes the method named "d" and prints 'd'.
console.log(h.e()); // works the same as above

// trying to get access to field whose key name has spaces in it
// console.log(h.some property); // nope
// console.log(h.'some property'); // nope
console.log(h['some property']); // yes! this is called bracket notation
console.log(h['a']); // still works
let key = 'some property';
console.log(h[key]); // works!

/*
    Type Coersion and Truthy/Falsy Values

    Falsy values:
        - false
        - null
        - undefined
        - '' (empty string)
        - NaN
        - 0
*/
console.log(10 / 0); // Infinity
console.log('hello ' + 3); // type coercion
console.log('hello' - 3); // NaN
console.log('hello ' * 3); // NaN
console.log(('hello' - 3) == ('hello' - 3)); // surprisingly false, because...
console.log(NaN == NaN); // false
console.log(typeof(NaN)); // not a number is a number!
console.log('2' == 2); // true, because this comparison operator performs type coercion
console.log('2' === 2); // false, because this comparison operator DOES NOT perform type coercion

let username = getUsername() || 'default-username'; // default operator
let password = 'password';

if (username && password) {
    login(username, password)
} else {
    console.error("INVAID CREDENTIALS PROVIDED!");
}

(username && password) && login(username, password); // guard operator!

function login(un, pw) {
    console.log("Provided credentials: " + un, pw)
}

function getUsername() {
    return null;
}

console.log(([] + {} + !{})); // try to make sense of this. why it prints [object Object] false
