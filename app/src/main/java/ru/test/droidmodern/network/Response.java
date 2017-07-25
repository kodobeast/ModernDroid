package ru.test.droidmodern.network;

import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("status")
    public String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @SuppressWarnings({"unused", "используется Retrofit"})
    public Response() {
    }

    public Response(String status) {
        this.status = status;
    }
}
