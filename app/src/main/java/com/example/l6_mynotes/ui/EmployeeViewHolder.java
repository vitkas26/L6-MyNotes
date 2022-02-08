package com.example.l6_mynotes.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.l6_mynotes.domain.EmployeeEntity;
import com.example.l6_mynotes.R;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    private final TextView nameTextView = itemView.findViewById(R.id.name_text_view);
    private final TextView surnameTextView = itemView.findViewById(R.id.surname_text_view);
    private final TextView positionTextView = itemView.findViewById(R.id.position_text_view);
    private final Button deleteButton = itemView.findViewById(R.id.delete_button);
    OnEmployeeListener onEmployeeListener;

    public EmployeeViewHolder(LayoutInflater inflater, @NonNull ViewGroup parent, OnEmployeeListener onEmployeeListener) {
        super(inflater.inflate(R.layout.item_employee, parent, false));
        this.onEmployeeListener = onEmployeeListener;
    }

    public void bind(EmployeeEntity item) {
        deleteButton.setOnClickListener(v -> onEmployeeListener.onDeleteEmployee(item));
        itemView.setOnClickListener(v -> onEmployeeListener.onClickEmployee(item));
        nameTextView.setText(item.getName());
        surnameTextView.setText(item.getSurname());
        positionTextView.setText(item.getPosition());
    }
}