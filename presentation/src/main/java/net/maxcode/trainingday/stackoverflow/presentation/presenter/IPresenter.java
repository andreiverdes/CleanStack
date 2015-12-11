package net.maxcode.trainingday.stackoverflow.presentation.presenter;

import net.maxcode.trainingday.stackoverflow.presentation.view.IView;

/**
 * Created by andrei on 11/12/15.
 */
public interface IPresenter {

    void onCreate();
    void onResume();
    void onPause();
    void onDestroy();

}
