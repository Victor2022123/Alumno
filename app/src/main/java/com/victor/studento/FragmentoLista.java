package com.victor.studento;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FragmentoLista extends Fragment {

    private AlumnoAdapter alumnoAdapter;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle  savedInstanceState) {
        // super.onCreate(savedInstanceState);
        // setContentView(R.layout.fragment_lista);
        view = inflater.inflate(R.layout.fragmento_lista, container, false);

//        String url = "http://10.0.2.2:8098/api/getUsers";
        String url = "https://my-alumno-victor.onrender.com/api/getStudents";
        //String url = "https://my-usuario-acme.onrender.com/api/getUsers"; // Reemplazar por la url desplegada en Render
        RequestQueue queue = Volley.newRequestQueue(getContext());

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<Student> students = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject studentObject = response.getJSONObject(i);
                        Integer id = studentObject.getInt("id");
                        String name = studentObject.getString("name");
                        String carrera = studentObject.getString("career");
                        String email = studentObject.getString("email");
                        String telefono = studentObject.getString("phone");
                        String ci = studentObject.getString("document");

                        students.add(new Student(id, name, carrera, email, telefono, ci));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                alumnoAdapter = new AlumnoAdapter(students, getContext());
                RecyclerView recyclerView = view.findViewById(R.id.recycler_View);

                recyclerView.setAdapter(alumnoAdapter);

                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getActivity(), "Datos de Lista " + error, Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
        return  view;

    }
}
