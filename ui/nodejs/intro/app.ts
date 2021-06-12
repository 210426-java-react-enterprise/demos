let myNumber: number = 'totally a number';

function onlyTakesInStrings(someString: string) {
    console.log(someString);
}

onlyTakesInStrings({x: 1, y: 2});

interface User {
    id: number,
    username: string,
    password: string
}

function register(newUser: User) {
    // do something with the user...
}

let someNewUser = {
    id: 0,
    username: 'wsingleton',
    password: 'password',
    email: 'wsingleton@gmail.com'
};

register(someNewUser);