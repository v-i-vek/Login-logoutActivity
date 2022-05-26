package com.example.android.firebase.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.firebase.Adapter.UserAdapter;
import com.example.android.firebase.R;
import com.example.android.firebase.databinding.FragmentChatBinding;
import com.example.android.firebase.user.user;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class chatFragment extends Fragment {


    public chatFragment() {
        // Required empty public constructor
    }


    FragmentChatBinding binding;

    ArrayList<user> list = new ArrayList<user>();
    FirebaseDatabase database;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChatBinding.inflate(inflater, container, false);

        database = FirebaseDatabase.getInstance();
        UserAdapter adapter = new UserAdapter(list,getContext());
        binding.RecyclerViewChat.setAdapter(adapter);
        LinearLayoutManager  layoutManager = new LinearLayoutManager(getContext());
        binding.RecyclerViewChat.setLayoutManager(layoutManager);

        database.getReference().child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list.clear();
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    user Users = dataSnapshot.getValue(user.class);
                    Users.getUserId(dataSnapshot.getKey());
                    list.add(Users);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        return binding.getRoot();
    }
}