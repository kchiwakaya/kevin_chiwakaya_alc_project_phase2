package com.technologyedgezw.kevin_chiwakaya_alc_project.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.technologyedgezw.kevin_chiwakaya_alc_project.models.Learning;
import com.technologyedgezw.kevin_chiwakaya_alc_project.models.SkillIQ;

import java.util.ArrayList;

public class PageViewModel extends ViewModel {

    public MutableLiveData<ArrayList<Learning>> mLearners;

    private MutableLiveData<ArrayList<SkillIQ>> mSkill;

    public PageViewModel()
    {
        mLearners = new MutableLiveData<>();
        mSkill = new MutableLiveData<>();

    }
    public LiveData<ArrayList<Learning>> getLearner()
    {
        return mLearners;
    }
    public LiveData<ArrayList<SkillIQ>> getSkills()
    {
        return mSkill;
    }



    public void setIndex(int index) {

    }

    public LiveData<String> getText() {
        return null;
    }
}