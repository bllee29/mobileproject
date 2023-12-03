package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 이미지 변경을 위한 변수
    int index = 0;

    // 액티비티가 생성될 때 호출되는 메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // activity_main 레이아웃을 화면에 표시
        setContentView(R.layout.activity_main);
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
}