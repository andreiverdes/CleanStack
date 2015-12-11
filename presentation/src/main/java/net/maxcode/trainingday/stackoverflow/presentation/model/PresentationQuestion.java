package net.maxcode.trainingday.stackoverflow.presentation.model;

import java.util.List;

/**
 * Created by andrei on 11/12/15.
 */
public class PresentationQuestion {
    private List<String> tags;
    private PresentationOwner owner;
    private boolean isAnswered;
    private int upVoteCount;
    private String title;
    private String body;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> pTags) {
        tags = pTags;
    }

    public PresentationOwner getOwner() {
        return owner;
    }

    public void setOwner(PresentationOwner pOwner) {
        owner = pOwner;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean pAnswered) {
        isAnswered = pAnswered;
    }

    public int getUpVoteCount() {
        return upVoteCount;
    }

    public void setUpVoteCount(int pUpVoteCount) {
        upVoteCount = pUpVoteCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String pTitle) {
        title = pTitle;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String pBody) {
        body = pBody;
    }
}
