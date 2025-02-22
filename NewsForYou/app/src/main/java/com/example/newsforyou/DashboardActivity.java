package com.example.newsforyou;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.newsforyou.Class.MainViewPagerAdapter;
import com.example.newsforyou.Class.News;
import com.example.newsforyou.Class.User;
import com.example.newsforyou.Class.ZoomOutPageTransformer;
import com.github.javafaker.Faker;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class DashboardActivity extends AppCompatActivity {
    private long Timeback;
    private DatabaseReference newsDatabase;
    private StorageReference storageRef;
    private FirebaseStorage storage;

    private ViewPager2 mViewPager;
    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_dashboard);
        initUI();
        initListener();
        //initNews();
        showUserInformation();
    }

    @Override
    public void onBackPressed() {
        if(mViewPager.getCurrentItem() != 0){
            mViewPager.setCurrentItem(0);
        } else {
            super.onBackPressed();
        }
    }

    private void initUI(){
        mViewPager = findViewById(R.id.view_pager);
        mBottomNavigationView = findViewById(R.id.navigation_bottom);
        MainViewPagerAdapter mainViewPagerAdapter =
                new MainViewPagerAdapter(this);
        mViewPager.setAdapter(mainViewPagerAdapter);
    }

    private void initListener() {

        mBottomNavigationView.setOnItemSelectedListener(
                new NavigationBarView.OnItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int id = item.getItemId();
                        if(id == R.id.bottom_home){
                            mViewPager.setCurrentItem(0);
                        } else if (id == R.id.bottom_search){
                            mViewPager.setCurrentItem(1);
                        } else if (id == R.id.bottom_save){
                            mViewPager.setCurrentItem(2);
                        } else  if (id == R.id.bottom_setting){
                            mViewPager.setCurrentItem(3);
                        }
                        return true;
                    }
                });

        mViewPager.setPageTransformer(new ZoomOutPageTransformer());
        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        mBottomNavigationView.getMenu()
                                .findItem(R.id.bottom_home)
                                .setChecked(true);
                        break;
                    case 1:
                        mBottomNavigationView.getMenu()
                                .findItem(R.id.bottom_search)
                                .setChecked(true);
                        break;
                    case 2:
                        mBottomNavigationView.getMenu()
                                .findItem(R.id.bottom_save)
                                .setChecked(true);
                        break;
                    case 3:
                        mBottomNavigationView.getMenu()
                                .findItem(R.id.bottom_setting)
                                .setChecked(true);
                        break;
                }
            }
        });
    }

    private void onClickSignOut() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        finish();
    }

    private void showUserInformation(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            return;
        }

        String email = user.getEmail();
    }

    private void initNews() {
        newsDatabase = FirebaseDatabase.getInstance().getReference();
        Faker faker = new Faker(new Locale("vi"));
        for(int i = 0; i < 100; i++){
            Date time = new Date();
            News news = new News(new Random().nextInt(),faker.book().title(), "Test", faker.book().author(), time.toString());
            newsDatabase.child("News").push().setValue(news);
        }

    }
}