package com.example.zmp3.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
//import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.zmp3.R;


public class Fragment_Tim_Kiem extends Fragment {

    View view;
//    Toolbar toolbar;
//    RecyclerView recyclerViewsearchbaihat;
//    TextView txtkhongcodulieu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_tim_kiem,container,false);
//        toolbar = view.findViewById(R.id.toolbarsearchbaihat);
//        recyclerViewsearchbaihat = view.findViewById(R.id.recyclerviewsearchbaihat);
//        txtkhongcodulieu = view.findViewById(R.id.textviewkhongcodulieu);
      
        return view;
    }
    }