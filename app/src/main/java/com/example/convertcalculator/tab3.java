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


public class tab3 extends Fragment {


    public tab3() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab3, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = getView().findViewById(R.id.cmToFeetConvertButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate();
            }
        });
    }



    @SuppressLint({"SetTextI18n", "DefaultLocale"})

    private void Calculate(){
        MainActivity mainActivity= (MainActivity) getActivity();
        EditText editText= (getView()).findViewById(R.id.cmToFeetEditText);
        TextView textView= getView().findViewById(R.id.cmToFeetResult);
        if (editText.getText().toString().trim().length()>0){
            double myInput= Double.parseDouble(editText.getText().toString());

            double result= myInput/30.48;
            String newResultString= String.format("%.2f",result);
            String resultString= Double.toString(Double.parseDouble(newResultString));

            textView.setText(resultString+" ft");

            if(mainActivity!=null) {
                mainActivity.updateList(resultString+"ft");
            }

        }else
        {
            Toast.makeText(getContext(),"Please Enter Value",Toast.LENGTH_SHORT).show();
        }
    }

}
