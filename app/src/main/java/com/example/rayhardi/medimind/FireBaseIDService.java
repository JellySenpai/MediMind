package com.example.rayhardi.medimind;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by rayhardi on 10/15/2017.
 */

public class FireBaseIDService extends FirebaseInstanceIdService {
    private static final String TAG = "FirebaseIDService";


    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String refreshedToken) {
        //TODO write code that sends  token to app server
    }
}
