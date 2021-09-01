package com.backgroundexecuter;

import android.os.AsyncTask;
import android.os.HandlerThread;
import android.os.Looper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import android.os.Handler;
import android.util.Log;

public abstract class BackgroundExecuter{
    private static final String TAG="BackgroundExecuter";
    StringBuffer sb = new StringBuffer();
    ExecutorService executorService=null;
    
    public BackgroundExecuter(){
        this.executorService = Executors.newSingleThreadExecutor();
    }

    public void execute(){
       startInBackground();
    }

    protected void startInBackground(){
        executorService.execute((()->{
            onPreExecute("Background Task execution is started");
            Log.d(TAG, "startInBackgrount: ThreadName->"+Thread.currentThread().getName());
            String result = doInBackground();// this will be executed in to background thread
            new Handler(Looper.getMainLooper()).post((()->{
                postExecute(result);  //This will be executed in main thread
            }));
        }));
    }

   

    private  String doInBackground(String ... params){

        return "Result from Background";
        
        //Update progress
    }
    public abstract void postExecute(String result);
    public void onPreExecute(String message){};

     

}

