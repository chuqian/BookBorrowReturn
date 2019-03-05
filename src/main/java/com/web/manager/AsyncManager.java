package com.web.manager;

import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author chuqian
 * @Date created in 2019/1/29 22:04
 * @describe 异步任务管理器
 */
public class AsyncManager {
    private final int OPERATE_DELAY_TIME = 10;  //操作延迟10毫秒

    /**
     * 异步操作任务调度线程池
     */
    private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);

    /**
     * 单例模式
     */
    private static AsyncManager asyncManager = new AsyncManager();

    public static AsyncManager getAsyncManager() {
        return asyncManager;
    }

    /**
     * @Author chuqian
     * @Date created in 2019/1/29 23:03
     * @Params TimerTask 任务
     * @describe 执行任务
     */
    public void execute(TimerTask task) {
        executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }
}
