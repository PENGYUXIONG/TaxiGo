package com.example.pengyuxiong.taxigo.Controller;

import android.support.annotation.NonNull;
import android.util.ArrayMap;
import android.util.Log;
import android.widget.Toast;

import com.example.pengyuxiong.taxigo.Model.User;
import com.example.pengyuxiong.taxigo.View.Log_In_Activity;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;


public class User_Controller {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseFirestore mFireStore;

    public String User_username;
    public String User_password;
    public String User_email;
    public int User_phone;
    public String User_address;
    public String User_userid;
    public String User_usertype;



    /**
     * write initial user into firebase database
     * @param User_ID
     * @param Password
     * @param Username
     * @param Address
     * @param Phone
     * @param Email
     * @param User_Type
     */
    public void writeNewUser(String User_ID, String Password, String Username, String Address,
                             int Phone,String Email, String User_Type){
        User user = new User(User_ID, Password, Username, Address, Phone, Email, User_Type);

        mFireStore = FirebaseFirestore.getInstance();
        Map<String, Object> datatosave = new HashMap<String, Object>();
        datatosave.put("User_ID", user.getUser_id());
        datatosave.put("Username", user.getName());
        datatosave.put("Password", user.getPassword());
        datatosave.put("Address", user.getPrimary_address());
        datatosave.put("Phone_num", user.getTelephone_num());
        datatosave.put("Email", user.getEmail());
        datatosave.put("User_type", user.getUser_type());

        // save driver inf
        if (user.getUser_type() == "D") {
            mFireStore.collection("Driver").document(user.getName()).set(datatosave);
        }

        // save passenger inf
        if (user.getUser_type() == "P"){
            mFireStore.collection("Passenger").document(user.getName()).set(datatosave);
        }
    }

}

