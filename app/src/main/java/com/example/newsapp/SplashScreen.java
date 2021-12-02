package com.example.newsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SplashScreen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SplashScreen extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView name;
    Animation bottAnim;
    View view;

    public SplashScreen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SplashScreen.
     */
    // TODO: Rename and change types and number of parameters
    public static SplashScreen newInstance(String param1, String param2) {
        SplashScreen fragment = new SplashScreen();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        bottAnim = AnimationUtils.loadAnimation(getActivity(),R.anim.bottom_animation);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_splash_screen, container, false);

        name = view.findViewById(R.id.name);

        name.setAnimation(bottAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SelectType selectType = new SelectType();
                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true).addToBackStack(null)
                        .replace(R.id.fragment_container_view, selectType, null)
                        .commit();
            }
        },4000);

        return view;
    }
}