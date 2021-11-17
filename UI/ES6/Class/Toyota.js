import Car from './Car';

class Toyota extends Car{
    color;

    constructor(){
        //this.color = 'Red';
        super(); //car constructor for initialization
    }

    honk(){
        return 'honk';
    }

    // drive(){
    //     console.log(super.drive());
    //     return 'I am driving toyota';
    // }
}

const toyota = new Toyota();
console.log(toyota)
console.log(toyota.honk());
console.log(toyota.drive());