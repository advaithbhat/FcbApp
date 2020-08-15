package com.example.fcbapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class recmain extends AppCompatActivity {
RecyclerView recyclerview;
LinearLayoutManager layoutManager;
PeopleAdapter peopleAdapter;
private Button back;

PlayersDetails[] details= {
        new PlayersDetails("Stegen","Ge","GK","stegen","stegen"),
        new PlayersDetails("Neto   ","Br","GK","neto","neto"),
        new PlayersDetails("Semedo","Por","Def","semedo","semedo"),
        new PlayersDetails("Pique","Esp","Def","pique","pique"),
        new PlayersDetails("Lenglet","Fr","Def","lenglet","lenglet"),
        new PlayersDetails("Wague","Sen","Def","wague","wague"),
        new PlayersDetails("J Alba","Esp","Def","alba","alba"),
        new PlayersDetails("Sergi","Esp","Def","sergi","sergi"),
        new PlayersDetails("Umtiti","Fr","Def","umtiti","umtiti"),
        new PlayersDetails("Firpo","Dom","Def","firpo","firpo"),
        new PlayersDetails("Rakitic","Cro","MF","rakitic","rakitic"),
        new PlayersDetails("Sergio","Esp","MF","sergio","sergio"),
        new PlayersDetails("Arthur","Br","MF","arthur","arthur"),
        new PlayersDetails("de Jong","Net","MF","jong","jong"),
        new PlayersDetails("Vidal","Chi","MF","vidal","vidal"),
        new PlayersDetails("Suarez","Uru","FW","suarez","suarez"),
        new PlayersDetails("Messi","Arg","FW","messi","messi"),
        new PlayersDetails("Dembele","Fr","FW","dembele","dembele"),
        new PlayersDetails("G mann","Fr","FW","griezmann","griezmann"),
        new PlayersDetails("Setien","Esp","Man","setien","setien")
};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recmain);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle extra=getIntent().getExtras();

        if(extra!=null)
        {
            details=(PlayersDetails[])extra.getSerializable("obj");
        }

        back=findViewById(R.id.button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(recmain.this,Main2Activity.class);
                finish();
                startActivity(i);
            }
        });

        recyclerview=findViewById(R.id.recyclerView);
        recyclerview.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(recyclerview.getContext(),layoutManager.getOrientation());
        recyclerview.addItemDecoration(dividerItemDecoration);

        peopleAdapter=new PeopleAdapter(details);
        recyclerview.setAdapter(peopleAdapter);
    }
}
