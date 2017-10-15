package com.example.rayhardi.medimind;

import org.json.JSONObject;

/**
 * Created by rayhardi on 10/15/2017.
 */
public interface DBWorkerDelegate {
    public void taskFinished(boolean isSuccess, JSONObject returnJSON);
}
