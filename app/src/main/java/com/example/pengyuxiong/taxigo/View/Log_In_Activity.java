package com.example.pengyuxiong.taxigo.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pengyuxiong.taxigo.Controller.User_Controller;
import com.example.pengyuxiong.taxigo.Model.User;
import com.example.pengyuxiong.taxigo.R;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import javax.annotation.Nullable;

public class Log_In_Activity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseFirestore mFireStore;

    private static final String REQUIRED = "Required";

    private EditText username;
    private EditText password;
    private Button login_button;
    private Button signup_button;
    private CheckBox driver_button;
    private CheckBox passenger_button;


    @Override
    protected void onStart() {
        // clear inf view
        username.setText("");
        password.setText("");
        driver_button.setChecked(false);
        passenger_button.setChecked(false);

        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        /**
         *  claim variables for edit_texts and buttons
         */
        username = (EditText) findViewById(R.id.Username);
        password = (EditText) findViewById(R.id.PassWord);
        login_button = (Button) findViewById(R.id.Login_button);
        signup_button = (Button) findViewById(R.id.Signup_button);

        driver_button = (CheckBox) findViewById(R.id.Driver_button);
        passenger_button = (CheckBox) findViewById(R.id.Passenger_button);


        final User_Controller user_controller = new User_Controller();

        /**
         * if user press signup_button
         */
        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Log_In_Activity.this,
                        Sign_Up_Activity.class);
                Log_In_Activity.this.startActivityForResult(intent, Sign_Up_Activity.request);
            }
        });


        /**
         *  if selected driver
         */
        driver_button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (driver_button.isChecked()) {
                    passenger_button.setChecked(false);
                }
            }
        });

        /**
         * if select passenger option
         */
        passenger_button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (passenger_button.isChecked()){
                    driver_button.setChecked(false);
                }
            }
        });


        /**
         * If user press login button
         */

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if user name is empty
                if(TextUtils.isEmpty(username.getText().toString())){
                    username.setError(REQUIRED);
                    Toast.makeText(Log_In_Activity.this, "Username is required",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                // if password is empty
                if(TextUtils.isEmpty(password.getText().toString())){
                    password.setError(REQUIRED);
                    Toast.makeText(Log_In_Activity.this, "Password is required",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                // if account type is not selected
                if(driver_button.isChecked() == false & passenger_button.isChecked()==false){
                    Toast.makeText(Log_In_Activity.this, "Please select the type " +
                            "of your account", Toast.LENGTH_LONG).show();
                    return;
                }

                final String Username = username.getText().toString();
                final String Password = password.getText().toString();
                String User_type;

                if (driver_button.isChecked()) {
                    User_type = "D";
                }
                else{
                    User_type = "P";
                }

                // if driver
                if (User_type == "D"){
                        Query query = db.collection("Driver").whereEqualTo("Username", Username).
                                whereEqualTo("Password", Password);
                        query.addSnapshotListener(new EventListener<QuerySnapshot>() {
                            @Override
                            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable
                                    FirebaseFirestoreException e) {
                                boolean check = true;
                                for(DocumentSnapshot doc: queryDocumentSnapshots){
                                    check = false;
                                    Log.d("Wrong data", doc.getString("Username"));
                                    user_controller.User_username = doc.getString("Username");
                                    Intent intent = new Intent(Log_In_Activity.this,
                                            Driver_Main_Activity.class);
                                    Log_In_Activity.this.startActivityForResult
                                            (intent, Driver_Main_Activity.confirm);
                                }
                                if (check){
                                    Toast.makeText(Log_In_Activity.this,
                                            "User not exist", Toast.LENGTH_LONG).show();
                                }
                            }

                        });
                    }

                // if passenger
                if (User_type == "P"){
                    Query query = db.collection("Passenger").whereEqualTo("Username", Username).
                            whereEqualTo("Password", Password);
                    query.addSnapshotListener(new EventListener<QuerySnapshot>() {
                        @Override
                        public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable
                                FirebaseFirestoreException e) {
                            boolean check = true;
                            for(DocumentSnapshot doc: queryDocumentSnapshots){
                                check = false;
                                Log.d("Wrong data", doc.getString("Username"));
                                user_controller.User_username = doc.getString("Username");
                                Intent intent = new Intent(Log_In_Activity.this,
                                        Passenger_Main_Activity.class);
                                Log_In_Activity.this.startActivityForResult(intent, Passenger_Main_Activity.Confirm);
                            }
                            if (check) {
                                Toast.makeText(Log_In_Activity.this,
                                        "User not exist", Toast.LENGTH_LONG).show();
                            }
                        }

                    });
                }

                /**
                 * todo: need to have controller to retrive the information from the server
                 *
                 * Pengyu Xiong
                 */
            }
        });
    }
}
