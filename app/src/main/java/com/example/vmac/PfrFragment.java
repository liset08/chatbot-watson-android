package com.example.vmac;

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

import com.example.vmac.WatBot.Adapter.PfrAdapter;
import com.example.vmac.WatBot.Model.Pfr;
import com.example.vmac.WatBot.R;
import com.example.vmac.WatBot.Service.ApiService;
import com.example.vmac.WatBot.Service.ApiServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PfrFragment extends Fragment {
    private static final String TAG = PfrFragment.class.getSimpleName();

    private RecyclerView pfrList;


    public PfrFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View d=inflater.inflate(R.layout.fragment_pfr, container, false);

        pfrList = d.findViewById(R.id.recyclerview);
        pfrList.setLayoutManager(new LinearLayoutManager(getActivity()));

        pfrList.setAdapter(new PfrAdapter());

        initialize();

        return d;
    }

    private void initialize() {

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<Pfr>> call = service.getPfr();

        call.enqueue(new Callback<List<Pfr>>() {

                         @Override
                         public void onResponse(Call<List<Pfr>> call, Response<List<Pfr>> response) {
                             try {

                                 int statusCode = response.code();
                                 Log.d(TAG, "HTTP status code: " + statusCode);

                                 if (response.isSuccessful()) {

                                     List<Pfr> pfr = response.body();
                                     Log.d(TAG, "pfr: " + pfr);

                                     PfrAdapter adapter = (PfrAdapter) pfrList.getAdapter();
                                     adapter.setProductos(pfr);
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
                         public void onFailure(Call<List<Pfr>> call, Throwable t) {
                             Log.e(TAG, "onFailure: " + t.toString());
                             Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
                         }


        });
                     }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

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
