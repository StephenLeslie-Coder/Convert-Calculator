package com.example.convertcalculator;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class tab2 extends Fragment {

    public tab2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab2, container, false);
    }    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = getView().findViewById(R.id.kmToMilesConvertButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate();
            }
        });
    }



    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void Calculate(){
        MainActivity mainActivity= (MainActivity) getActivity();
        EditText editText= Objects.requireNonNull(getView()).findViewById(R.id.kmToMilesEditText);
        TextView textView= getView().findViewById(R.id.kmToMilesResult);
        if (editText.getText().toString().trim().length()>0){
            double myInput= Double.parseDouble(editText.getText().toString());

            double result= myInput*1.609;
            String resultString= String.format("%.2f",result);
            textView.setText(resultString+" mi");
            if(mainActivity!=null) {
                mainActivity.updateList(resultString+"mi");
            }

        }else
        {
            Toast.makeText(getContext(),"Please Enter Value",Toast.LENGTH_SHORT).show();
        }
    }

}
