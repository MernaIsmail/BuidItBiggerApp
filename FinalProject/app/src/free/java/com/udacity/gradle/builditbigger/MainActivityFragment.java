package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.jokes.Joker;
import com.vis.merna.androidlibrary.AndroidLibActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        Button jokesBtn = root.findViewById(R.id.jokes_button);
        jokesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                complete step 1
//                Toast.makeText(getContext(), myJoker.getJoke(), Toast.LENGTH_LONG).show();
//                complete step 2
//                Joker myJoker = new Joker();
//                launchLibraryActivity.(myJoker.getJoke());
//                complete step 3
                new EndpointsAsyncTask() {
                    @Override
                    protected void onPostExecute(String result) {
                        super.onPostExecute(result);
                        launchLibraryActivity(result);
                    }
                }.execute();

            }
        });
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }


    public void launchLibraryActivity(String jokes) {
        Intent myIntent = new Intent(getContext(), AndroidLibActivity.class);
        myIntent.putExtra(Intent.EXTRA_TEXT, jokes);
        startActivity(myIntent);
    }

}
