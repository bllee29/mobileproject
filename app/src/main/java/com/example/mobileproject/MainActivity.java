package com.example.mobileproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
// toolbar import 주의
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.mobileproject.model.CartRepository;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    // 이미지 변경을 위한 변수
    int index = 0;
    Toolbar toolbar;
    DrawerLayout dLayout;
    NavigationView navigation;

    ImageView  menuObj;

    public static CartRepository cartRepositoryObj;

    // 액티비티가 생성될 때 호출되는 메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // activity_main 레이아웃을 화면에 표시
        setContentView(R.layout.activity_main);

        cartRepositoryObj = new CartRepository();

        menuObj = findViewById(R.id.imageV1);

        toolbar = findViewById(R.id.toolbar);
        navigation = findViewById(R.id.navigation);
        dLayout = findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar); // 툴바 출력

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dLayout.openDrawer(Gravity.LEFT);
            }
        });
        navigation.setNavigationItemSelectedListener(this);
    }

    // 도서 목록 버튼 클릭 시 호출하는 메소드
    public void onBookClick(View view){
        // 토스트를 이용해 도서 목록 버튼 클릭되면 지정 text 출력
        Intent intent = new Intent(getApplicationContext(), BooksActivity.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(),"도서목록버튼이 클릭되었습니다",Toast.LENGTH_SHORT).show();
    }

    // 동영상 강좌 버튼 클릭 시 호출되는 메소드
    public void onVideoClick(View view){
        // 토스트를 이용해 동영상강좌 버튼 클릭되면 지정 text 출력
        Toast.makeText(getApplicationContext(),"동영상강좌버튼이 클릭되었습니다",Toast.LENGTH_SHORT).show();
    }

    // 고객센터 버튼 클릭 시 호출되는 메소드
    public void onCustomerClick(View view){
        // 토스트를 이용해 고객센터 버튼 클릭되면 지정 text 출력
        Toast.makeText(getApplicationContext(),"고객센터버튼이 클릭되었습니다",Toast.LENGTH_SHORT).show();
    }

    // 마이페이지 버튼 클릭 시 호출되는 메소드
    public void onMyPageClick(View view){
        // 토스트를 이용해 마이페이지 버튼 클릭되면 지정 text 출력
        Toast.makeText(getApplicationContext(),"마이페이지버튼이 클릭되었습니다",Toast.LENGTH_SHORT).show();
    }

    // 상단 이미지 배경 클릭 시 호출되는 메소드
    public void onImageClick(View view){
        // 이미지뷰 객체 가져오기
        ImageView menuObj  = (ImageView) findViewById(R.id.imageV1);

        // 인덱스가 짝수일 때 cover02 이미지로 변경, 홀수일 때 cover01 이미지로 변경
        if (index % 2 == 0)
            menuObj.setImageResource(R.drawable.cover02);
        else
            menuObj.setImageResource(R.drawable.cover01);
        // 인덱스 증가
        index = 1 - index;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();
        if (itemId == R.id.menu01) {
//            Toast.makeText(this, " 메뉴1 : " + item.getTitle(), Toast.LENGTH_SHORT).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            LayoutInflater inflater = getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.dialog_login, null);
            builder.setView(dialogView);
            AlertDialog dialog = builder.show();

            Button loginbtn = dialogView.findViewById(R.id.loginBtn);
            loginbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView tvID = dialogView.findViewById(R.id.userID);
                    TextView tvPW = dialogView.findViewById(R.id.userPW);

                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), "ID: " + tvID.getText() + " PW: " +
                            tvPW.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        } else if (itemId == R.id.menu02) {
            Toast.makeText(this, " 메뉴2 : " + item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.menu03) {
            Toast.makeText(this, " 메뉴3 : " + item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        dLayout.closeDrawers();

        return false;
    }

    @Override
    public void onBackPressed() {
        if (dLayout.isDrawerOpen(Gravity.LEFT)) {
            dLayout.closeDrawers();
        } else {

            super.onBackPressed();
        }
    }
}