package net.maxcode.trainingday.stackoverflow.presentation.view;

/**
 * Created by andrei on 11/12/15.
 */
public interface ILoadingView extends IView{

    void showLoading();
    void hideLoading();
    void showRetry();
    void hideRetry();
    void showError(String message);

}
