package com.example.l6_mynotes.ui;

import com.example.l6_mynotes.domain.EmployeeEntity;

interface OnEmployeeListener {

    void onDeleteEmployee(EmployeeEntity employeeEntity);

    void onClickEmployee(EmployeeEntity employeeEntity);
}