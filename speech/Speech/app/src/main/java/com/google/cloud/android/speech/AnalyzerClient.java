package com.google.cloud.android.speech;

import android.content.Context;
import android.os.AsyncTask;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.service.WatsonService;
/**
 * Created by brentsamuels on 9/17/17.
 */

public class AnalyzerClient extends AsyncTask<>{

    public static final String URL = "https://gateway.watsonplatform.net/natural-language-understanding/api";
    public static final String USERNAME = "82b07e0f-a9b1-4e83-8706-15f8a8a1b577";
    public static final String PASSWORD = "nBnUFpVKPCV2";
    Context context;
    //ToneAnalyzer service;

    public AnalyzerClient(Context context){
        this.context = context;
        service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);
        service.setEndPoint(URL);
        service.setUsernameAndPassword(USERNAME, PASSWORD);
    }

    public AnalyzerClient(){
        service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);
        service.setEndPoint(URL);
        service.setUsernameAndPassword(USERNAME, PASSWORD);
    }

    @Override
    protected Object doInBackground(Object[] params) {

    }


}
