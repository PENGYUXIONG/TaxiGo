package com.example.pengyuxiong.taxigo.Controller;

import android.support.annotation.NonNull;
import android.util.ArrayMap;
import android.util.Log;

import com.example.pengyuxiong.taxigo.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class User_Controller {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseFirestore mFireStore;

    private int Phone;
    private String Email = null;
    private String UserName;
    private String PassWord;
    private String Address;
    private String User_Type;
    private String User_ID;



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

    /**
     * read driver data
     * @param Username
     * @param Password
     * @return
     */
    public User readDriver(String Username, String Password) {

        Query query = db.collection("Driver").
                whereEqualTo("Username", Username).whereEqualTo("Password", Password);
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                Map<String, Object> user = null;

                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d("Wrong Data", document.getId() + " => " + document.getData());
                        user = document.getData();
                    }
                    if (user != null) {
                        Log.d("Wrong data", "refreshing data from controller");
                        User_Type = String.valueOf(user.get("User_type"));
                        Email = String.valueOf(user.get("Email"));
                        Address = String.valueOf(user.get("Address"));
                        Phone = Integer.parseInt(String.valueOf(user.get("Phone_num")));
                        UserName = String.valueOf(user.get("Username"));
                        User_ID = String.valueOf(user.get("User_ID"));
                        PassWord = String.valueOf(user.get("Password"));
                    }
                } else {
                    Log.d("Wrong data", "Error getting documents: ", task.getException());
                }
            }
        });
            if (Email != null) {
                Log.d("Wrong data", "user data from controller");
                User user1 = new User(User_ID, PassWord, UserName, Address, Phone, Email, User_Type);
                Email = null;
                return user1;
            }

            Log.d("Wrong data", "null data from controller");
            return null;
    }

    /**
     * read Passenger data
     * @param Username
     * @param Password
     * @return
     */
    public User readPassenger(final String Username, final String Password) {


        Query query = db.collection("Passenger").
                whereEqualTo("Username", Username).whereEqualTo("Password", Password);
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                Map<String, Object> user = null;

                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d("Wrong Data", document.getId() + " => " + document.getData());
                        user = document.getData();
                    }
                    if (user != null) {
                        User_Type = String.valueOf(user.get("User_type"));
                        Email = String.valueOf(user.get("Email"));
                        Address = String.valueOf(user.get("Address"));
                        Phone = Integer.parseInt(String.valueOf(user.get("Phone_num")));
                        UserName = String.valueOf(user.get("Username"));
                        User_ID = String.valueOf(user.get("User_ID"));
                        PassWord = String.valueOf(user.get("Password"));
                    }
                } else {
                    Log.d("Wrong data", "Error getting documents: ", task.getException());
                }
            }
        });
        if (Email != null) {
            User user1 = new User(User_ID, PassWord, UserName, Address, Phone, Email, User_Type);
            return user1;
        }
        return null;
    }
}

