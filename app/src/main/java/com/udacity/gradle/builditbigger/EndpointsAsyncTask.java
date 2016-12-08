package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;

import com.androidlibrary.JokeActivityLib;
import com.example.sagar.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static java.security.AccessController.getContext;

/**
 * Created by sagar on 7/12/16.
 */

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private MyApi myApiService = null;
    private Context mContext;
    private ProgressDialog dialog;

    public EndpointsAsyncTask(Context context) {
       mContext=context;

    }

    @Override
    protected void onPreExecute() {
        //progressBar.setVisibility(View.VISIBLE);
//        dialog=new ProgressDialog(mContext);
//        dialog.setTitle("Please Wait");
//        dialog.setCancelable(false);
//         dialog.show();
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }



        try {
            return myApiService.sayHi().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
      //  progressBar.setVisibility(View.GONE);
       // dialog.dismiss();
        Intent intent=new Intent(mContext,JokeActivityLib.class);
        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
        System.out.println("joke "+result);
        intent.putExtra("joke",result);
        mContext.startActivity(intent);
    }
}
