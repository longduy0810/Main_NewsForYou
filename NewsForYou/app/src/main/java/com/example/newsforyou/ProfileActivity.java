package com.example.newsforyou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newsforyou.Fragments.HomeFragment;

public class ProfileActivity extends AppCompatActivity {

    private ImageButton btnBack;
    private TextView tvProfile;
    private ImageView ivAvatar;
    private Button btnChangeAvatar;
    private EditText edtUsername;
    private EditText edtEmail;
    private EditText edtBirthday;
    private Button btnSave;
    private Button btnChangePassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initUI();
        initListener();
    }

    private void initUI() {
        btnBack = (ImageButton) findViewById(R.id.btn_back);
        tvProfile = (TextView) findViewById(R.id.tv_profile);
        ivAvatar = (ImageView) findViewById(R.id.iv_avatar);
        btnChangeAvatar = (Button) findViewById(R.id.btn_change_avt);
        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtEmail = (EditText) findViewById(R.id.edt_email);
        edtBirthday = (EditText) findViewById(R.id.edt_birthday);
        btnSave = (Button) findViewById(R.id.btn_save_change);
        btnChangePassword = (Button) findViewById(R.id.btn_change_password);
    }

    private void initListener() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                //
                //
                //
                //

                Toast.makeText(ProfileActivity.this, "Đã lưu", Toast.LENGTH_SHORT).show();
            }
        });

        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                //
                //
                //
                //
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HomeFragment.class);
                startActivity(intent);
            }
        });
    }
}
