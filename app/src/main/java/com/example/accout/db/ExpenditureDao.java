package com.example.accout.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.accout.Model.Expenditure;

import java.util.List;
@Dao
public interface ExpenditureDao {
    @Query("Select * from  expenditure")
    List<Expenditure> getAllExpenditure();

    @Insert
    void insert_Expenditure(Expenditure expenditure);

    @Query("Select sum(money) from  expenditure")
    int getSumMoney();
}
