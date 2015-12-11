package net.maxcode.trainingday.stackoverflow.domain;

/**
 * Created by andrei on 11/12/15.
 */
public interface IUseCaseCallback<T> {

    void onSuccess(T pObject);
    void onError(Exception pException);

}
