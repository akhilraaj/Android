package com.android.sunshine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public  class ForecastFragment extends Fragment {
	private ArrayAdapter<String> mForecastAdapter;
	public ForecastFragment() {
	} 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.forecastfragment, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id=item.getItemId();
		if(id==R.id.action_refresh){
			FetchWeathertask weathertask=new FetchWeathertask();
			weathertask.execute();
			return true;
			
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		  String[] forecastArray={"akhilraj= coder",
				  "sunday= rainy day","monday= cloudy","tuesday = rainy afgaun"};
		  List<String>	weekForecast=new ArrayList<String>(Arrays.asList( forecastArray));
		mForecastAdapter= new   ArrayAdapter<String>(getActivity(),R.layout.list_item_forecast,
				R.id.list_item_forecast_textview,weekForecast
				);
		ListView listView=(ListView)rootView.findViewById(R.id.listview_forecast);
		listView.setAdapter(mForecastAdapter);
		
		
		

        return rootView;
    }
}
