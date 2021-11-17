import { from } from 'rxjs';
import { map, filter } from 'rxjs/operators';

export class Map {

    //map(project: Function, thisArg: any): Observable

    /*
    An Observable that emits the values from the source Observable transformed by the given project function.
    
    Like Array.prototype.map(), it passes each source value through a transformation function to get 
    corresponding output values.

    Similar to the well known Array.prototype.map function, this operator applies a projection 
    to each value and emits that projection in the output Observable.
    */
    static processMap() {

        //emit (1,2,3,4,5)
        const source = from([1, 2, 3, 4, 5]);
        //add 10 to each value
        const example = source.pipe(map(val => val + 10));
        //output: 11,12,13,14,15
        const subscribe = example.subscribe(val => console.log(val));
    }

    static processMap1() {

        //emit ({name: 'Joe', age: 30}, {name: 'Frank', age: 20},{name: 'Ryan', age: 50})
        const source = from([
            { name: 'Joe', age: 30 },
            { name: 'Frank', age: 20 },
            { name: 'Ryan', age: 50 }
        ]);
        //grab each persons name, could also use pluck for this scenario
        const example = source.pipe(map(({ name }) => name));
        //output: "Joe","Frank","Ryan"
        const subscribe = example.subscribe(val => console.log(val));
    }

    static processMap2() {

        //emit ({name: 'Joe', age: 30}, {name: 'Frank', age: 20},{name: 'Ryan', age: 50})
        const source = from([
            { name: 'Joe', age: 30 },
            { name: 'Frank', age: 20 },
            { name: 'Ryan', age: 50 }
        ]);
        //add serialNo to all objects
        const example = source.pipe(map((val, index) => {
            val["serialNo"] = index + 1;
            return val;
        }));
        
        const subscribe = example.subscribe(val => console.log(val));
    }

    static processMapWithFilter() {

        const source = from([
            { name: 'Joe', age: 30 },
            { name: 'Frank', age: 20 },
            { name: 'Ryan', age: 50 }
        ]);
        const example = source.pipe(map(val => val), filter(item => item.age > 25));
        
        const subscribe = example.subscribe(val => console.log(val));
    }

    static processMapWithFilter1() {

        const source = from([
            {entityList:[{ name: 'Joe', age: 30 },
            { name: 'Frank', age: 20 },
            { name: 'Ryan', age: 50 }
            ]}
        ]);
        
        const example = source.pipe(map(val => val.entityList.filter(item => item.age > 25)));

        //output: "Joe","Frank","Ryan"
        const subscribe = example.subscribe(val => console.log(val));
    }
    
}