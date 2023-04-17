package com.example.dietplanner.ui.loginregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dietplanner.R;
import com.example.dietplanner.databinding.ActivityRegisterBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://dietplanner-b6460-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick (View view) {
                String registerEmail =getString(binding.etRegisterEmail);

                String registerPassword = getString(binding.etRegisterPassword);
                String registerConfirmPassword = getString(binding.etRegisterConfirmPassword);
                String registerContact = getString(binding.etRegisterContact);

                Log.d("REGISTER_",registerEmail.toString()  );

                if(registerEmail.isEmpty() || registerPassword.isEmpty()|| registerContact.isEmpty()||registerConfirmPassword.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Enter All Details", Toast.LENGTH_SHORT).show();
                }else if(registerContact.length()<10){
                    Toast.makeText(RegisterActivity.this, "Contact must be 10 digit", Toast.LENGTH_SHORT).show();
                } else if (registerPassword.length()>8) {
                    Toast.makeText(RegisterActivity.this, "Password should be 8 character long", Toast.LENGTH_SHORT).show();
                    
                } else if(!registerPassword.equals(registerConfirmPassword)){
                    Toast.makeText(RegisterActivity.this, "Passwords are not matching", Toast.LENGTH_SHORT).show();
                }else{

                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange (@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(registerEmail)){
                                Toast.makeText(RegisterActivity.this, "Email have already registered", Toast.LENGTH_SHORT).show();
                            }else{
                                databaseReference.child("users").child(registerEmail).child("contact").setValue(registerContact);
                                databaseReference.child("users").child(registerEmail).child("password").setValue(registerPassword);
                                databaseReference.child("users").child(registerEmail).child("contact").setValue(registerContact);
                            }
                        }

                        @Override
                        public void onCancelled (@NonNull DatabaseError error) {
                            Toast.makeText(RegisterActivity.this, "Check the internet connection", Toast.LENGTH_SHORT).show();
                        }
                    });



                }
            }
        });

        binding.tvRegisterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

    }




    private String getString(EditText editText){
        return editText.getText().toString();
    }

    private Integer getInteger(EditText editText){
        return Integer.parseInt(editText.getText().toString().trim());
    }
}