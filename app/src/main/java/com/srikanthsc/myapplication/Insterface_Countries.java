package com.srikanthsc.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.view.MenuItem;

import androidx.annotation.NonNull;

public interface Insterface_Countries {
    public void beforeTextChanged(CharSequence s, int start, int count, int after);
    public void onTextChanged(CharSequence s, int start, int before, int count);

    public void afterTextChanged(Editable s);

    public boolean onOptionsItemSelected(@NonNull MenuItem item);




}
