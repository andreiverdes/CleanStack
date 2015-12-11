package net.maxcode.trainingday.stackoverflow.domain;

import net.maxcode.trainingday.stackoverflow.data.model.DataOwner;
import net.maxcode.trainingday.stackoverflow.data.model.DataQuestion;
import net.maxcode.trainingday.stackoverflow.domain.model.DomainOwner;
import net.maxcode.trainingday.stackoverflow.domain.model.DomainQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrei on 11/12/15.
 */
public class QuestionMapper {

    private static final QuestionMapper instance = new QuestionMapper();

    public static QuestionMapper getInstance(){
        return instance;
    }

    public DomainOwner transform(DataOwner pDataOwner){
        DomainOwner domainOwner = new DomainOwner();
        if(pDataOwner == null){
            return domainOwner;
        }
        domainOwner.setDisplayName(pDataOwner.getDisplayName());
        return domainOwner;
    }

    public DomainQuestion transform(DataQuestion pDataQuestion){
        DomainQuestion domainQuestion = new DomainQuestion();
        if(pDataQuestion == null){
            return domainQuestion;
        }
        DomainOwner domainOwner = this.transform(pDataQuestion.getOwner());

        domainQuestion.setAnswered(pDataQuestion.isAnswered());
        domainQuestion.setBody(pDataQuestion.getBody());
        domainQuestion.setOwner(domainOwner);
        domainQuestion.setTags(pDataQuestion.getTags());
        domainQuestion.setUpVoteCount(pDataQuestion.getUpVoteCount());
        return domainQuestion;
    }

    public List<DomainQuestion> transform(List<DataQuestion> pQuestionEntities){
        List<DomainQuestion> domainQuestionList = new ArrayList<>();
        if(pQuestionEntities == null){
            return domainQuestionList;
        }
        for(DataQuestion dataQuestion : pQuestionEntities){
            domainQuestionList.add(transform(dataQuestion));
        }
        return domainQuestionList;
    }
}
