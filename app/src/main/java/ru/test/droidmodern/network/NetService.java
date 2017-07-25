package ru.test.droidmodern.network;


import ru.test.droidmodern.model.SomeResponse;

import retrofit2.http.GET;
import rx.Observable;

public interface NetService {

    //TODO: прорисать урл
    @GET("???")
    Observable<SomeResponse> getSomeData();

}
