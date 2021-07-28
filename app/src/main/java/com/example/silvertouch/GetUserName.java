package com.example.silvertouch;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GetUserName extends AppCompatActivity {

    EditText putName;
    Button saveName;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.getusername);

        /*
        EditText에 입력한 이름 값 -> 스트링이면 저장 -> 아니면 다시
        저장 메소드 -> setUserName, getUserName, key값 "UserName"
         */

    }
}
