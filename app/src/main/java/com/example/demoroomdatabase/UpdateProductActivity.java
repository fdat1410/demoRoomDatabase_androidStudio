package com.example.demoroomdatabase;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.demoroomdatabase.respository.UserRespository;

public class UpdateProductActivity extends AppCompatActivity {
    EditText edtEmail, edtPw, edtName;
    Button btnUpdate;
    UserRespository userRespository;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtEmail = findViewById(R.id.edtEmail);
        edtPw = findViewById(R.id.edtPw);
        edtName = findViewById(R.id.edtName);
        btnUpdate = findViewById(R.id.btnUpdate);
        edtEmail.setText(getIntent().getStringExtra("USER_EMAIL"));
        edtPw.setText(getIntent().getStringExtra("USER_PASSWORD"));
        edtName.setText(getIntent().getStringExtra("USER_NAME"));
        // Lấy ID sản phẩm từ Intent
        int userId = getIntent().getIntExtra("USER_ID", -1);
        // Sử dụng productId để cập nhật sản phẩm
        userRespository = new UserRespository(this);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userRespository.updateUserById(userId, edtName.getText().toString(), edtEmail.getText().toString(), edtPw.getText().toString());
                Intent intent = new Intent(UpdateProductActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}