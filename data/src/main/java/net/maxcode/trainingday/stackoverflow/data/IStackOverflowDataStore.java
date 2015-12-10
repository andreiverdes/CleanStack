package net.maxcode.trainingday.stackoverflow.data;

import net.maxcode.trainingday.stackoverflow.data.model.QuestionEntity;

import java.util.List;

/**
 * Created by andreiverdes on 12/10/15.
 */
public interface IStackOverflowDataStore {

    List<QuestionEntity> getQuestions();

}
