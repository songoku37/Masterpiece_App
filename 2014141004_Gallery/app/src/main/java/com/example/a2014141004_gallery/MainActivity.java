package com.example.a2014141004_gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void disPlayPicture(View v){
        int id = v.getId(); // 해쉬값을 가져옴
        LinearLayout layout = (LinearLayout) findViewById(id); // 가져온 해쉬값에 해당하는 Layout Id를 찾아옴
        String tag = (String) layout.getTag(); // layout의 가져온 속성에 tag값을 가져와서 String형 변환 01 02 따위를 가져옴

        // Toast.makeText(this,"클릭한 아이템: " + tag , Toast.LENGTH_LONG).show();

        Intent it = new Intent(this,PictureDesc.class);
        it.putExtra("it_tag",tag); // it_tag = tag 해서 그 값을 넘겨줌
        startActivity(it);
    }

}