package net.maxcode.trainingday.cleanstackoverflow.android;


import net.maxcode.trainingday.cleanstackoverflow.android.model.AndroidOwner;
import net.maxcode.trainingday.cleanstackoverflow.android.model.AndroidQuestion;
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

    public AndroidOwner transform(PresentationOwner pPresentationOwner){
        AndroidOwner androidOwner = new AndroidOwner();
        if(pPresentationOwner == null){
            return androidOwner;
        }
        androidOwner.setDisplayName(pPresentationOwner.getDisplayName());
        return androidOwner;
    }

    public AndroidQuestion transform(PresentationQuestion pPresentationQuestion){
        AndroidQuestion androidQuestion = new AndroidQuestion();
        if(pPresentationQuestion == null){
            return androidQuestion;
        }
        AndroidOwner androidOwner = this.transform(pPresentationQuestion.getOwner());

        androidQuestion.setAnswered(pPresentationQuestion.isAnswered());
        androidQuestion.setTitle(pPresentationQuestion.getTitle());
        androidQuestion.setBody(pPresentationQuestion.getBody());
        androidQuestion.setOwner(androidOwner);
        androidQuestion.setTags(pPresentationQuestion.getTags());
        androidQuestion.setUpVoteCount(pPresentationQuestion.getUpVoteCount());
        return androidQuestion;
    }

    public List<AndroidQuestion> transform(List<PresentationQuestion> pQuestionEntities){
        List<AndroidQuestion> androidQuestionList = new ArrayList<>();
        if(pQuestionEntities == null){
            return androidQuestionList;
        }
        for(PresentationQuestion androidQuestion : pQuestionEntities){
            androidQuestionList.add(transform(androidQuestion));
        }
        return androidQuestionList;
    }
    
}
