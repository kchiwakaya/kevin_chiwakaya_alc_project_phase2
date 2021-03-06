package com.technologyedgezw.kevin_chiwakaya_alc_project.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technologyedgezw.kevin_chiwakaya_alc_project.R;
import com.technologyedgezw.kevin_chiwakaya_alc_project.adapters.LearningAdapter;
import com.technologyedgezw.kevin_chiwakaya_alc_project.adapters.SkillAdapter;
import com.technologyedgezw.kevin_chiwakaya_alc_project.models.ConnectionService;
import com.technologyedgezw.kevin_chiwakaya_alc_project.models.SkillIQ;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SkillFragment extends Fragment {

    private static final String BASE_URL = " https://gadsapi.herokuapp.com";
    private PageViewModel mViewModel;
    private RecyclerView rvSkillsIQ;
    private ArrayList<SkillIQ> skills;
    private SkillAdapter adapter;

    public static SkillFragment newInstance() {
        return new SkillFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        mViewModel.setIndex(1);
        skills = new ArrayList<>();
        //new AsyncTask<Void>()
        Skills();

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.skillrecyclerview, container, false);

        rvSkillsIQ = root.findViewById(R.id.skillrecyclerview);


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }
    public void Skills()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ConnectionService fcmApi = retrofit.create(ConnectionService.class);


        Call<ArrayList<SkillIQ>> call = fcmApi.listSkill();
        call.enqueue(new Callback<ArrayList<SkillIQ>>() {
            @Override
            public void onResponse(Call<ArrayList<SkillIQ>> call, Response<ArrayList<SkillIQ>> response) {
                skills= response.body();
                adapter = new SkillAdapter(getContext(),skills);

                rvSkillsIQ.setAdapter(adapter);
                LinearLayoutManager appointmentsLayoutManager =
                        new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                rvSkillsIQ.setLayoutManager(appointmentsLayoutManager);
            }

            @Override
            public void onFailure(Call<ArrayList<SkillIQ>> call, Throwable t) {

            }
        });

    }
}