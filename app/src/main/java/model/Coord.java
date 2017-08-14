package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kamina on 09.08.2017.
 */

public class Coord {
    @SerializedName("lon")

    @Expose

    private Double lon;

    @SerializedName("lat")

    @Expose

    private Double lat;
    public Double getLon() {
        return lon;

    }

    public void setLon(Double lon) {

        this.lon = lon;

    }

    public Double getLat() {

        return lat;

    }

    public void setLat(Double lat) {

        this.lat = lat;

    }
}
