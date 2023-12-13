package com.victor.studento;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FragmentoRegistro extends Fragment {

    Button botonRegistroGuardar;
    EditText nombreEditText, carreraEditText,emailEditText, telefonoEditText, ciEditText;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        //super.onCreate(saveInstanceState);
        // setContentView(R.layout.fragment_registro);

        view = inflater.inflate(R.layout.fragmento_registro, container, false);

        nombreEditText = (EditText) view.findViewById(R.id.txtNombre);
        carreraEditText = (EditText) view.findViewById(R.id.txtCarrera);
        emailEditText = (EditText) view.findViewById(R.id.txtCorreo);
        telefonoEditText = (EditText) view.findViewById(R.id.txtTelefono);
        ciEditText = (EditText) view.findViewById(R.id.txtCi);
        botonRegistroGuardar = (Button) view.findViewById(R.id.btnGuardar);

        botonRegistroGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nombreEditText.getText().toString();
                String carrera = carreraEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String telefono = telefonoEditText.getText().toString();
                String  ci = ciEditText.getText().toString();

                //String url = "http://10.0.2.2:8098/api/saveUser"; // url local
                String url = "https://my-alumno-victor.onrender.com/api/saveStudent";
                //String url = "https://my-usuario-acme.onrender.com/api/saveUser"; // Reemplazar por la url desplegada en Render

                RequestQueue queue = Volley.newRequestQueue(getActivity());

                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getActivity(), "Datos guardados exitosamente", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "Error al guardar los datos " + error, Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("name", name);
                        params.put("career", carrera);
                        params.put("email", email);
                        params.put("phone", telefono);
                        params.put("document", ci);
                        return params;
                    }

                    @Override
                    public byte[] getBody() {
                        return new JSONObject(getParams()).toString().getBytes();
                    }

                    @Override
                    public String getBodyContentType() {
                        return "application/json; charset=utf-8";
                    }
                };
                queue.add(request);
            }
        });
        return view;

    }
}
