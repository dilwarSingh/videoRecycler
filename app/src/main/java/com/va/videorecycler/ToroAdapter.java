package com.va.videorecycler;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ToroAdapter extends RecyclerView.Adapter<viewHolder> {


    Context context;
    ArrayList<String> uris;

    public ToroAdapter(Context context, ArrayList<String> uris) {
        this.context = context;
        this.uris = uris;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        String uri = uris.get(position);

        holder.onBind(this, Uri.parse(uri), null);


    }

    @Override
    public int getItemCount() {
        return uris.size();
    }


}
