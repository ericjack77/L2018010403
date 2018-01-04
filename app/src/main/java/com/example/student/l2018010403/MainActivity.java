package com.example.student.l2018010403;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> str;
    Spinner sp,sp2;
    TextView tv,tv2,tv3;
    EditText et;
    ArrayAdapter<String> adapter;
    String city[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView);
        tv2=findViewById(R.id.textView2);
        tv3=findViewById(R.id.textView3);
        et=findViewById(R.id.editText);
        str = new ArrayList<String>();
        city=getResources().getStringArray(R.array.Cities);
        str.add("AA11");
        str.add("BB22");
        str.add("CC33");
        sp = findViewById(R.id.spinner);
        sp2 =findViewById(R.id.spinner2);


        adapter=new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1,str);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv.setText(str.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv3.setText(city[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void click1(View v)
    {
        int pos=sp.getSelectedItemPosition();
        tv2.setText(str.get(pos));
        adapter.notifyDataSetChanged();
    }

    public void click2(View v)
    {

        str.add(et.getText().toString());
        adapter.notifyDataSetChanged();
    }

    public  void click3(View v)
    {



        str.remove(sp.getSelectedItemPosition());
        adapter.notifyDataSetChanged();//告知adapter已經更新



    }


}
