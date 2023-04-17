package com.example.dietplanner.ui.loginregister;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dietplanner.MainActivity;
import com.example.dietplanner.UserInfoActivity;
import com.example.dietplanner.databinding.ActivityLoginBinding;
import com.example.dietplanner.ui.onboarding.NameFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class LoginActivity extends AppCompatActivity {
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://dietplanner-b6460-default-rtdb.firebaseio.com/");
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        
        
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                String loginEmail = getEmail(binding.etLoginEmail);
                String loginPassword = getPassword(binding.etLoginPassword);
                
                if(loginPassword.isEmpty()|| loginEmail.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Email or Password can not be empty", Toast.LENGTH_SHORT).show();
                }else {
                   databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                       @Override
                       public void onDataChange (@NonNull DataSnapshot snapshot) {
                           if(snapshot.hasChild(loginEmail)){
                               String getPassword = snapshot.child(loginEmail).child("password").getValue(String.class);

                            if(getPassword.equals(loginPassword)){
                                startActivity(new Intent(LoginActivity.this, UserInfoActivity.class));
                            }else {
                                Toast.makeText(LoginActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                            }
                               
                           }else {
                               Toast.makeText(LoginActivity.this, "Enter registered email", Toast.LENGTH_SHORT).show();
                           }
                       }

                       @Override
                       public void onCancelled (@NonNull DatabaseError error) {

                       }
                   });
                }
            }   
        });

        binding.tvLoginNewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                startActivity(new Intent(LoginActivity.this ,RegisterActivity.class));
            }
        });
        
        
    
    
    }
    
    
    private String getEmail(EditText etEmail){
        return etEmail.getText().toString().trim();
    }

    private String getPassword(EditText etPassword){
        return etPassword.getText().toString().trim();
    }
}