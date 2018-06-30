package com.example.pengyuxiong.taxigo.Controller;

import com.example.pengyuxiong.taxigo.Model.User;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class User_Controller {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseFirestore mFireStore;
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
        datatosave.put("email", user.getEmail());
        datatosave.put("user_type", user.getUser_type());
        mFireStore.collection("User").add(datatosave);
    }
}

