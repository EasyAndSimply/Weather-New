package com.home.weather_rebild;

import android.app.ProgressDialog;
import android.icu.text.DateFormat;
import android.icu.text.DecimalFormat;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.annotations.Until;
import com.hannesdorfmann.mosby.mvp.MvpActivity;

import java.util.Date;


import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import data.WeatherAdapter;
import model.Weather;
import model.WeatherInfo;
import presenter.WeatherPresenter;
import view.WeatherView;


public class MainActivity

        extends MvpActivity<WeatherView, WeatherPresenter>
        implements WeatherView {



    @Bind(R.id.root_layout)
    ViewGroup rootLayout;



    @Bind(R.id.city_text)
    TextView cityText;



    @Bind(R.id.weather_condition)
    TextView conditionText;



    @Bind(R.id.temp_text)
    TextView tempText;



    @Bind(R.id.humidity_text)
    TextView humidityText;



    @Bind(R.id.wind_text)
    TextView windText;
    private ProgressDialog progressDialog;
    private GPSTracker gps;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.please_wait));
        gps = new GPSTracker(this);
        onRefreshButtonClick();
    }



    @OnClick(R.id.refresh_button)

    public void onRefreshButtonClick() {
        if (gps.canGetLocation()) {
            presenter.doObtainWeather(gps.getLatitude(), gps.getLongitude());
        }

    }



    @Override

    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }



    @NonNull

    @Override

    public WeatherPresenter createPresenter() {
        return new WeatherPresenter();
    }



    @Override

    public void showLoading() {
        progressDialog.show();
    }



    @Override

    public void hideLoading() {
        progressDialog.hide();
    }



    @Override

    public void showError(String error) {
        hideLoading();
        Snackbar.make(rootLayout, error, Snackbar.LENGTH_LONG).show();

    }



    @Override

    public void onWeatherObtained(WeatherInfo w) {
        hideLoading();
        showWeather(w);

    }



    private void showWeather(WeatherInfo w) {

        String city = w.getName();
        String condition = w.getWeather().get(0).getDescription();
        String temp = w.getMain().getTemp() +
                getString(R.string.celsius);
        String humidity = getString(R.string.humidity) + ": " +
                w.getMain().getHumidity() + "%";
        String wind = getString(R.string.wind_speed) + ": " +
                w.getWind().getSpeed() + " m/s";



        cityText.setText(city);
        conditionText.setText(condition);
        tempText.setText(temp);
        humidityText.setText(humidity);
        windText.setText(wind);

    }

}













