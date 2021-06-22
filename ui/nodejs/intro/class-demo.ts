class SomeClass {

    // not necessary if passing private params to constructor with same name
    // id;
    // someValue;

    constructor(private id, private someValue) {
        this.id = id;
        this.someValue = someValue;
    }

    
    setSomeValue(v : string) {
        this.someValue = v;
    }
    
}