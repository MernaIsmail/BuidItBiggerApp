package com.udacity.gradle.builditbigger;

import android.util.Log;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class EndpointAsyncTaskTest {
    @Test
    public void verifyEndPointResponse() {
        String response = null;
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.execute();
        try {
            response = endpointsAsyncTask.get();
            Log.d("test**", "Response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(response);
    }

}
