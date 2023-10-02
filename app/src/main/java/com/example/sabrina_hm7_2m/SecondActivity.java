package com.example.sabrina_hm7_2m;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private TextView textView;
    private ImageView like;
    private ImageView dislike;
    private boolean isLiked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String text = getIntent().getStringExtra("key");
        textView = findViewById(R.id.tv_result);
        textView.setText(text.toString());
        Button btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(view -> {
            onDestroy();
        });

        like = findViewById(R.id.like);
        dislike = findViewById(R.id.dislike);

        dislike.setOnClickListener(view -> {
            if (isLiked) {
                like.setVisibility(View.VISIBLE);
            } else {
                like.setVisibility(View.GONE);
            }
        });

        like.setOnClickListener(view -> {
            if (isLiked) {
                like.setVisibility(View.GONE);
            }
        });
    }

    public void showPopup(View v) {

        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }

    @Override

    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}