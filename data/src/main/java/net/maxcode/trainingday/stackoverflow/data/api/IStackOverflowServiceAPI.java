package net.maxcode.trainingday.stackoverflow.data.api;

import net.maxcode.trainingday.stackoverflow.data.model.DataQuestion;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by andreiverdes on 12/10/15.
 */
public interface IStackOverflowServiceAPI {
    String ROOT_URL = "https://api.stackexchange.com/2.2";

    @GET("questions?order=desc&sort=votes&tagged=android&site=stackoverflow")
    Call<ApiResponse<DataQuestion>> getQuestions();

}
