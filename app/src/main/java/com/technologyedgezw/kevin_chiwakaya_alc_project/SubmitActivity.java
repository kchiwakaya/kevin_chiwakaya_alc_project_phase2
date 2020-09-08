package com.technologyedgezw.kevin_chiwakaya_alc_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.technologyedgezw.kevin_chiwakaya_alc_project.fragments.SubmitFragment;
import com.technologyedgezw.kevin_chiwakaya_alc_project.models.ConnectionService;
import com.technologyedgezw.kevin_chiwakaya_alc_project.utilities.ChoiceDialog;
import com.technologyedgezw.kevin_chiwakaya_alc_project.utilities.FailureDialog;
//import com.technologyedgezw.kevin_chiwakaya_alc_project.utilities.IReplace;
import com.technologyedgezw.kevin_chiwakaya_alc_project.utilities.SuccessDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmitActivity extends AppCompatActivity  implements SubmitFragment.IReplace{


    private Fragment submitFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_submit);
        Toolbar toolbar =findViewById(R.id.dash_toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        submitFragment = new SubmitFragment(this);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.contentFragment, submitFragment);
        transaction.commit();





    }


    @Override
    public void replace() {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.remove(submitFragment);
        transaction.commit();
        DialogFragment   fragment = new ChoiceDialog();
        fragment.show(getSupportFragmentManager(), "");
    }

    @Override
    public void replaceFailed() {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.remove(submitFragment);
        transaction.commit();
        DialogFragment   fragment = new FailureDialog();
        fragment.show(getSupportFragmentManager(), "");
    }

    @Override
    public void yes() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.remove(submitFragment);
        transaction.commit();

    }
}