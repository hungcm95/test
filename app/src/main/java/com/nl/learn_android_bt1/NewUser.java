package com.nl.learn_android_bt1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        Button btnSave=findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtName=findViewById(R.id.edtNewName);
                EditText edtPhone=findViewById(R.id.edtNewPhone);
                Intent intent=new Intent();
                intent.putExtra("name",edtName.getText().toString());
                intent.putExtra("phone",edtPhone.getText().toString());
                setResult(1,intent);
                finish();
            }
        });
    }
}
