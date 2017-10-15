package com.example.rayhardi.medimind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DBWorkerDelegate {
    private final String TAG ="Main Activity";

    private ArrayList <Medication> medicationList;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        medicationList = new ArrayList<>();


        DBWorker dbWorker = new DBWorker();
        dbWorker.setOnFinishedListener(this);
        dbWorker.execute();


    }

    @Override
    public void taskFinished(boolean isSuccess, JSONObject returnJSON) {
        Log.d(TAG, returnJSON.toString());
        try {

            JSONArray temp = returnJSON.getJSONArray("medication");
            for (int i = 0;i<temp.length();i++)
            {
                JSONObject tempMedication = temp.getJSONObject(i);
                medicationList.add(new Medication(tempMedication));
            }
            int x = 0;
        }
        catch (JSONException ex){ Log.d(TAG, "Failed eto create medication data set");}
    }
}
