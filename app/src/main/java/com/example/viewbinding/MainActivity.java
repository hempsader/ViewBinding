package com.example.viewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.viewbinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //First time we define at module gradle level the following:
    /*
        android {
    ...
    buildFeatures {
        viewBinding true
    }
}
     */

    //Get a refference from the generated binding class
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Inflate the class
        //For fragment use ActivityMainBinding.inflate(inflater,container,false) into onCreateView
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        //Get the root view, which is an constraint layout in this case
        View view = binding.getRoot();

        //Now set the content view
        setContentView(view);

        //Get the views id through binding.
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.editTextTextPersonName.getText().toString());
            }
        });
    }

    //For Fragments call binding = null into onDestroyView override
}