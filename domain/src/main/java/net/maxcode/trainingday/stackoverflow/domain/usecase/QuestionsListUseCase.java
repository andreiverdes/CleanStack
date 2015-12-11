package net.maxcode.trainingday.stackoverflow.domain.usecase;

import net.maxcode.trainingday.stackoverflow.data.model.DataQuestion;
import net.maxcode.trainingday.stackoverflow.data.store.IStackOverflowDataStore;
import net.maxcode.trainingday.stackoverflow.data.store.IStoreCallback;
import net.maxcode.trainingday.stackoverflow.domain.IUseCaseCallback;
import net.maxcode.trainingday.stackoverflow.domain.QuestionMapper;
import net.maxcode.trainingday.stackoverflow.domain.exception.QuestionFetchException;
import net.maxcode.trainingday.stackoverflow.domain.model.DomainQuestion;

import java.util.List;

/**
 * Created by andrei on 11/12/15.
 */
public class QuestionsListUseCase extends AbstractUseCase<List<DomainQuestion>> {

    public QuestionsListUseCase(IStackOverflowDataStore pStackOverflowDataStore) {
        super(pStackOverflowDataStore);
    }

    @Override public void execute(final IUseCaseCallback<List<DomainQuestion>> pUseCaseCallback) {
        getStackOverflowDataStore().getQuestions(new IStoreCallback<List<DataQuestion>>() {
            @Override public void onCallback(List<DataQuestion> pObject) {
                if(pObject != null){
                    List<DomainQuestion> domainQuestions = QuestionMapper.getInstance().transform(pObject);
                    pUseCaseCallback.onSuccess(domainQuestions);
                } else {
                    pUseCaseCallback.onError(new QuestionFetchException());
                }
            }
        });
    }
}
