package com.example.l6_mynotes.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.l6_mynotes.App;
import com.example.l6_mynotes.R;
import com.example.l6_mynotes.domain.EmployeeEntity;
import com.example.l6_mynotes.domain.EmployeeRepository;

public class MainActivity extends AppCompatActivity implements OnEmployeeListener {
    private static final int EMPLOYEE_REQUEST_CODE = 999;
    private EmployeeRepository employeeRepository;
    private EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employeeRepository = App.get(this).getEmployeeRepository();
        initRecycler();
    }

    private void initRecycler() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new EmployeeAdapter();
        adapter.setData(employeeRepository.getEmployees());
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDeleteEmployee(EmployeeEntity employeeEntity) {
        employeeRepository.deleteEmployees(employeeEntity);
        adapter.setData(employeeRepository.getEmployees());
    }

    public void onClickEmployee(EmployeeEntity employeeEntity) {
       Intent intent = new Intent(this, EmployeeActivity.class);
       intent.putExtra(EmployeeActivity.EMPLOYEE_EXTRA_KEY, employeeEntity);
       startActivityForResult(intent, EMPLOYEE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EMPLOYEE_REQUEST_CODE && resultCode == RESULT_OK){
            adapter.setData(employeeRepository.getEmployees());
        }

    }
}