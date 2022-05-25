package com.example.liveapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.liveapp.R;
import com.example.liveapp.ui.adapters.UserAdapter;
import com.example.liveapp.ui.fragment.HomeFragment;
import com.example.liveapp.ui.models.UserModel;
import com.example.liveapp.ui.view.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      if (savedInstanceState == null) {
          getSupportFragmentManager().beginTransaction()
                  .replace(R.id.container, HomeFragment.newInstance())
                  .commitNow();
      }

    }

}