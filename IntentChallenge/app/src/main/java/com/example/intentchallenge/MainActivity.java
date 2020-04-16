package com.example.intentchallenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnCreate;
    ImageView ivFace, ivPhone, ivMap, ivWebsite;
    TextView tvInfo;
    String name, number,website, location;

    final int CREATENEWCONTACT=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivFace=findViewById(R.id.ivFace);
        ivPhone=findViewById(R.id.ivPhone);
        ivMap=findViewById(R.id.ivMap);
        ivWebsite= findViewById(R.id.ivWebsite);
        btnCreate=findViewById(R.id.btnCreate);
        tvInfo=findViewById(R.id.tvInfo);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.intentchallenge.Activity2.class);
                startActivityForResult(intent, CREATENEWCONTACT);

            }
        });

        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });

        ivMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+location));
                startActivity(intent);
        }
        });

        ivWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse(website));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CREATENEWCONTACT){
            String pictureType = data.getStringExtra("pictureType").toString();
            if (pictureType.equals("sad"))
                ivFace.setImageResource(R.drawable.sad_face);
            else if (pictureType.equals("normal"))
                ivFace.setImageResource(R.drawable.normal_face);
            else
                ivFace.setImageResource(R.drawable.happy_face);

            ivFace.setVisibility(View.VISIBLE);
            ivPhone.setVisibility(View.VISIBLE);
            ivMap.setVisibility(View.VISIBLE);

            name=data.getStringExtra("name").toString();
            number= data.getStringExtra("number").toString();
            website = data.getStringExtra("website").toString();
            location =  data.getStringExtra("location").toString();


        }


    }
}
