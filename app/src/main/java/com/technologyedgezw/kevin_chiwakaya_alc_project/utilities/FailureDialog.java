package com.technologyedgezw.kevin_chiwakaya_alc_project.utilities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.technologyedgezw.kevin_chiwakaya_alc_project.R;
import com.technologyedgezw.kevin_chiwakaya_alc_project.fragments.SubmitFragment;

public class FailureDialog extends DialogFragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.failure_dialog, container, false);

        ImageView fail = view.findViewById(R.id.failure);

        fail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dismiss();
            }
        });


        return view;
    }

}
