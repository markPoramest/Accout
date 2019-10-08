package com.example.accout.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Expenditure")
public class Expenditure {
        @PrimaryKey(autoGenerate = true)
        public  int id;

        @ColumnInfo(name = "name")
        public String name;

        @ColumnInfo(name = "money")
        public int money;

        @ColumnInfo(name = "img")
        public int img;

        public Expenditure(int id,String name, int money , int img) {
            this.id = id;
            this.name = name;
            this.money = money;
            this.img = img;
        }
}

