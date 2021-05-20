package com.srikanthsc.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
//l'adapter pour le recyclerview
public class RetrofitAdapter extends RecyclerView.Adapter<RetrofitAdapter.RetrofitViewHolder> {


    List<ModelRetrofit> RetrofitList;
    Context context;

    public RetrofitAdapter(Context context , List<ModelRetrofit> posts){
        this.context= context;
        RetrofitList = posts;
    }
    @NonNull
    @Override
    public RetrofitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items2 , parent, false);
        return new RetrofitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RetrofitViewHolder holder, int position) {

        ModelRetrofit retro = RetrofitList.get(position);
        holder.title.setText(retro.getTitle());


    }

    @Override
    public int getItemCount() {
        return RetrofitList.size();
    }

    public class RetrofitViewHolder extends RecyclerView.ViewHolder{
  TextView userId ,  title;
        public RetrofitViewHolder(@NonNull View itemView) {
            super(itemView);


            title = itemView.findViewById(R.id.textView);
            userId = itemView.findViewById(R.id.textView1);
        }
    }


}
