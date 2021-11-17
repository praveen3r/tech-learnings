class Car{

    title;
    constructor(){
        //this.title = 'Car';
    }
    drive(){
        return 'I am driving car';
    }

    static display(){
        console.log('I am displaying')
    }
}

const car = new Car();
console.log(car)
console.log(car.drive());
Car.display();

export default Car;
