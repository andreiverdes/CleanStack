package net.maxcode.trainingday.stackoverflow.presentation.view;

import net.maxcode.trainingday.stackoverflow.presentation.model.PresentationQuestion;

import java.util.List;

/**
 * Created by andrei on 11/12/15.
 */
public interface IUserListView extends ILoadingView {

    public void renderQuestionsList(List<PresentationQuestion> pQuestions);

}
