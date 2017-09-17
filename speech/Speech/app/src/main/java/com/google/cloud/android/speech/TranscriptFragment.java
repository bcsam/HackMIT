package com.google.cloud.android.speech;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by brentsamuels on 9/16/17.
 */

public class TranscriptFragment extends Fragment{
    TextView tvTranscript;

    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_transcript, container, false);
        tvTranscript = (TextView) v.findViewById(R.id.tvTranscript);
        String transcript = getArguments().getString("transcript");
        tvTranscript.setText(transcript);
    }
}
