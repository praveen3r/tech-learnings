import NodeCache from 'node-cache';

class CacheManager {
    private static instance: NodeCache;

    
    private constructor() { }

    
    public static getInstance(): NodeCache {
        if (!CacheManager.instance) {
            CacheManager.instance = new NodeCache();
        }

        return CacheManager.instance;
    }
}

export default CacheManager;