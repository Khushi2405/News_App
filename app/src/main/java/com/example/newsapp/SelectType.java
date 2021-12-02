package com.example.newsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelectType#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectType extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private ArrayList<modelClass> recyclerDataArrayList;
    private ArrayList<String> selectedList;
    private Button next;
    View view;

    public SelectType() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SelectType.
     */
    // TODO: Rename and change types and number of parameters
    public static SelectType newInstance(String param1, String param2) {
        SelectType fragment = new SelectType();
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
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_select_type, container, false);
        recyclerView=view.findViewById(R.id.idType);
        next = view.findViewById(R.id.next);
        recyclerDataArrayList=new ArrayList<>();
        selectedList=new ArrayList<>();


        // added data to array list
        recyclerDataArrayList.add(new modelClass("General"));
        recyclerDataArrayList.add(new modelClass("Business"));
        recyclerDataArrayList.add(new modelClass("Entertainment"));
        recyclerDataArrayList.add(new modelClass("Health"));
        recyclerDataArrayList.add(new modelClass("Science"));
        recyclerDataArrayList.add(new modelClass("Sports"));
        recyclerDataArrayList.add(new modelClass("Technology"));

        // added data from arraylist to adapter class.
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(recyclerDataArrayList,getActivity(), new RecyclerViewAdapter.OnItemClickListener(){

            @Override
            public void onItemClick(modelClass item) {
                selectedList.add(item.getName());
            }
            });

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager=new GridLayoutManager(getActivity(),2);

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        next.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String[] str = new String[selectedList.size()];

                for (int i = 0; i < selectedList.size(); i++) {
                    str[i] = selectedList.get(i).toLowerCase();
                }
                Bundle bundle = new Bundle();
                bundle.putStringArray("news", str);
                News news = new News();
                news.setArguments(bundle);
                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true).addToBackStack(null)
                        .replace(R.id.fragment_container_view, news, null)
                        .commit();
            }
        });

        return view;
    }
}