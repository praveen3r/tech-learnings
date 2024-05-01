import {afterMethod, beforeMethod} from 'aspect.js'
import LogManager from '../log/LogManager';
import log from '../log/LogManager';

class LoggingAspect {
  private log = LogManager.getInstance();

    @beforeMethod({
        classNamePattern: /.*/,
        methodNamePattern: /^(get)/
      })
    logBefore(meta: any) {
        this.log.info(`Before executing method ${meta.method}`);
    }

    @afterMethod({
        classNamePattern: /.*/,
        methodNamePattern: /^(get)/
      })
      logAfter(meta: any) {
        this.log.info(`After executing method ${meta.method}`);
    } 
}