package com.google.cloud.android.speech;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by brentsamuels on 9/17/17.
 */

public class ConceptAdapter extends RecyclerView.Adapter<ConceptAdapter.ViewHolder> {
    List<WordRelevance> results;
    Context context;
    RestfulClient client;
    View rowView;


    public ConceptAdapter(Context mContext, List<WordRelevance> results){
        context = mContext;
        this.results = results;
    }

    @Override
    public ConceptAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        rowView = inflater.inflate(R.layout.item_feedback, parent, false);
        ViewHolder viewHolder = new ViewHolder(rowView) {
        };
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ConceptAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }



    }
}
