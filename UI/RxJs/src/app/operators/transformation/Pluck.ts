import { merge, from, Observable } from 'rxjs';
import { map, partition, pluck } from 'rxjs/operators';


export class Pluck {

    //pluck(properties: ...args): Observable

    /* A new Observable of property values from the source values.
    
    Like map, but meant only for picking one of the nested properties of every emitted object.
    
    Given a list of strings describing a path to an object property, retrieves the value of a specified 
    nested property from all values in the source Observable. If a property can't be resolved, 
    it will return undefined for that value.
    */


    //Pluck object property
    static processPluck() {
        const source = from([
            { name: 'Joe', age: 30 },
            { name: 'Sarah', age: 35 }
          ]);
          //grab names
          const example = source.pipe(pluck('name'));
          //output: "Joe", "Sarah"
          const subscribe = example.subscribe(val => console.log(val));
    }

    //Pluck nested properties
    static processPluck1() {
        const source = from([
            { name: 'Joe', age: 30, job: { title: 'Developer', language: 'JavaScript' } },
            //will return undefined when no job is found
            { name: 'Sarah', age: 35 }
          ]);
          //grab title property under job
          const example = source.pipe(pluck('job', 'title'));
          //output: "Developer" , undefined
          const subscribe = example.subscribe(val => console.log(val));
    }

}

