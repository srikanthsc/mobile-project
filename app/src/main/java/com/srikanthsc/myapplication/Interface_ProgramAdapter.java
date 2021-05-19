package com.srikanthsc.myapplication;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

public interface Interface_ProgramAdapter {


     ProgramAdapterRecyclerView.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType);
     void onBindViewHolder(@NonNull ProgramAdapterRecyclerView.holder holder, int position);
    public  int getItemCount();
}


