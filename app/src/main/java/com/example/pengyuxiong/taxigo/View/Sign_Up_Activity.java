package com.example.pengyuxiong.taxigo.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.pengyuxiong.taxigo.R;

public class Sign_Up_Activity extends AppCompatActivity {

    public static final int request = 0;

    private EditText phone;
    private EditText email;
    private EditText username;
    private EditText password;
    private ImageButton Addimage;
    private Button done;
    private CheckBox driver;
    private CheckBox passenger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up_);

        phone = (EditText) findViewById(R.id.Phone);
        email = (EditText) findViewById(R.id.Email);
        username = (EditText) findViewById(R.id.Username);
        password = (EditText) findViewById(R.id.PassWord);
        done = (Button) findViewById(R.id.Done);
        driver = (CheckBox) findViewById(R.id.checkBox);
        passenger = (CheckBox) findViewById(R.id.checkBox2);


        /**
         *  if selected driver
         */
        driver.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (driver.isChecked()) {
                    passenger.setChecked(false);
                }
            }
        });

        /**
         * if select passenger option
         */
        passenger.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (passenger.isChecked()){
                    driver.setChecked(false);
                }
            }
        });

        /**
         * if finished sign up
         */
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Phone = Integer.parseInt(phone.getText().toString());
                String Email = email.getText().toString();

                finish();
            }
        });
    }
}
