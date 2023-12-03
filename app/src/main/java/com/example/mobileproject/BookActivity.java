package com.example.mobileproject;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class BookActivity extends AppCompatActivity {

    ImageView imgObj;
    TextView bookidObj, nameObj, priceObj, dateObj, writerObj, pageObj, descriptionObj, categoryObj;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 돌아가기 화살표
        
        imgObj = findViewById(R.id.book_iv01);
        bookidObj = findViewById(R.id.book_tv01);
        nameObj = findViewById(R.id.book_tv02);
        priceObj = findViewById(R.id.book_tv03);
        dateObj = findViewById(R.id.book_tv04);
        writerObj = findViewById(R.id.book_tv05);
        pageObj = findViewById(R.id.book_tv06);
        descriptionObj = findViewById(R.id.book_tv07);
        categoryObj = findViewById(R.id.book_tv08);
        Intent intent = getIntent();
        bookidObj.setText(intent.getStringExtra("bookid"));
        nameObj.setText(intent.getStringExtra("name"));
        priceObj.setText(intent.getStringExtra("price"));
        dateObj.setText(intent.getStringExtra("date"));
        writerObj.setText(intent.getStringExtra("writer"));
        pageObj.setText(intent.getStringExtra("page"));
        descriptionObj.setText(intent.getStringExtra("description"));
        categoryObj.setText(intent.getStringExtra("category"));
        switch (bookidObj.getText().toString()) {
            case "BOOK1234":
                imgObj.setImageResource(R.drawable.book11);
                break;
            case "BOOK1235":
                imgObj.setImageResource(R.drawable.book21);
                break;
            case "BOOK1236":
                imgObj.setImageResource(R.drawable.book31);
                break;
            case "BOOK1237":
                imgObj.setImageResource(R.drawable.book41);
                break;
        }

//        // This callback will only be called when MyFragment is at least Started.
//        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
//            @Override
//            public void handleOnBackPressed() {
//                finish();
//            }
//        };
//        BookActivity().getOnBackPressedDispatcher().addCallback(this, callback);
//
//        // The callback can be enabled or disabled here or in handleOnBackPressed()

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // 메뉴 파일 등록
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_book, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // 메뉴 클릭 이벤트
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
//            onBackPressed();
            finish();
        } else if (itemId == R.id.menu_home) {
            Toast.makeText(getApplicationContext(), "홈으로 메뉴가 클릭되었습니다", Toast.LENGTH_LONG).show();
            finish();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (itemId == R.id.menu_list) {
            Toast.makeText(getApplicationContext(), "도서목록 메뉴가 클릭되었습니다", Toast.LENGTH_LONG).show();
            finish();
            Intent intent2 = new Intent(this, BooksActivity.class);
            startActivity(intent2);
        } else if (itemId == R.id.menu_cart) {
            Toast.makeText(getApplicationContext(), "장바구니 메뉴가 클릭되었습니다", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
