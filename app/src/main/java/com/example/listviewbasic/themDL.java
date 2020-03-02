package com.example.listviewbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class themDL extends AppCompatActivity {
    TextView txtDL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_dl);
        txtDL = findViewById(R.id.txtDL);

         Bundle bd = getIntent().getExtras();
         if(bd!=null){
             txtDL.setText(bd.getString("DL","Sai key"));
         }
    }
}
