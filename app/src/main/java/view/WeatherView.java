package view;

import com.hannesdorfmann.mosby.mvp.MvpView;

import model.WeatherInfo;

/**
 * Created by kamina on 09.08.2017.
 */



public interface WeatherView extends MvpView {
 void showLoading();
void hideLoading();
 void showError(String error);
 void onWeatherObtained(WeatherInfo w);
}