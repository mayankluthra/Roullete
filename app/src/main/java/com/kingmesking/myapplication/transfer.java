package com.kingmesking.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class transfer extends AppCompatActivity {
    EditText transferid,tpoints;
    Button transferr,back;
    FirebaseDatabase mFirebaseDatabase ;
    double point;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transfer);

        transferid=findViewById(R.id.transferid);
        tpoints=findViewById(R.id.tpoints);
        transferr=findViewById(R.id.transfer);
        back=findViewById(R.id.back);
        final MediaPlayer mysong =MediaPlayer.create(transfer.this,R.raw.button);
         DatabaseReference myref;
        String userh=getIntent().getStringExtra("user");

        final String usera =userh.replace("@","");
        final String usern =usera.replace(".","");
        myref=mFirebaseDatabase.getInstance().getReference().child("Member").child(usern);
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                String pointsg = dataSnapshot.child("points").getValue().toString();
                point=Double.parseDouble(pointsg);





            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(transfer.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }



        });
        transferr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mysong.start();
                if (transferid.getText().toString().isEmpty()) {

                    transferid.setError("Please enter Transfer ID");
                    transferid.requestFocus();
                } else if (tpoints.getText().toString().isEmpty()) {

                    tpoints.setError("Please enter The Amount To Transfer");
                    tpoints.requestFocus();
                } else if (transferid.getText().toString().isEmpty() && tpoints.getText().toString().isEmpty()) {

                    Toast.makeText(transfer.this, "Fields Are Empty!", Toast.LENGTH_SHORT).show();
                }else if (!transferid.getText().toString().isEmpty() && !tpoints.getText().toString().isEmpty()) {
                    if (point > Double.parseDouble(tpoints.getText().toString()) && point - Double.parseDouble(tpoints.getText().toString()) >= 1 &&Double.parseDouble(tpoints.getText().toString())>0) {
                       if(!transferid.getText().toString().equals(getIntent().getStringExtra("user"))) {
                           DatabaseReference myref8, myref9;
                           DatabaseReference myref65;
                           String userh = getIntent().getStringExtra("user");
                           final String usera = userh.replace("@", "");
                           final String usern = usera.replace(".", "");

                           final String usera3 = transferid.getText().toString().replace("@", "");
                           final String usern3 = usera3.replace(".", "");
                           myref65 = FirebaseDatabase.getInstance().getReference().child("Received").child(usern3).child("1");
                           Map<String, Object> upv = new HashMap<>();
                           upv.put("/points", tpoints.getText().toString());
                           upv.put("Email", userh);
                           myref65.updateChildren(upv);


                           myref8 = FirebaseDatabase.getInstance().getReference().child("transfered").child(usern).child("1");
                           Map<String, Object> updateValues = new HashMap<>();
                           updateValues.put("/points", tpoints.getText().toString());
                           updateValues.put("/Email", transferid.getText().toString());

                           myref8.updateChildren(updateValues);
                           Map<String, Object> updateValues34 = new HashMap<>();
                           myref9 = FirebaseDatabase.getInstance().getReference().child("Member").child(usern);
                           double pointss = point;
                           double tp = Double.parseDouble(tpoints.getText().toString());
                           pointss = pointss - tp;
                           updateValues34.put("/points", pointss);
                           myref9.updateChildren(updateValues34);
                           Map<String, Object> updateValues547 = new HashMap<>();
                           final String usera4 = transferid.getText().toString().replace("@", "");
                           final String userna = usera4.replace(".", "");
                           String email = userh;
                           Intent intToHome = new Intent(transfer.this, Home.class);
                           intToHome.putExtra("email", email);
                           intToHome.putExtra("skey",(getIntent().getStringExtra("skey")));
                           startActivity(intToHome);
                       }
                       else {
                           Toast.makeText(transfer.this, "Transfer & Receiver ID's Are Same", Toast.LENGTH_SHORT).show();
                       }

                    } else {
                        Toast.makeText(transfer.this, "Insuficient Balance", Toast.LENGTH_SHORT).show();
                    }

                }




            }

        });
        back.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                mysong.start();
                String userh=getIntent().getStringExtra("user");
                final String usera =userh.replace("@","");
                final String usern =usera.replace(".","");
                String email = userh;
                Intent intToHome = new Intent(transfer.this, Home.class);
                intToHome.putExtra("email",email);
                intToHome.putExtra("skey",(getIntent().getStringExtra("skey")));
                startActivity(intToHome);
            }
        });

    }
}
