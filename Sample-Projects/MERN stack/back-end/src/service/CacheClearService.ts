import CacheManager from "../cache/CacheManager";

class CacheClearService {
  private cacheManager = CacheManager.getInstance();

  clearAllCache = async (): Promise<string> => {
    try {
      this.cacheManager.flushAll();
      return "successfully cleared all cache";
    } catch (error) {
      throw error;
    }
  };

  clearCache = async (key: string): Promise<string> => {
    try {
      this.cacheManager.del(key);
      return `successfully cleared cache ${key}`;
    } catch (error) {
      throw error;
    }
  };
}

export default CacheClearService;
