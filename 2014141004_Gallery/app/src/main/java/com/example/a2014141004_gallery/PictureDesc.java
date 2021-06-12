package com.example.a2014141004_gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PictureDesc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_desc);

        TextView tv_title = (TextView)findViewById(R.id.title); // activity_picture_desc에 있는 id값이 title을 텍스트뷰타입으로 넘겨줌
        TextView tv_author = (TextView)findViewById(R.id.artist);
        ImageView iv_picture = (ImageView)findViewById(R.id.picture);

        Intent it = getIntent(); // Main에서 넘어온 Intent를 받는다
        String tag = it.getStringExtra("it_tag"); // it_tag이름으로 보낸 걸 String 형변환해서 받는다

        Resources res = getResources(); // 리소스(res에 있는 모든 것)를 받을 수 있는 객체 만들기


        int id_title = res.getIdentifier("title"+tag, "string",getPackageName());
        // title + 01(tag) 를 string 타입(title(string)+tag(string))인 것을 getPackageName (com.example.a...)에서 가져온다
        String title = res.getString(id_title); // 가져온 리소스 주소값을 위에 string과 여기 string동일하게 해야 한다
        // 즉 title01이라는 이름에 해당되는 안에 값이 title에 들어가게 된다
        tv_title.setText(title); //  tv_title에 title값을 넣는다 : setText

        int id_author = res.getIdentifier("artist"+tag, "string",getPackageName());
        String author = res.getString(id_author);
        tv_author.setText(author);

        int id_picture = res.getIdentifier("picture"+tag, "string",getPackageName());
        String picture = res.getString(id_picture);
        int id_img = res.getIdentifier(picture,"drawable",getPackageName());
        // drawable 형태의 picture라는 이름을 가져온다
        Drawable drawble = res.getDrawable(id_img); // Drawable 객체의 id_img를 가져온다
        iv_picture.setBackground(drawble); // iv_picture에 배경화면을 drawble에 들어있는 걸로한다

    }
    public void closePicture(View v) {finish();} // 눌렀을 때 종료시킨다
}