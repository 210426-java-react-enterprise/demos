"use strict";
let myNumber = 'totally a number';
function onlyTakesInStrings(someString) {
    console.log(someString);
}
onlyTakesInStrings({ x: 1, y: 2 });
function register(newUser) {
    // do something with the user...
}
let someNewUser = {
    id: 0,
    username: 'wsingleton',
    password: 'password',
    email: 'wsingleton@gmail.com'
};
register(someNewUser);
