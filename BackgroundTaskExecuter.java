package com.aakash.util;

import android.os.AsyncTask;
import android.os.HandlerThread;
import android.os.Looper;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import android.os.Handler;
import android.util.Log;

public abstract class BackgroundExecuter{
    ExecutorService executorService = null;

    public BackgroundExecuter() {
        this.executorService = Executors.newSingleThreadExecutor();
    }

    public void execute(){
        startInBackground();

    }

    private void startInBackground(){
        executorService.execute((()->{
            doInBackground();
            new Handler(Looper.getMainLooper()).post((()->{
                postExecute();
            }));
        }));
    }
    public abstract void onPreExecute();
    public abstract void doInBackground();

    public  void onProgressUpdate(long update){};
    public abstract void postExecute();


}

