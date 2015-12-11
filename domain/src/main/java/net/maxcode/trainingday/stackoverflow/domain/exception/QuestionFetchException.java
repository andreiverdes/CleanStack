package net.maxcode.trainingday.stackoverflow.domain.exception;

/**
 * Created by andrei on 11/12/15.
 */
public class QuestionFetchException extends IllegalStateException {
    public QuestionFetchException(){
        super("Error occurred fetching questions!");
    }
}
