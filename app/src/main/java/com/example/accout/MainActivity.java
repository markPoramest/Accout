package com.example.accout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.accout.Adapter.RecyclerAdapter;
import com.example.accout.Model.Expenditure;
import com.example.accout.db.AppDB;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Expenditure> listPlace = new ArrayList<Expenditure>();
    private RecyclerAdapter mAdapter;
    private AppDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = AppDB.getInstance(MainActivity.this);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Refresh();


            }
        });
        t1.start();

        Button addPlace = findViewById(R.id.addExpenditure);
        addPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ListName = findViewById(R.id.List_name);
                EditText moneyName = findViewById(R.id.money);
                final TextView Sum = findViewById(R.id.sum);

                String name = ListName.getText().toString();
                String Smoney = moneyName.getText().toString();
                int money = Integer.parseInt(Smoney);


                final Expenditure expenditure = new Expenditure(0,name,money,R.drawable.moneyicon);
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        db.expenditureDao().insert_Expenditure(expenditure);
                        final int sum = db.expenditureDao().getSumMoney();
                        Refresh();

                    }
                });
                t.start();

            }
        });

    }
    private void Refresh() {
        listPlace = db.expenditureDao().getAllExpenditure();
        final RecyclerView ExpenditureList = findViewById(R.id.expenditure_list_view);
        mAdapter = new RecyclerAdapter(MainActivity.this, R.layout.item_list, listPlace);
        final LinearLayoutManager ln = new LinearLayoutManager(MainActivity.this);
        final int sum = db.expenditureDao().getSumMoney();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ExpenditureList.setLayoutManager(ln);
                ExpenditureList.setAdapter(mAdapter);
                final TextView Sum = findViewById(R.id.sum);
                Sum.setText(sum+" บาท");
            }
        });
    }

}
