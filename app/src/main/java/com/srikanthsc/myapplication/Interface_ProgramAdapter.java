package com.srikanthsc.myapplication;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

public interface Interface_ProgramAdapter {


     ProgramAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType);
     void onBindViewHolder(@NonNull ProgramAdapter.holder holder, int position);
    public  int getItemCount();
}


