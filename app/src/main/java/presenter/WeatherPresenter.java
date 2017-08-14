package presenter;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import data.WeatherAdapter;
import model.WeatherInfo;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import view.WeatherView;

/**
 * Created by kamina on 09.08.2017.
 */





public class WeatherPresenter extends MvpBasePresenter<WeatherView> {

    public void doObtainWeather(double lat, double lon) {
        if (getView() == null) {
            return;
        }
        getView().showLoading();
        WeatherAdapter.getInstance().getCurrentWeather(lat, lon)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WeatherInfo>() {

                    @Override
                    public void onCompleted() {
                    }

                    @Override public void onError(Throwable e) {
                        getView().showError(e.getMessage());
                    }

                    @Override
                    public void onNext(WeatherInfo weather) {
                        getView().onWeatherObtained(weather);
                    }

                });

    }

}