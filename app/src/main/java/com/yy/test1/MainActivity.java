package com.yy.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    static final int GET_STRING = 1;
    TextView text;

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        text = (TextView) findViewById(R.id.text);
        button.setOnClickListener(new View.OnClickListener() { //??
            // @Override
            public void onClick(View arg0) {
                //액티비티 실행하려면 인텐트객체 생성해야함 -> 두번째 액티비티 이름 적어준다. -> 명시적 인텐트
                Intent in = new Intent(MainActivity.this, SubActivity.class);
                startActivityForResult(in, GET_STRING);//서브액티비티 실행하기
            }
        });
    }

    //서브액티비티로부터 메인액티비티의 밑줄 부분에 결과를 받는다.
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        if(requestCode == GET_STRING){
            if(resultCode == RESULT_OK){
                text.setText(data.getStringExtra("INPUT_TEXT"));
            }
        }
    }
}