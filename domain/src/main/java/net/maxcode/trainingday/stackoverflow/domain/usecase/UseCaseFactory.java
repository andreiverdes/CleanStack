package net.maxcode.trainingday.stackoverflow.domain.usecase;

import net.maxcode.trainingday.stackoverflow.data.api.StackOverflowWebService;
import net.maxcode.trainingday.stackoverflow.data.store.IStackOverflowDataStore;

/**
 * Created by andrei on 11/12/15.
 */
public class UseCaseFactory {

    private static final UseCaseFactory instance = new UseCaseFactory();

    public static UseCaseFactory getInstance() {
        return instance;
    }

    private IStackOverflowDataStore mStackOverflowDataStore;

    private UseCaseFactory(){
        this.mStackOverflowDataStore = StackOverflowWebService.getInstance();
    }

    public QuestionsListUseCase newQuestionsListUseCase(){
        return new QuestionsListUseCase(mStackOverflowDataStore);
    }

}
