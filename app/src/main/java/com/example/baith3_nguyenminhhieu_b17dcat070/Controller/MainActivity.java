package com.example.baith3_nguyenminhhieu_b17dcat070.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.baith3_nguyenminhhieu_b17dcat070.R;

public class MainActivity extends AppCompatActivity {
    TextView textViewHelloUser;
    Button btnTao,btnDS;
    EditText editTextUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mapping();
        this.getData();
        this.setListener();
    }

    private  void mapping() {
        textViewHelloUser = findViewById(R.id.textViewHelloUser);
        editTextUser = findViewById(R.id.editTextUser);
        btnTao = findViewById(R.id.btnTao);
        btnDS = findViewById(R.id.btnDS);
    }

    private void setListener() {
        SharedPreferences sharedPreferences = this.getSharedPreferences("userDATA",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        btnTao.setOnClickListener(v-> {
            editor.putString("SV", editTextUser.getText().toString());
            editor.commit();
            String SV = sharedPreferences.getString("SV", "");
            textViewHelloUser.setText("Xin Chao: " + SV);
        });

    }

    private void getData() {
        SharedPreferences sharedPreference = this.getSharedPreferences("userDATA", MODE_PRIVATE);
        String SV = sharedPreference.getString("SV", "");
        if (SV != "") {
            textViewHelloUser.setText("Xin Chao: " + SV);
        }
        else {
            textViewHelloUser.setText("Xin Chao"+"MSV");
        }
    }
}