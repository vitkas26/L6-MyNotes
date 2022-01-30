package com.example.l6_mynotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {
    private final ArrayList<EmployeeEntity> employeeList = new ArrayList<>();
    private LinearLayout listLinearlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLinearlayout = findViewById(R.id.linear_layout_list);
        employeeList.addAll(ListViewUtils.createEmployees());

        refreshList();
    }

    private void refreshList() {
        listLinearlayout.removeAllViews();
        Button refreshButton = getButton(this, v -> refreshList());
        listLinearlayout.addView(refreshButton);

        for (EmployeeEntity employeeItem : employeeList) {
            View employeeItemView = ListViewUtils.createItemView(getLayoutInflater(), listLinearlayout, employeeItem, v -> {
                int deletePosition = getPosByItem(employeeList,employeeItem);
                listLinearlayout.removeViewAt(deletePosition + 1);
                employeeList.remove(deletePosition);
            });
            listLinearlayout.addView(employeeItemView);
        }
    }

    @NonNull
    private Button getButton(Context context, View.OnClickListener onClickListener) {
        Button clearButton = new Button(context);
        clearButton.setText(R.string.refresh_button_name);
        clearButton.setOnClickListener(onClickListener);
        return clearButton;
    }

    private static int getPosByItem(ArrayList<EmployeeEntity> employeeList, EmployeeEntity employeeItem) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeItem.getId().equals(employeeList.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }


}