package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kamina on 09.08.2017.
 */

public class Clouds {


    @SerializedName("all")
    @Expose
    private Integer all;
    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }
}
