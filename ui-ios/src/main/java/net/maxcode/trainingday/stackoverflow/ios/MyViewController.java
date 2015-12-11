package net.maxcode.trainingday.stackoverflow.ios;

import net.maxcode.trainingday.stackoverflow.ios.model.IosQuestion;
import net.maxcode.trainingday.stackoverflow.presentation.model.PresentationQuestion;
import net.maxcode.trainingday.stackoverflow.presentation.presenter.PresenterFactory;
import net.maxcode.trainingday.stackoverflow.presentation.presenter.QuestionsListPresenter;
import net.maxcode.trainingday.stackoverflow.presentation.view.IQuestionsListView;
import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.*;

import java.util.List;

public class MyViewController extends UIViewController implements IQuestionsListView{

    private PresenterFactory mPresenterFactory;
    private QuestionMapper mQuestionMapper;
    private QuestionsListPresenter mQuestionsListPresenter;
    private QuestionsTableSource mQuestionsTableSource;

    private UITableView mUiTableView;
    private UIActivityIndicatorView mIndicatorView;

    public MyViewController() {
        this.mQuestionMapper = QuestionMapper.getInstance();
        this.mQuestionsTableSource = new QuestionsTableSource();
        this.mPresenterFactory = PresenterFactory.getInstance();
        this.mQuestionsListPresenter = this.mPresenterFactory.newQuestionListPresenter();

    }

    @Override public void viewDidLoad() {
        super.viewDidLoad();
        this.addUiTableView();
        this.addUiIndicatorView();
        this.afterViewDidLoad();
    }

    private void afterViewDidLoad() {
        this.mQuestionsListPresenter.setView(this);
        this.mQuestionsListPresenter.onCreate();
    }

    private void addUiIndicatorView() {
        mIndicatorView = new UIActivityIndicatorView();
        mIndicatorView.setColor(UIColor.black());
        mIndicatorView.setFrame(new CGRect(40.0, 40.0, 40.0, 40.0));
        mIndicatorView.setCenter(getView().getCenter());
        this.getView().addSubview(mIndicatorView);
        mIndicatorView.bringSubviewToFront(this.getView());
        mIndicatorView.setHidesWhenStopped(true);
    }

    private void addUiTableView() {
        this.mUiTableView = new UITableView(getView().getBounds());
        this.getView().addSubview(mUiTableView);
        this.mUiTableView.setModel(mQuestionsTableSource);
    }

    @Override public void renderQuestionsList(List<PresentationQuestion> pQuestions) {
        List<IosQuestion> iosQuestions = this.mQuestionMapper.transform(pQuestions);
        iosQuestions.add(0, new IosQuestion());
        mQuestionsTableSource.setQuestions(iosQuestions);
        mUiTableView.reloadData();
    }

    @Override public void showLoading() {
        mIndicatorView.startAnimating();
        UIApplication.getSharedApplication().setNetworkActivityIndicatorVisible(true);
    }

    @Override public void hideLoading() {
        mIndicatorView.stopAnimating();
        UIApplication.getSharedApplication().setNetworkActivityIndicatorVisible(false);
    }

    @Override public void showRetry() {

    }

    @Override public void hideRetry() {

    }

    @Override public void showError(String message) {

    }
}
