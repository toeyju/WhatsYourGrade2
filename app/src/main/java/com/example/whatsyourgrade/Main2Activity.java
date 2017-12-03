package com.example.whatsyourgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView name;
TextView grade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = (TextView) findViewById(R.id.n_text);
        grade = (TextView) findViewById(R.id.s_text);

        Intent Page = getIntent();
        String name1 = Page.getStringExtra("Name");
        String grade1 = Page.getStringExtra("GradeText");

        name.setText(name1);
        grade.setText(grade1);
    }
}
