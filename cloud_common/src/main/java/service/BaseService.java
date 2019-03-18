package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.IdWorker;

/**
 * 基础Service
 *
 * @author jbb
 * @date 2019/3/16
 */
public class BaseService {
    public Logger log = LoggerFactory.getLogger(this.getClass());
    public IdWorker idWorker = new IdWorker();

    /**
     * 获取主键ID
     *
     * @return java.lang.String
     */
    public String getId() {
        return String.valueOf(idWorker.nextId());
    }
}
