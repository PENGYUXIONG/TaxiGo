package com.example.pengyuxiong.taxigo.View;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.pengyuxiong.taxigo.Model.User;
import com.example.pengyuxiong.taxigo.R;
import com.example.pengyuxiong.taxigo.Controller.User_Controller;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.UUID;

import javax.annotation.Nullable;

import static java.util.UUID.randomUUID;

public class Sign_Up_Activity extends AppCompatActivity {

    public static final int request = 0;
    private static final String REQUIRED = "Required";

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private User_Controller user_controller;

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
        password = (EditText) findViewById(R.id.Password);
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

                // if phone number is empty
                if(TextUtils.isEmpty(phone.getText().toString())){
                    phone.setError(REQUIRED);
                    Toast.makeText(Sign_Up_Activity.this, "Phone number is required",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                // if email is empty
                if(TextUtils.isEmpty(email.getText().toString())){
                    email.setError(REQUIRED);
                    Toast.makeText(Sign_Up_Activity.this, "Email is required",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                // if user name is empty
                if(TextUtils.isEmpty(username.getText().toString())){
                    username.setError(REQUIRED);
                    Toast.makeText(Sign_Up_Activity.this, "Username is required",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                // if password is empty
                if(TextUtils.isEmpty(password.getText().toString())){
                    password.setError(REQUIRED);
                    Toast.makeText(Sign_Up_Activity.this, "Password is required",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                // if address is empty
                if(TextUtils.isEmpty(address.getText().toString())){
                    address.setError(REQUIRED);
                    Toast.makeText(Sign_Up_Activity.this, "Address is required",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                // if account type is not selected
                if(driver.isChecked() == false & passenger.isChecked()==false){
                    Toast.makeText(Sign_Up_Activity.this, "Please select the type " +
                                    "of your account", Toast.LENGTH_LONG).show();
                    return;
                }

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
                user_controller = new User_Controller();

                // if driver
                if(User_Type == "D") {
                    db.collection("Driver").
                            document(Username).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.getResult().exists() == false) {
                                user_controller.writeNewUser(User_ID, Password, Username, Address, Phone, Email, User_Type);
                                finish();
                            } else {
                                Toast.makeText(Sign_Up_Activity.this, "User alreay exist", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }

                // if passenger
                else {
                    db.collection("Passenger").
                            document(Username).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.getResult().exists() == false) {
                                user_controller.writeNewUser(User_ID, Password, Username, Address, Phone, Email, User_Type);
                                finish();
                            } else {
                                Toast.makeText(Sign_Up_Activity.this, "User alreay exist", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
    }

}
