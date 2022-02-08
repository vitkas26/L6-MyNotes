package com.example.l6_mynotes.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.l6_mynotes.App;
import com.example.l6_mynotes.R;
import com.example.l6_mynotes.domain.EmployeeEntity;
import com.example.l6_mynotes.utils.ContextUtils;

public class EmployeeActivity extends AppCompatActivity {
    public static final String EMPLOYEE_EXTRA_KEY = "EMPLOYEE_EXTRA_KEY";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        TextView nameTextView = findViewById(R.id.name_text_view);
        Button deleteButton = findViewById(R.id.delete_button);

        EmployeeEntity employeeEntity = getIntent().getParcelableExtra("EMPLOYEE_EXTRA_KEY");
        nameTextView.setText(employeeEntity.getName());
        deleteButton.setOnClickListener(v->{
            App.get(this).getEmployeeRepository().deleteEmployees(employeeEntity);
            setResult(RESULT_OK);
            finish();
        });
    }
}
