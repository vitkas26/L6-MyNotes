package com.example.l6_mynotes.data;

import androidx.annotation.NonNull;

import com.example.l6_mynotes.domain.EmployeeEntity;
import com.example.l6_mynotes.domain.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class CacheEmployeeRepositoryImpl implements EmployeeRepository {
    private ArrayList<EmployeeEntity> cache = new ArrayList<>();

    public CacheEmployeeRepositoryImpl(){
        cache.addAll(createEmployees());
    }

    @Override
    public List<EmployeeEntity> getEmployees() {
        return cache;
    }

    @Override
    public void deleteEmployees(EmployeeEntity employeeEntity) {
        try{
            cache.remove(getPosByItem(employeeEntity));
        } catch (IllegalArgumentException iae){
            iae.printStackTrace();
        }
    }

    @NonNull
    private static List<EmployeeEntity> createEmployees() {
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

    private int getPosByItem(EmployeeEntity employeeItem) {
        for (int i = 0; i < cache.size(); i++) {
            if (employeeItem.getId().equals(cache.get(i).getId())) {
                return i;
            }
        }
        throw new IllegalArgumentException("Not existing parameter");
    }
}
