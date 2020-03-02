package com.example.listviewbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonHoc;
    EditText edtMonHoc;
    Button btnNhap , btnUpdate;
    ArrayList<String> monHoc;
    int vitri=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMonHoc= findViewById(R.id.lvMonHoc);
        edtMonHoc = findViewById(R.id.edtMonHoc);
        btnNhap = findViewById(R.id.btnNhap);
        btnUpdate = findViewById(R.id.btnUpdate);
        monHoc = new ArrayList<>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,monHoc);
        lvMonHoc.setAdapter(adapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monhoc =edtMonHoc.getText().toString();
                monHoc.add(monhoc);
                adapter.notifyDataSetChanged();
                edtMonHoc.setText("");
            }
        });
//        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                monHoc.remove(position);
//                adapter.notifyDataSetChanged();
//            }
//        });
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtMonHoc.setText(monHoc.get(position));
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monHoc.set(vitri,edtMonHoc.getText().toString());
                adapter.notifyDataSetChanged();
                edtMonHoc.setText("");
            }
        });
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent a = new Intent(MainActivity.this,themDL.class);
                Bundle bd = new Bundle();
                bd.putString("DL",monHoc.get(position));
                a.putExtras(bd);
                startActivity(a);
                return false;
            }
        });

    }
}
