package com.example.whatsyourgrade;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText name,score;
Button find,exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name_edit_text);
        score = (EditText) findViewById(R.id.score_edit_text);
        find = (Button) findViewById(R.id.find_button);
        exit = (Button) findViewById(R.id.exit_button);

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double score1 = Double.valueOf(score.getText().toString());
                String name1 = String.valueOf(name.getText().toString());

                /*if(name1.equals(" ")){
                    name.setError("ป้อนชื่อ");
                }else{

                }
                if(score.equals("")){
                    score.setError("ป้อนคะแนน");
                }*/

                String Grade = " ";
                if (score1 == 80 || score1 > 80){
                    Grade = "A";
                }else if(score1 == 70 && score1 < 80){
                    Grade = "B";
                }else if (score1 == 60 && score1 <70){
                    Grade = "C";
                }else if(score1 == 50 && score1< 60){
                    Grade = "D";
                }else if(score1 <50){
                    Grade = "F";
                }
                Intent New = new Intent(MainActivity.this,Main2Activity.class);
                New.putExtra("Name",name1);
                New.putExtra("GradeText",Grade);
                startActivity(New);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Confirm exit?\nแน่ใจว่าต้องการออกจากแอพ?");
                dialog.setPositiveButton("ออก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                     finish();
                    }
                });
                dialog.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
               dialog.show();
            }
        });
    }
}
