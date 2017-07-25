package ru.test.droidmodern.dagdeps;


import ru.test.droidmodern.base.Activity;
import ru.test.droidmodern.network.NetModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetModule.class})
public interface DagDeps {
    void inject(Activity activity);
}
