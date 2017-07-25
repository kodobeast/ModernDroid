package ru.test.droidmodern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ru.test.droidmodern.dagdeps.DaggerDagDeps;
import ru.test.droidmodern.dagdeps.DagDeps;
import ru.test.droidmodern.network.NetModule;

import java.io.File;

public class MainActivity extends AppCompatActivity{

    DagDeps dagDeps;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");
        dagDeps = DaggerDagDeps.builder().netModule(new NetModule(cacheFile)).build();
    }

    public DagDeps getDagDeps() {

        return dagDeps;
    }
}
