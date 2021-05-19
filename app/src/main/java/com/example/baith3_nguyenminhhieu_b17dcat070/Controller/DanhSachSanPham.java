package com.example.baith3_nguyenminhhieu_b17dcat070.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.baith3_nguyenminhhieu_b17dcat070.Database.SQLiteHelper;
import com.example.baith3_nguyenminhhieu_b17dcat070.Model.Item;
import com.example.baith3_nguyenminhhieu_b17dcat070.R;

import java.util.ArrayList;
import java.util.List;

public class DanhSachSanPham extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner listFilter;
    private TextView nameTextView;
    private RecyclerView listProduct;
    private Button addNewBtn;
    SharedPreferences userInfo;

    List<Item> listItem;
    SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_san_pham);

        listFilter = (Spinner) findViewById(R.id.list_filter);
        nameTextView = (TextView) findViewById(R.id.name_text_view);
        listProduct = (RecyclerView) findViewById(R.id.list_product);
        addNewBtn = (Button) findViewById(R.id.add_new_btn);

        userInfo = getSharedPreferences("userDATA", MODE_PRIVATE);

        getUserName();
        addItemOnSpinner();

        addNewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanhSachSanPham.this, ThemSanPham.class);
                startActivity(intent);
            }
        });

        sqLiteHelper = new SQLiteHelper(getBaseContext());
        listItem = sqLiteHelper.getAllItems();

        Item item = (Item) listItem.get(0);
        System.out.println(item.toString());
    }

    private void getUserName() {
        String name = userInfo.getString("name", null);
        nameTextView.setText("Xin Chao: " + name);
    }

    private void addItemOnSpinner() {
        List<String> list = new ArrayList<>();
        list.add("Tat Ca");
        list.add("Dien Thoai");
        list.add("May Tinh");
        list.add("Phu Kien");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list);
        listFilter.setAdapter(dataAdapter);
        listFilter.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                System.out.println("Tat ca");
                break;
            case 1:
                System.out.println("Dien thoai");
                break;
            case 2:
                System.out.println("May tinh");
                break;
            case 3:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}