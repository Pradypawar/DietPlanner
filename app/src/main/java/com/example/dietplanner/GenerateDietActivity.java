package com.example.dietplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dietplanner.databinding.ActivityGenerateDietBinding;
import com.example.dietplanner.models.UserInfoModel;

public class GenerateDietActivity extends AppCompatActivity {

    private UserInfoModel user;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.dietplanner.databinding.ActivityGenerateDietBinding binding = ActivityGenerateDietBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);



        Intent intent = getIntent();
        UserInfoModel user = (UserInfoModel)intent.getSerializableExtra("userInfo");

        binding.generateCalories.setText(String.valueOf(user.getMaintainCalories()));

        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("userInfo",user);
                startActivity(intent);
            }
        });


    }
}