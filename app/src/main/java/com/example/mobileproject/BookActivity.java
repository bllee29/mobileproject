package com.example.mobileproject;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class BookActivity extends AppCompatActivity {

    ImageView imgObj;
    TextView bookidObj, nameObj, priceObj, dateObj, writerObj, pageObj, descriptionObj, categoryObj;
    Button cartplusObj;
    TextView cartCount;



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
        
//        cartCount = view.findViewById(R.id.basket_count);

        cartplusObj = findViewById(R.id.book_bt01);
        cartplusObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(BookActivity.this);

                alertDialog.setTitle("도서주문");
                alertDialog.setMessage("상품을 장바구니에 추가하시겠습니까?");
                alertDialog.setIcon(R.drawable.dialog_cat);

                // yes no button listener
                DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            // yes누르면 카운트 + 1
                            case DialogInterface.BUTTON_POSITIVE:
                                int count = Integer.parseInt(cartCount.getText().toString()) + 1;
                                cartCount.setText(Integer.toString(count));
                                dialog.dismiss();
                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                dialog.cancel();
                                break;
                        }
                    }
                };

                alertDialog.setPositiveButton("예", listener);
                alertDialog.setNegativeButton("아니오", listener);
                alertDialog.show();
            }
        });

        String s = bookidObj.getText().toString();
        switch (s) {
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // 메뉴 파일 등록
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_book, menu);

        RelativeLayout relativeLayout = (RelativeLayout)menu.findItem(R.id.menu_cart).getActionView();
        cartCount = relativeLayout.findViewById(R.id.basket_count);


//        RelativeLayout cartValue = (RelativeLayout)item.getActionView();
//        cartCount = (TextView)cartValue.findViewById(R.id.basket_count);



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
