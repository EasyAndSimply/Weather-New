package Util;
import android.database.Observable;

import org.json.JSONException;
import org.json.JSONObject;

import model.WeatherInfo;
import retrofit.http.GET;
import retrofit.http.Query;

public interface Utils {
    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    public static final String ICON_URL = "http://openweathermap.org/img/w/";
    String API_KEY =  "&appid=4a48e751d3b607df422c9d8a4655b4fc";
    String UNITS_METRIC = "metric";
    String UNITS_IMPERAL = "imperial";

    @GET("weather?")
    Observable<WeatherInfo> getWeatherData(@Query("q=")String city);

    }


