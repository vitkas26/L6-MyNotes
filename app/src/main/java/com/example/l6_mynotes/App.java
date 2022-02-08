package com.example.l6_mynotes;

import android.app.Application;
import android.content.Context;

import com.example.l6_mynotes.data.CacheEmployeeRepositoryImpl;
import com.example.l6_mynotes.domain.EmployeeRepository;

public class App extends Application {
    private final EmployeeRepository employeeRepository = new CacheEmployeeRepositoryImpl();
    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }
}
