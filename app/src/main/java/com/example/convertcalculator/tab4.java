package com.example.convertcalculator;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.LinkedList;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class tab4 extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    LinkedList<String>myList;
    Button myButton;
    EditText editText;
    View view;

    public tab4() {
        // Required empty public constructor
    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainActivity mainActivity= (MainActivity)getActivity();

         view = inflater.inflate(R.layout.fragment_tab4, container, false);
         recyclerView= view.findViewById(R.id.myRecyclerView);
        myList=new LinkedList<>();
         myAdapter= new WordListAdapter(getActivity(),mainActivity.myLinkedList);
         layoutManager= new LinearLayoutManager(getActivity());

         recyclerView.setLayoutManager(layoutManager);
         recyclerView.setAdapter(myAdapter);


        return view;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    public void updateData(){
        MainActivity mainActivity= (MainActivity) getActivity();
        /*myList.clear();
            myList.addAll(mainActivity.myLinkedList);*/

        /*myAdapter= new WordListAdapter(getActivity(),myList);*/
        myAdapter.notifyDataSetChanged();

            Log.d("TESTING", "updateData: one in");

    }



}

