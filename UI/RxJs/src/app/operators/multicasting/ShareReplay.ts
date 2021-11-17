import { tap, pluck, shareReplay } from 'rxjs/operators';
import { Subject } from 'rxjs';

export class ShareReplay {


    static processShareReplay() {

        // simulate url change with subject
        const routeEnd = new Subject<{ data: any, url: string }>();

        // grab url and share with subscribers
        const lastUrl = routeEnd.pipe(
            tap(_ => console.log('executed')),
            pluck('url'),
            // defaults to all values so we set it to just keep and replay last one
            shareReplay(1)
        );

        // requires initial subscription
        const initialSubscriber = lastUrl.subscribe(console.log);

        // simulate route change
        // logged: 'executed', 'my-path'
        routeEnd.next({ data: {}, url: 'my-path' });

        // logged: 'my-path'
        const lateSubscriber = lastUrl.subscribe(console.log);

    }
}