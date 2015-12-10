package net.maxcode.trainingday.stackoverflow.data;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.maxcode.trainingday.stackoverflow.data.model.QuestionEntity;

import java.io.IOException;
import java.util.List;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by andreiverdes on 12/10/15.
 */
public class StackOverflowWebService implements IStackOverflowDataStore{

    private IStackOverflowServiceAPI mStackOverflowServiceAPI;

    private static final StackOverflowWebService instance = new StackOverflowWebService();

    public static StackOverflowWebService instance(){
        return instance;
    }

    private StackOverflowWebService(){
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IStackOverflowServiceAPI.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        this.mStackOverflowServiceAPI = retrofit.create(IStackOverflowServiceAPI.class);
    }

    @Override public List<QuestionEntity> getQuestions() {
        try {
            return mStackOverflowServiceAPI.getQuestions().execute().body().getItems();
        } catch (IOException pE) {
            pE.printStackTrace();
        }
        return null;
    }
}
