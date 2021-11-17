import { fromEvent } from 'rxjs';
import { find } from 'rxjs/operators';

export class Find {


    //find(predicate: function)

    /* An Observable of the first item that matches the condition.
    
    Finds the first value that passes some test and emits that. find searches for the first item in the 
    source Observable that matches the specified condition embodied by the predicate, and returns the 
    first occurrence in the source. Unlike first, the predicate is required in find, and does not emit
     an error if a valid value is not found.*/

    static processFind() {
        const clicks = fromEvent(document, 'click');
        const result = clicks.pipe(find((event: any) => event.target.tagName === 'DIV'));
        result.subscribe(x => console.log(x));
    }
}