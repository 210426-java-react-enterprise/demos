"use strict";
class SomeClass {
    // not necessary if passing private params to constructor with same name
    // id;
    // someValue;
    constructor(id, someValue) {
        this.id = id;
        this.someValue = someValue;
        this.id = id;
        this.someValue = someValue;
    }
    setSomeValue(v) {
        this.someValue = v;
    }
}
