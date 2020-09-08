package com.technologyedgezw.kevin_chiwakaya_alc_project.utilities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.technologyedgezw.kevin_chiwakaya_alc_project.R;

public class SuccessDialog extends DialogFragment {

    public static boolean isYes = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.success_dialog, container, false);

        Button yes = view.findViewById(R.id.btnYes);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isYes =true;
                dismiss();
            }
        });


        return view;
    }
}
