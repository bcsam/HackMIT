package com.google.cloud.android.speech;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.ConceptsResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsResult;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by felipemonsalve on 9/17/17.
 */

public class RestfulClient {

    private final String API_KEY = "";
    private final String API_BASE_URL = "https://gateway.watsonplatform.net/natural-language-understanding/api/v1";
    private AsyncHttpClient client;

    public RestfulClient() {
        this.client = new AsyncHttpClient();
    }

    public HashMap<String, List<WordRelevance>> analyzeText(String text){

        HashMap<String, List<WordRelevance>> results = new HashMap<>();

        NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding(
                NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27,
                "{username}",
                "{password}"
        );

        EntitiesOptions entitiesOptions = new EntitiesOptions.Builder()
//                .emotion(true)
//                .sentiment(true)
                .limit(2)
                .build();

        KeywordsOptions keywordsOptions = new KeywordsOptions.Builder()
                .limit(2)
                .build();

        Features features = new Features.Builder()
                .entities(entitiesOptions)
                .keywords(keywordsOptions)
                .build();

        AnalyzeOptions parameters = new AnalyzeOptions.Builder()
                .text(text)
                .features(features)
                .build();

        AnalysisResults response = service
                .analyze(parameters)
                .execute();

        results.put("keywords", new ArrayList<WordRelevance>());
        for (KeywordsResult keyword: response.getKeywords()){
            results.get("keywords").add(new WordRelevance(keyword.getText(), keyword.getRelevance()));
        }

        results.put("concepts", new ArrayList<WordRelevance>());
        for (ConceptsResult concept: response.getConcepts()){
            results.get("concepts").add(new WordRelevance(concept.getText(), concept.getRelevance()));
        }

        results.put("entities", new ArrayList<WordRelevance>());
        for (EntitiesResult entity: response.getEntities()){
            results.get("entities").add(new WordRelevance(entity.getText(), entity.getRelevance()));
        }

        return results;
    }


    public void genericRestfulCall(JsonHttpResponseHandler handler, String text) {
        String url = getApiUrl("/analyze");
        Map<String,String> paramsDict = new HashMap<String, String>();
        paramsDict.put("text",text);
        RequestParams params = new RequestParams(paramsDict);
        client.get(url, params, handler);
    }

    private String getApiUrl(String relativeUrl) {
        return API_BASE_URL + relativeUrl;
    }
}

class WordRelevance{
    public String text;
    public double relevance;

    public WordRelevance(String text, double relevance){
        this.text = text;
        this.relevance = relevance;
    }
}
