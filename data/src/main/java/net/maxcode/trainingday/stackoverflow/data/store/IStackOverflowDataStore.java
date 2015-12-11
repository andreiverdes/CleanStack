package net.maxcode.trainingday.stackoverflow.data.store;

import net.maxcode.trainingday.stackoverflow.data.model.DataQuestion;

import java.util.List;

/**
 * Created by andreiverdes on 12/10/15.
 */
public interface IStackOverflowDataStore {

    void getQuestions(IStoreCallback<List<DataQuestion>> pQuestionsCallback);

}
