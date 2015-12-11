package net.maxcode.trainingday.cleanstackoverflow.android;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import net.maxcode.trainingday.cleanstackoverflow.android.model.AndroidQuestion;
import net.maxcode.trainingday.stackoverflow.presentation.model.PresentationQuestion;
import net.maxcode.trainingday.stackoverflow.presentation.presenter.PresenterFactory;
import net.maxcode.trainingday.stackoverflow.presentation.presenter.QuestionsListPresenter;
import net.maxcode.trainingday.stackoverflow.presentation.view.IQuestionsListView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IQuestionsListView {

    private QuestionMapper mQuestionMapper;
    private QuestionsListAdapter mQuestionsListAdapter;
    private QuestionsListPresenter mQuestionsListPresenter;
    private PresenterFactory mPresenterFactory;

    private ListView mListView;
    private ProgressDialog mProgressDialog;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.afterInject();
        this.setContentView(R.layout.activity_main);
        this.injectViews();
        this.afterViews();
    }

    private void afterInject() {
        this.mQuestionMapper = QuestionMapper.getInstance();
        this.mPresenterFactory = PresenterFactory.getInstance();
        this.mQuestionsListPresenter = this.mPresenterFactory.newQuestionListPresenter();
        this.mQuestionsListAdapter = new QuestionsListAdapter(this);
    }

    private void injectViews() {
        this.mListView = ((ListView) this.findViewById(R.id.list));
    }

    private void afterViews() {
        this.mListView.setAdapter(mQuestionsListAdapter);
        this.mQuestionsListPresenter.setView(this);
        this.mQuestionsListPresenter.onCreate();
    }

    @Override protected void onResume() {
        super.onResume();
        this.mQuestionsListPresenter.onResume();
    }

    @Override protected void onPause() {
        super.onPause();
        this.mQuestionsListPresenter.onPause();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        this.mQuestionsListPresenter.onDestroy();
    }

    @Override public void renderQuestionsList(List<PresentationQuestion> pQuestions) {
        List<AndroidQuestion> androidQuestions = this.mQuestionMapper.transform(pQuestions);
        this.mQuestionsListAdapter.update(androidQuestions);
    }

    @Override public void showLoading() {
        if(mProgressDialog == null){
            this.mProgressDialog = ProgressDialog.show(this, "", "Loading...", true, false);
        } else {
            this.mProgressDialog.show();
        }
    }

    @Override public void hideLoading() {
        this.mProgressDialog.dismiss();
    }

    @Override public void showRetry() {

    }

    @Override public void hideRetry() {

    }

    @Override public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
