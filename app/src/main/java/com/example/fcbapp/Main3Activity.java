package com.example.fcbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
PlayersDetails[] playerDetails;
int position;
private TextView flname,posi,country;
ImageView profileimage;
Button update,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bundle extra=getIntent().getExtras();
        if(extra!=null)
        {
            playerDetails=(PlayersDetails[])extra.getSerializable("obj");
            position=extra.getInt("pos");
        }
        flname=findViewById(R.id.textView4);
        posi=findViewById(R.id.textView5);
        country=findViewById(R.id.textView6);
        profileimage=findViewById(R.id.profilepic);

        back=findViewById(R.id.button3);

        flname.setText(playerDetails[position].fname);
        posi.setText(playerDetails[position].position);
        country.setText(playerDetails[position].country);

        int resID=getResources().getIdentifier(playerDetails[position].imagename,"mipmap",getPackageName());
        profileimage.setImageBitmap(BitmapFactory.decodeResource(getResources(),resID));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Main3Activity.this,recmain.class);
                i.putExtra("obj",playerDetails);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.putExtra("EXIT",true);
                startActivity(i);
                finish();
            }
        });

    }
}
