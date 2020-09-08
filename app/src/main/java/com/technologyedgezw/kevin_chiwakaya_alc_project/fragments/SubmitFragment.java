package com.technologyedgezw.kevin_chiwakaya_alc_project.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.technologyedgezw.kevin_chiwakaya_alc_project.R;
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

/**
 * A simple {@link Fragment} subclass.
 * Use t
 * create an instance of this fragment.
 */
public class SubmitFragment extends Fragment implements ChoiceDialog.ISubmit {

    // TODO: Rename parameter arguments, choose names that match
    private static final String BASE_URL = "https://docs.google.com/forms/d/e/";
    private EditText mName, mSurname, mEmail, mGithub;
    private Button button;
    private ImageView imageView;
    private IReplace replace;



    public SubmitFragment(IReplace replace) {
        // Required empty public constructor
        this.replace = replace;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_submit, container, false);

        final ChoiceDialog dialog = new ChoiceDialog(this);

        button =view.findViewById(R.id.button);
        mName = view.findViewById(R.id.editTextTextPersonName);
        mSurname =view.findViewById(R.id.editTextTextPersonSurnme);
        mEmail =view.findViewById(R.id.editTextTextEmailAddress);
        mGithub =view.findViewById(R.id.editTextTextPersonName3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replace.yes();
                dialog.show(getActivity(). getSupportFragmentManager(), "Are you sure?");


            }
        });



        return view;
    }

    @Override
    public void goAhead() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            final ConnectionService fcmApi = retrofit.create(ConnectionService.class);
        String surn = mSurname.getText().toString();
        String name = mName.getText().toString();
        String email = mSurname.getText().toString();
        String gitbub = mGithub.getText().toString();

        Call<Void> call = fcmApi.submitForm(email, name, surn, gitbub);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                replace.replace();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                replace.replaceFailed();
            }
        });
    }



    public interface IReplace {

        void replace();
        void replaceFailed();
        void yes();
    }

}