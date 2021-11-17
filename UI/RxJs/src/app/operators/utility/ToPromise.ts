import { of } from 'rxjs';

export class ToPromise {

    //toPromise() : Promise


    static processToPromise() {

        //return basic observable
        const sample = val => of(val);

        //convert basic observable to promise
        const example = sample('First Example')
            .toPromise()
            //output: 'First Example'
            .then(result => {
                console.log('From Promise:', result);
            });
    }
}