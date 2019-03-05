package com.example.android.sunshine;

// Within ForecastAdapter.java /////////////////////////////////////////////////////////////////
// TODO (15) Add a class file called ForecastAdapter
// TODO (22) Extend RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>

// TODO (23) Create a private string array called mWeatherData

// TODO (47) Create the default constructor (we will pass in parameters in a later lesson)

// TODO (16) Create a class within ForecastAdapter called ForecastAdapterViewHolder
// TODO (17) Extend RecyclerView.ViewHolder

// Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////
// TODO (18) Create a public final TextView variable called mWeatherTextView

// TODO (19) Create a constructor for this class that accepts a View as a parameter
// TODO (20) Call super(view) within the constructor for ForecastAdapterViewHolder
// TODO (21) Using view.findViewById, get a reference to this layout's TextView and save it to mWeatherTextView
// Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////

// Within ForecastAdapter.java /////////////////////////////////////////////////////////////////

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {

    private String[] mWeatherData;

    public ForecastAdapter() {

    }

    // TODO (24) Override onCreateViewHolder
    // TODO (25) Within onCreateViewHolder, inflate the list item xml into a view
    // TODO (26) Within onCreateViewHolder, return a new ForecastAdapterViewHolder with the above view passed in as a parameter
    @NonNull
    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.forecast_list_item, viewGroup, false);

        return new ForecastAdapterViewHolder(view);
    }

    // TODO (27) Override onBindViewHolder
    // TODO (28) Set the text of the TextView to the weather for this list item's position
    @Override
    public void onBindViewHolder(@NonNull ForecastAdapterViewHolder forecastAdapterViewHolder, int i) {
        forecastAdapterViewHolder.mWeatherTextView.setText(mWeatherData[i]);
    }

    // TODO (29) Override getItemCount
    // TODO (30) Return 0 if mWeatherData is null, or the size of mWeatherData if it is not null

    @Override
    public int getItemCount() {
        return mWeatherData == null ? 0 : mWeatherData.length;
    }

    // TODO (31) Create a setWeatherData method that saves the weatherData to mWeatherData
    // TODO (32) After you save mWeatherData, call notifyDataSetChanged
    void setWeatherData(String[] weatherData) {
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }

    class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {

        public final TextView mWeatherTextView;

        public ForecastAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            mWeatherTextView = (TextView) itemView.findViewById(R.id.tv_weather_data);
        }
    }

}
