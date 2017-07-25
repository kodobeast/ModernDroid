package ru.test.droidmodern.base;

import ru.test.droidmodern.model.SomeResponse;

public interface View {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getSomeDataSuccess(SomeResponse someResponse);

}
