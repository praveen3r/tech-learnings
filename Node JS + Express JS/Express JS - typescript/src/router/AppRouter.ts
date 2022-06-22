import { Router } from 'express';

interface AppRouter {
    path: string;
    router: Router;
}

export default AppRouter;