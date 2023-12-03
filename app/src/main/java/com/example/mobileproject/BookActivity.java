package com.example.mobileproject;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class BookActivity extends AppCompatActivity {

    ImageView imgObj;
    TextView bookidObj, nameObj, priceObj, dateObj, writerObj, pageObj, descriptionObj, categoryObj;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
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
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
