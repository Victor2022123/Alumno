package com.victor.studento;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class FragmentoInicio extends Fragment {
    View view;
    Button botoninicio;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmento_inicio, container, false);
        botoninicio = (Button) view.findViewById(R.id.btnInicio);
        botoninicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Iniciando nueva Secion", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}