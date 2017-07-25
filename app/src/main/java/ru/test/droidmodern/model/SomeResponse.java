package ru.test.droidmodern.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SomeResponse {

    @SerializedName("data")
    @Expose
    private List<SomeData> data = new ArrayList<SomeData>();

    @SerializedName("status")
    @Expose
    private int status;

    public List<SomeData> getData() {
        return data;
    }

    public void setData(List<SomeData> data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}