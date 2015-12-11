package net.maxcode.trainingday.stackoverflow.data.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.maxcode.trainingday.stackoverflow.data.model.QuestionEntity;
import net.maxcode.trainingday.stackoverflow.data.store.IStackOverflowDataStore;
import net.maxcode.trainingday.stackoverflow.data.store.IStoreCallback;

import java.util.List;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by andreiverdes on 12/10/15.
 */
public class StackOverflowWebService implements IStackOverflowDataStore {

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

    @Override public void getQuestions(final IStoreCallback<List<QuestionEntity>> pQuestionsCallback) {
        this.mStackOverflowServiceAPI.getQuestions().enqueue(new Callback<ApiResponse<QuestionEntity>>() {
            @Override public void onResponse(Response<ApiResponse<QuestionEntity>> response, Retrofit retrofit) {
                pQuestionsCallback.onCallback(response.body().getItems());
            }

            @Override public void onFailure(Throwable t) {
                pQuestionsCallback.onCallback(null);
            }
        });
    }
}
