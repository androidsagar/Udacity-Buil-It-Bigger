package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.test.AndroidTestCase;
import android.util.Log;

import java.util.concurrent.ExecutionException;

/**
 * Created by sagar on 8/12/16.
 */

public class FetchJokeTest extends AndroidTestCase {

   // private static final String TAG = FetchJokeTaskTest.class.getSimpleName();

    public void testFetchesNonEmptyString() {

        try {
           String toast=new EndpointsAsyncTask(InstrumentationRegistry.getTargetContext()).execute().get();
            assertNotNull(toast);
        } catch (InterruptedException | ExecutionException e) {
            Log.e("Test", Log.getStackTraceString(e));
        }
    }


}