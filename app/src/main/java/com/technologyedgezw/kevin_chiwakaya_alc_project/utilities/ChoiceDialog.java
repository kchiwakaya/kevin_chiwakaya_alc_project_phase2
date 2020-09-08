package com.technologyedgezw.kevin_chiwakaya_alc_project.utilities;

import android.content.Intent;
import android.icu.util.IslamicCalendar;
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

public class ChoiceDialog extends DialogFragment {

    private ISubmit submit;
    public ChoiceDialog(ISubmit submit)
    {
        this.submit =submit;
    }
    public ChoiceDialog()
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.choice_dialog, container, false);

        Button yes = view.findViewById(R.id.btnYes);
       ImageView imageView = view.findViewById(R.id.btnClose);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit.goAhead();
                dismiss();
            }
        });


        return view;
    }
    public interface ISubmit
    {
        void goAhead();
    }
}

