function Shape(){
    this.area = function(){
        console.log("need to override")
    }
}

function Circle(r){
    this.radius = r;
    this.area = function(){
        return  3.14 * this.radius;
    }
}

Circle.prototype = new Shape();
console.log(new Circle(2).area());