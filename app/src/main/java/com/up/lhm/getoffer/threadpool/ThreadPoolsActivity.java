package com.up.lhm.getoffer.threadpool;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.up.lhm.getoffer.R;
import com.up.lhm.hmtools.system.IntentUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lianghaimiao
 * @date 2019/3/30
 * @function
 */

public class ThreadPoolsActivity extends Activity {

    private ExecutorService mFixedThreadPool= Executors.newFixedThreadPool(2);;
    private ExecutorService mNewSingleThreadExecutor= Executors.newSingleThreadExecutor();;
    private ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();;
    private ExecutorService newScheduledThreadPool= Executors.newScheduledThreadPool(2);;

    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, ThreadPoolsActivity.class, finishSelf, args);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_pool);
        testThread();
    }

    private void testThread() {
        Thread thread = new Thread(new MyRunnable());
        mFixedThreadPool.execute(thread);

        mFixedThreadPool.execute(new MyRunnable());
        mNewSingleThreadExecutor.execute(new MyRunnable());
        newCachedThreadPool.execute(new MyRunnable());
        newScheduledThreadPool.execute(new MyRunnable());
    }

    class MyRunnable implements Runnable{

        @Override
        public void run() {
            Log.d("线程池","当前线程名字"+Thread.currentThread());
        }
    }
}
