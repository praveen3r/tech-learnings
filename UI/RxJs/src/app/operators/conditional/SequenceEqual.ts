import { of, from, fromEvent } from 'rxjs';
import { switchMap, sequenceEqual, map, tap, bufferCount, mergeMap } from 'rxjs/operators';

export class SequenceEqual {

    // sequenceEqual(compareTo: Observable, comparor?: (a, b) => boolean): Observable

    /*
    An Observable of a single boolean value representing whether or not the values emitted by 
    both observables were equal in sequence.

    sequenceEqual subscribes to two observables and buffers incoming values from each observable. 
    Whenever either observable emits a value, the value is buffered and the buffers are shifted and 
    compared from the bottom up; If any value pair doesn't match, the returned observable will emit 
    false and complete. If one of the observables completes, the operator will wait for the other 
    observable to complete; If the other observable emits before completing, the returned observable 
    will emit false and complete. If one observable never completes or emits after the other complets, 
    the returned observable will never complete.
    */

    static SequenceEqual() {
        const expectedSequence = from([4, 5, 6]);

        of([1, 2, 3], [4, 5, 6], [7, 8, 9])
            .pipe(switchMap(arr => from(arr).pipe(sequenceEqual(expectedSequence))))
            .subscribe(console.log);
    }

    static SequenceEqual1() {
        const codes = from([
            'ArrowUp',
            'ArrowUp',
            'ArrowDown',
            'ArrowDown',
            'ArrowLeft',
            'ArrowRight',
            'ArrowLeft',
            'ArrowRight',
            'KeyB',
            'KeyA',
            'Enter', // no start key, clearly.
          ]);
           
          const keys = fromEvent(document, 'keyup').pipe(map((e: KeyboardEvent) => e.key));
          const matches = keys.pipe(
            bufferCount(11, 1),
            mergeMap(
              last11 => from(last11).pipe(sequenceEqual(codes)),
            ),
          );
          matches.subscribe(matched => console.log('Successful cheat at Contra? ', matched));
    } 

    //keyboard events
    static SequenceEqual2() {
        const expectedSequence = from(['q', 'w', 'e', 'r', 't', 'y']);
        const setResult = text => (document.getElementById('result').innerText = text);

        fromEvent(document, 'keydown')
        .pipe(
            map((e: KeyboardEvent) => e.key),
            tap(v => setResult(v)),
            bufferCount(6),
            mergeMap(keyDowns =>
            from(keyDowns).pipe(
                sequenceEqual(expectedSequence),
                tap(isItQwerty => setResult(isItQwerty ? 'WELL DONE!' : 'TYPE AGAIN!'))
            )
            )
        )
        .subscribe(e => console.log(`did you say qwerty? ${e}`));
    }
    }