package com.example.dietplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.dietplanner.databinding.ActivityUserInfoBinding;
import com.example.dietplanner.models.UserInfoModel;
import com.example.dietplanner.utils.Convertors;
import com.example.dietplanner.utils.InputValidator;
import com.google.android.material.button.MaterialButton;

public class UserInfoActivity extends AppCompatActivity {

    private ActivityUserInfoBinding binding;
    private UserInfoModel user;
    private InputValidator inputValidator;
    private int caloriesToMaintain;
    private int activityLevel;
    private String gender;

    ArrayAdapter<String> genderAdapter;

    String[] genderList = {"Male","Female"};




    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserInfoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        genderAdapter = new ArrayAdapter<>(this,R.layout.option_row,genderList);
        binding.etGenderAutoComplete.setAdapter(genderAdapter);

        binding.etGenderAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> adapterView, View view, int i, long l) {
                String selectedGender = adapterView.getItemAtPosition(i).toString();

                if(selectedGender.equals("Male")){
                    gender="Male";
                }else
                    gender="Female";
            }
        });


        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged (RadioGroup radioGroup, int i) {

                switch (i){
                    case R.id.rb_sedentary:
                        activityLevel=1;
                        break;
                    case R.id.rb_little_active:
                        activityLevel=2;
                        break;
                    case R.id.rb_moderateley_active:
                        activityLevel=3;
                        break;
                    case R.id.rb_very_active:
                        activityLevel=4;
                        break;
                    case R.id.rb_extra_active:
                        activityLevel=5;
                        break;

                }
                RadioButton radioButton = radioGroup.findViewById(i);
            }
        });
        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {

                int selectedId = binding.radioGroup.getCheckedRadioButtonId();
                if (selectedId==-1) {
                    Toast.makeText(UserInfoActivity.this, "Select Activity Level", Toast.LENGTH_SHORT).show();
                    return;
                }

                user = new UserInfoModel();
                setUser(user,binding);
               caloriesToMaintain = Convertors.caloriesToMaintain(user);
               user.setCaloriesToMaintain(caloriesToMaintain);
                //Toast.makeText(UserInfoActivity.this, " "+ user.getCaloriesToMaintain(), Toast.LENGTH_SHORT).show();
               // Toast.makeText(UserInfoActivity.this, Convertors.caloriesToMaintain(user).toString() +" "+user.getGender(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),GenerateDietActivity.class);
                intent.putExtra("userInfo",user);
                startActivity(intent);


            }
        });



    }

    @Override
    protected void onResume () {
        super.onResume();
        genderAdapter = new ArrayAdapter<>(this,R.layout.option_row,genderList);
        binding.etGenderAutoComplete.setAdapter(genderAdapter);
    }

    public void setUser(UserInfoModel user, ActivityUserInfoBinding binding){
        user.setWeightInKg(Double.parseDouble(binding.etWeightKG.getText().toString()));
        user.setHeightInFt(Double.parseDouble(binding.etHeightCM.getText().toString()));
        user.setAge(Integer.parseInt(binding.etAge.getText().toString()));
        user.setGender(gender);
        user.setActivityLevel(activityLevel);
    }





}