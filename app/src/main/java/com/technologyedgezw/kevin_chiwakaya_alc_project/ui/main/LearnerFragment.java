package com.technologyedgezw.kevin_chiwakaya_alc_project.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.technologyedgezw.kevin_chiwakaya_alc_project.R;
import com.technologyedgezw.kevin_chiwakaya_alc_project.adapters.LearningAdapter;
import com.technologyedgezw.kevin_chiwakaya_alc_project.adapters.SkillAdapter;
import com.technologyedgezw.kevin_chiwakaya_alc_project.models.ConnectionService;
import com.technologyedgezw.kevin_chiwakaya_alc_project.models.Learning;
import com.technologyedgezw.kevin_chiwakaya_alc_project.models.SkillIQ;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LearnerFragment extends Fragment {

    private PageViewModel pageViewModel;
    private RecyclerView rvLearners;
    private ArrayList<Learning> learners;
    private LearningAdapter adapter;
    private static final String BASE_URL = " https://gadsapi.herokuapp.com";

    public static LearnerFragment newInstance() {
        return new LearnerFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        pageViewModel.setIndex(2);

        learners = new ArrayList<>();
        Learning();

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.learningrecyclerview, container, false);

        rvLearners = root.findViewById(R.id.learnrecycler);


        return root;
    }


    public void Learning()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ConnectionService fcmApi = retrofit.create(ConnectionService.class);


        Call<ArrayList<Learning>> call = fcmApi.listLearner();

        call.enqueue(new Callback<ArrayList<Learning>>() {
            @Override
            public void onResponse(Call<ArrayList<Learning>> call, Response<ArrayList<Learning>> response) {
                learners = response.body();

                adapter = new LearningAdapter(getContext(),learners);

                rvLearners.setAdapter(adapter);
                LinearLayoutManager appointmentsLayoutManager =
                        new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                rvLearners.setLayoutManager(appointmentsLayoutManager);
            }

            @Override
            public void onFailure(Call<ArrayList<Learning>> call, Throwable t) {
                Toast.makeText(getContext(),"Connection error",Toast.LENGTH_LONG).show();
            }
        });
    }



}