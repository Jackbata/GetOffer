package com.up.lhm.getoffer.threadpool;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;

import com.up.lhm.getoffer.R;
import com.up.lhm.hmtools.system.IntentUtil;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author lianghaimiao
 * @date 2019/3/30
 * @function
 */

public class ThreadPoolsActivity extends Activity {

    @BindView(R.id.button)
    Button mButton;
    private ExecutorService mFixedThreadPool = Executors.newFixedThreadPool(2);
    ;
    private ExecutorService mNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
    ;
    private ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
    ;
    private ExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(2);
    ;

    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, ThreadPoolsActivity.class, finishSelf, args);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_pool);
        ButterKnife.bind(this);
//        testThread();
        LinkedBlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>();
        blockingDeque.offer("d");
        try {
            blockingDeque.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LinkedList<String> strings = new LinkedList<>();
        strings.add("d");


        ArrayBlockingQueue<String> strings1 = new ArrayBlockingQueue<String>(12);
        strings1.offer("s");


        try {
            strings1.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void testThread() {
        Thread thread = new Thread(new MyRunnable());
        mFixedThreadPool.execute(thread);

        mFixedThreadPool.execute(new MyRunnable());
        mNewSingleThreadExecutor.execute(new MyRunnable());
        newCachedThreadPool.execute(new MyRunnable());
        newScheduledThreadPool.execute(new MyRunnable());
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 20, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>());

        threadPoolExecutor.execute(new MyRunnable());
    }

    class MyRunnable implements Runnable {

        @Override
        public void run() {
            Log.d("线程池", "当前线程名字" + Thread.currentThread());
        }
    }
}
