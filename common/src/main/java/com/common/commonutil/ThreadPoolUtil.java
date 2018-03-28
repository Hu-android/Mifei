package com.common.commonutil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 提供三种线程池类型管理
 *
 * @author zhang
 * @time 2017/3/7 17:37
 */

public class ThreadPoolUtil {

    private static ExecutorService singleExecutor = null;
    private static ExecutorService FixedExecutor = null;
    private static ExecutorService CachedExecutor = null;

    /**
     * 单例线程池：只会存在一个执行线程
     *
     * @author liu
     * @time 2017/3/7 17:32
     */
    public static ExecutorService getSingleExecutor() {
        if (singleExecutor == null) {
            singleExecutor = Executors.newSingleThreadExecutor();
        }
        return singleExecutor;
    }

    /**
     * 固定数量的线程池：同时执行指定数量的线程
     *
     * @author zhang
     * @time 2017/3/7 17:34
     */
    public static ExecutorService getFixedExecutor(int threadSize) {
        if (FixedExecutor == null) {
            FixedExecutor = Executors.newFixedThreadPool(threadSize);
        }
        return FixedExecutor;
    }

    /**
     * 缓存的线程池：无限数量的线程一起执行
     *
     * @author zhang
     * @time 2017/3/7 17:35
     */
    public static ExecutorService getCachedExecutor() {
        if (CachedExecutor == null) {
            CachedExecutor = Executors.newCachedThreadPool();
        }
        return CachedExecutor;
    }
}
