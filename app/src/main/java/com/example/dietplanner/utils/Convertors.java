package com.example.dietplanner.utils;

import com.example.dietplanner.models.UserInfoModel;

public class Convertors {
     private static final Float ACTIVITY_LEVEL_SEDENTARY=1.2F;
     private static final Float ACTIVITY_LEVEL_LITTLE=1.375F;
     private static final Float ACTIVITY_LEVEL_MODERATE=1.55F;
     private static final Float ACTIVITY_LEVEL_HARD=1.725F;
     private static final Float ACTIVITY_LEVEL_VERY_HARD=1.9F;


     public static Integer BMR(UserInfoModel userInfoModel){
          //weight in KG
          // height in CM
          if (userInfoModel.getGender().equals("Male")){
               return Math.toIntExact(Math.round(10 * userInfoModel.getWeightInKg() + 6.25 * (userInfoModel.getHeightInCM()) - 5 * userInfoModel.getAge() + 5));
          }
          return Math.toIntExact(Math.round(10 * userInfoModel.getWeightInKg() + 6.25 * (userInfoModel.getHeightInCM()) - 5 * userInfoModel.getAge() - 161));

     }
//   Harris Benedict Formula
     public static Integer caloriesToMaintain(UserInfoModel userInfoModel){
          int dailyCalories=0;
          switch (userInfoModel.getActivityLevel()){
               case 1:
                    dailyCalories = Math.round(BMR(userInfoModel)*ACTIVITY_LEVEL_SEDENTARY);
                    break;
               case 2:
                    dailyCalories = Math.round(BMR(userInfoModel)*ACTIVITY_LEVEL_LITTLE);
                    break;
               case 3:
                    dailyCalories = Math.round(BMR(userInfoModel)*ACTIVITY_LEVEL_MODERATE);
                    break;
               case 4:
                    dailyCalories = Math.round(BMR(userInfoModel)*ACTIVITY_LEVEL_HARD);
                    break;
               case 5:
                    dailyCalories = Math.round(BMR(userInfoModel)*ACTIVITY_LEVEL_VERY_HARD);
                    break;
          }
          return dailyCalories;
     }


     public static double footToCM(double foot){
          return 30.48*foot;
     }

//     public static Integer caloriesToGain(){
//
//     }

}
