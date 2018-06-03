package com.example.vmac.WatBot.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.vmac.WatBot.Adapter.CpeAdapter;
import com.example.vmac.WatBot.Adapter.PfrAdapter;
import com.example.vmac.WatBot.Model.Cpe;
import com.example.vmac.WatBot.Model.Pfr;
import com.example.vmac.WatBot.R;
import com.example.vmac.WatBot.Service.ApiService;
import com.example.vmac.WatBot.Service.ApiServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;


public class CursoCortoFragment extends Fragment {


    private RecyclerView cpeList;

    public CursoCortoFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View d=inflater.inflate(R.layout.fragment_curso_corto, container, false);

        cpeList = d.findViewById(R.id.recyclerview);
        cpeList.setLayoutManager(new LinearLayoutManager(getActivity()));

        cpeList.setAdapter(new CpeAdapter());

        initialize();

        return d;
    }

    private void initialize() {
        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<Cpe>> call = service.showCpe("CursoCorto");

        call.enqueue(new Callback<List<Cpe>>() {

            @Override
            public void onResponse(Call<List<Cpe>> call, Response<List<Cpe>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<Cpe> cpe = response.body();
                        Log.d(TAG, "cpe: " + cpe);

                        CpeAdapter adapter = (CpeAdapter) cpeList.getAdapter();
                        adapter.setCpe(cpe);
                        adapter.notifyDataSetChanged();

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }

            }

            @Override
            public void onFailure(Call<List<Cpe>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
            }




        });
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
