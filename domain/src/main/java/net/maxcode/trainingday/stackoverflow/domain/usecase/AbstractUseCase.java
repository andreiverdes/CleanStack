package net.maxcode.trainingday.stackoverflow.domain.usecase;

import net.maxcode.trainingday.stackoverflow.data.store.IStackOverflowDataStore;
import net.maxcode.trainingday.stackoverflow.domain.IUseCaseCallback;

/**
 * Created by andrei on 11/12/15.
 */
public abstract class AbstractUseCase<T> {

    private IStackOverflowDataStore mStackOverflowDataStore;

    public AbstractUseCase(IStackOverflowDataStore pStackOverflowDataStore){
        this.mStackOverflowDataStore = pStackOverflowDataStore;
    }

    public abstract void execute(IUseCaseCallback<T> pUseCaseCallback);

    public IStackOverflowDataStore getStackOverflowDataStore() {
        return mStackOverflowDataStore;
    }
}
