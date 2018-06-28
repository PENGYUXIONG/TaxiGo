package com.example.pengyuxiong.taxigo.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pengyuxiong.taxigo.R;

public class Log_In_Activity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login_button;
    private Button signup_button;

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

        /**
         * If user press login button
         */

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = username.getText().toString();
                String Password = password.getText().toString();

                /**
                 * todo: need to have controller to retrive the information from the server
                 *
                 * Pengyu Xiong
                 */
            }
        });

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
    }


}
