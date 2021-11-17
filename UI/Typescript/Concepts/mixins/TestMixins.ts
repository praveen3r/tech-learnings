class Car1{
    startCar(){
        console.log("Start car");
    }
    
}

class Lorry{
    startLorry(){
        console.log("Start Lorry");
    }
}

class  Vehicle12 {}
interface Vehicle12 extends Car1,Lorry{}

function applyMixins(derivedCtor: any, baseCtors: any[]) {
    baseCtors.forEach(baseCtor => {
        Object.getOwnPropertyNames(baseCtor.prototype).forEach(name => {
            Object.defineProperty(derivedCtor.prototype, name, 
                Object.getOwnPropertyDescriptor(baseCtor.prototype, name) as PropertyDescriptor);
        });
    });
}


applyMixins(Vehicle12, [Car1, Lorry]);

const vehicle12:Vehicle12 = new Vehicle12();
vehicle12.startCar();
vehicle12.startLorry();

