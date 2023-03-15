package com.example.dietplanner.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietplanner.R;
import com.example.dietplanner.adapters.FoodListRecyclerViewAdapter;
import com.example.dietplanner.databinding.FragmentHomeBinding;
import com.example.dietplanner.models.FoodItemModel;
import com.example.dietplanner.models.UserInfoModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    ArrayList<FoodItemModel> todaysDiet = new ArrayList<>();

    public View onCreateView (@NonNull LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        setRecyclerView(root);

       Intent i = getActivity().getIntent();
       UserInfoModel userInfoModel = (UserInfoModel) i.getSerializableExtra("userInfo");
        binding.tvdailyCalories.setText((String.valueOf(userInfoModel.getCaloriesToMaintain())));
        return root;
    }

    @Override
    public void onDestroyView () {
        super.onDestroyView();
        binding = null;
    }

    private void setRecyclerView(View root){
        RecyclerView recyclerView = root.findViewById(R.id.recycler_view_todays_diet);

        setFoodItems();
        FoodListRecyclerViewAdapter foodListRecyclerViewAdapter = new FoodListRecyclerViewAdapter(getActivity(),todaysDiet);
        recyclerView.setAdapter(foodListRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }
    private void setFoodItems(){
      for (int i=0;i<2;i++){
          todaysDiet.add(new FoodItemModel("Milk","200","1 L"));
          todaysDiet.add(new FoodItemModel("Chicken","600","200g"));
          todaysDiet.add(new FoodItemModel("Paneer","430","100g"));
          todaysDiet.add(new FoodItemModel("Rice","600","200g"));
      }
    }
}