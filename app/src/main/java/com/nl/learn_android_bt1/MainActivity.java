package com.nl.learn_android_bt1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<User> users =new ArrayList<>();
    static final String TAG="MainActivity";
    static final int REQUEST_ADD=1;
    static final int REQUEST_EDIT=1;
    MyAdapter myAdapter;
    void _genarateData(){
        for(int i=0;i<20;i++){
            User user =new User();
            user.setName("name_"+i);
            user.setPhone("0000"+i);
            users.add(user);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _genarateData();
        ListView ltsUser=findViewById(R.id.ltsUser);
        myAdapter=new MyAdapter(this,R.layout.item_user,users);
        ltsUser.setAdapter(myAdapter);
        Button btnAdd=findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NewUser.class);
                startActivityForResult(intent,1);
            }
        });
        ltsUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user=(User)parent.getItemAtPosition(position);
                Intent intent=new Intent(MainActivity.this,EditUser.class);
                intent.putExtra("user",user);
                intent.putExtra("pos",position);
                startActivityForResult(intent,2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                //case1
                if(resultCode==1){
                    String name=data.getStringExtra("name");
                    String phone=data.getStringExtra("phone");
                    User user=new User();
                    //Log.e(TAG,name);
                    user.setName(name);
                    user.setPhone(phone);
                    users.add(user);
                    myAdapter.notifyDataSetChanged();
                }
                else{
                    Log.e(TAG,"RESULT_CODE ERROR");
                }
                break;
            case 2:
                //case 2
                if(resultCode==1){
                    User user =(User)data.getSerializableExtra("user");
                    int pos=data.getIntExtra("pos",-1);
                    if(pos>-1){
                        users.set(pos,user);
                    }
                    myAdapter.notifyDataSetChanged();
                }
                else{
                    Log.e(TAG,"RESULT_CODE ERROR");
                }
                break;
        }

    }
}
