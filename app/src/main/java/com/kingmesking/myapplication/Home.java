package com.kingmesking.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;


public class Home extends AppCompatActivity  {
    Received Received;
    Long currentpoints,rpoint,rpoint2,tpoint,tpoint2;
    String User;
    EditText eid,points,receivedid,receivedid2,receivedpoints,receivedpoints2,transferedid,transferedid2,transferedpoints,transferedpoints2;
    private DatabaseReference myref,myref1,myref2,myref3,myref4,myref5,myref7,myref8,myref11;

    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    String id1,id2;
    long backpressedtime;






    Button logout, rgo,acceptrpoints,acceptrpoints2,cancelrpoints,cancelrpoints2,canceltpoints,canceltpoints2,transfer,recharge,changepassword;
    String rf;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);







        logout = findViewById(R.id.logout);
        acceptrpoints=findViewById(R.id.acceptrpoints);
                acceptrpoints2=findViewById(R.id. acceptrpoints2);
        cancelrpoints=findViewById(R.id. cancelrpoints);
                cancelrpoints2=findViewById(R.id.cancelrpoints2);
        canceltpoints=findViewById(R.id.canceltpoints);
                canceltpoints2=findViewById(R.id.canceltpoints2);
        receivedid=findViewById(R.id.recivedid);
                receivedid2=findViewById(R.id. receivedid2);
        receivedpoints=findViewById(R.id.receivedpoints);
                receivedpoints2=findViewById(R.id.receivedpoints2);
        transferedid=findViewById(R.id.transferedid);
                transferedid2=findViewById(R.id.transferedid2);
        transferedpoints=findViewById(R.id.transferedpoints);
                transferedpoints2=findViewById(R.id.transferedpoints2);
                changepassword=findViewById(R.id.changePaas);
                transfer=findViewById(R.id.transfer);
                recharge=findViewById(R.id.recharge);
        final MediaPlayer mysong =MediaPlayer.create(Home.this,R.raw.button);
                Received=new Received();


        rgo=findViewById(R.id.rgo);
        eid =  findViewById(R.id.eid);
        points =  findViewById(R.id.points);
        logout.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          mysong.start();
                                          Intent intSignUp = new Intent(Home.this, Login_form.class);
                                          startActivity(intSignUp);
                                          Home.this.finish();

                                      }

                                  });
        changepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mysong.start();
                Intent intch = new Intent(Home.this, changepassword.class);
                intch.putExtra("email", getIntent().getStringExtra("email"));
                startActivity(intch);
                Home.this.finish();

            }

        });
        rgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mysong.start();
                Intent intrgo = new Intent(Home.this, Roullete.class);
                intrgo.putExtra("points",points.getText().toString());
                intrgo.putExtra("user",getIntent().getStringExtra("email"));
                intrgo.putExtra("skey",getIntent().getStringExtra("skey"));
                startActivity(intrgo);



            }

        });
        recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mysong.start();




            }

        });
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mysong.start();
                Intent intrgo = new Intent(Home.this, transfer.class);

                intrgo.putExtra("user",getIntent().getStringExtra("email"));
                intrgo.putExtra("points",getIntent().getStringExtra(""+points));
                intrgo.putExtra("skey",getIntent().getStringExtra("skey"));
                startActivity(intrgo);



            }

        });

        acceptrpoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mysong.start();




                currentpoints=currentpoints+rpoint;
                points.setText(""+currentpoints);

                Map<String,Object> updateValues = new HashMap<>();
                updateValues.put("/points",currentpoints);
                myref.updateChildren(updateValues);

                rpoint=0L;
                final String usera =receivedid.getText().toString().replace("@","");
                final String usern =usera.replace(".","");
                DatabaseReference myref65= FirebaseDatabase.getInstance().getReference().child("transfered").child(usern).child("1");
                Map<String,Object> upv =new HashMap<>();
                upv.put("/points","0");
                upv.put("/Email","Game ID");
                myref65.updateChildren(upv);
                updateValues.put("/points","0");
                myref2.updateChildren(updateValues);
                updateValues.put("/Email","Game ID");
                myref2.updateChildren(updateValues);







            }

        });

        acceptrpoints2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mysong.start();




                currentpoints=currentpoints+rpoint2;
                points.setText(""+currentpoints);


                Map<String,Object> updateValues = new HashMap<>();
                updateValues.put("/points",currentpoints);
                myref.updateChildren(updateValues);

                rpoint2=0L;
                updateValues.put("/points","00");
                myref3.updateChildren(updateValues);
                updateValues.put("/Email","Game ID");
                myref3.updateChildren(updateValues);





            }

        });
        cancelrpoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mysong.start();
                String iu=receivedid.getText().toString();
                final String usera =iu.replace("@","");
                final String usern =usera.replace(".","");
                long pois =Long.parseLong(receivedpoints.getText().toString());
                DatabaseReference myref81,myref91,myref101;
                myref101= FirebaseDatabase.getInstance().getReference().child("Received").child(usern).child("1");
                Map<String,Object> updateValues54 = new HashMap<>();
                updateValues54.put("/points",pois);
                myref101.updateChildren(updateValues54);
                updateValues54.put("/Email",eid.getText().toString());
                myref101.updateChildren(updateValues54);
                final String usera1 =eid.getText().toString().replace("@","");
                final String usern1 =usera1.replace(".","");

                myref81= FirebaseDatabase.getInstance().getReference().child("transfered").child(usern).child("1");
                Map<String,Object> updateValues23 = new HashMap<>();
                updateValues23.put("/points","0");
                updateValues23.put("/Email","Game ID");

                myref81.updateChildren(updateValues23);
                myref91= FirebaseDatabase.getInstance().getReference().child("Received").child(usern1).child("1");
                Map<String,Object> updateValues232 = new HashMap<>();
                updateValues232.put("/points","0");
                updateValues232.put("/Email","Game ID");

                myref91.updateChildren(updateValues232);

                DatabaseReference myref814= FirebaseDatabase.getInstance().getReference().child("transfered").child(usern1).child("1");
                Map<String,Object> updateValues2323 = new HashMap<>();
                updateValues2323.put("/points",pois);
                updateValues2323.put("/Email",receivedid.getText().toString());

                myref814.updateChildren(updateValues2323);
            }

        });
        cancelrpoints2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mysong.start();



            }

        });
        canceltpoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mysong.start();
               String tidd=transferedid.getText().toString();
               long pou =Long.parseLong(transferedpoints.getText().toString());
                DatabaseReference myref91,myref101;
                pou=pou+Long.parseLong(points.getText().toString());

                final String usera =eid.getText().toString().replace("@","");
                final String usern =usera.replace(".","");


                myref101= FirebaseDatabase.getInstance().getReference().child("Member").child(usern);
                Map<String,Object> updateValues54 = new HashMap<>();
                updateValues54.put("/points",pou);
                pou=0;


                myref101.updateChildren(updateValues54);
                final String usera1 =tidd.replace("@","");
                final String usern1 =usera1.replace(".","");


                myref91= FirebaseDatabase.getInstance().getReference().child("Received").child(usern1).child("1");
                Map<String,Object> updateValues232 = new HashMap<>();
                updateValues232.put("/points","0");
                updateValues232.put("/Email","Game ID");
                myref91.updateChildren(updateValues232);

                myref91= FirebaseDatabase.getInstance().getReference().child("transfered").child(usern).child("1");
                Map<String,Object> updateValues2323 = new HashMap<>();
                updateValues2323.put("/points","0");
                updateValues2323.put("/Email","Game ID");

                myref91.updateChildren(updateValues2323);



            }

        });

        mFirebaseDatabase=FirebaseDatabase.getInstance();
        final String Userg=getIntent().getStringExtra("email");
        final String usera =Userg.replace("@","");
        final String usern =usera.replace(".","");
        myref=mFirebaseDatabase.getInstance().getReference().child("Member").child(usern);
        myref1= FirebaseDatabase.getInstance().getReference().child("Received").child(usern);
        myref2= FirebaseDatabase.getInstance().getReference().child("Received").child(usern).child("1");
        myref3= FirebaseDatabase.getInstance().getReference().child("Received").child(usern).child("2");

        myref11=FirebaseDatabase.getInstance().getReference().child("transfered").child(usern);
       DatabaseReference myref12=FirebaseDatabase.getInstance().getReference().child("Session").child(usern);




        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user =mAuth.getCurrentUser();



        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                    String pointsg = dataSnapshot.child("points").getValue().toString();
                    currentpoints=Long.parseLong(pointsg);

                    points.setText(pointsg);
                    /*if(pointsg.equals(1)){
                        rgo.setEnabled(true);
                        acceptrpoints.setEnabled(true);
                        acceptrpoints2.setEnabled(true);
                        cancelrpoints.setEnabled(true);
                        cancelrpoints2.setEnabled(true);
                        canceltpoints.setEnabled(true);
                        cancelrpoints2.setEnabled(true);
                        transfer.setEnabled(true);

                    }else{
                        rgo.setEnabled(false);
                        acceptrpoints.setEnabled(false);
                        acceptrpoints2.setEnabled(false);
                        cancelrpoints.setEnabled(false);
                        cancelrpoints2.setEnabled(false);
                        canceltpoints.setEnabled(false);
                        cancelrpoints2.setEnabled(false);
                        transfer.setEnabled(false);


                    }*/





            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Home.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }



        });
        myref12.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                String key = dataSnapshot.child("key").getValue().toString();
                if(!key.equals(getIntent().getStringExtra("skey"))){
                    Intent intSignUp = new Intent(Home.this, Login_form.class);
                    startActivity(intSignUp);
                    Home.this.finish();
                    Home.this.onDestroy();

                }







            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Home.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }



        });

        myref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                String Emailr = dataSnapshot.child("1").child("Email").getValue().toString();
                String pointsr = dataSnapshot.child("1").child("points").getValue().toString();
                    rpoint = Long.parseLong(pointsr);
                    id1=Emailr;

                receivedid.setText(Emailr);
                receivedpoints.setText(pointsr);

                String Emailr2 = dataSnapshot.child("2").child("Email").getValue().toString();
                String pointsr2 = dataSnapshot.child("2").child("points").getValue().toString();

                   rpoint2 = Long.parseLong(pointsr2);
                   id2=Emailr2;


                receivedid2.setText(Emailr2);
                receivedpoints2.setText(pointsr2);





            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Home.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
        myref11.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                String Emailr = dataSnapshot.child("1").child("Email").getValue().toString();
                String pointsr = dataSnapshot.child("1").child("points").getValue().toString();

                Long rpointt = Long.parseLong(pointsr);
                String id1=Emailr;

                transferedid.setText(id1);
                transferedpoints.setText(""+rpointt);

                String Emailr2 = dataSnapshot.child("2").child("Email").getValue().toString();
                String pointsr2 = dataSnapshot.child("2").child("points").getValue().toString();
                Long rpointte = Long.parseLong(pointsr);
                String id1e=Emailr;

                transferedid2.setText(id1e);
                transferedpoints2.setText(""+rpointte);



                transferedid2.setText(Emailr2);
                transferedpoints2.setText(pointsr2);





            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Home.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });








        eid.setText(getIntent().getStringExtra("email"));
        rf=getIntent().getStringExtra("email");



        User=getIntent().getStringExtra("email");
        Toast.makeText(Home.this, User.toString(), Toast.LENGTH_SHORT).show();






        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
  /*  @Override
    protected void onPause(){
        super.onPause();
        Home.this.finish();
    }*/





    @Override
    public void onBackPressed() {

        if(backpressedtime+2000>System.currentTimeMillis()){
            super.onBackPressed();
            Home.this.onDestroy();

            Intent intToHome = new Intent(Home.this, Login_form.class);

            startActivity(intToHome);
            return;
        }else{
            Toast.makeText(getBaseContext(),"Press Back Again To Exit",Toast.LENGTH_SHORT).show();
        }

        backpressedtime=System.currentTimeMillis();
    }
}





