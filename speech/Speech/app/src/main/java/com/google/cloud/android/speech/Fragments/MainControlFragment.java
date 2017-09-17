package com.google.cloud.android.speech.Fragments;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.google.cloud.android.speech.MainActivity;
import com.google.cloud.android.speech.R;
import com.skyfishjy.library.RippleBackground;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainControlFragment extends Fragment {

    private ImageButton ivPlay;
    private ImageButton ibStop;
    private ImageButton ibFlag;
    private RippleBackground rippleBackground;

    private boolean isListening;

    private ArrayList<String> transcriptSnippets;
    private ArrayList<String> flags;
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 1;



    public MainControlFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_control, container, false);

        ivPlay = (ImageButton) v.findViewById(R.id.ivRecord);
        ibFlag = (ImageButton) v.findViewById(R.id.ibFlag);
        rippleBackground = (RippleBackground) v.findViewById(R.id.content);

        transcriptSnippets = new ArrayList<>();
        flags = new ArrayList<>();

        setupListeners();
        return v;
    }

    public void setupListeners() {

        ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isListening) {
                    isListening = false;
                    // Stop listening to voice
                    ((MainActivity) getActivity()).stopVoiceRecorder();

                    String finalTranscript = "";

                    for (String snippet : transcriptSnippets) {
                        finalTranscript += snippet + ' ';
                    }
                    rippleBackground.stopRippleAnimation();

                    //ivPlay.setVisibility(View.GONE);

                } else {
                    // Start listening to voices
                    isListening = true;
                    rippleBackground.startRippleAnimation();
                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.RECORD_AUDIO)
                            == PackageManager.PERMISSION_GRANTED) {

                        ((MainActivity)getActivity()).startVoiceRecorder();

                    } else if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                            Manifest.permission.RECORD_AUDIO)) {
                        ((MainActivity)getActivity()).showPermissionMessageDialog();
                    } else {
                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.RECORD_AUDIO},
                                REQUEST_RECORD_AUDIO_PERMISSION);
                    }
                }

            }
        });

        /*ibStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Stop listening to voice
                ((MainActivity) getActivity()).stopVoiceRecorder();

                String finalTranscript = "";

                for (String snippet : transcriptSnippets) {
                    finalTranscript += snippet + ' ';
                }
                rippleBackground.stopRippleAnimation();

                ivPlay.setVisibility(View.GONE);
                ibStop.setVisibility(View.GONE);*/

                /*
                cvTranscript.setVisibility(View.VISIBLE);
                tvTranscript.setText(finalTranscript);

                mAdapter = new ResultAdapter(flags);
                mRecyclerView.setAdapter(mAdapter);

                Intent i = new Intent(context, PostRecordActivity.class);
                i.putExtra("transcript", finalTranscript);
                i.putExtra("flags", flags);
                context.startActivity(i);

            }
        });*/

        ibFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // add the last two snippets
                flags.add(transcriptSnippets.get(transcriptSnippets.size() - 1));

            }
        });

    }

    public void addSnipet(String snippet) {
        transcriptSnippets.add(snippet);
    }

}
