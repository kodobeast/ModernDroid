package ru.test.droidmodern.base;

import ru.test.droidmodern.model.SomeResponse;
import ru.test.droidmodern.network.NetError;
import ru.test.droidmodern.network.RxService;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class Presenter {
    private final RxService rxService;
    private final View view;
    private CompositeSubscription subscriptions;

    public Presenter(RxService rxService, View view) {
        this.rxService = rxService;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
    }

    public void getCityList() {
        view.showWait();

        Subscription subscription = rxService.getSomeData(new RxService.getSomeDataCallback() {
            @Override
            public void onSuccess(SomeResponse cityListResponse) {
                view.removeWait();
                view.getSomeDataSuccess(cityListResponse);
            }

            @Override
            public void onError(NetError networkError) {
                view.removeWait();
                view.onFailure(networkError.getAppErrorMessage());
            }

        });

        subscriptions.add(subscription);
    }
    public void onStop() {
        subscriptions.unsubscribe();
    }
}
