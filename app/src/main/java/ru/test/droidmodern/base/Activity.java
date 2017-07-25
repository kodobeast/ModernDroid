package ru.test.droidmodern.base;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.Toast;

import ru.test.droidmodern.MainActivity;
import ru.test.droidmodern.R;
import ru.test.droidmodern.model.SomeData;
import ru.test.droidmodern.model.SomeResponse;
import ru.test.droidmodern.network.RxService;

import javax.inject.Inject;

public class Activity extends MainActivity implements View {

    private RecyclerView list;
    @Inject
    public RxService rxService;
    ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDagDeps().inject(this);

        renderView();
        init();

        Presenter presenter = new Presenter(rxService, this);
        presenter.getCityList();
    }

    public void renderView(){
        setContentView(R.layout.activity_home);
        list = (RecyclerView) findViewById(R.id.list);
        progressBar = (ProgressBar) findViewById(R.id.progress);
    }

    @Override
    public void getSomeDataSuccess(SomeResponse someResponse) {

        Adapter adapter = new Adapter(getApplicationContext(), someResponse.getData(),
                new Adapter.OnItemClickListener() {
                    @Override
                    public void onClick(SomeData Item) {
                        Toast.makeText(getApplicationContext(), Item.getName(),
                                Toast.LENGTH_LONG).show();
                    }
                });

        list.setAdapter(adapter);

    }

    private void init(){
        list.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showWait() {
        progressBar.setVisibility(android.view.View.VISIBLE);
    }

    @Override
    public void removeWait() {
        progressBar.setVisibility(android.view.View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {}
}
