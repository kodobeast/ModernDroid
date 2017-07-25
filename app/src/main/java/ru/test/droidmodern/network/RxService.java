package ru.test.droidmodern.network;


import ru.test.droidmodern.model.SomeResponse;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RxService {

    private final NetService netService;

    public RxService(NetService netService) {

        this.netService = netService;
    }
//TODO: переделать на лямбду
    public Subscription getSomeData(final getSomeDataCallback callback) {

        return netService.getSomeData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends SomeResponse>>() {
                    @Override
                    public Observable<? extends SomeResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<SomeResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable cause) {
                        callback.onError(new NetError(cause));

                    }

                    @Override
                    public void onNext(SomeResponse someResponse) {
                        callback.onSuccess(someResponse);

                    }
                });
    }

    public interface getSomeDataCallback {
        void onSuccess(SomeResponse someResponse);

        void onError(NetError netError);
    }
}
