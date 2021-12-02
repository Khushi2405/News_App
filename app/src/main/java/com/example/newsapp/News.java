package com.example.newsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link News#newInstance} factory method to
 * create an instance of this fragment.
 */
public class News extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String api = "8d41787f87354a058fc300193561116c";
    String[] selectedList;
    ArrayList<modelAPIClass> modelAPIClassArrayList;
    RecyclerViewAdapter2 adapter2;
    String country = "in";
    private RecyclerView recyclerView;
    View view;

    public News() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment News.
     */
    // TODO: Rename and change types and number of parameters
    public static News newInstance(String param1, String param2) {
        News fragment = new News();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news, container, false);
        // Inflate the layout for this fragment
        Bundle bundle = this.getArguments();
        try {
            selectedList = bundle.getStringArray("news");
        } catch (Exception e) {

        }

        recyclerView = view.findViewById(R.id.newsRecycler);
        modelAPIClassArrayList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter2 = new RecyclerViewAdapter2(modelAPIClassArrayList, getContext());
        recyclerView.setAdapter(adapter2);

        findNews();


        return view;
    }

    private void findNews() {

        if (selectedList.length > 0) {
            for (int i = 0; i < selectedList.length; i++) {
                ApiUtilities.getApiInterface().getCategoryNews(country, 5, api, selectedList[i]).enqueue(new Callback<mainAPIClass>() {
                    @Override
                    public void onResponse(Call<mainAPIClass> call, Response<mainAPIClass> response) {
                        if (response.isSuccessful()) {
                            modelAPIClassArrayList.addAll(response.body().getArticles());
                            adapter2.notifyDataSetChanged();
                        }
                    }
                    @Override
                    public void onFailure(Call<mainAPIClass> call, Throwable t) {
                    }
                });
            }
        }
        else {
            ApiUtilities.getApiInterface().getNews(country, 5, api).enqueue(new Callback<mainAPIClass>() {
                @Override
                public void onResponse(Call<mainAPIClass> call, Response<mainAPIClass> response) {
                    if (response.isSuccessful()) {
                        modelAPIClassArrayList.addAll(response.body().getArticles());
                        adapter2.notifyDataSetChanged();
                    }
                }
                @Override
                public void onFailure(Call<mainAPIClass> call, Throwable t) {
                }
            });
        }
    }
}