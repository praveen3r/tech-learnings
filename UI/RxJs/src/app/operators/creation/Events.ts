import { timer, fromEvent } from 'rxjs';

export class Events {

    static processEvents() {

        /* fromEvent(target: EventTargetLike, eventName: string, selector: function): Observable

        Turn event into observable sequence */

        //create observable that emits click events
        const source = fromEvent(document, 'click');
        
        const subscribe = source.subscribe(evt => console.log(evt));


    }
}
