package com.example.vmac.WatBot.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.vmac.WatBot.Adapter.CursosAdapter;
import com.example.vmac.WatBot.Model.tipocurso;
import com.example.vmac.WatBot.R;
import com.example.vmac.WatBot.Service.ApiService;
import com.example.vmac.WatBot.Service.ApiServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CursosFragment extends Fragment {
    private static final String TAG = PfrFragment.class.getSimpleName();

    private RecyclerView tcursoList;

    public CursosFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View d=inflater.inflate(R.layout.fragment_cursos, container, false);

        tcursoList = d.findViewById(R.id.recyclerview);
        tcursoList.setLayoutManager(new LinearLayoutManager(getActivity()));

        tcursoList.setAdapter(new CursosAdapter());

        initialize();

        return d;    }

    private void initialize() {

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<tipocurso>> call = service.gettcurso();

        call.enqueue(new Callback<List<tipocurso>>() {

            @Override
            public void onResponse(Call<List<tipocurso>> call, Response<List<tipocurso>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<tipocurso> tipocurso = response.body();
                        Log.d(TAG, "tipocurso: " + tipocurso);

                        CursosAdapter adapter = (CursosAdapter) tcursoList.getAdapter();
                        adapter.setTipocurso(tipocurso);
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
            public void onFailure(Call<List<tipocurso>> call, Throwable t) {
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
