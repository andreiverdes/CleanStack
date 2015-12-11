package net.maxcode.trainingday.stackoverflow.presentation.presenter;

import net.maxcode.trainingday.stackoverflow.domain.usecase.UseCaseFactory;

/**
 * Created by andrei on 11/12/15.
 */
public class PresenterFactory
{
    private static PresenterFactory instance = new PresenterFactory();

    public static PresenterFactory getInstance() {
        return instance;
    }

    private UseCaseFactory mUseCaseFactory;

    private PresenterFactory() {
        this.mUseCaseFactory = UseCaseFactory.getInstance();
    }

    public QuestionsListPresenter newQuestionListPresenter(){
        return new QuestionsListPresenter(mUseCaseFactory.newQuestionsListUseCase());
    }
}
