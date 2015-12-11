package net.maxcode.trainingday.stackoverflow.presentation;

import net.maxcode.trainingday.stackoverflow.domain.model.DomainOwner;
import net.maxcode.trainingday.stackoverflow.domain.model.DomainQuestion;
import net.maxcode.trainingday.stackoverflow.presentation.model.PresentationOwner;
import net.maxcode.trainingday.stackoverflow.presentation.model.PresentationQuestion;

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

    public PresentationOwner transform(DomainOwner pDomainOwner){
        PresentationOwner presentationOwner = new PresentationOwner();
        if(pDomainOwner == null){
            return presentationOwner;
        }
        presentationOwner.setDisplayName(pDomainOwner.getDisplayName());
        return presentationOwner;
    }

    public PresentationQuestion transform(DomainQuestion pDomainQuestion){
        PresentationQuestion presentationQuestion = new PresentationQuestion();
        if(pDomainQuestion == null){
            return presentationQuestion;
        }
        PresentationOwner presentationOwner = this.transform(pDomainQuestion.getOwner());

        presentationQuestion.setAnswered(pDomainQuestion.isAnswered());
        presentationQuestion.setTitle(pDomainQuestion.getTitle());
        presentationQuestion.setBody(pDomainQuestion.getBody());
        presentationQuestion.setOwner(presentationOwner);
        presentationQuestion.setTags(pDomainQuestion.getTags());
        presentationQuestion.setUpVoteCount(pDomainQuestion.getUpVoteCount());
        return presentationQuestion;
    }

    public List<PresentationQuestion> transform(List<DomainQuestion> pQuestionEntities){
        List<PresentationQuestion> presentationQuestionList = new ArrayList<>();
        if(pQuestionEntities == null){
            return presentationQuestionList;
        }
        for(DomainQuestion presentationQuestion : pQuestionEntities){
            presentationQuestionList.add(transform(presentationQuestion));
        }
        return presentationQuestionList;
    }
    
}
