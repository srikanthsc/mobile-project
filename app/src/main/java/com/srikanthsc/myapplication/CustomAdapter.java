package com.srikanthsc.myapplication;// nom du package
// import
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<CountriesModel> implements Interface_CustomAdapter {

    private Context context; // variable c'est le contexte de l'état actuel de l'application / objet.
    private List<CountriesModel> countriesModelsList; // variable  liste
    private List<CountriesModel> countriesModelsListFiltered; // variable liste

    public CustomAdapter(Context context, List<CountriesModel> countriesModelsList) { // constructeur
        // Custom adapter Un adapteur est un objet de classe qui fait introduire l'interface Adapter. Il agit comme un lien entre un ensemble de  et une vue d'adapteur, un objet de classe qui etend la classe abstraite de AdapterView

        super(context, R.layout.list_custom_item, countriesModelsList);

        this.context = context;

        this.countriesModelsList = countriesModelsList;

        this.countriesModelsListFiltered = countriesModelsList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) { //methode getview

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom_item,null,true);
        TextView tvCountryName = view.findViewById(R.id.tvCountryName);//ressource

        ImageView imageView = view.findViewById(R.id.imageFlag);//resoource

        tvCountryName.setText(countriesModelsListFiltered.get(position).getCountry());//resoource

        Glide.with(context).load(countriesModelsListFiltered.get(position).getFlag()).into(imageView);//resoource
//Glide est une bibliothèque de chargement d’images pour Android
        return view;
    }

    @Override
    public int getCount() {
        return countriesModelsListFiltered.size();
    }

    @Nullable
    @Override
    public CountriesModel getItem(int position) //methode
    {
        return countriesModelsListFiltered.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    } //methode

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) { //methode

                FilterResults filterResults = new FilterResults();
                if(constraint == null || constraint.length() == 0){



                    filterResults.count = countriesModelsList.size();


                    filterResults.values = countriesModelsList;

                }else{
                    List<CountriesModel> resultsModel = new ArrayList<>();


                    String searchStr = constraint.toString().toLowerCase();

                    for(CountriesModel itemsModel: countriesModelsList){

                        if(itemsModel.getCountry().toLowerCase().contains(searchStr)){


                            resultsModel.add(itemsModel);

                        }

                        filterResults.count = resultsModel.size();

                        filterResults.values = resultsModel;
                    }


                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) { //methode

                countriesModelsListFiltered = (List<CountriesModel>) results.values;
                Countries.countriesModelsList = (List<CountriesModel>) results.values;

                notifyDataSetChanged();//signaler si les donnees ont changer

            }
        };



        return filter;
    }
}

