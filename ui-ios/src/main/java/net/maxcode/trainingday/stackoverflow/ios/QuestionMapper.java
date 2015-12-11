package net.maxcode.trainingday.stackoverflow.ios;

import net.maxcode.trainingday.stackoverflow.ios.model.IosOwner;
import net.maxcode.trainingday.stackoverflow.ios.model.IosQuestion;
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

    public IosOwner transform(PresentationOwner pPresentationOwner){
        IosOwner iosOwner = new IosOwner();
        if(pPresentationOwner == null){
            return iosOwner;
        }
        iosOwner.setDisplayName(pPresentationOwner.getDisplayName());
        return iosOwner;
    }

    public IosQuestion transform(PresentationQuestion pPresentationQuestion){
        IosQuestion iosQuestion = new IosQuestion();
        if(pPresentationQuestion == null){
            return iosQuestion;
        }
        IosOwner iosOwner = this.transform(pPresentationQuestion.getOwner());

        iosQuestion.setAnswered(pPresentationQuestion.isAnswered());
        iosQuestion.setTitle(pPresentationQuestion.getTitle());
        iosQuestion.setBody(pPresentationQuestion.getBody());
        iosQuestion.setOwner(iosOwner);
        iosQuestion.setTags(pPresentationQuestion.getTags());
        iosQuestion.setUpVoteCount(pPresentationQuestion.getUpVoteCount());
        return iosQuestion;
    }

    public List<IosQuestion> transform(List<PresentationQuestion> pQuestionEntities){
        List<IosQuestion> iosQuestionList = new ArrayList<>();
        if(pQuestionEntities == null){
            return iosQuestionList;
        }
        for(PresentationQuestion iosQuestion : pQuestionEntities){
            iosQuestionList.add(transform(iosQuestion));
        }
        return iosQuestionList;
    }
}
