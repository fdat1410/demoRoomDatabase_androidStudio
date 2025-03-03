package com.example.demoroomdatabase;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoroomdatabase.adapter.UserAdapter;
import com.example.demoroomdatabase.entity.User;
import com.example.demoroomdatabase.respository.UserRespository;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btnAdd, btnUpdate;
    //UserRoomDatabase userRoomDatabase = UserRoomDatabase.getInstance(this);
    //UserDAO userDAO = userRoomDatabase.userDao();
    UserRespository userRespository;
    BottomNavigationView bottomNavigationView;

    @SuppressLint({"MissingInflatedId", "NonConstantResourceId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        userRespository = new UserRespository(this);
        recyclerView = findViewById(R.id.recyclerView);
        btnAdd = findViewById(R.id.btnAdd);
        List<User> users =userRespository.getAll();
        UserAdapter userAdapter = new UserAdapter(this,users);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
                startActivity(intent);
            }
        });
//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, UpdateProductActivity.class);
//                startActivity(intent);
//            }
//        });
//        bottomNavigationView.findViewById(R.id.bottom_nav);
//        bottomNavigationView.setOnItemSelectedListener(item -> {
//            Fragment selectedFragment = null;
//            switch (item.getItemId()) {
//                case R.id.action_home:
//                    Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
//                    break;
//                case R.id.action_fav:
//                    Toast.makeText(MainActivity.this, "Favourite", Toast.LENGTH_SHORT).show();
//                    break;
//                case R.id.action_profile:
//                    Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
//                    break;
//            }
//            return true;
//        });

//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @SuppressLint("NonConstantResourceId")
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.action_home:
//                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.action_fav:
//                        Toast.makeText(MainActivity.this, "Favourite", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.action_profile:
//                        Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
//                        break;
//                    default:
//                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
//                }
//                return true;
//            }
//        });
    }
}