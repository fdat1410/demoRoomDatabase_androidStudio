package com.example.demoroomdatabase.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoroomdatabase.R;
import com.example.demoroomdatabase.adapter.UserAdapter;
import com.example.demoroomdatabase.entity.User;
import com.example.demoroomdatabase.respository.UserRespository;

import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private UserRespository userRespository;
    Context context = getContext();
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        userRespository = new UserRespository(getContext());
        List<User> users =userRespository.getAll();
        UserAdapter userAdapter = new UserAdapter(context,users);
//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
//        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        return view;
    }
}
