package com.nl.learn_android_bt1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditUser extends AppCompatActivity {
    User user;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        EditText edtName=findViewById(R.id.edtName);
        EditText edtPhone=findViewById(R.id.edtPhone);
        user=(User)getIntent().getSerializableExtra("user");
        pos=getIntent().getIntExtra("pos",-1);
        edtName.setText(user.getName());
        edtPhone.setText(user.getPhone());
        Button btnSave=findViewById(R.id.btnSaveEdit);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                EditText edtName=findViewById(R.id.edtName);
                EditText edtPhone=findViewById(R.id.edtPhone);
                user.setPhone(edtPhone.getText().toString());
                user.setName(edtName.getText().toString());
                intent.putExtra("user",user);
                intent.putExtra("pos",pos);
                setResult(1,intent);
                finish();
            }
        });

    }
}
