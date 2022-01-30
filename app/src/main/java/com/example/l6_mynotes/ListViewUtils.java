package com.example.l6_mynotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewUtils {
    static View createItemView(LayoutInflater inflater, ViewGroup layout, EmployeeEntity employeeItem, View.OnClickListener onClickListener) {
        final View employeeItemView = inflater.inflate(R.layout.item_employee, layout, false);

        final TextView nameTextView = employeeItemView.findViewById(R.id.name_text_view);
        final TextView surnameTextView = employeeItemView.findViewById(R.id.surname_text_view);
        final TextView positionTextView = employeeItemView.findViewById(R.id.position_text_view);
        final Button deleteButton = employeeItemView.findViewById(R.id.delete_button);

        nameTextView.setText(employeeItem.getName());
        surnameTextView.setText(employeeItem.getSurname());
        positionTextView.setText(employeeItem.getPosition());

        deleteButton.setOnClickListener(onClickListener);
        return employeeItemView;
    }

    static ArrayList<EmployeeEntity> createEmployees() {
        final ArrayList<EmployeeEntity> employeeEntities = new ArrayList<>();
        employeeEntities.add(new EmployeeEntity(
                "1",
                "Дмитрий",
                "Барабанов",
                "+7708998855",
                50_000,
                "Музыкант"));
        employeeEntities.add(new EmployeeEntity(
                "2",
                "Евгений",
                "Будкин",
                "+7704550055",
                60_000,
                "Кабельщик"));
        employeeEntities.add(new EmployeeEntity(
                "3",
                "Ольга",
                "Неразберихина",
                "+7505859987",
                80_000,
                "Бухгалтер"));
        employeeEntities.add(new EmployeeEntity(
                "4",
                "Диана",
                "Плюшкина",
                "+77894562311",
                100_000,
                "Менеджер"));
        employeeEntities.add(new EmployeeEntity(
                "5",
                "Аркадий",
                "Овечкин",
                "+85554477888",
                40_000,
                "Вахтер"));
        return employeeEntities;
    }
}
