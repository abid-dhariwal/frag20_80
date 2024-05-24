package com.example.frag20_80;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
Button btn1,btn2;
FrameLayout frag1,frag2;
FragmentManager manager;
TextView tvfrag1,tvfrag2;

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

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.beginTransaction()
                        .show(tvfrag1)
                        .hide(tvfrag2)
                        .commit();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.beginTransaction()
                        .show(tvfrag2)
                        .show(tvfrag1)
                        .commit();
            }
        });
    }
    private void init(){
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        frag1=findViewById(R.id.frag1);
        frag2=findViewById(R.id.frag2);
        manager=getSupportFragmentManager();


    }
}