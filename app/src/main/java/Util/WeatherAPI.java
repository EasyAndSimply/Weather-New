package Util;
import android.database.Observable;
import model.WeatherInfo;
import retrofit.http.GET;
import retrofit.http.Query;


public interface WeatherAPI {
    String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";
    String API_KEY = "b1b15e88fa797225412429c1c50c122a";
    String UNITS_METRIC = "metric";
    String UNITS_IMPERAL = "imperial";
    @GET("weather?")
 Observable<WeatherInfo> getCurrentWeather(@Query("lat") double lat,
                                           @Query("lon") double lon,
                                           @Query("units") String units,
                                           @Query("appid") String appid);
}