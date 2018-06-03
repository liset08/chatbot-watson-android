package com.example.vmac.WatBot.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.vmac.WatBot.R;
import com.roughike.bottombar.BottomBar;


public class CarrerasTecnFragment extends Fragment {
BottomBar mBottomBar;
    public CarrerasTecnFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View d=inflater.inflate(R.layout.fragment_carreras_tecn, container, false);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)d.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                switch (item.getItemId()) {
                    case R.id.menu_home:
                        CursoCortoFragment fragment2 = new CursoCortoFragment();
                        fragmentManager.beginTransaction().replace(R.id.main_content2, fragment2).addToBackStack("tag").commit();
                        break;
                    case R.id.menu_favorite:
                        ProgIntegFragment fragment3 = new ProgIntegFragment();
                        fragmentManager.beginTransaction().replace(R.id.main_content2, fragment3).addToBackStack("tag").commit();
                        break;


                }
                return true;
            }
        });

        return d;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
