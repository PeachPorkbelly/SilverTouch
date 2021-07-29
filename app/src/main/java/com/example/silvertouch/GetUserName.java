package com.example.silvertouch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GetUserName extends AppCompatActivity {

    SavedInfo si = new SavedInfo();
    EditText putName;
    Button saveName;

    String userName;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.getusername);

        /*
        EditText에 입력한 이름 값 -> 스트링이면 저장 -> 아니면 다시
        저장 메소드 -> setUserName, getUserName, key값 "UserName"
         */

        putName = (EditText) findViewById(R.id.putName);
        saveName = (Button) findViewById(R.id.saveName);

        saveName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{

                    userName = putName.getText().toString();
                    si.setUserName(getApplicationContext(), userName);
                    setResult(RESULT_OK, new Intent());
                    finish();

                } catch(Exception e){
                    Toast.makeText(getApplicationContext(), "잘못된 입력입니다.", Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}
