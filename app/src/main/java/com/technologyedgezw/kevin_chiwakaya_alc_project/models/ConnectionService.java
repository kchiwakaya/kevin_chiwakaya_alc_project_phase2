package com.technologyedgezw.kevin_chiwakaya_alc_project.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface ConnectionService {


    @GET("/api/skilliq")
    Call<ArrayList<SkillIQ>> listSkill(
    );
    @GET("/api/hours")
    Call<ArrayList<Learning>> listLearner(
    );

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse") // FORM URL
    @FormUrlEncoded
    Call<Void> submitForm( // Entry ID of the response field for each of the question
                           @Field("entry.1824927963") String email,
                           @Field("entry.1877115667") String name,
                           @Field("entry.2006916086") String lastname,
                           @Field("entry.284483984") String projectlink

    );

}
