package net.maxcode.trainingday.stackoverflow.data.store;

/**
 * Created by andrei on 11/12/15.
 */
public interface IStoreCallback<T> {

    void onCallback(T pObject);

}
