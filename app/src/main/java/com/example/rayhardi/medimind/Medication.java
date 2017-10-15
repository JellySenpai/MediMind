package com.example.rayhardi.medimind;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rayhardi on 10/15/2017.
 */

public class Medication {
    private String Name;
    private int Quantity;
    private Date dateToTake;

    public Medication(JSONObject medication)
    {

       try {
           Name = medication.getString("mediName");
           Quantity = medication.getInt("mediQuantity");
           DateFormat formatter = new SimpleDateFormat("HH:mm");
           dateToTake = formatter.parse (medication.getString("time_to_take"));
       }
       catch (JSONException e) {}
        catch (ParseException ex){}
    }


}
