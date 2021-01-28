package com.up.lhm.getoffer.apm.apmutil;


import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.format.Formatter;
import android.util.Log;


import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Usage:
 * Sampler.getInstance().init(getApplicationContext(), 100L);
 * Sampler.getInstance().start();
 */
public class Sampler implements Runnable {

    private volatile static Sampler instance = null;
    private ScheduledExecutorService scheduler;
    private ActivityManager activityManager;
    private long freq;
    private Long lastCpuTime;
    private Long lastAppCpuTime;
    private RandomAccessFile procStatFile;
    private RandomAccessFile appStatFile;
    private Context mContext;

    private Sampler() {
        scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    public static Sampler getInstance() {
        if (instance == null) {
            synchronized (Sampler.class) {
                if (instance == null) {
                    instance = new Sampler();
                }
            }
        }
        return instance;
    }

    // freq为采样周期
    public void init(Context context, long freq) {
        mContext=context;
        activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        this.freq = freq;
    }

    public void start() {
        scheduler.scheduleWithFixedDelay(this, 0L, freq, TimeUnit.MILLISECONDS);
    }

    @Override
    public void run() {
        getMeminfo();
        MemUtils.getRunTimeInfo();
    }

    private void getMeminfo() {

        DecimalFormat df2 = new DecimalFormat("0.00");
        ActivityManager.MemoryInfo memoryInfo = MemUtils.getSystemAvaialbeMemorySize(mContext);
        //手机剩余可用
        long memSize = memoryInfo.availMem;
        //RAM总内存
        long totalMem = memoryInfo.totalMem;

        boolean lowMemory = memoryInfo.lowMemory;
        long threshold = memoryInfo.threshold;

        //内存使用率
        String useRate = df2.format((totalMem - memSize)/(double)totalMem*100D);
        //app当前进程占用内存
        String useMemStr = MemUtils.sampleMemory(mContext,Process.myPid());

        String availMemStr = formateFileSize(memSize);
        String totalMemStr = formateFileSize(totalMem);
        Log.d("Sampler", "pidusemem: " + useMemStr + "M--" + "availMemStr：" + availMemStr + "--" + "totalMemStr：" + totalMemStr + "GB" + "--内存使用率：" + useRate + "%" + "--curpid：" + Process.myPid());
    }

    private double sampleCPU() {
        long cpuTime;
        long appTime;
        double sampleValue = 0.0D;
        try {
            if (procStatFile == null || appStatFile == null) {
                procStatFile = new RandomAccessFile("/proc/stat", "r");
                appStatFile = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
            } else {
                procStatFile.seek(0L);
                appStatFile.seek(0L);
            }
            String procStatString = procStatFile.readLine();
            String appStatString = appStatFile.readLine();
            String procStats[] = procStatString.split(" ");
            String appStats[] = appStatString.split(" ");
            cpuTime = Long.parseLong(procStats[2]) + Long.parseLong(procStats[3])
                    + Long.parseLong(procStats[4]) + Long.parseLong(procStats[5])
                    + Long.parseLong(procStats[6]) + Long.parseLong(procStats[7])
                    + Long.parseLong(procStats[8]);
            appTime = Long.parseLong(appStats[13]) + Long.parseLong(appStats[14]);
            if (lastCpuTime == null && lastAppCpuTime == null) {
                lastCpuTime = cpuTime;
                lastAppCpuTime = appTime;
                return sampleValue;
            }
            sampleValue = ((double) (appTime - lastAppCpuTime) / (double) (cpuTime - lastCpuTime)) * 100D;
            lastCpuTime = cpuTime;
            lastAppCpuTime = appTime;
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Sampler", "e=" + e.toString());

        }
        return sampleValue;
    }

    //调用系统函数，字符串转换 long -String KB/MB
    private String formateFileSize(long size) {
        return Formatter.formatFileSize(mContext, size);
    }
}
