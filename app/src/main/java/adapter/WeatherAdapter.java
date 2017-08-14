package adapter;

import android.database.Observable;

import Util.WeatherAPI;
import model.WeatherInfo;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by kamina on 09.08.2017.
 */

public class WeatherAdapter {
    private static WeatherAdapter instance;
    private WeatherAPI weatherAPI;
    private WeatherAdapter() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(WeatherAPI.BASE_URL)
                .build();
        weatherAPI = retrofit.create(WeatherAPI.class);
    }

    public static WeatherAdapter getInstance() {
        if (instance == null) {
            instance = new WeatherAdapter();
        }
        return instance;
    }
    public Observable<WeatherInfo> getCurrentWeather(double lat, double lon) {
        return weatherAPI.getCurrentWeather(lat, lon, WeatherAPI.UNITS_METRIC, WeatherAPI.API_KEY);
    }
}