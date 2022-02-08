package com.example.l6_mynotes.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.l6_mynotes.domain.EmployeeEntity;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {
    List<EmployeeEntity> data = new ArrayList<>();
    private OnEmployeeListener onEmployeeListener;

    public void setOnClickListener(OnEmployeeListener onEmployeeListener) {
        this.onEmployeeListener = onEmployeeListener;
    }

    public void setData(List<EmployeeEntity> employeeList) {
        data = employeeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new EmployeeViewHolder(inflater, parent, onEmployeeListener);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    public EmployeeEntity getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
