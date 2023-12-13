package com.victor.studento;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.AlumnoViewHolder> {

    private List<Student> students;
    private int selectedPosition = -1;

    private Context context;

    public AlumnoAdapter(List<Student> students, Context context) {
        this.students = students;
        this.context = context;
    }

    @Override
    public AlumnoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alumn_items, parent, false);
        return new AlumnoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlumnoViewHolder holder, int position) {
        Student student = students.get(position);
        // Se configura los datos de los elementos de la lista
        holder.idTV.setText(String.valueOf(student.getId()));
        holder.nombreTV.setText(student.getName());
        holder.carreraTV.setText(student.getCareer());
        holder.correoTV.setText(student.getEmail());
        holder.telefonoTV.setText(student.getPhone());
        holder.ciTV.setText(student.getCi());

        // Configura un OnClickListener en el ViewHolder
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Guarda el índice del elemento seleccionado
                setSelectedPosition(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }

    class AlumnoViewHolder extends RecyclerView.ViewHolder {
        // Se declararan los elementos de la vista (Layout user_item.xml)
        TextView idTV, nombreTV, carreraTV, correoTV, telefonoTV, ciTV;

        public AlumnoViewHolder(View itemView) {
            super(itemView);
            idTV = itemView.findViewById(R.id.txtItmId);
            nombreTV = itemView.findViewById(R.id.txtItemNombre);
            carreraTV = itemView.findViewById(R.id.txtItemCarrera);
            correoTV = itemView.findViewById(R.id.txtItemCorreo);
            telefonoTV = itemView.findViewById(R.id.txtItemTel);
            ciTV = itemView.findViewById(R.id.txtItemCi);

        }
    }

}
