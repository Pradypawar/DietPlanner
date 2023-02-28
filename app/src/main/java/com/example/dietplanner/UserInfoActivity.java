package com.example.dietplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;

import com.example.dietplanner.databinding.ActivityUserInfoBinding;
import com.example.dietplanner.models.UserInfoModel;
import com.example.dietplanner.utils.InputValidator;
import com.google.android.material.button.MaterialButton;

public class UserInfoActivity extends AppCompatActivity {

    private ActivityUserInfoBinding binding;
    private UserInfoModel user;
    private InputValidator inputValidator;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserInfoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {

//               user = new UserInfoModel();
//               user.setWeightInKg(Double.parseDouble(binding.editTextWeight.getText().toString()));
//               user.setHeightInFt(Double.parseDouble(binding.editTextHeight.getText().toString()));
//               user.setAge(Integer.parseInt(binding.editTextAge.getText().toString()));
//               user.setGender(binding.userGender.getText().toString());
//               user.setActivityLevel(binding.editTextLifestyle.getText().toString());

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                //intent.putExtra("userInfo",user);
                startActivity(intent);


            }
        });


    }



}