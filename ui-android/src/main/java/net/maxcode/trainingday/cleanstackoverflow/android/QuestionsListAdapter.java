package net.maxcode.trainingday.cleanstackoverflow.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import net.maxcode.trainingday.cleanstackoverflow.android.model.AndroidQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrei on 11/12/15.
 */
public class QuestionsListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<AndroidQuestion> mQuestionsList;

    public QuestionsListAdapter(Context pContext){
        this.mContext = pContext;
        this.mLayoutInflater = ((LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        this.mQuestionsList = new ArrayList<>();
    }

    @Override public int getCount() {
        return mQuestionsList.size();
    }

    @Override public AndroidQuestion getItem(int position) {
        return mQuestionsList.get(position);
    }

    @Override public long getItemId(int position) {
        return position;
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        AndroidQuestion androidQuestion = getItem(position);
        if(view == null){
            view = this.mLayoutInflater.inflate(R.layout.item_question, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        ViewHolder viewHolder = ((ViewHolder) view.getTag());
        viewHolder.mUpVotesTextView.setText(""+androidQuestion.getUpVoteCount());
        viewHolder.mTitleTextView.setText(androidQuestion.getTitle());
        viewHolder.mUpVotesTextView.setVisibility(View.GONE);
        return view;
    }

    public void update(List<AndroidQuestion> pAndroidQuestionList){
        this.mQuestionsList = pAndroidQuestionList;
        this.notifyDataSetChanged();
    }

    private static class ViewHolder{
        public TextView mUpVotesTextView;
        public TextView mTitleTextView;
        public ViewHolder(View pView){
            this.mUpVotesTextView = ((TextView) pView.findViewById(R.id.up_votes));
            this.mTitleTextView = ((TextView) pView.findViewById(R.id.title));
        }
    }
}
