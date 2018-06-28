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

import java.util.UUID;

import static java.util.UUID.randomUUID;

public class Sign_Up_Activity extends AppCompatActivity {

    public static final int request = 0;

    private EditText phone;
    private EditText email;
    private EditText username;
    private EditText password;
    private EditText address;
    private ImageButton Addimage;
    private Button done;
    private CheckBox driver;
    private CheckBox passenger;

    private int Phone;
    private String Email;
    private String Username;
    private String Password;
    private String Address;
    private String User_Type;
    private String User_ID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up_);

        phone = (EditText) findViewById(R.id.Phone);
        email = (EditText) findViewById(R.id.Email);
        username = (EditText) findViewById(R.id.Username);
        password = (EditText) findViewById(R.id.PassWord);
        address = (EditText) findViewById(R.id.Address);
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
                /**
                 * todo: need constrains for all the informations
                 *
                 * designed to have a checking block in model when the controller passing
                 * data into the model code, the model will check the validate of the data.
                 *
                 * before the controller being built, avoid sketchy testing data for the signup UI.
                 *
                 * Pengyu Xiong
                 */

                Phone = Integer.parseInt(phone.getText().toString());
                Email = email.getText().toString();
                Username = username.getText().toString();
                Password = password.getText().toString();
                Address = address.getText().toString();
                User_ID = UUID.randomUUID().toString();

                if (driver.isChecked()) {
                    User_Type = "D";
                }
                else{
                    User_Type = "P";
                }
                finish();
            }
        });
    }
}
