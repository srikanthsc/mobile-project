package com.srikanthsc.myapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface Interface_CustomAdapter {


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent);
    public int getCount();
    public CountriesModel getItem(int position);
    public long getItemId(int position);
    public Filter getFilter();

}

