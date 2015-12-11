package net.maxcode.trainingday.stackoverflow.presentation.presenter;

import net.maxcode.trainingday.stackoverflow.domain.IUseCaseCallback;
import net.maxcode.trainingday.stackoverflow.domain.model.DomainQuestion;
import net.maxcode.trainingday.stackoverflow.domain.usecase.QuestionsListUseCase;
import net.maxcode.trainingday.stackoverflow.presentation.QuestionMapper;
import net.maxcode.trainingday.stackoverflow.presentation.model.PresentationQuestion;
import net.maxcode.trainingday.stackoverflow.presentation.view.IUserListView;

import java.util.List;

/**
 * Created by andrei on 11/12/15.
 */
public class QuestionsListPresenter implements IPresenter {

    private IUserListView mUserListView;
    private QuestionsListUseCase mQuestionsListUseCase;
    private QuestionMapper mQuestionMapper;

    public QuestionsListPresenter(QuestionsListUseCase pQuestionsListUseCase){
        this.mQuestionsListUseCase = pQuestionsListUseCase;
        this.mQuestionMapper = QuestionMapper.getInstance();
    }

    public void setView(IUserListView pView) {
        this.mUserListView = pView;
    }

    @Override public void onCreate() {
        if(mUserListView == null){
            throw new IllegalStateException("UserListView is null! Please set view first!");
        }
        this.loadQuestionsList();
    }

    private void loadQuestionsList() {
        this.mUserListView.hideRetry();
        this.mUserListView.showLoading();
        this.getQuestionsList();
    }

    private void getQuestionsList() {
        this.mQuestionsListUseCase.execute(new IUseCaseCallback<List<DomainQuestion>>() {
            @Override public void onSuccess(List<DomainQuestion> pObject) {
                List<PresentationQuestion> presentationQuestions = mQuestionMapper.transform(pObject);
                mUserListView.renderQuestionsList(presentationQuestions);
            }

            @Override public void onError(Exception pException) {
                mUserListView.hideLoading();
                mUserListView.showError(pException.getMessage());
                mUserListView.showRetry();
            }
        });
    }

    @Override public void onResume() {}

    @Override public void onPause() {}

    @Override public void onDestroy() {
        this.mUserListView = null;
        this.mQuestionsListUseCase = null;
    }

}
