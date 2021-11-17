export class CombineAll {

    //combineAll(project: function): Observable

    /*
    Flattens an Observable-of-Observables by applying combineLatest when the 
    Observable-of-Observables completes.

    combineAll takes an Observable of Observables, and collects all Observables from it. Once the outer Observable completes, it subscribes to all collected Observables and combines their values using the combineLatest strategy, such that:

    Every time an inner Observable emits, the output Observable emits
    When the returned observable emits, it emits all of the latest values by:
        If a project function is provided, it is called with each recent value from each inner Observable in whatever order they arrived, and the result of the project function is what is emitted by the output Observable.
        If there is no project function, an array of all the most recent values is emitted by the output Observable.

    */
    static processCombineAll() {
    }
}