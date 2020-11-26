package com.kingmesking.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Roullete extends AppCompatActivity {
    Button c1,c5,c10,c50,c100,c500,c1000,c5000;
    member member;
    bets bets;
    DatabaseReference reff;

    Double timef, bet=1.0,placebet0=0.0,placebet00=0.0,placebet1=0.0,placebet2=0.0,placebet3=0.0,placebet4=0.0,placebet5=0.0,placebet6=0.0
            ,placebet7=0.0,placebet8=0.0,placebet9=0.0,placebet10=0.0,placebet11=0.0,placebet12=0.0,placebet13=0.0,placebet14=0.0
            ,placebet15=0.0,placebet16=0.0,placebet17=0.0,placebet18=0.0,placebet19=0.0,placebet20=0.0,placebet21=0.0,placebet22=0.0
            ,placebet23=0.0,placebet24=0.0,placebet25=0.0,placebet26=0.0,placebet27=0.0,placebet28=0.0,placebet29=0.0,placebet30=0.0
            ,placebet31=0.0,placebet32=0.0,placebet33=0.0,placebet34=0.0,placebet35=0.0,placebet36=0.0,placebet2to11=0.0,placebet2to12=0.0
            ,placebet2to13=0.0,placebet1st12=0.0,placebet2nd12=0.0,placebet3rd12=0.0,placebet1to18=0.0,placebeteven=0.0,placebetr=0.0,placebetb=0.0
            ,placebetodd=0.0,placebet19to36=0.0,Won0=0.0,Won00=0.0,Won1=0.0,Won2=0.0,Won3=0.0,Won4=0.0,Won5=0.0,Won6=0.0,Won7=0.0,Won8=0.0,
            Won9=0.0,Won10=0.0,Won11=0.0,Won12=0.0,Won13=0.0,Won14=0.0,Won15=0.0,Won16=0.0,Won17=0.0,Won18=0.0,Won19=0.0,Won20=0.0,Won21=0.0,Won22=0.0,Won23=0.0,Won24=0.0,Won25=0.0,Won26=0.0,Won27=0.0
            ,Won28=0.0,Won29=0.0,Won30=0.0,Won31=0.0,Won32=0.0,Won33=0.0,Won34=0.0,Won35=0.0,Won36=0.0,Won1h=0.0,Won2h=0.0,Won3h=0.0,Won4h=0.0,Won5h=0.0,Won6h=0.0,Won7h=0.0,Won8h=0.0,
            Won9h=0.0,Won10h=0.0,Won11h=0.0,Won12h=0.0,Won13h=0.0,Won14h=0.0,Won15h=0.0,Won16h=0.0,Won17h=0.0,Won18h=0.0,Won19h=0.0,Won20h=0.0,Won21h=0.0,Won22h=0.0,Won23h=0.0,Won24h=0.0,Won25h=0.0,Won26h=0.0,Won27h=0.0
            ,Won28h=0.0,Won29h=0.0,Won30h=0.0,Won31h=0.0,Won32h=0.0,Won33h=0.0,Won34h=0.0,Won35h=0.0,Won36h=0.0,winned=0.0,winnedd=0.0,tobet=0.0,placebet1h=0.0,placebet2h=0.0,placebet3h=0.0,placebet4h=0.0,placebet5h=0.0,placebet6h=0.0
            ,placebet7h=0.0,placebet8h=0.0,placebet9h=0.0,placebet10h=0.0,placebet11h=0.0,placebet12h=0.0,placebet13h=0.0,placebet14h=0.0
            ,placebet15h=0.0,placebet16h=0.0,placebet17h=0.0,placebet18h=0.0,placebet19h=0.0,placebet20h=0.0,placebet21h=0.0,placebet22h=0.0
            ,placebet23h=0.0,placebet24h=0.0,placebet25h=0.0,placebet26h=0.0,placebet27h=0.0,placebet28h=0.0,placebet29h=0.0,placebet30h=0.0
            ,placebet31h=0.0,placebet32h=0.0,placebet33h=0.0,placebet34h=0.0,placebet35h=0.0,placebet36h=0.0;


    int hjk = 0,minutes,seconds,totalusers=0;

    Double point=0.0;
    String howtoplay,th;






    //table buttons

    private Button button0;
    private Button button00;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;
    private Button button13;
    private Button button14;
    private Button button15;
    private Button button16;
    private Button button17;
    private Button button18;
    private Button button19;
    private Button button20;
    private Button button21;
    private Button button22;
    private Button button23;
    private Button button24;
    private Button button25;
    private Button button26;
    private Button button27;
    private Button button28;
    private Button button29;
    private Button button30;
    private Button button31;
    private Button button32;
    private Button button33;
    private Button button34;
    private Button button35;
    private Button button36;
    private Button button1st12;
    private Button button2nd12;
    private Button button3rd12;
    private Button button1to18;
    private Button buttoneven;
    private Button buttonodd;
    private Button buttonred;
    private Button buttonblack;
    private Button button19to36;
    private Button button2to11;
    private Button button2to12;
    private Button button2to13;
    private Button buttontake;

    private Button buttonexit;








    //for timer
    private EditText countdown,availablep,winning,tbet;
    private Button countdownbutton;
    private CountDownTimer countDownTimer;

    private boolean timeRunning;
    private long timerr;
    private long timeLeftMillis,backpressedtime;
    int ij =0;

    //for wheel rotate
    Button button,btake,betlock,bcancel;
    EditText EditText1,EditText2,EditText3,EditText4,EditText5;
    ImageView iv_wheel;

    Random r;
    int degree = 0, degree_old =0;
    public static final float FACTOR = 4.73684211f;
    String temp,temp1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roullete);
        availablep=findViewById(R.id.availablep);
        winning=findViewById(R.id.winning);
        btake=findViewById(R.id.btake);
        c1 = findViewById(R.id.c1);
        c5 = findViewById(R.id.c5);
        c10 = findViewById(R.id.c10);
        c100 = findViewById(R.id.c100);
        c50 = findViewById(R.id.c50);
        c500 = findViewById(R.id.c500);
        c1000 = findViewById(R.id.c1000);
        c5000 = findViewById(R.id.c5000);
        tbet=findViewById(R.id.tbet);



        //counter

        countdown = findViewById(R.id.countdown);
        countdownbutton = findViewById(R.id.b1to18);
        button0 = findViewById(R.id.b0);
        button00 = findViewById(R.id.b00);
        button1 = findViewById(R.id.b1);
        button2 = findViewById(R.id.b2);
        button3 = findViewById(R.id.b3);
        button4 = findViewById(R.id.b4);
        button5 = findViewById(R.id.b5);
        button6 = findViewById(R.id.b6);
        button7 = findViewById(R.id.b7);
        button8 = findViewById(R.id.b8);
        button9 = findViewById(R.id.b9);
        button10 = findViewById(R.id.b10);
        button11 = findViewById(R.id.b11);
        button12 = findViewById(R.id.b12);
        button13 = findViewById(R.id.b13);
        button14 = findViewById(R.id.b14);
        button15 = findViewById(R.id.b15);
        button16 = findViewById(R.id.b16);
        button17 = findViewById(R.id.b17);
        button18 = findViewById(R.id.b18);
        button19 = findViewById(R.id.b19);
        button20 = findViewById(R.id.b20);
        button21 = findViewById(R.id.b21);
        button22= findViewById(R.id.b22);
        button23 = findViewById(R.id.b23);
        button24 = findViewById(R.id.b24);
        button25 = findViewById(R.id.b25);
        button26 = findViewById(R.id.b26);
        button27 = findViewById(R.id.b27);
        button28 = findViewById(R.id.b28);
        button29 = findViewById(R.id.b29);
        button30 = findViewById(R.id.b30);
        button31 = findViewById(R.id.b31);
        button32 = findViewById(R.id.b32);
        button33 = findViewById(R.id.b33);
        button34 = findViewById(R.id.b34);
        button35 = findViewById(R.id.b35);
        button36 = findViewById(R.id.b36);
        button1to18 = findViewById(R.id.b1to18);
        button19to36 = findViewById(R.id.b19to36);
        button1st12 = findViewById(R.id.b1st12);
        button2nd12 = findViewById(R.id.b2nd12);
        button3rd12 = findViewById(R.id.b3rd12);
        buttoneven = findViewById(R.id.beven);
        buttonred = findViewById(R.id.bred);
        buttonblack = findViewById(R.id.bblack);
        buttonodd = findViewById(R.id.bodd);
        button2to11 = findViewById(R.id.b2to11);
        button2to12 = findViewById(R.id.b2to12);
        button2to13 = findViewById(R.id.b2to13);
        buttontake = findViewById(R.id.btake);
        bcancel = findViewById(R.id.bcancel);
        betlock=findViewById(R.id.block);

        buttonexit = findViewById(R.id.bexit);

        member=new member();
        bets=new bets();





        btake.setEnabled(false);
        String ap=getIntent().getStringExtra("points");
        String w = getIntent().getStringExtra("email");




        String a = availablep.getText().toString();


        availablep.setText(ap);

        final DatabaseReference myref;
        final DatabaseReference myref1,myref5,myref6,myref9,myref10,myref15,myref19,myref20,myreftg;
        FirebaseDatabase mFirebaseDatabase=FirebaseDatabase.getInstance();

        FirebaseAuth mAuth;

        final String Userg=getIntent().getStringExtra("user");
        final String usera =Userg.replace("@","");
        final String usern =usera.replace(".","");

        myref=mFirebaseDatabase.getInstance().getReference().child("Member").child(usern);
        myref5=mFirebaseDatabase.getInstance().getReference().child("Bets").child(usern);
        myref6=mFirebaseDatabase.getInstance().getReference().child("timer");
        myref9=mFirebaseDatabase.getInstance().getReference().child("betsplay");
        myref10=mFirebaseDatabase.getInstance().getReference().child("mode");
        myref15=mFirebaseDatabase.getInstance().getReference().child("Totalusers");
        myreftg=mFirebaseDatabase.getInstance().getReference().child("Session").child(usern);

        Map<String,Object> updateValues = new HashMap<>();
        updateValues.put("/betsplayed",0);
        myref9.updateChildren(updateValues);



        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user =mAuth.getCurrentUser();

        myreftg.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                String key = dataSnapshot.child("key").getValue().toString();
                if(!key.equals(getIntent().getStringExtra("skey"))){
                    Intent intSignUp = new Intent(Roullete.this, Login_form.class);
                    startActivity(intSignUp);
                    Roullete.this.finish();


                }







            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Roullete.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }



        });
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                checkConnection();
                String tak = dataSnapshot.child("points").getValue().toString();
                availablep.setText(tak);


                String p1 = dataSnapshot.child("take").getValue().toString();
                winning.setText(p1);


                winnedd=Double.parseDouble(winning.getText().toString());

                if(tobet>0){
                    betlock.setEnabled(true);
                }
                else if(tobet==0){
                    betlock.setEnabled(false);


                }




            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Roullete.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
        myref15.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                checkConnection();


                totalusers = Integer.parseInt(dataSnapshot.child("count").getValue().toString());













            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Roullete.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });




       /* myref6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                minutes =00;

                int timed = Integer.parseInt(dataSnapshot.child("second").getValue().toString());
                degree=Integer.parseInt(dataSnapshot.child("degree").getValue().toString());
                seconds = (int) (timed / 1000) % 60;

                String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
                countdown.setText(timeLeftFormatted);
                int o1=Integer.parseInt(dataSnapshot.child("1").getValue().toString());
                int o2=Integer.parseInt(dataSnapshot.child("2").getValue().toString());
                int o3=Integer.parseInt(dataSnapshot.child("3").getValue().toString());
                int o4=Integer.parseInt(dataSnapshot.child("4").getValue().toString());
                int o5=Integer.parseInt(dataSnapshot.child("5").getValue().toString());
                EditText1.setText(""+o1);
                EditText2.setText(""+o2);
                EditText3.setText(""+o3);
                EditText4.setText(""+o4);
                EditText5.setText(""+o5);
                if (EditText5.getText().toString().equals("18") || EditText5.getText().toString().equals("21") || EditText5.getText().toString().equals("16") || EditText5.getText().toString().equals("23") || EditText5.getText().toString().equals("14") || EditText5.getText().toString().equals("9") || EditText5.getText().toString().equals("30") || EditText5.getText().toString().equals("7") || EditText5.getText().toString().equals("32") || EditText5.getText().toString().equals("5") || EditText5.getText().toString().equals("34") || EditText5.getText().toString().equals("3") || EditText5.getText().toString().equals("36") || EditText5.getText().toString().equals("1") || EditText5.getText().toString().equals("27") || EditText5.getText().toString().equals("25") || EditText5.getText().toString().equals("12") || EditText5.getText().toString().equals("19")) {
                    EditText5.setBackgroundColor(Color.RED);
                } else if (EditText5.getText().toString().equals("6") || EditText5.getText().toString().equals("33") || EditText5.getText().toString().equals("4") || EditText5.getText().toString().equals("35") || EditText5.getText().toString().equals("2") || EditText5.getText().toString().equals("28") || EditText5.getText().toString().equals("26") || EditText5.getText().toString().equals("11") || EditText5.getText().toString().equals("20") || EditText5.getText().toString().equals("17") || EditText5.getText().toString().equals("22") || EditText5.getText().toString().equals("15") || EditText5.getText().toString().equals("24") || EditText5.getText().toString().equals("13") || EditText5.getText().toString().equals("10") || EditText5.getText().toString().equals("29") || EditText5.getText().toString().equals("8") || EditText5.getText().toString().equals("31")) {
                    EditText5.setBackgroundColor(Color.BLACK);
                    EditText5.setTextColor(Color.WHITE);
                } else if (EditText5.getText().toString().equals("0") || EditText5.getText().toString().equals("00")) {
                    EditText5.setBackgroundColor(Color.GREEN);
                }

                if (EditText4.getText().toString().equals("18") || EditText4.getText().toString().equals("21") || EditText4.getText().toString().equals("16") || EditText4.getText().toString().equals("23") || EditText4.getText().toString().equals("14") || EditText4.getText().toString().equals("9") || EditText4.getText().toString().equals("30") || EditText4.getText().toString().equals("7") || EditText4.getText().toString().equals("32") || EditText4.getText().toString().equals("5") || EditText4.getText().toString().equals("34") || EditText4.getText().toString().equals("3") || EditText4.getText().toString().equals("36") || EditText4.getText().toString().equals("1") || EditText4.getText().toString().equals("27") || EditText4.getText().toString().equals("25") || EditText4.getText().toString().equals("12") || EditText4.getText().toString().equals("19")) {
                    EditText4.setBackgroundColor(Color.RED);
                } else if (EditText4.getText().toString().equals("6") || EditText4.getText().toString().equals("33") || EditText4.getText().toString().equals("4") || EditText4.getText().toString().equals("35") || EditText4.getText().toString().equals("2") || EditText4.getText().toString().equals("28") || EditText4.getText().toString().equals("26") || EditText4.getText().toString().equals("11") || EditText4.getText().toString().equals("20") || EditText4.getText().toString().equals("17") || EditText4.getText().toString().equals("22") || EditText4.getText().toString().equals("15") || EditText4.getText().toString().equals("24") || EditText4.getText().toString().equals("13") || EditText4.getText().toString().equals("10") || EditText4.getText().toString().equals("29") || EditText4.getText().toString().equals("8") || EditText4.getText().toString().equals("31")) {
                    EditText4.setBackgroundColor(Color.BLACK);
                    EditText4.setTextColor(Color.WHITE);
                } else if (EditText4.getText().toString().equals("0") || EditText4.getText().toString().equals("00")) {
                    EditText4.setBackgroundColor(Color.GREEN);
                }
                if (EditText3.getText().toString().equals("18") || EditText3.getText().toString().equals("21") || EditText3.getText().toString().equals("16") || EditText3.getText().toString().equals("23") || EditText3.getText().toString().equals("14") || EditText3.getText().toString().equals("9") || EditText3.getText().toString().equals("30") || EditText3.getText().toString().equals("7") || EditText3.getText().toString().equals("32") || EditText3.getText().toString().equals("5") || EditText3.getText().toString().equals("34") || EditText3.getText().toString().equals("3") || EditText3.getText().toString().equals("36") || EditText3.getText().toString().equals("1") || EditText3.getText().toString().equals("27") || EditText3.getText().toString().equals("25") || EditText3.getText().toString().equals("12") || EditText3.getText().toString().equals("19")) {
                    EditText3.setBackgroundColor(Color.RED);
                } else if (EditText3.getText().toString().equals("6") || EditText3.getText().toString().equals("33") || EditText3.getText().toString().equals("4") || EditText3.getText().toString().equals("35") || EditText3.getText().toString().equals("2") || EditText3.getText().toString().equals("28") || EditText3.getText().toString().equals("26") || EditText3.getText().toString().equals("11") || EditText3.getText().toString().equals("20") || EditText3.getText().toString().equals("17") || EditText3.getText().toString().equals("22") || EditText3.getText().toString().equals("15") || EditText3.getText().toString().equals("24") || EditText3.getText().toString().equals("13") || EditText3.getText().toString().equals("10") || EditText3.getText().toString().equals("29") || EditText3.getText().toString().equals("8") || EditText3.getText().toString().equals("31")) {
                    EditText3.setBackgroundColor(Color.BLACK);
                    EditText3.setTextColor(Color.WHITE);
                } else if (EditText3.getText().toString().equals("0") || EditText3.getText().toString().equals("00")) {
                    EditText3.setBackgroundColor(Color.GREEN);
                }

                if (EditText2.getText().toString().equals("18") || EditText2.getText().toString().equals("21") || EditText2.getText().toString().equals("16") || EditText2.getText().toString().equals("23") || EditText2.getText().toString().equals("14") || EditText2.getText().toString().equals("9") || EditText2.getText().toString().equals("30") || EditText2.getText().toString().equals("7") || EditText2.getText().toString().equals("32") || EditText2.getText().toString().equals("5") || EditText2.getText().toString().equals("34") || EditText2.getText().toString().equals("3") || EditText2.getText().toString().equals("36") || EditText2.getText().toString().equals("1") || EditText2.getText().toString().equals("27") || EditText2.getText().toString().equals("25") || EditText2.getText().toString().equals("12") || EditText2.getText().toString().equals("19")) {
                    EditText2.setBackgroundColor(Color.RED);
                } else if (EditText2.getText().toString().equals("6") || EditText2.getText().toString().equals("33") || EditText2.getText().toString().equals("4") || EditText2.getText().toString().equals("35") || EditText2.getText().toString().equals("2") || EditText2.getText().toString().equals("28") || EditText2.getText().toString().equals("26") || EditText2.getText().toString().equals("11") || EditText2.getText().toString().equals("20") || EditText2.getText().toString().equals("17") || EditText2.getText().toString().equals("22") || EditText2.getText().toString().equals("15") || EditText2.getText().toString().equals("24") || EditText2.getText().toString().equals("13") || EditText2.getText().toString().equals("10") || EditText2.getText().toString().equals("29") || EditText2.getText().toString().equals("8") || EditText2.getText().toString().equals("31")) {
                    EditText2.setBackgroundColor(Color.BLACK);
                    EditText2.setTextColor(Color.WHITE);
                } else if (EditText2.getText().toString().equals("0") || EditText2.getText().toString().equals("00")) {
                    EditText2.setBackgroundColor(Color.GREEN);
                }

                if (EditText1.getText().toString().equals("18") || EditText1.getText().toString().equals("21") || EditText1.getText().toString().equals("16") || EditText1.getText().toString().equals("23") || EditText1.getText().toString().equals("14") || EditText1.getText().toString().equals("9") || EditText1.getText().toString().equals("30") || EditText1.getText().toString().equals("7") || EditText1.getText().toString().equals("32") || EditText1.getText().toString().equals("5") || EditText1.getText().toString().equals("34") || EditText1.getText().toString().equals("3") || EditText1.getText().toString().equals("36") || EditText1.getText().toString().equals("1") || EditText1.getText().toString().equals("27") || EditText1.getText().toString().equals("25") || EditText1.getText().toString().equals("12") || EditText1.getText().toString().equals("19")) {
                    EditText1.setBackgroundColor(Color.RED);
                } else if (EditText1.getText().toString().equals("6") || EditText1.getText().toString().equals("33") || EditText1.getText().toString().equals("4") || EditText1.getText().toString().equals("35") || EditText1.getText().toString().equals("2") || EditText1.getText().toString().equals("28") || EditText1.getText().toString().equals("26") || EditText1.getText().toString().equals("11") || EditText1.getText().toString().equals("20") || EditText1.getText().toString().equals("17") || EditText1.getText().toString().equals("22") || EditText1.getText().toString().equals("15") || EditText1.getText().toString().equals("24") || EditText1.getText().toString().equals("13") || EditText1.getText().toString().equals("10") || EditText1.getText().toString().equals("29") || EditText1.getText().toString().equals("8") || EditText1.getText().toString().equals("31")) {
                    EditText1.setBackgroundColor(Color.BLACK);
                    EditText1.setTextColor(Color.WHITE);
                } else if (EditText1.getText().toString().equals("0") || EditText1.getText().toString().equals("00")) {
                    EditText1.setBackgroundColor(Color.GREEN);
                }





                countdown.setText(timeLeftFormatted);



















            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Roullete.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });*/
        myref10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                checkConnection();
                String how = dataSnapshot.child("how").getValue().toString();
                howtoplay=how;














            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Roullete.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });





        point=Double.parseDouble(availablep.getText().toString());
        winned=Double.parseDouble(winning.getText().toString());
        button1st12.setEnabled(true);


        startTimer();



        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bet=1.0;


            }

        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bet=5.0;


            }

        });
        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bet=10.0;


            }

        });
        c100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bet=100.0;


            }

        });
        c500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bet=500.0;


            }

        });
        c1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bet=1000.0;


            }

        });
        c5000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bet=5000.0;


            }

        });
        c50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bet=50.0;



            }

        });




        button0.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet0=placebet0+bet;
                if(placebet0==-9){
                    button0.setText("0");
                }
                if(placebet0>5000.0){
                    placebet0=placebet0-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);



                    String pb = String.valueOf(placebet0);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button0.setText(pd);
                    button0.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h


                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/0",placebet0); myref5.updateChildren(updateValues);



                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button00.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet00=placebet00+bet;
                if(placebet00==-9){
                    button00.setText("00");
                }
                if(placebet00>5000.0){
                    placebet00=placebet00+bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet00);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button00.setText(pd);
                    button00.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("points",point); myref.updateChildren(updateValues);
                    updateValues.put("/00",placebet00); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet1=placebet1+bet;
                if(placebet1==-9){
                    button1.setText("1");
                }
                if(placebet1>5000.0){
                    placebet1=placebet1-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet1);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button1.setText(pd);
                    button1.setTextColor(Color.YELLOW);

                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/1",placebet1); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });


        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet2=placebet2+bet;
                if(placebet2==-9){
                    placebet2=placebet2-bet;
                    button2.setText("0");
                }
                if(placebet2>5000.0){
                    placebet2=placebet2-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet2);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button2.setText(pd);
                    button2.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/2",placebet2); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet3=placebet3+bet;
                if(placebet3==-9){

                    button3.setText("0");
                }
                if(placebet3>5000.0){
                    placebet3=placebet3-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet3);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button3.setText(pd);
                    button3.setTextColor(Color.YELLOW);

                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/3",placebet3); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet4=placebet4+bet;
                if(placebet4==-9){
                    button4.setText("0");
                }
                if(placebet4>5000.0){
                    placebet4=placebet4-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();

                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet4);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button4.setText(pd);
                    button4.setTextColor(Color.YELLOW);

                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/4",placebet4); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet5=placebet5+bet;
                if(placebet5==-9){
                    button5.setText("0");
                }
                if(placebet5>5000.0){
                    placebet5=placebet5-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet5);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button5.setText(pd);
                    button5.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/5",placebet5); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet6=placebet6+bet;
                if(placebet6==-9){
                    button6.setText("0");
                }
                if(placebet6>5000.0){
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                    placebet6=placebet6-bet;
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet6);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button6.setText(pd);
                    button6.setTextColor(Color.YELLOW);

                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/6",placebet6); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet7=placebet7+bet;
                if(placebet7==-9){
                    button7.setText("0");
                }
                if(placebet7>5000.0){
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                    placebet7=placebet7-bet;
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet7);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button7.setText(pd);
                    button7.setTextColor(Color.YELLOW);

                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/7",placebet7); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet8=placebet8+bet;
                if(placebet8==-9){
                    button8.setText("0");
                }
                if(placebet8>5000.0){
                    placebet8=placebet8-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet8);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button8.setText(pd);
                    button8.setTextColor(Color.YELLOW);

                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/8",placebet8); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet9=placebet9+bet;
                if(placebet9==-9){
                    button9.setText("0");
                }
                if(placebet9>5000.0){
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                    placebet9=placebet9-bet;
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet9);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button9.setText(pd);
                    button9.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);

                    updateValues.put("/9",placebet9); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet10=placebet10+bet;
                if(placebet10==-9){
                    button10.setText("0");
                }
                if(placebet10>5000.0){
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                    placebet10=placebet10-bet;
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet10);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button10.setText(pd);
                    button10.setTextColor(Color.YELLOW);

                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/10",placebet10); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet11=placebet11+bet;
                if(placebet11==-9){
                    button11.setText("0");
                }
                if(placebet11>5000.0){
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                    placebet11=placebet11-bet;
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet11);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button11.setText(pd);
                    button11.setTextColor(Color.YELLOW);

                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/11",placebet11); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet12=placebet12+bet;
                if(placebet12==-9){
                    button12.setText("0");
                }
                if(placebet12>5000.0){
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                    placebet12=placebet12-bet;
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet12);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button12.setText(pd);
                    button12.setTextColor(Color.YELLOW);

                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/12",placebet12); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button13.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet13=placebet13+bet;
                if(placebet13==-9){
                    button13.setText("0");
                }
                if(placebet13>5000.0){
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                    placebet13=placebet13-bet;
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet13);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button13.setText(pd);
                    button13.setTextColor(Color.YELLOW);

                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/13",placebet13); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button14.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet14=placebet14+bet;
                if(placebet14==-9){
                    button14.setText("0");
                }
                if(placebet14>5000.0){
                    placebet14=placebet14-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet14);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button14.setText(pd);
                    button14.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/14",placebet14); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button15.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet15=placebet15+bet;
                if(placebet15==-9){
                    button15.setText("0");
                }
                if(placebet15>5000.0){
                    placebet15=placebet15-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet15);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button15.setText(pd);
                    button15.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/15",placebet15); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button16.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet16=placebet16+bet;
                if(placebet16==-9){
                    button16.setText("0");
                }
                if(placebet16>5000.0){
                    placebet16=placebet16-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet16);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button16.setText(pd);
                    button16.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/16",placebet16); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button17.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet17=placebet17+bet;
                if(placebet17==-9){
                    button17.setText("0");
                }
                if(placebet17>5000.0){
                    placebet17=placebet17-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet17);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button17.setText(pd);
                    button17.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/17",placebet17); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button18.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet18=placebet18+bet;
                if(placebet18==-9){
                    button18.setText("0");
                }
                if(placebet18>5000.0){
                    placebet18=placebet18-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet18);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button18.setText(pd);
                    button18.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/18",placebet18); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button19.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet19=placebet19+bet;
                if(placebet19==-9){
                    button19.setText("0");
                }
                if(placebet19>5000.0){
                    placebet19=placebet19-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet19);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button19.setText(pd);
                    button19.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/19",placebet19); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button20.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet20=placebet20+bet;
                if(placebet20==-9){
                    button20.setText("0");
                }
                if(placebet20>5000.0){
                    placebet20=placebet20-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet20);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button20.setText(pd);
                    button20.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/20",placebet20); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button21.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet21=placebet21+bet;
                if(placebet21==-9){
                    button21.setText("0");
                }
                if(placebet21>5000.0){
                    placebet21=placebet21-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet21);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button21.setText(pd);
                    button21.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/21",placebet21); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button22.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet22=placebet22+bet;
                if(placebet22==-9){
                    button22.setText("0");
                }
                if(placebet22>5000.0){
                    placebet22=placebet22-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet22);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button22.setText(pd);
                    button22.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/22",placebet22); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button23.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet23=placebet23+bet;
                if(placebet23==-9){
                    button23.setText("0");
                }
                if(placebet23>5000.0){
                    placebet23=placebet23-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet23);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button23.setText(pd);
                    button23.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/23",placebet23); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button24.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet24=placebet24+bet;
                if(placebet24==-9){
                    button24.setText("0");
                }
                if(placebet24>5000.0){
                    placebet24=placebet24-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet24);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button24.setText(pd);
                    button24.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/24",placebet24); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button25.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet25=placebet25+bet;
                if(placebet25==-9){
                    button25.setText("0");
                }
                if(placebet25>5000.0){
                    placebet25=placebet25-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet25);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button25.setText(pd);
                    button25.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/25",placebet25); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button26.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet26=placebet26+bet;
                if(placebet26==-9){
                    button26.setText("0");
                }
                if(placebet26>5000.0){
                    placebet26=placebet26-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet26);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button26.setText(pd);
                    button26.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/26",placebet26); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button27.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet27=placebet27+bet;
                if(placebet27==-9){
                    button27.setText("0");
                }
                if(placebet27>5000.0){
                    placebet27=placebet27-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet27);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button27.setText(pd);
                    button27.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/27",placebet27); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button28.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet28=placebet28+bet;
                if(placebet28==-9){
                    button9.setText("0");
                }
                if(placebet28>5000.0){
                    placebet28=placebet28-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet28);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button28.setText(pd);
                    button28.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/28",placebet28); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button29.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet29=placebet29+bet;
                if(placebet29==-9){
                    button29.setText("0");
                }
                if(placebet29>5000.0){
                    placebet29=placebet29-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet29);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button29.setText(pd);
                    button29.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/29",placebet29); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button30.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet30=placebet30+bet;
                if(placebet30==-9){
                    button30.setText("0");
                }
                if(placebet30>5000.0){
                    placebet30=placebet30-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet30);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button30.setText(pd);
                    button30.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/30",placebet30); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button31.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet31=placebet31+bet;
                if(placebet31==-9){
                    button31.setText("0");
                }
                if(placebet31>5000.0){
                    placebet31=placebet31-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet31);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button31.setText(pd);
                    button31.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);

                    updateValues.put("/31",placebet31); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button32.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet32=placebet32+bet;
                if(placebet32==-9){
                    button32.setText("0");
                }
                if(placebet32>5000.0){
                    placebet32=placebet32-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet32);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button32.setText(pd);
                    button32.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);

                    updateValues.put("/32",placebet32); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button33.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet33=placebet33+bet;
                if(placebet33==-9){
                    button33.setText("0");
                }
                if(placebet33>5000.0){
                    placebet33=placebet33-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet33);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button33.setText(pd);
                    button33.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/33",placebet33); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button34.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet34=placebet34+bet;
                if(placebet34==-9){
                    button34.setText("0");
                }
                if(placebet34>5000.0){
                    placebet34=placebet34-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet34);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button34.setText(pd);
                    button34.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);

                    updateValues.put("/34",placebet34); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button35.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet35=placebet35+bet;
                if(placebet35==-9){
                    button35.setText("0");
                }
                if(placebet35>5000.0){
                    placebet35=placebet35-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet35);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button35.setText(pd);
                    button35.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/35",placebet35); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button36.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                placebet36=placebet36+bet;
                if(placebet36==-9){
                    button36.setText("0");
                }
                if(placebet36>5000.0){
                    placebet36=placebet36-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet36);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button36.setText(pd);
                    button36.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/36",placebet36); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button2to11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                double tj =bet;
                tj=tj/12;
                placebet3h=placebet3h+tj;
                placebet6h=placebet6h+tj;
                placebet9h= placebet9h+tj;
                placebet12h=placebet12h+tj;
                placebet15h=placebet15h+tj;
                placebet18h=placebet18h+tj;
                placebet21h=placebet21h+tj;
                placebet24h=placebet24h+tj;
                placebet27h=placebet27h+tj;
                placebet30h=placebet30h+tj;
                placebet33h=placebet33h+tj;
                placebet36h=placebet36h+tj;



                placebet2to11=placebet2to11+bet;
                if(placebet2to11==-9){
                    button2to11.setText("0");
                }
                if(placebet2to11>5000.0){

                    placebet3h=placebet3h-tj;
                    placebet6h=placebet6h-tj;
                    placebet9h= placebet9h-tj;
                    placebet12h=placebet12h-tj;
                    placebet15h=placebet15h-tj;
                    placebet18h=placebet18h-tj;
                    placebet21h=placebet21h-tj;
                    placebet24h=placebet24h-tj;
                    placebet27h=placebet27h-tj;
                    placebet30h=placebet30h-tj;
                    placebet33h=placebet33h-tj;
                    placebet36h=placebet36h-tj;




                    placebet2to11=placebet2to11-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet2to11);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button2to11.setText(pd);
                    button2to11.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);

                    updateValues.put("/2to11",placebet2to11); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button2to12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                double tj =bet;
                tj=tj/12;
                placebet2h=placebet2h+tj;
                placebet5h=placebet5h+tj;
                placebet8h= placebet8h+tj;
                placebet11h=placebet11h+tj;
                placebet14h=placebet14h+tj;
                placebet17h=placebet17h+tj;
                placebet20h=placebet20h+tj;
                placebet23h=placebet23h+tj;
                placebet26h=placebet26h+tj;
                placebet29h=placebet29h+tj;
                placebet32h=placebet32h+tj;
                placebet35h=placebet35h+tj;




                placebet2to12=placebet2to12+bet;
                if(placebet2to12==-9){
                    button2to12.setText("0");
                }
                if(placebet2to12>5000.0){
                    placebet2h=placebet2h-tj;
                    placebet5h=placebet5h-tj;
                    placebet8h= placebet8h-tj;
                    placebet11h=placebet11h-tj;
                    placebet14h=placebet14h-tj;
                    placebet17h=placebet17h-tj;
                    placebet20h=placebet20h-tj;
                    placebet23h=placebet23h-tj;
                    placebet26h=placebet26h-tj;
                    placebet29h=placebet29h-tj;
                    placebet32h=placebet32h-tj;
                    placebet35h=placebet35h-tj;
                    placebet2to12=placebet2to12-bet;


                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet2to12);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button2to12.setText(pd);
                    button2to12.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);

                    updateValues.put("/2to12",placebet2to12); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button2to13.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {

                double tj =bet;
                tj=tj/12;
                placebet1h=placebet1h+tj;
                placebet4h=placebet4h+tj;
                placebet7h= placebet7h+tj;
                placebet10h=placebet10h+tj;
                placebet13h=placebet13h+tj;
                placebet16h=placebet16h+tj;
                placebet19h=placebet19h+tj;
                placebet22h=placebet22h+tj;
                placebet25h=placebet25h+tj;
                placebet28h=placebet28h+tj;
                placebet31h=placebet31h+tj;
                placebet34h=placebet34h+tj;


                placebet2to13=placebet2to13+bet;


                if(placebet2to13==-9){
                    button2to13.setText("0");
                }
                if(placebet2to13>5000.0){
                    placebet1h=placebet1h-tj;
                    placebet4h=placebet4h-tj;
                    placebet7h= placebet7h-tj;
                    placebet10h=placebet10h-tj;
                    placebet13h=placebet13h-tj;
                    placebet16h=placebet16h-tj;
                    placebet19h=placebet19h-tj;
                    placebet22h=placebet22h-tj;
                    placebet25h=placebet25h-tj;
                    placebet28h=placebet28h-tj;
                    placebet31h=placebet31h-tj;
                    placebet34h=placebet34h-tj;







                    placebet2to13=placebet2to13-bet;


                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet2to13);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button2to13.setText(pd);
                    button2to13.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/2to13",placebet2to13); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button1st12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                double tj =bet;
                tj=tj/12;

                placebet1h=placebet1h+tj;
                placebet2h=placebet2h+tj;
                placebet3h=placebet3h+tj;
                placebet4h=placebet4h+tj;
                placebet5h=placebet5h+tj;
                placebet6h=placebet6h+tj;
                placebet7h=placebet7h+tj;
                placebet8h=placebet8h+tj;
                placebet9h=placebet9h+tj;
                placebet10h=placebet10h+tj;
                placebet11h=placebet11h+tj;
                placebet12h=placebet12h+tj;

                placebet1st12=placebet1st12+bet;
                if(placebet1st12==-9){
                    button1st12.setText("0");
                }
                if(placebet1st12>5000.0){

                    placebet1h=placebet1h-tj;
                    placebet2h=placebet2h-tj;
                    placebet3h=placebet3h-tj;
                    placebet4h=placebet4h-tj;
                    placebet5h=placebet5h-tj;
                    placebet6h=placebet6h-tj;
                    placebet7h=placebet7h-tj;
                    placebet8h=placebet8h-tj;
                    placebet9h=placebet9h-tj;
                    placebet10h=placebet10h-tj;
                    placebet11h=placebet11h-tj;
                    placebet12h=placebet12h-tj;


                    placebet1st12=placebet1st12-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet1st12);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button1st12.setText(pd);
                    button1st12.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/1st12",placebet1st12); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button2nd12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                double tj =bet;
                tj=tj/12;

                placebet13h=placebet13h+tj;
                placebet14h=placebet14h+tj;
                placebet15h=placebet15h+tj;
                placebet16h=placebet16h+tj;
                placebet17h=placebet17h+tj;
                placebet18h=placebet18h+tj;
                placebet19h=placebet19h+tj;
                placebet20h=placebet20h+tj;
                placebet21h=placebet21h+tj;
                placebet22h=placebet22h+tj;
                placebet23h=placebet23h+tj;
                placebet24h=placebet24h+tj;

                placebet2nd12=placebet2nd12+bet;
                if(placebet2nd12==-9){
                    button2nd12.setText("0");
                }
                if(placebet2nd12>5000.0){
                    placebet13h=placebet13h-tj;
                    placebet14h=placebet14h-tj;
                    placebet15h=placebet15h-tj;
                    placebet16h=placebet16h-tj;
                    placebet17h=placebet17h-tj;
                    placebet18h=placebet18h-tj;
                    placebet19h=placebet19h-tj;
                    placebet20h=placebet20h-tj;
                    placebet21h=placebet21h-tj;
                    placebet22h=placebet22h-tj;
                    placebet23h=placebet23h-tj;
                    placebet24h=placebet24h-tj;


                    placebet2nd12=placebet2nd12-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet2nd12);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button2nd12.setText(pd);
                    button2nd12.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/2nd12",placebet2nd12); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button3rd12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                double tj =bet;
                tj=tj/12;

                placebet25h=placebet25h+tj;
                placebet26h=placebet26h+tj;
                placebet27h=placebet27h+tj;
                placebet28h=placebet28h+tj;
                placebet29h=placebet29h+tj;
                placebet30h=placebet30h+tj;
                placebet31h=placebet31h+tj;
                placebet32h=placebet32h+tj;
                placebet33h=placebet33h+tj;
                placebet34h=placebet35h+tj;
                placebet35h=placebet35h+tj;
                placebet36h=placebet36h+tj;


                placebet3rd12=placebet3rd12+bet;
                if(placebet3rd12==-9){
                    button3rd12.setText("0");
                }
                if(placebet3rd12>5000.0){
                    placebet25h=placebet25h-tj;
                    placebet26h=placebet26h-tj;
                    placebet27h=placebet27h-tj;
                    placebet28h=placebet28h-tj;
                    placebet29h=placebet29h-tj;
                    placebet30h=placebet30h-tj;
                    placebet31h=placebet31h-tj;
                    placebet32h=placebet32h-tj;
                    placebet33h=placebet33h-tj;
                    placebet34h=placebet34h-tj;
                    placebet35h=placebet35h-tj;
                    placebet36h=placebet36h-tj;

                    placebet3rd12=placebet3rd12-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet3rd12);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button3rd12.setText(pd);
                    button3rd12.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/3rd12",placebet3rd12); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button1to18.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                double tj =bet;
                tj=tj/18;
                placebet1h=placebet1h+tj;
                placebet2h=placebet2h+tj;
                placebet3h=placebet3h+tj;
                placebet4h=placebet4h+tj;
                placebet5h=placebet5h+tj;
                placebet6h=placebet6h+tj;
                placebet7h=placebet7h+tj;
                placebet8h=placebet8h+tj;
                placebet9h=placebet9h+tj;
                placebet10h=placebet10h+tj;
                placebet11h=placebet11h+tj;
                placebet12h=placebet12h+tj;
                placebet13h=placebet13h+tj;
                placebet14h=placebet14h+tj;
                placebet15h=placebet15h+tj;
                placebet16h=placebet16h+tj;
                placebet17h=placebet17h+tj;
                placebet18h=placebet18h+tj;

                placebet1to18=placebet1to18+bet;
                if(placebet1to18==-9){
                    button1to18.setText("0");
                }
                if(placebet1to18>5000.0){

                    placebet1h=placebet1h-tj;
                    placebet2h=placebet2h-tj;
                    placebet3h=placebet3h-tj;
                    placebet4h=placebet4h-tj;
                    placebet5h=placebet5h-tj;
                    placebet6h=placebet6h-tj;
                    placebet7h=placebet7h-tj;
                    placebet8h=placebet8h-tj;
                    placebet9h=placebet9h-tj;
                    placebet10h=placebet10h-tj;
                    placebet11h=placebet11h-tj;
                    placebet12h=placebet12h-tj;
                    placebet13h=placebet13h-tj;
                    placebet14h=placebet14h-tj;
                    placebet15h=placebet15h-tj;
                    placebet16h=placebet16h-tj;
                    placebet17h=placebet17h-tj;
                    placebet18h=placebet18h-tj;




                    placebet1to18=placebet1to18-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet1to18);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button1to18.setText(pd);
                    button1to18.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);

                    updateValues.put("/1to18",placebet1to18); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        button19to36.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                double tj =bet;
                tj=tj/18;

                placebet19h=placebet19h+tj;
                placebet20h=placebet20h+tj;
                placebet21h=placebet21h+tj;
                placebet22h=placebet22h+tj;
                placebet23h=placebet23h+tj;
                placebet24h=placebet24h+tj;

                placebet25h=placebet25h+tj;
                placebet26h=placebet26h+tj;
                placebet27h=placebet27h+tj;
                placebet28h=placebet28h+tj;
                placebet29h=placebet29h+tj;
                placebet30h=placebet30h+tj;
                placebet31h=placebet31h+tj;
                placebet32h=placebet32h+tj;
                placebet33h=placebet33h+tj;
                placebet36h=placebet36h+tj;
                placebet35h=placebet35h+tj;
                placebet36h=placebet36h+tj;

                placebet19to36=placebet19to36+bet;
                if(placebet19to36==-9){
                    button19to36.setText("0");
                }
                if(placebet19to36>5000.0){
                    placebet19h=placebet19h-tj;
                    placebet20h=placebet20h-tj;
                    placebet21h=placebet21h-tj;
                    placebet22h=placebet22h-tj;
                    placebet23h=placebet23h-tj;
                    placebet24h=placebet24h-tj;

                    placebet25h=placebet25h-tj;
                    placebet26h=placebet26h-tj;
                    placebet27h=placebet27h-tj;
                    placebet28h=placebet28h-tj;
                    placebet29h=placebet29h-tj;
                    placebet30h=placebet30h-tj;
                    placebet31h=placebet31h-tj;
                    placebet32h=placebet32h-tj;
                    placebet33h=placebet33h-tj;
                    placebet36h=placebet36h-tj;
                    placebet35h=placebet35h-tj;
                    placebet36h=placebet36h-tj;


                    placebet19to36=placebet19to36-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebet19to36);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    button19to36.setText(pd);
                    button19to36.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/19to36",placebet19to36); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        buttoneven.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                double tj =bet;
                tj=tj/18;

                placebet2h=placebet2h+tj;
                placebet4h=placebet4h+tj;
                placebet6h=placebet6h+tj;
                placebet8h=placebet8h+tj;
                placebet10h=placebet10h+tj;
                placebet12h=placebet12h+tj;
                placebet14h=placebet14h+tj;
                placebet16h=placebet16h+tj;
                placebet18h=placebet18h+tj;
                placebet20h=placebet20h+tj;
                placebet22h=placebet22h+tj;
                placebet24h=placebet24h+tj;
                placebet26h=placebet26h+tj;
                placebet28h=placebet28h+tj;
                placebet30h=placebet30h+tj;
                placebet32h=placebet32h+tj;
                placebet36h=placebet36h+tj;
                placebet36h=placebet36h+tj;



                placebeteven=placebeteven+bet;
                if(placebeteven==-9){;
                    buttoneven.setText("0");
                }
                if(placebeteven>5000.0){

                    placebet2h=placebet2h-tj;
                    placebet4h=placebet4h-tj;
                    placebet6h=placebet6h-tj;
                    placebet8h=placebet8h-tj;
                    placebet10h=placebet10h-tj;
                    placebet12h=placebet12h-tj;
                    placebet14h=placebet14h-tj;
                    placebet16h=placebet16h-tj;
                    placebet18h=placebet18h-tj;
                    placebet20h=placebet20h-tj;
                    placebet22h=placebet22h-tj;
                    placebet24h=placebet24h-tj;
                    placebet26h=placebet26h-tj;
                    placebet28h=placebet28h-tj;
                    placebet30h=placebet30h-tj;
                    placebet32h=placebet32h-tj;
                    placebet36h=placebet36h-tj;
                    placebet36h=placebet36h-tj;

                    placebeteven=placebeteven-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebeteven);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    buttoneven.setText(pd);
                    buttoneven.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/even",placebeteven); myref5.updateChildren(updateValues); } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        buttonodd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                double tj =bet;
                tj=tj/18;

                placebet1h=placebet1h+tj;
                placebet3h=placebet3h+tj;
                placebet5h=placebet5h+tj;
                placebet7h=placebet7h+tj;
                placebet9h=placebet9h+tj;
                placebet11h=placebet11h+tj;
                placebet13h=placebet13h+tj;
                placebet15h=placebet15h+tj;
                placebet17h=placebet17h+tj;
                placebet19h=placebet19h+tj;
                placebet21h=placebet21h+tj;
                placebet23h=placebet23h+tj;
                placebet25h=placebet25h+tj;
                placebet27h=placebet27h+tj;
                placebet29h=placebet29h+tj;
                placebet31h=placebet31h+tj;
                placebet33h=placebet33h+tj;
                placebet35h=placebet35h+tj;



                placebetodd=placebetodd+bet;
                if(placebetodd==-9){
                    buttonodd.setText("0");
                }
                if(placebetodd>5000.0){
                    placebet1h=placebet1h-tj;
                    placebet3h=placebet3h-tj;
                    placebet5h=placebet5h-tj;
                    placebet7h=placebet7h-tj;
                    placebet9h=placebet9h-tj;
                    placebet11h=placebet11h-tj;
                    placebet13h=placebet13h-tj;
                    placebet15h=placebet15h-tj;
                    placebet17h=placebet17h-tj;
                    placebet19h=placebet19h-tj;
                    placebet21h=placebet21h-tj;
                    placebet23h=placebet23h-tj;
                    placebet25h=placebet25h-tj;
                    placebet27h=placebet27h-tj;
                    placebet29h=placebet29h-tj;
                    placebet31h=placebet31h-tj;
                    placebet33h=placebet33h-tj;
                    placebet35h=placebet35h-tj;


                    placebetodd=placebetodd-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebetodd);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    buttonodd.setText(pd);
                    buttonodd.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/odd",placebetodd); myref5.updateChildren(updateValues);} } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        buttonred.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                double tj =bet;
                tj=tj/18;

                placebet1h=placebet1h+tj;
                placebet3h=placebet3h+tj;
                placebet5h=placebet5h+tj;
                placebet7h=placebet7h+tj;
                placebet9h=placebet9h+tj;
                placebet12h=placebet12h+tj;
                placebet14h=placebet14h+tj;
                placebet16h=placebet16h+tj;
                placebet18h=placebet18h+tj;
                placebet19h=placebet19h+tj;
                placebet21h=placebet21h+tj;
                placebet23h=placebet23h+tj;
                placebet25h=placebet25h+tj;
                placebet27h=placebet27h+tj;
                placebet30h=placebet30h+tj;
                placebet32h=placebet32h+tj;
                placebet34h=placebet34h+tj;
                placebet36h=placebet36h+tj;
                Toast.makeText(Roullete.this, ""+placebet36h, Toast.LENGTH_SHORT).show();

                placebetr=placebetr+bet;
                if(placebetr==-9){
                    buttonred.setText("0");
                }
                if(placebetr>5000.0){

                    placebet1h=placebet1h-tj;
                    placebet3h=placebet3h-tj;
                    placebet5h=placebet5h-tj;
                    placebet7h=placebet7h-tj;
                    placebet9h=placebet9h-tj;
                    placebet12h=placebet12h-tj;
                    placebet14h=placebet14h-tj;
                    placebet16h=placebet16h-tj;
                    placebet18h=placebet18h-tj;
                    placebet19h=placebet19h-tj;
                    placebet21h=placebet21h-tj;
                    placebet23h=placebet23h-tj;
                    placebet25h=placebet25h-tj;
                    placebet27h=placebet27h-tj;
                    placebet30h=placebet30h-tj;
                    placebet32h=placebet32h-tj;
                    placebet36h=placebet36h-tj;
                    placebet36h=placebet36h-tj;


                    placebetr=placebetr-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebetr);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);

                    buttonred.setText(pd);
                    buttonred.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/red",placebetr); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Balance", Toast.LENGTH_SHORT).show(); } } });

        buttonblack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { checkConnection(); if(bet<point) {
                double tj =bet;
                tj=tj/18;

                placebet2h=placebet2h+tj;
                placebet4h=placebet4h+tj;
                placebet6h=placebet6h+tj;
                placebet8h=placebet8h+tj;
                placebet10h=placebet10h+tj;
                placebet11h=placebet11h+tj;
                placebet13h=placebet13h+tj;
                placebet15h=placebet15h+tj;
                placebet17h=placebet17h+tj;
                placebet20h=placebet20h+tj;
                placebet22h=placebet22h+tj;
                placebet24h=placebet24h+tj;
                placebet26h=placebet26h+tj;
                placebet28h=placebet28h+tj;
                placebet29h=placebet29h+tj;
                placebet31h=placebet31h+tj;
                placebet33h=placebet33h+tj;
                placebet35h=placebet35h+tj;
                placebetb=placebetb+bet;
                if(placebetb==-9){
                    buttonblack.setText("0");
                }
                if(placebetb>5000.0){
                    placebet2h=placebet2h-tj;
                    placebet4h=placebet4h-tj;
                    placebet6h=placebet6h-tj;
                    placebet8h=placebet8h-tj;
                    placebet10h=placebet10h-tj;
                    placebet11h=placebet11h-tj;
                    placebet13h=placebet13h-tj;
                    placebet15h=placebet15h-tj;
                    placebet17h=placebet17h-tj;
                    placebet20h=placebet20h-tj;
                    placebet22h=placebet22h-tj;
                    placebet24h=placebet24h-tj;
                    placebet26h=placebet26h-tj;
                    placebet28h=placebet28h-tj;
                    placebet29h=placebet29h-tj;
                    placebet31h=placebet31h-tj;
                    placebet33h=placebet33h-tj;
                    placebet35h=placebet35h-tj;


                    placebetb=placebetb-bet;
                    Toast.makeText(Roullete.this, "Max Bet 5000", Toast.LENGTH_SHORT).show();
                }

                else{
                    point= point-bet;
                    String p= String.valueOf(point);

                    String pb = String.valueOf(placebetb);
                    final String pd = pb.replace(".0",""); availablep.setText(pd);
                    buttonblack.setText(pd);
                    buttonblack.setTextColor(Color.YELLOW);
                    double rg = placebet0+placebet00+placebet1+placebet2+placebet3+placebet4+placebet5+placebet6+placebet7+placebet8+placebet9+placebet10+placebet11+
                            placebet12+placebet13+placebet14+placebet15+placebet16+placebet17+placebet18+placebet19+placebet20+placebet21+placebet22+placebet23+placebet24+
                            placebet25+placebet26+placebet27+placebet28+placebet29+placebet30+placebet31+placebet32+placebet33+placebet34+placebet35+placebet36+placebet1h+placebet2h+placebet3h+placebet4h+placebet5h+placebet6h+placebet7h+placebet8h+placebet9h+placebet10h+placebet11h+placebet12h+placebet13h+placebet14h+placebet15h+placebet16h+placebet17h+placebet18h+placebet19h+placebet20h+placebet21h+placebet22h+placebet23h+placebet24h+placebet25h+placebet26h+placebet27h+placebet28h+placebet29h+placebet30h+placebet31h+placebet32h+placebet33h+placebet34h+placebet35h+placebet36h
                            ;
                    double tob=Math.round(rg); tobet=tob; tbet.setText(""+tobet);  Map<String,Object> updateValues = new HashMap<>(); updateValues.put("/points",point); myref.updateChildren(updateValues);
                    updateValues.put("/black",placebetb); myref5.updateChildren(updateValues);
                } } else { Toast.makeText(Roullete.this, "Insufficient Points", Toast.LENGTH_SHORT).show(); } } });





















        bcancel.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View v) { checkConnection();
                final String Userg = getIntent().getStringExtra("user");
                final String usera = Userg.replace("@", "");
                final String usern = usera.replace(".", "");
                final DatabaseReference myref5;
                FirebaseDatabase mFirebaseDatabase1 = FirebaseDatabase.getInstance();
                myref5 = mFirebaseDatabase1.getInstance().getReference().child("Bets").child(usern);


                Map<String, Object> updateValues1 = new HashMap<>();
                updateValues1 = new HashMap<>();
                for (int i = 0; i < 37; i++) {
                    updateValues1.put("/" + i, 0);
                    myref5.updateChildren(updateValues1);
                }
                updateValues1.put("/00", 0);
                updateValues1.put("/2to11", 0);
                updateValues1.put("/2to12", 0);
                updateValues1.put("/2to13", 0);
                updateValues1.put("/1to18A", 0);
                updateValues1.put("/even", 0);
                updateValues1.put("/red", 0);
                updateValues1.put("/black", 0);
                updateValues1.put("/odd", 0);
                updateValues1.put("/19to36", 0);
                updateValues1.put("/1st12", 0);
                updateValues1.put("/2nd12", 0);
                updateValues1.put("/3rd12", 0);

                myref5.updateChildren(updateValues1);

                point=point+tobet;
                tobet=0.0;
                Map<String,Object> updateValues = new HashMap<>();

                updateValues.put("/points",point);

                myref.updateChildren(updateValues);
                reset();
            }});
        betlock.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) { checkConnection();
                if(tobet>0) {
                    betlock.setEnabled(false);
                }
                else if(tobet==0){
                    betlock.setEnabled(true);
                }
                button0.setEnabled(false);
                button00.setEnabled(false);
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);
                button10.setEnabled(false);
                button11.setEnabled(false);
                button12.setEnabled(false);
                button13.setEnabled(false);
                button14.setEnabled(false);
                button15.setEnabled(false);
                button16.setEnabled(false);
                button17.setEnabled(false);
                button18.setEnabled(false);
                button19.setEnabled(false);
                button20.setEnabled(false);
                button21.setEnabled(false);
                button22.setEnabled(false);
                button23.setEnabled(false);
                button24.setEnabled(false);
                button25.setEnabled(false);
                button26.setEnabled(false);
                button27.setEnabled(false);
                button28.setEnabled(false);
                button29.setEnabled(false);
                button30.setEnabled(false);
                button31.setEnabled(false);
                button32.setEnabled(false);
                button33.setEnabled(false);
                button34.setEnabled(false);
                button35.setEnabled(false);
                button36.setEnabled(false);
                button1st12.setEnabled(false);
                button2nd12.setEnabled(false);
                button3rd12.setEnabled(false);
                button1to18.setEnabled(false);
                buttoneven.setEnabled(false);
                buttonodd.setEnabled(false);
                buttonred.setEnabled(false);
                buttonblack.setEnabled(false);
                button19to36.setEnabled(false);
                button2to11.setEnabled(false);
                button2to12.setEnabled(false);
                button2to13.setEnabled(false);
                buttontake.setEnabled(false);
                bcancel.setEnabled(false);

            }});




        btake.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) { checkConnection();




                point = point + winnedd ;
                availablep.setText(""+point);
                winning.setText(""+00);
                winnedd=0.0;
                btake.setEnabled(false);




                Map<String,Object> updateValues = new HashMap<>();
                updateValues.put("/take",winnedd);
                updateValues.put("/points",point);

                Map<String,Object> updateValues1 = new HashMap<>();

                updateValues1.put("/points",point);

                myref.updateChildren(updateValues);
                myref5.updateChildren(updateValues1);
                reset();

                button0.setEnabled(true);
                button00.setEnabled(true);
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(true);
                button4.setEnabled(true);
                button5.setEnabled(true);
                button6.setEnabled(true);
                button7.setEnabled(true);
                button8.setEnabled(true);
                button9.setEnabled(true);
                button10.setEnabled(true);
                button11.setEnabled(true);
                button12.setEnabled(true);
                button13.setEnabled(true);
                button14.setEnabled(true);
                button15.setEnabled(true);
                button16.setEnabled(true);
                button17.setEnabled(true);
                button18.setEnabled(true);
                button19.setEnabled(true);
                button20.setEnabled(true);
                button21.setEnabled(true);
                button22.setEnabled(true);
                button23.setEnabled(true);
                button24.setEnabled(true);
                button25.setEnabled(true);
                button26.setEnabled(true);
                button27.setEnabled(true);
                button28.setEnabled(true);
                button29.setEnabled(true);
                button30.setEnabled(true);
                button31.setEnabled(true);
                button32.setEnabled(true);
                button33.setEnabled(true);
                button34.setEnabled(true);
                button35.setEnabled(true);
                button36.setEnabled(true);
                button1st12.setEnabled(true);
                button2nd12.setEnabled(true);
                button3rd12.setEnabled(true);
                button1to18.setEnabled(true);
                buttoneven.setEnabled(true);
                buttonodd.setEnabled(true);
                buttonred.setEnabled(true);
                buttonblack.setEnabled(true);
                button19to36.setEnabled(true);
                button2to11.setEnabled(true);
                button2to12.setEnabled(true);
                button2to13.setEnabled(true);
                buttontake.setEnabled(false);
                buttontake.setBackgroundColor(Color.GREEN);
                bcancel.setEnabled(true);
                buttonexit.setEnabled(true);








            }});



        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //for wheel Rotate


        EditText1 =(EditText)findViewById(R.id.open1);
        EditText2 =(EditText)findViewById(R.id.open2);
        EditText3 =(EditText)findViewById(R.id.open3);
        EditText4 =(EditText)findViewById(R.id.open4);
        EditText5 =(EditText)findViewById(R.id.open5);



        iv_wheel = (ImageView) findViewById(R.id.roulletewheel);

        r = new Random();





    }

    private  void startTimer(){

        timeLeftMillis=60000;

        countDownTimer =new CountDownTimer(timeLeftMillis,1000) {
            @Override

            public void onTick(long millisUntilFinished) {

                final DatabaseReference myref6;
                FirebaseDatabase mFirebaseDatabase=FirebaseDatabase.getInstance();
                myref6=mFirebaseDatabase.getInstance().getReference().child("timer");
                timeLeftMillis = millisUntilFinished;
                Map<String,Object> updateValues = new HashMap<>();
                updateValues.put("second",timeLeftMillis);

                myref6.updateChildren(updateValues);



                updateCountDownText();

            }



            @Override
            public void onFinish() {
                timeLeftMillis = 30000;

                startTimer();


            }
        }.start();
        timeRunning = true;

    }


    private void updateCountDownText() {
        try{
            minutes = 00;
            seconds = (int) (timeLeftMillis / 1000) % 60;


            if (seconds == 11) {

                final MediaPlayer mysong2 = MediaPlayer.create(Roullete.this, R.raw.tentozero);
                mysong2.start();
            }
            if (timeLeftMillis > 11000) {
                final MediaPlayer mysong = MediaPlayer.create(Roullete.this, R.raw.time);
                mysong.start();
            }

            if (seconds == 9) {


                FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
                final DatabaseReference myref20 = mFirebaseDatabase.getInstance().getReference().child("Bets");
                myref20.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {

                            Map<String, Object> map = (Map<String, Object>) ds.getValue();
                            Object placebet0j = map.get("0");
                            Object placebet00j = map.get("00");
                            Object placebet1j = map.get("1");
                            Object placebet2j = map.get("2");
                            Object placebet3j = map.get("3");
                            Object placebet4j = map.get("4");
                            Object placebet5j = map.get("5");
                            Object placebet6j = map.get("6");
                            Object placebet7j = map.get("7");
                            Object placebet8j = map.get("8");
                            Object placebet9j = map.get("9");
                            Object placebet10j = map.get("10");
                            Object placebet11j = map.get("11");
                            Object placebet12j = map.get("12");
                            Object placebet13j = map.get("13");
                            Object placebet14j = map.get("14");
                            Object placebet15j = map.get("15");
                            Object placebet16j = map.get("16");
                            Object placebet17j = map.get("17");
                            Object placebet18j = map.get("18");
                            Object placebet19j = map.get("19");
                            Object placebet20j = map.get("20");
                            Object placebet21j = map.get("21");
                            Object placebet22j = map.get("22");
                            Object placebet23j = map.get("23");
                            Object placebet24j = map.get("24");
                            Object placebet25j = map.get("25");
                            Object placebet26j = map.get("26");
                            Object placebet27j = map.get("27");
                            Object placebet28j = map.get("28");
                            Object placebet29j = map.get("29");
                            Object placebet30j = map.get("30");
                            Object placebet31j = map.get("31");
                            Object placebet32j = map.get("32");
                            Object placebet33j = map.get("33");
                            Object placebet34j = map.get("34");
                            Object placebet35j = map.get("35");
                            Object placebet36j = map.get("36");


                            Double pq0 = Double.parseDouble(String.valueOf(placebet0j));
                            Double pq00 = Double.parseDouble(String.valueOf(placebet00j));
                            Double pq1 = Double.parseDouble(String.valueOf(placebet1j));
                            Double pq2 = Double.parseDouble(String.valueOf(placebet2j));
                            Double pq3 = Double.parseDouble(String.valueOf(placebet3j));
                            Double pq4 = Double.parseDouble(String.valueOf(placebet4j));
                            Double pq5 = Double.parseDouble(String.valueOf(placebet5j));
                            Double pq6 = Double.parseDouble(String.valueOf(placebet6j));
                            Double pq7 = Double.parseDouble(String.valueOf(placebet7j));
                            Double pq8 = Double.parseDouble(String.valueOf(placebet8j));
                            Double pq9 = Double.parseDouble(String.valueOf(placebet9j));
                            Double pq10 = Double.parseDouble(String.valueOf(placebet10j));
                            Double pq11 = Double.parseDouble(String.valueOf(placebet11j));
                            Double pq12 = Double.parseDouble(String.valueOf(placebet12j));
                            Double pq13 = Double.parseDouble(String.valueOf(placebet13j));
                            Double pq14 = Double.parseDouble(String.valueOf(placebet14j));
                            Double pq15 = Double.parseDouble(String.valueOf(placebet15j));
                            Double pq16 = Double.parseDouble(String.valueOf(placebet16j));
                            Double pq17 = Double.parseDouble(String.valueOf(placebet17j));
                            Double pq18 = Double.parseDouble(String.valueOf(placebet18j));
                            Double pq19 = Double.parseDouble(String.valueOf(placebet19j));
                            Double pq20 = Double.parseDouble(String.valueOf(placebet20j));
                            Double pq21 = Double.parseDouble(String.valueOf(placebet21j));
                            Double pq22 = Double.parseDouble(String.valueOf(placebet22j));
                            Double pq23 = Double.parseDouble(String.valueOf(placebet23j));
                            Double pq24 = Double.parseDouble(String.valueOf(placebet24j));
                            Double pq25 = Double.parseDouble(String.valueOf(placebet25j));
                            Double pq26 = Double.parseDouble(String.valueOf(placebet26j));
                            Double pq27 = Double.parseDouble(String.valueOf(placebet27j));
                            Double pq28 = Double.parseDouble(String.valueOf(placebet28j));
                            Double pq29 = Double.parseDouble(String.valueOf(placebet29j));
                            Double pq30 = Double.parseDouble(String.valueOf(placebet30j));
                            Double pq31 = Double.parseDouble(String.valueOf(placebet31j));
                            Double pq32 = Double.parseDouble(String.valueOf(placebet32j));
                            Double pq33 = Double.parseDouble(String.valueOf(placebet33j));
                            Double pq34 = Double.parseDouble(String.valueOf(placebet34j));
                            Double pq35 = Double.parseDouble(String.valueOf(placebet35j));
                            Double pq36 = Double.parseDouble(String.valueOf(placebet36j));


                            placebet0 += pq0;
                            pq0 = 0.0;
                            placebet00 += pq00;

                            placebet1 += pq1;
                            placebet2 += pq2;
                            placebet3 += pq3;
                            placebet4 += pq4;
                            placebet5 += pq5;
                            placebet6 += pq6;
                            placebet7 += pq7;
                            placebet8 += pq8;
                            placebet9 += pq9;
                            placebet10 += pq10;
                            placebet11 += pq11;
                            placebet12 += pq12;
                            placebet13 += pq13;
                            placebet14 += pq14;
                            placebet15 += pq15;
                            placebet16 += pq16;
                            placebet17 += pq17;
                            placebet18 += pq18;
                            placebet19 += pq19;
                            placebet20 += pq20;
                            placebet21 += pq21;
                            placebet22 += pq22;
                            placebet23 += pq23;
                            placebet24 += pq24;
                            placebet25 += pq25;
                            placebet26 += pq26;
                            placebet27 += pq27;
                            placebet28 += pq28;
                            placebet29 += pq29;
                            placebet30 += pq30;
                            placebet31 += pq31;
                            placebet32 += pq32;
                            placebet33 += pq33;
                            placebet34 += pq34;
                            placebet35 += pq35;
                            placebet36 += pq36;


                           /* pq0=0.0; pq00=0.0; pq1=0.0;pq2=0.0;pq3=0.0;pq4=0.0;pq5=0.0;pq6=0.0;pq7=0.0;pq8=0.0;pq9=0.0;pq10=0.0;pq11=0.0;
                            pq25=0.0;pq24=0.0;pq23=0.0;pq22=0.0;pq21=0.0;pq20=0.0;pq19=0.0;pq18=0.0;pq17=0.0;pq16=0.0;pq15=0.0;pq14=0.0;pq13=0.0;pq12=0.0;
                            pq26=0.0;pq27=0.0;pq28=0.0;pq29=0.0;pq30=0.0;pq31=0.0;pq32=0.0;pq33=0.0;pq34=0.0;pq35=0.0;pq36=0.0;*/


                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(Roullete.this, "Something went wrong", Toast.LENGTH_SHORT).show();

                    }
                });


            }

            if (seconds == 4) {
                final DatabaseReference myref9;
                FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
                myref9 = mFirebaseDatabase.getInstance().getReference().child("betsplay");
                ij = ij + 1;
                Map<String, Object> updateValues = new HashMap<>();
                updateValues.put("/betsplayed", ij);
                myref9.updateChildren(updateValues);

                degree_old = degree % 360;

                if (howtoplay.equals("kl")) {


                    if (placebet0 > 0 || placebet00 > 0 || placebet1 > 0 || placebet2 > 0 || placebet3 > 0 || placebet4 > 0 || placebet5 > 0 || placebet6 > 0 || placebet7 > 0 || placebet8 > 0 ||
                            placebet9 > 0 || placebet10 > 0 || placebet11 > 0 || placebet12 > 0 || placebet13 > 0 || placebet14 > 0 || placebet15 > 0 || placebet16 > 0 || placebet17 > 0 || placebet18 > 0 ||
                            placebet19 > 0 || placebet20 > 0 || placebet21 > 0 || placebet22 > 0 || placebet23 > 0 || placebet24 > 0 || placebet25 > 0 || placebet26 > 0 ||
                            placebet27 > 0 || placebet28 > 0 || placebet29 > 0 || placebet30 > 0 || placebet31 > 0 || placebet32 > 0 || placebet33 > 0 || placebet34 > 0 ||
                            placebet35 > 0 || placebet36 > 0) {
                        if (placebet1h == 0 && placebet2h == 0 && placebet3h == 0 && placebet4h == 0 && placebet5h == 0 && placebet6h == 0 && placebet7h == 0 && placebet8h == 0 &&
                                placebet9h == 0 && placebet10h == 0 && placebet11h == 0 && placebet12h == 0 && placebet13h == 0 && placebet14h == 0 && placebet15h == 0 && placebet16h == 0 && placebet17h == 0 && placebet18h == 0 &&
                                placebet19h == 0 && placebet20h == 0 && placebet21h == 0 && placebet22h == 0 && placebet23h == 0 && placebet24h == 0 && placebet25h == 0 && placebet26h == 0 &&
                                placebet27h == 0 && placebet28h == 0 && placebet29h == 0 && placebet30h == 0 && placebet31h == 0 && placebet32h == 0 && placebet33h == 0 && placebet34h == 0 &&
                                placebet35h == 0 && placebet36h == 0


                        ) {
                            double ae[] = new double[39];

                            ae[1] = placebet1;
                            ae[2] = placebet2;
                            ae[3] = placebet3;
                            ae[4] = placebet4;
                            ae[5] = placebet5;
                            ae[6] = placebet6;
                            ae[7] = placebet7;
                            ae[8] = placebet8;
                            ae[9] = placebet9;
                            ae[10] = placebet10;
                            ae[11] = placebet11;
                            ae[12] = placebet12;
                            ae[13] = placebet13;
                            ae[14] = placebet14;
                            ae[15] = placebet15;
                            ae[16] = placebet16;
                            ae[17] = placebet17;
                            ae[18] = placebet18;
                            ae[19] = placebet19;
                            ae[20] = placebet20;
                            ae[21] = placebet21;
                            ae[22] = placebet22;
                            ae[23] = placebet23;
                            ae[24] = placebet24;
                            ae[25] = placebet25;
                            ae[26] = placebet26;
                            ae[27] = placebet27;
                            ae[28] = placebet28;
                            ae[29] = placebet29;
                            ae[30] = placebet30;
                            ae[31] = placebet31;
                            ae[32] = placebet32;
                            ae[33] = placebet33;
                            ae[34] = placebet34;
                            ae[35] = placebet35;
                            ae[36] = placebet36;
                            ae[37] = placebet0;
                            ae[38] = placebet00;
                            double minimum = ae[1];

                            int location = 0;
                            int n = 1;


                            for (int i = 1; i <= 38; i++) {

                                if (ae[i] <= minimum) {
                                    minimum = ae[i];

                                    location = i;


                                }
                            }
                            for (int i = 1; i <= 38; i++) {

                                if (ae[location] == ae[i]) {
                                    n++;


                                }
                            }

                            int lg[] = new int[n];
                            int j = 1;
                            for (int i = 1; i <= 38; i++) {
                                if (ae[location] == ae[i]) {
                                    lg[j] = i;
                                    j++;

                                }
                            }


                            Random dice = new Random();
                            int num;
                            num = dice.nextInt(n);
                            location = lg[num];


                            if (location == 37) {
                                degree = 3600 + 264;
                            }
                            if (location == 38) {
                                degree = 3600 + 447;
                            }
                            if (location == 1) {
                                degree = 3600 + 457;

                            }
                            if (location == 2) {
                                degree = 3600 + 273;
                            }
                            if (location == 3) {
                                degree = 3600 + 133;
                            }
                            if (location == 4) {
                                degree = 3600 + 314;
                            }
                            if (location == 5) {
                                degree = 3600 + 172;
                            }
                            if (location == 6) {
                                degree = 3600 + 354;
                            }
                            if (location == 7) {
                                degree = 3600 + 211;
                            }
                            if (location == 8) {
                                degree = 3600 + 387;

                            }
                            if (location == 9) {
                                degree = 3600 + 248;
                            }
                            if (location == 10) {
                                degree = 3600 + 427;
                            }
                            if (location == 11) {
                                degree = 3600 + 221;
                            }

                            if (location == 12) {
                                degree = 3600 + 397;
                            }

                            if (location == 13) {
                                degree = 3600 + 467;
                            }

                            if (location == 14) {
                                degree = 3600 + 284;
                            }

                            if (location == 15) {
                                degree = 3600 + 142;
                            }

                            if (location == 16) {
                                degree = 3600 + 324;
                            }

                            if (location == 17) {
                                degree = 3600 + 182;
                            }

                            if (location == 18) {
                                degree = 3600 + 363;
                            }

                            if (location == 19) {
                                degree = 3600 + 380;
                            }

                            if (location == 20) {
                                degree = 3600 + 202;
                            }
                            if (location == 21) {
                                degree = 3600 + 344;
                            }

                            if (location == 22) {
                                degree = 3600 + 162;
                            }

                            if (location == 23) {
                                degree = 3600 + 304;
                            }

                            if (location == 24) {
                                degree = 3600 + 122;
                            }

                            if (location == 25) {
                                degree = 3600 + 417;
                            }

                            if (location == 26) {
                                degree = 3600 + 240;
                            }

                            if (location == 27) {
                                degree = 3600 + 437;
                            }

                            if (location == 28) {
                                degree = 3600 + 255;
                            }

                            if (location == 29) {
                                degree = 3600 + 407;
                            }

                            if (location == 30) {
                                degree = 3600 + 230;
                            }
                            if (location == 31) {
                                degree = 3600 + 373;
                            }

                            if (location == 32) {
                                degree = 3600 + 192;
                            }

                            if (location == 33) {
                                degree = 3600 + 334;
                            }

                            if (location == 34) {
                                degree = 3600 + 152;
                            }

                            if (location == 35) {
                                degree = 3600 + 294;
                            }

                            if (location == 36) {
                                degree = 3600 + 477;
                            }
                        }


                    }
                    if (placebet0 > 0 || placebet00 > 0 || placebet1 > 0 || placebet2 > 0 || placebet3 > 0 || placebet4 > 0 || placebet5 > 0 || placebet6 > 0 || placebet7 > 0 || placebet8 > 0 ||
                            placebet9 > 0 || placebet10 > 0 || placebet11 > 0 || placebet12 > 0 || placebet13 > 0 || placebet14 > 0 || placebet15 > 0 || placebet16 > 0 || placebet17 > 0 || placebet18 > 0 ||
                            placebet19 > 0 || placebet20 > 0 || placebet21 > 0 || placebet22 > 0 || placebet23 > 0 || placebet24 > 0 || placebet25 > 0 || placebet26 > 0 ||
                            placebet27 > 0 || placebet28 > 0 || placebet29 > 0 || placebet30 > 0 || placebet31 > 0 || placebet32 > 0 || placebet33 > 0 || placebet34 > 0 ||
                            placebet35 > 0 || placebet36 > 0 || placebet1h > 0 || placebet2h > 0 || placebet3h > 0 || placebet4h > 0 || placebet5h > 0 || placebet6h > 0 || placebet7h > 0 || placebet8h > 0 ||
                            placebet9h > 0 || placebet10h > 0 || placebet11h > 0 || placebet12h > 0 || placebet13h > 0 || placebet14h > 0 || placebet15h > 0 || placebet16h > 0 || placebet17h > 0 || placebet18h > 0 ||
                            placebet19h > 0 || placebet20h > 0 || placebet21h > 0 || placebet22h > 0 || placebet23h > 0 || placebet24h > 0 || placebet25h > 0 || placebet26h > 0 ||
                            placebet27h > 0 || placebet28h > 0 || placebet29h > 0 || placebet30h > 0 || placebet31h > 0 || placebet32h > 0 || placebet33h > 0 || placebet34h > 0 ||
                            placebet35h > 0 || placebet36h > 0) {
                        double ae[] = new double[39];

                        ae[1] = placebet1 + placebet1h;
                        ae[2] = placebet2 + placebet2h;
                        ae[3] = placebet3 + placebet3h;
                        ae[4] = placebet4 + placebet4h;
                        ae[5] = placebet5 + placebet5h;
                        ae[6] = placebet6 + placebet6h;
                        ae[7] = placebet7 + placebet7h;
                        ae[8] = placebet8 + placebet8h;
                        ae[9] = placebet9 + placebet9h;
                        ae[10] = placebet10 + placebet10h;
                        ae[11] = placebet11 + placebet11h;
                        ae[12] = placebet12 + placebet12h;
                        ae[13] = placebet13 + placebet13h;
                        ae[14] = placebet14 + placebet14h;
                        ae[15] = placebet15 + placebet15h;
                        ae[16] = placebet16 + placebet16h;
                        ae[17] = placebet17 + placebet17h;
                        ae[18] = placebet18 + placebet18h;
                        ae[19] = placebet19 + placebet19h;
                        ae[20] = placebet20 + placebet20h;
                        ae[21] = placebet21 + placebet21h;
                        ae[22] = placebet22 + placebet22h;
                        ae[23] = placebet23 + placebet23h;
                        ae[24] = placebet24 + placebet24h;
                        ae[25] = placebet25 + placebet25h;
                        ae[26] = placebet26 + placebet26h;
                        ae[27] = placebet27 + placebet27h;
                        ae[28] = placebet28 + placebet28h;
                        ae[29] = placebet29 + placebet29h;
                        ae[30] = placebet30 + placebet30h;
                        ae[31] = placebet31 + placebet31h;
                        ae[32] = placebet32 + placebet32h;
                        ae[33] = placebet33 + placebet33h;
                        ae[34] = placebet34 + placebet34h;
                        ae[35] = placebet35 + placebet35h;
                        ae[36] = placebet36 + placebet36h;
                        ae[37] = placebet0;
                        ae[38] = placebet00;


                        double minimum = ae[1];

                        int location = 0;
                        int n = 1;


                        for (int i = 1; i <= 38; i++) {

                            if (ae[i] <= minimum) {
                                minimum = ae[i];

                                location = i;


                            }
                        }
                        for (int i = 1; i <= 38; i++) {

                            if (ae[location] == ae[i]) {
                                n++;


                            }
                        }

                        int lg[] = new int[n];
                        int j = 1;
                        for (int i = 1; i <= 38; i++) {
                            if (ae[location] == ae[i]) {
                                lg[j] = i;
                                j++;

                            }
                        }


                        Random dice = new Random();
                        int num;
                        num = dice.nextInt(n);
                        location = lg[num];


                        if (location == 37) {
                            degree = 3600 + 264;
                        }
                        if (location == 38) {
                            degree = 3600 + 447;
                        }
                        if (location == 1) {
                            degree = 3600 + 457;

                        }
                        if (location == 2) {
                            degree = 3600 + 273;
                        }
                        if (location == 3) {
                            degree = 3600 + 133;
                        }
                        if (location == 4) {
                            degree = 3600 + 314;
                        }
                        if (location == 5) {
                            degree = 3600 + 172;
                        }
                        if (location == 6) {
                            degree = 3600 + 354;
                        }
                        if (location == 7) {
                            degree = 3600 + 211;
                        }
                        if (location == 8) {
                            degree = 3600 + 387;

                        }
                        if (location == 9) {
                            degree = 3600 + 248;
                        }
                        if (location == 10) {
                            degree = 3600 + 427;
                        }
                        if (location == 11) {
                            degree = 3600 + 221;
                        }

                        if (location == 12) {
                            degree = 3600 + 397;
                        }

                        if (location == 13) {
                            degree = 3600 + 467;
                        }

                        if (location == 14) {
                            degree = 3600 + 284;
                        }

                        if (location == 15) {
                            degree = 3600 + 142;
                        }

                        if (location == 16) {
                            degree = 3600 + 324;
                        }

                        if (location == 17) {
                            degree = 3600 + 182;
                        }

                        if (location == 18) {
                            degree = 3600 + 363;
                        }

                        if (location == 19) {
                            degree = 3600 + 380;
                        }

                        if (location == 20) {
                            degree = 3600 + 202;
                        }
                        if (location == 21) {
                            degree = 3600 + 344;
                        }

                        if (location == 22) {
                            degree = 3600 + 162;
                        }

                        if (location == 23) {
                            degree = 3600 + 304;
                        }

                        if (location == 24) {
                            degree = 3600 + 122;
                        }

                        if (location == 25) {
                            degree = 3600 + 417;
                        }

                        if (location == 26) {
                            degree = 3600 + 240;
                        }

                        if (location == 27) {
                            degree = 3600 + 437;
                        }

                        if (location == 28) {
                            degree = 3600 + 255;
                        }

                        if (location == 29) {
                            degree = 3600 + 407;
                        }

                        if (location == 30) {
                            degree = 3600 + 230;
                        }
                        if (location == 31) {
                            degree = 3600 + 373;
                        }

                        if (location == 32) {
                            degree = 3600 + 192;
                        }

                        if (location == 33) {
                            degree = 3600 + 334;
                        }

                        if (location == 34) {
                            degree = 3600 + 152;
                        }

                        if (location == 35) {
                            degree = 3600 + 294;
                        }

                        if (location == 36) {
                            degree = 3600 + 477;
                        }


                    }
                    if (placebet1h == 0 && placebet2h == 0 && placebet3h == 0 && placebet4h == 0 && placebet5h == 0 && placebet6h == 0 && placebet7h == 0 && placebet8h == 0 &&
                            placebet9h == 0 && placebet10h == 0 && placebet11h == 0 && placebet12h == 0 && placebet13h == 0 && placebet14h == 0 && placebet15h == 0 && placebet16h == 0 && placebet17h == 0 && placebet18h == 0 &&
                            placebet19h == 0 && placebet20h == 0 && placebet21h == 0 && placebet22h == 0 && placebet23h == 0 && placebet24h == 0 && placebet25h == 0 && placebet26h == 0 &&
                            placebet27h == 0 && placebet28h == 0 && placebet29h == 0 && placebet30h == 0 && placebet31h == 0 && placebet32h == 0 && placebet33h == 0 && placebet34h == 0 &&
                            placebet35h == 0 && placebet36h == 0 && placebet1 == 0 && placebet2 == 0 && placebet3 == 0 && placebet4 == 0 && placebet5 == 0 && placebet6 == 0 && placebet7 == 0 && placebet8 == 0 &&
                            placebet9 == 0 && placebet10 == 0 && placebet11 == 0 && placebet12 == 0 && placebet13 == 0 && placebet14 == 0 && placebet15 == 0 && placebet16 == 0 && placebet17 == 0 && placebet18 == 0 &&
                            placebet19 == 0 && placebet20 == 0 && placebet21 == 0 && placebet22 == 0 && placebet23 == 0 && placebet24 == 0 && placebet25 == 0 && placebet26 == 0 &&
                            placebet27 == 0 && placebet28 == 0 && placebet29 == 0 && placebet30 == 0 && placebet31 == 0 && placebet32 == 0 && placebet33 == 0 && placebet34 == 0 &&
                            placebet35 == 0 && placebet36 == 0


                    ) {

                        degree = r.nextInt(3600) + 720;

                    }


                    if (placebet1h > 0 || placebet2h > 0 || placebet3h > 0 || placebet4h > 0 || placebet5h > 0 || placebet6h > 0 || placebet7h > 0 || placebet8h > 0 ||
                            placebet9h > 0 || placebet10h > 0 || placebet11h > 0 || placebet12h > 0 || placebet13h > 0 || placebet14h > 0 || placebet15h > 0 || placebet16h > 0 || placebet17h > 0 || placebet18h > 0 ||
                            placebet19h > 0 || placebet20h > 0 || placebet21h > 0 || placebet22h > 0 || placebet23h > 0 || placebet24h > 0 || placebet25h > 0 || placebet26h > 0 ||
                            placebet27h > 0 || placebet28h > 0 || placebet29h > 0 || placebet30h > 0 || placebet31h > 0 || placebet32h > 0 || placebet33h > 0 || placebet34h > 0 ||
                            placebet35h > 0 || placebet36h > 0

                    ) {
                        if (placebet1 == 0 && placebet2 == 0 && placebet3 == 0 && placebet4 == 0 && placebet5 == 0 && placebet6 == 0 && placebet7 == 0 && placebet8 == 0 &&
                                placebet9 == 0 && placebet10 == 0 && placebet11 == 0 && placebet12 == 0 && placebet13 == 0 && placebet14 == 0 && placebet15 == 0 && placebet16 == 0 && placebet17 == 0 && placebet18 == 0 &&
                                placebet19 == 0 && placebet20 == 0 && placebet21 == 0 && placebet22 == 0 && placebet23 == 0 && placebet24 == 0 && placebet25 == 0 && placebet26 == 0 &&
                                placebet27 == 0 && placebet28 == 0 && placebet29 == 0 && placebet30 == 0 && placebet31 == 0 && placebet32 == 0 && placebet33 == 0 && placebet34 == 0 &&
                                placebet35 == 0 && placebet36 == 0


                        ) {
                            double ae1[] = new double[37];
                            int n = 1;

                            ae1[1] = placebet1h;
                            ae1[2] = placebet2h;
                            ae1[3] = placebet3h;
                            ae1[4] = placebet4h;
                            ae1[5] = placebet5h;
                            ae1[6] = placebet6h;
                            ae1[7] = placebet7h;
                            ae1[8] = placebet8h;
                            ae1[9] = placebet9h;
                            ae1[10] = placebet10h;
                            ae1[11] = placebet11h;
                            ae1[12] = placebet12h;
                            ae1[13] = placebet13h;
                            ae1[14] = placebet14h;
                            ae1[15] = placebet15h;
                            ae1[16] = placebet16h;
                            ae1[17] = placebet17h;
                            ae1[18] = placebet18h;
                            ae1[19] = placebet19h;
                            ae1[20] = placebet20h;
                            ae1[21] = placebet21h;
                            ae1[22] = placebet22h;
                            ae1[23] = placebet23h;
                            ae1[24] = placebet24h;
                            ae1[25] = placebet25h;
                            ae1[26] = placebet26h;
                            ae1[27] = placebet27h;
                            ae1[28] = placebet28h;
                            ae1[29] = placebet29h;
                            ae1[30] = placebet30h;
                            ae1[31] = placebet31h;
                            ae1[32] = placebet32h;
                            ae1[33] = placebet33h;
                            ae1[34] = placebet34h;
                            ae1[35] = placebet35h;
                            ae1[36] = placebet36h;
                            double min = ae1[1];

                            int loc = 0;
                            for (int i = 1; i <= 36; i++) {

                                if (ae1[i] <= min) {
                                    min = ae1[i];
                                    loc = i;


                                }
                            }
                            for (int i = 1; i <= 36; i++) {

                                if (ae1[loc] == ae1[i]) {
                                    n++;


                                }
                            }

                            int lg[] = new int[n];
                            int j = 1;
                            for (int i = 1; i <= 36; i++) {
                                if (ae1[loc] == ae1[i]) {
                                    lg[j] = i;
                                    j++;

                                }
                            }


                            Random dice = new Random();
                            int num;
                            num = dice.nextInt(n);
                            loc = lg[num];
                            if (loc == 1) {
                                degree = 3600 + 457;

                            }
                            if (loc == 2) {
                                degree = 3600 + 273;
                            }
                            if (loc == 3) {
                                degree = 3600 + 133;
                            }
                            if (loc == 4) {
                                degree = 3600 + 314;
                            }
                            if (loc == 5) {
                                degree = 3600 + 172;
                            }
                            if (loc == 6) {
                                degree = 3600 + 354;
                            }
                            if (loc == 7) {
                                degree = 3600 + 211;
                            }
                            if (loc == 8) {
                                degree = 3600 + 387;

                            }
                            if (loc == 9) {
                                degree = 3600 + 248;
                            }
                            if (loc == 10) {
                                degree = 3600 + 427;
                            }
                            if (loc == 11) {
                                degree = 3600 + 221;
                            }

                            if (loc == 12) {
                                degree = 3600 + 397;
                            }

                            if (loc == 13) {
                                degree = 3600 + 467;
                            }

                            if (loc == 14) {
                                degree = 3600 + 284;
                            }

                            if (loc == 15) {
                                degree = 3600 + 142;
                            }

                            if (loc == 16) {
                                degree = 3600 + 324;
                            }

                            if (loc == 17) {
                                degree = 3600 + 182;
                            }

                            if (loc == 18) {
                                degree = 3600 + 363;
                            }

                            if (loc == 19) {
                                degree = 3600 + 380;
                            }

                            if (loc == 20) {
                                degree = 3600 + 202;
                            }
                            if (loc == 21) {
                                degree = 3600 + 344;
                            }

                            if (loc == 22) {
                                degree = 3600 + 162;
                            }

                            if (loc == 23) {
                                degree = 3600 + 304;
                            }

                            if (loc == 24) {
                                degree = 3600 + 122;
                            }

                            if (loc == 25) {
                                degree = 3600 + 417;
                            }

                            if (loc == 26) {
                                degree = 3600 + 240;
                            }

                            if (loc == 27) {
                                degree = 3600 + 437;
                            }

                            if (loc == 28) {
                                degree = 3600 + 255;
                            }

                            if (loc == 29) {
                                degree = 3600 + 407;
                            }

                            if (loc == 30) {
                                degree = 3600 + 230;
                            }
                            if (loc == 31) {
                                degree = 3600 + 373;
                            }

                            if (loc == 32) {
                                degree = 3600 + 192;
                            }

                            if (loc == 33) {
                                degree = 3600 + 334;
                            }

                            if (loc == 34) {
                                degree = 3600 + 152;
                            }

                            if (loc == 35) {
                                degree = 3600 + 294;
                            }

                            if (loc == 36) {
                                degree = 3600 + 477;
                            }


                        }


                    }


                }

                if (howtoplay.equals("jkl")) {


                    if (placebet0 > 0 || placebet00 > 0 || placebet1 > 0 || placebet2 > 0 || placebet3 > 0 || placebet4 > 0 || placebet5 > 0 || placebet6 > 0 || placebet7 > 0 || placebet8 > 0 ||
                            placebet9 > 0 || placebet10 > 0 || placebet11 > 0 || placebet12 > 0 || placebet13 > 0 || placebet14 > 0 || placebet15 > 0 || placebet16 > 0 || placebet17 > 0 || placebet18 > 0 ||
                            placebet19 > 0 || placebet20 > 0 || placebet21 > 0 || placebet22 > 0 || placebet23 > 0 || placebet24 > 0 || placebet25 > 0 || placebet26 > 0 ||
                            placebet27 > 0 || placebet28 > 0 || placebet29 > 0 || placebet30 > 0 || placebet31 > 0 || placebet32 > 0 || placebet33 > 0 || placebet34 > 0 ||
                            placebet35 > 0 || placebet36 > 0) {
                        if (placebet1h == 0 && placebet2h == 0 && placebet3h == 0 && placebet4h == 0 && placebet5h == 0 && placebet6h == 0 && placebet7h == 0 && placebet8h == 0 &&
                                placebet9h == 0 && placebet10h == 0 && placebet11h == 0 && placebet12h == 0 && placebet13h == 0 && placebet14h == 0 && placebet15h == 0 && placebet16h == 0 && placebet17h == 0 && placebet18h == 0 &&
                                placebet19h == 0 && placebet20h == 0 && placebet21h == 0 && placebet22h == 0 && placebet23h == 0 && placebet24h == 0 && placebet25h == 0 && placebet26h == 0 &&
                                placebet27h == 0 && placebet28h == 0 && placebet29h == 0 && placebet30h == 0 && placebet31h == 0 && placebet32h == 0 && placebet33h == 0 && placebet34h == 0 &&
                                placebet35h == 0 && placebet36h == 0


                        ) {
                            double ae[] = new double[39];

                            ae[1] = placebet1;
                            ae[2] = placebet2;
                            ae[3] = placebet3;
                            ae[4] = placebet4;
                            ae[5] = placebet5;
                            ae[6] = placebet6;
                            ae[7] = placebet7;
                            ae[8] = placebet8;
                            ae[9] = placebet9;
                            ae[10] = placebet10;
                            ae[11] = placebet11;
                            ae[12] = placebet12;
                            ae[13] = placebet13;
                            ae[14] = placebet14;
                            ae[15] = placebet15;
                            ae[16] = placebet16;
                            ae[17] = placebet17;
                            ae[18] = placebet18;
                            ae[19] = placebet19;
                            ae[20] = placebet20;
                            ae[21] = placebet21;
                            ae[22] = placebet22;
                            ae[23] = placebet23;
                            ae[24] = placebet24;
                            ae[25] = placebet25;
                            ae[26] = placebet26;
                            ae[27] = placebet27;
                            ae[28] = placebet28;
                            ae[29] = placebet29;
                            ae[30] = placebet30;
                            ae[31] = placebet31;
                            ae[32] = placebet32;
                            ae[33] = placebet33;
                            ae[34] = placebet34;
                            ae[35] = placebet35;
                            ae[36] = placebet36;
                            ae[37] = placebet0;
                            ae[38] = placebet00;
                            double minimum = 0;
                            for (int i = 1; i <= 38; i++) {
                                if (ae[i] != 0) {
                                    minimum = ae[i];
                                    break;
                                }
                            }


                            int location = 0;
                            int n = 1;
                            Toast.makeText(Roullete.this, "rrrrrrrr", Toast.LENGTH_SHORT).show();

                            for (int i = 1; i <= 38; i++) {

                                if (ae[i] <= minimum && ae[i] > 0) {
                                    minimum = ae[i];

                                    location = i;


                                }
                            }
                            for (int i = 1; i <= 38; i++) {

                                if (ae[location] == ae[i]) {
                                    n++;


                                }
                            }

                            int lg[] = new int[n];
                            int j = 1;
                            for (int i = 1; i <= 38; i++) {
                                if (ae[location] == ae[i]) {
                                    lg[j] = i;
                                    j++;

                                }
                            }


                            Random dice = new Random();
                            int num;
                            num = dice.nextInt(n);
                            location = lg[num];


                            if (location == 37) {
                                degree = 3600 + 264;
                            }
                            if (location == 38) {
                                degree = 3600 + 447;
                            }
                            if (location == 1) {
                                degree = 3600 + 457;

                            }
                            if (location == 2) {
                                degree = 3600 + 273;
                            }
                            if (location == 3) {
                                degree = 3600 + 133;
                            }
                            if (location == 4) {
                                degree = 3600 + 314;
                            }
                            if (location == 5) {
                                degree = 3600 + 172;
                            }
                            if (location == 6) {
                                degree = 3600 + 354;
                            }
                            if (location == 7) {
                                degree = 3600 + 211;
                            }
                            if (location == 8) {
                                degree = 3600 + 387;

                            }
                            if (location == 9) {
                                degree = 3600 + 248;
                            }
                            if (location == 10) {
                                degree = 3600 + 427;
                            }
                            if (location == 11) {
                                degree = 3600 + 221;
                            }

                            if (location == 12) {
                                degree = 3600 + 397;
                            }

                            if (location == 13) {
                                degree = 3600 + 467;
                            }

                            if (location == 14) {
                                degree = 3600 + 284;
                            }

                            if (location == 15) {
                                degree = 3600 + 142;
                            }

                            if (location == 16) {
                                degree = 3600 + 324;
                            }

                            if (location == 17) {
                                degree = 3600 + 182;
                            }

                            if (location == 18) {
                                degree = 3600 + 363;
                            }

                            if (location == 19) {
                                degree = 3600 + 380;
                            }

                            if (location == 20) {
                                degree = 3600 + 202;
                            }
                            if (location == 21) {
                                degree = 3600 + 344;
                            }

                            if (location == 22) {
                                degree = 3600 + 162;
                            }

                            if (location == 23) {
                                degree = 3600 + 304;
                            }

                            if (location == 24) {
                                degree = 3600 + 122;
                            }

                            if (location == 25) {
                                degree = 3600 + 417;
                            }

                            if (location == 26) {
                                degree = 3600 + 240;
                            }

                            if (location == 27) {
                                degree = 3600 + 437;
                            }

                            if (location == 28) {
                                degree = 3600 + 255;
                            }

                            if (location == 29) {
                                degree = 3600 + 407;
                            }

                            if (location == 30) {
                                degree = 3600 + 230;
                            }
                            if (location == 31) {
                                degree = 3600 + 373;
                            }

                            if (location == 32) {
                                degree = 3600 + 192;
                            }

                            if (location == 33) {
                                degree = 3600 + 334;
                            }

                            if (location == 34) {
                                degree = 3600 + 152;
                            }

                            if (location == 35) {
                                degree = 3600 + 294;
                            }

                            if (location == 36) {
                                degree = 3600 + 477;
                            }
                        }


                    }
                    if (placebet0 > 0 || placebet00 > 0 || placebet1 > 0 || placebet2 > 0 || placebet3 > 0 || placebet4 > 0 || placebet5 > 0 || placebet6 > 0 || placebet7 > 0 || placebet8 > 0 ||
                            placebet9 > 0 || placebet10 > 0 || placebet11 > 0 || placebet12 > 0 || placebet13 > 0 || placebet14 > 0 || placebet15 > 0 || placebet16 > 0 || placebet17 > 0 || placebet18 > 0 ||
                            placebet19 > 0 || placebet20 > 0 || placebet21 > 0 || placebet22 > 0 || placebet23 > 0 || placebet24 > 0 || placebet25 > 0 || placebet26 > 0 ||
                            placebet27 > 0 || placebet28 > 0 || placebet29 > 0 || placebet30 > 0 || placebet31 > 0 || placebet32 > 0 || placebet33 > 0 || placebet34 > 0 ||
                            placebet35 > 0 || placebet36 > 0 || placebet1h > 0 || placebet2h > 0 || placebet3h > 0 || placebet4h > 0 || placebet5h > 0 || placebet6h > 0 || placebet7h > 0 || placebet8h > 0 ||
                            placebet9h > 0 || placebet10h > 0 || placebet11h > 0 || placebet12h > 0 || placebet13h > 0 || placebet14h > 0 || placebet15h > 0 || placebet16h > 0 || placebet17h > 0 || placebet18h > 0 ||
                            placebet19h > 0 || placebet20h > 0 || placebet21h > 0 || placebet22h > 0 || placebet23h > 0 || placebet24h > 0 || placebet25h > 0 || placebet26h > 0 ||
                            placebet27h > 0 || placebet28h > 0 || placebet29h > 0 || placebet30h > 0 || placebet31h > 0 || placebet32h > 0 || placebet33h > 0 || placebet34h > 0 ||
                            placebet35h > 0 || placebet36h > 0) {
                        double ae[] = new double[39];

                        ae[1] = placebet1 + placebet1h;
                        ae[2] = placebet2 + placebet2h;
                        ae[3] = placebet3 + placebet3h;
                        ae[4] = placebet4 + placebet4h;
                        ae[5] = placebet5 + placebet5h;
                        ae[6] = placebet6 + placebet6h;
                        ae[7] = placebet7 + placebet7h;
                        ae[8] = placebet8 + placebet8h;
                        ae[9] = placebet9 + placebet9h;
                        ae[10] = placebet10 + placebet10h;
                        ae[11] = placebet11 + placebet11h;
                        ae[12] = placebet12 + placebet12h;
                        ae[13] = placebet13 + placebet13h;
                        ae[14] = placebet14 + placebet14h;
                        ae[15] = placebet15 + placebet15h;
                        ae[16] = placebet16 + placebet16h;
                        ae[17] = placebet17 + placebet17h;
                        ae[18] = placebet18 + placebet18h;
                        ae[19] = placebet19 + placebet19h;
                        ae[20] = placebet20 + placebet20h;
                        ae[21] = placebet21 + placebet21h;
                        ae[22] = placebet22 + placebet22h;
                        ae[23] = placebet23 + placebet23h;
                        ae[24] = placebet24 + placebet24h;
                        ae[25] = placebet25 + placebet25h;
                        ae[26] = placebet26 + placebet26h;
                        ae[27] = placebet27 + placebet27h;
                        ae[28] = placebet28 + placebet28h;
                        ae[29] = placebet29 + placebet29h;
                        ae[30] = placebet30 + placebet30h;
                        ae[31] = placebet31 + placebet31h;
                        ae[32] = placebet32 + placebet32h;
                        ae[33] = placebet33 + placebet33h;
                        ae[34] = placebet34 + placebet34h;
                        ae[35] = placebet35 + placebet35h;
                        ae[36] = placebet36 + placebet36h;
                        ae[37] = placebet0;
                        ae[38] = placebet00;


                        double minimum = ae[1];

                        int location = 0;
                        int n = 1;


                        for (int i = 1; i <= 38; i++) {

                            if (ae[i] <= minimum) {
                                minimum = ae[i];

                                location = i;


                            }
                        }
                        for (int i = 1; i <= 38; i++) {

                            if (ae[location] == ae[i]) {
                                n++;


                            }
                        }

                        int lg[] = new int[n];
                        int j = 1;
                        for (int i = 1; i <= 38; i++) {
                            if (ae[location] == ae[i]) {
                                lg[j] = i;
                                j++;

                            }
                        }


                        Random dice = new Random();
                        int num;
                        num = dice.nextInt(n);
                        location = lg[num];


                        if (location == 37) {
                            degree = 3600 + 264;
                        }
                        if (location == 38) {
                            degree = 3600 + 447;
                        }
                        if (location == 1) {
                            degree = 3600 + 457;

                        }
                        if (location == 2) {
                            degree = 3600 + 273;
                        }
                        if (location == 3) {
                            degree = 3600 + 133;
                        }
                        if (location == 4) {
                            degree = 3600 + 314;
                        }
                        if (location == 5) {
                            degree = 3600 + 172;
                        }
                        if (location == 6) {
                            degree = 3600 + 354;
                        }
                        if (location == 7) {
                            degree = 3600 + 211;
                        }
                        if (location == 8) {
                            degree = 3600 + 387;

                        }
                        if (location == 9) {
                            degree = 3600 + 248;
                        }
                        if (location == 10) {
                            degree = 3600 + 427;
                        }
                        if (location == 11) {
                            degree = 3600 + 221;
                        }

                        if (location == 12) {
                            degree = 3600 + 397;
                        }

                        if (location == 13) {
                            degree = 3600 + 467;
                        }

                        if (location == 14) {
                            degree = 3600 + 284;
                        }

                        if (location == 15) {
                            degree = 3600 + 142;
                        }

                        if (location == 16) {
                            degree = 3600 + 324;
                        }

                        if (location == 17) {
                            degree = 3600 + 182;
                        }

                        if (location == 18) {
                            degree = 3600 + 363;
                        }

                        if (location == 19) {
                            degree = 3600 + 380;
                        }

                        if (location == 20) {
                            degree = 3600 + 202;
                        }
                        if (location == 21) {
                            degree = 3600 + 344;
                        }

                        if (location == 22) {
                            degree = 3600 + 162;
                        }

                        if (location == 23) {
                            degree = 3600 + 304;
                        }

                        if (location == 24) {
                            degree = 3600 + 122;
                        }

                        if (location == 25) {
                            degree = 3600 + 417;
                        }

                        if (location == 26) {
                            degree = 3600 + 240;
                        }

                        if (location == 27) {
                            degree = 3600 + 437;
                        }

                        if (location == 28) {
                            degree = 3600 + 255;
                        }

                        if (location == 29) {
                            degree = 3600 + 407;
                        }

                        if (location == 30) {
                            degree = 3600 + 230;
                        }
                        if (location == 31) {
                            degree = 3600 + 373;
                        }

                        if (location == 32) {
                            degree = 3600 + 192;
                        }

                        if (location == 33) {
                            degree = 3600 + 334;
                        }

                        if (location == 34) {
                            degree = 3600 + 152;
                        }

                        if (location == 35) {
                            degree = 3600 + 294;
                        }

                        if (location == 36) {
                            degree = 3600 + 477;
                        }


                    }
                    if (placebet1h == 0 && placebet2h == 0 && placebet3h == 0 && placebet4h == 0 && placebet5h == 0 && placebet6h == 0 && placebet7h == 0 && placebet8h == 0 &&
                            placebet9h == 0 && placebet10h == 0 && placebet11h == 0 && placebet12h == 0 && placebet13h == 0 && placebet14h == 0 && placebet15h == 0 && placebet16h == 0 && placebet17h == 0 && placebet18h == 0 &&
                            placebet19h == 0 && placebet20h == 0 && placebet21h == 0 && placebet22h == 0 && placebet23h == 0 && placebet24h == 0 && placebet25h == 0 && placebet26h == 0 &&
                            placebet27h == 0 && placebet28h == 0 && placebet29h == 0 && placebet30h == 0 && placebet31h == 0 && placebet32h == 0 && placebet33h == 0 && placebet34h == 0 &&
                            placebet35h == 0 && placebet36h == 0 && placebet1 == 0 && placebet2 == 0 && placebet3 == 0 && placebet4 == 0 && placebet5 == 0 && placebet6 == 0 && placebet7 == 0 && placebet8 == 0 &&
                            placebet9 == 0 && placebet10 == 0 && placebet11 == 0 && placebet12 == 0 && placebet13 == 0 && placebet14 == 0 && placebet15 == 0 && placebet16 == 0 && placebet17 == 0 && placebet18 == 0 &&
                            placebet19 == 0 && placebet20 == 0 && placebet21 == 0 && placebet22 == 0 && placebet23 == 0 && placebet24 == 0 && placebet25 == 0 && placebet26 == 0 &&
                            placebet27 == 0 && placebet28 == 0 && placebet29 == 0 && placebet30 == 0 && placebet31 == 0 && placebet32 == 0 && placebet33 == 0 && placebet34 == 0 &&
                            placebet35 == 0 && placebet36 == 0


                    ) {

                        degree = r.nextInt(3600) + 720;

                    }


                    if (placebet1h > 0 || placebet2h > 0 || placebet3h > 0 || placebet4h > 0 || placebet5h > 0 || placebet6h > 0 || placebet7h > 0 || placebet8h > 0 ||
                            placebet9h > 0 || placebet10h > 0 || placebet11h > 0 || placebet12h > 0 || placebet13h > 0 || placebet14h > 0 || placebet15h > 0 || placebet16h > 0 || placebet17h > 0 || placebet18h > 0 ||
                            placebet19h > 0 || placebet20h > 0 || placebet21h > 0 || placebet22h > 0 || placebet23h > 0 || placebet24h > 0 || placebet25h > 0 || placebet26h > 0 ||
                            placebet27h > 0 || placebet28h > 0 || placebet29h > 0 || placebet30h > 0 || placebet31h > 0 || placebet32h > 0 || placebet33h > 0 || placebet34h > 0 ||
                            placebet35h > 0 || placebet36h > 0

                    ) {
                        if (placebet1 == 0 && placebet2 == 0 && placebet3 == 0 && placebet4 == 0 && placebet5 == 0 && placebet6 == 0 && placebet7 == 0 && placebet8 == 0 &&
                                placebet9 == 0 && placebet10 == 0 && placebet11 == 0 && placebet12 == 0 && placebet13 == 0 && placebet14 == 0 && placebet15 == 0 && placebet16 == 0 && placebet17 == 0 && placebet18 == 0 &&
                                placebet19 == 0 && placebet20 == 0 && placebet21 == 0 && placebet22 == 0 && placebet23 == 0 && placebet24 == 0 && placebet25 == 0 && placebet26 == 0 &&
                                placebet27 == 0 && placebet28 == 0 && placebet29 == 0 && placebet30 == 0 && placebet31 == 0 && placebet32 == 0 && placebet33 == 0 && placebet34 == 0 &&
                                placebet35 == 0 && placebet36 == 0


                        ) {
                            double ae1[] = new double[37];
                            int n = 1;

                            ae1[1] = placebet1h;
                            ae1[2] = placebet2h;
                            ae1[3] = placebet3h;
                            ae1[4] = placebet4h;
                            ae1[5] = placebet5h;
                            ae1[6] = placebet6h;
                            ae1[7] = placebet7h;
                            ae1[8] = placebet8h;
                            ae1[9] = placebet9h;
                            ae1[10] = placebet10h;
                            ae1[11] = placebet11h;
                            ae1[12] = placebet12h;
                            ae1[13] = placebet13h;
                            ae1[14] = placebet14h;
                            ae1[15] = placebet15h;
                            ae1[16] = placebet16h;
                            ae1[17] = placebet17h;
                            ae1[18] = placebet18h;
                            ae1[19] = placebet19h;
                            ae1[20] = placebet20h;
                            ae1[21] = placebet21h;
                            ae1[22] = placebet22h;
                            ae1[23] = placebet23h;
                            ae1[24] = placebet24h;
                            ae1[25] = placebet25h;
                            ae1[26] = placebet26h;
                            ae1[27] = placebet27h;
                            ae1[28] = placebet28h;
                            ae1[29] = placebet29h;
                            ae1[30] = placebet30h;
                            ae1[31] = placebet31h;
                            ae1[32] = placebet32h;
                            ae1[33] = placebet33h;
                            ae1[34] = placebet34h;
                            ae1[35] = placebet35h;
                            ae1[36] = placebet36h;
                            double min = ae1[1];

                            int loc = 0;
                            for (int i = 1; i <= 36; i++) {

                                if (ae1[i] <= min) {
                                    min = ae1[i];
                                    loc = i;


                                }
                            }
                            for (int i = 1; i <= 36; i++) {

                                if (ae1[loc] == ae1[i]) {
                                    n++;


                                }
                            }

                            int lg[] = new int[n];
                            int j = 1;
                            for (int i = 1; i <= 36; i++) {
                                if (ae1[loc] == ae1[i]) {
                                    lg[j] = i;
                                    j++;

                                }
                            }


                            Random dice = new Random();
                            int num;
                            num = dice.nextInt(n);
                            loc = lg[num];
                            if (loc == 1) {
                                degree = 3600 + 457;

                            }
                            if (loc == 2) {
                                degree = 3600 + 273;
                            }
                            if (loc == 3) {
                                degree = 3600 + 133;
                            }
                            if (loc == 4) {
                                degree = 3600 + 314;
                            }
                            if (loc == 5) {
                                degree = 3600 + 172;
                            }
                            if (loc == 6) {
                                degree = 3600 + 354;
                            }
                            if (loc == 7) {
                                degree = 3600 + 211;
                            }
                            if (loc == 8) {
                                degree = 3600 + 387;

                            }
                            if (loc == 9) {
                                degree = 3600 + 248;
                            }
                            if (loc == 10) {
                                degree = 3600 + 427;
                            }
                            if (loc == 11) {
                                degree = 3600 + 221;
                            }

                            if (loc == 12) {
                                degree = 3600 + 397;
                            }

                            if (loc == 13) {
                                degree = 3600 + 467;
                            }

                            if (loc == 14) {
                                degree = 3600 + 284;
                            }

                            if (loc == 15) {
                                degree = 3600 + 142;
                            }

                            if (loc == 16) {
                                degree = 3600 + 324;
                            }

                            if (loc == 17) {
                                degree = 3600 + 182;
                            }

                            if (loc == 18) {
                                degree = 3600 + 363;
                            }

                            if (loc == 19) {
                                degree = 3600 + 380;
                            }

                            if (loc == 20) {
                                degree = 3600 + 202;
                            }
                            if (loc == 21) {
                                degree = 3600 + 344;
                            }

                            if (loc == 22) {
                                degree = 3600 + 162;
                            }

                            if (loc == 23) {
                                degree = 3600 + 304;
                            }

                            if (loc == 24) {
                                degree = 3600 + 122;
                            }

                            if (loc == 25) {
                                degree = 3600 + 417;
                            }

                            if (loc == 26) {
                                degree = 3600 + 240;
                            }

                            if (loc == 27) {
                                degree = 3600 + 437;
                            }

                            if (loc == 28) {
                                degree = 3600 + 255;
                            }

                            if (loc == 29) {
                                degree = 3600 + 407;
                            }

                            if (loc == 30) {
                                degree = 3600 + 230;
                            }
                            if (loc == 31) {
                                degree = 3600 + 373;
                            }

                            if (loc == 32) {
                                degree = 3600 + 192;
                            }

                            if (loc == 33) {
                                degree = 3600 + 334;
                            }

                            if (loc == 34) {
                                degree = 3600 + 152;
                            }

                            if (loc == 35) {
                                degree = 3600 + 294;
                            }

                            if (loc == 36) {
                                degree = 3600 + 477;
                            }


                        }


                    }


                }
                if (howtoplay.equals("w")) {
                    if (placebet00 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet0 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet1 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet2 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet3 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet4 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet5 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet6 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet7 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet8 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet9 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet10 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet11 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet12 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet13 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet14 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet15 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet16 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet17 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet18 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet19 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet20 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet21 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet22 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet23 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet24 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet25 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet26 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet27 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet28 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet29 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet30 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet31 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet32 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet33 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet34 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet35 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (placebet36 > 0.0) {
                        hjk = hjk + 1;
                    }
                    if (hjk == 0.0) {
                        hjk = 1;
                    }


                    if (tobet > 0) {
                        double gh = tobet / hjk;
                        if (placebet2 >= gh) {
                            degree = 3600 + 273;
                        }
                        if (placebet2 >= gh) {
                            degree = 3600 + 273;
                        }

                        if (placebet2 >= gh) {
                            degree = 3600 + 273;
                        }
                        if (placebet3 >= gh) {
                            degree = 3600 + 133;
                        }
                        if (placebet4 >= gh) {
                            degree = 3600 + 314;
                        }
                        if (placebet5 >= gh) {
                            degree = 3600 + 172;
                        }
                        if (placebet6 >= gh) {
                            degree = 3600 + 354;
                        }
                        if (placebet7 >= gh) {
                            degree = 3600 + 211;
                        }
                        if (placebet8 >= gh) {
                            degree = 3600 + 387;
                        }
                        if (placebet9 >= gh) {
                            degree = 3600 + 248;
                        }
                        if (placebet10 >= gh) {
                            degree = 3600 + 427;
                        }
                        if (placebet11 >= gh) {
                            degree = 3600 + 221;
                        }
                        if (placebet12 >= gh) {
                            degree = 3600 + 397;
                        }
                        if (placebet13 >= gh) {
                            degree = 3600 + 467;
                        }
                        if (placebet14 >= gh) {
                            degree = 3600 + 284;
                        }
                        if (placebet15 >= gh) {
                            degree = 3600 + 142;
                        }
                        if (placebet16 >= gh) {
                            degree = 3600 + 324;
                        }
                        if (placebet17 >= gh) {
                            degree = 3600 + 182;
                        }
                        if (placebet18 >= gh) {
                            degree = 3600 + 363;
                        }
                        if (placebet19 >= gh) {
                            degree = 3600 + 380;
                        }
                        if (placebet20 >= gh) {
                            degree = 3600 + 202;
                        }
                        if (placebet21 >= gh) {
                            degree = 3600 + 344;
                        }
                        if (placebet22 >= gh) {
                            degree = 3600 + 162;
                        }
                        if (placebet23 >= gh) {
                            degree = 3600 + 304;
                        }
                        if (placebet24 >= gh) {
                            degree = 3600 + 122;
                        }
                        if (placebet25 >= gh) {
                            degree = 3600 + 417;
                        }
                        if (placebet26 >= gh) {
                            degree = 3600 + 240;
                        }
                        if (placebet27 >= gh) {
                            degree = 3600 + 437;
                        }
                        if (placebet28 >= gh) {
                            degree = 3600 + 255;
                        }
                        if (placebet29 >= gh) {
                            degree = 3600 + 407;
                        }
                        if (placebet30 >= gh) {
                            degree = 3600 + 230;
                        }
                        if (placebet31 >= gh) {
                            degree = 3600 + 373;
                        }
                        if (placebet32 >= gh) {
                            degree = 3600 + 192;
                        }
                        if (placebet33 >= gh) {
                            degree = 3600 + 334;
                        }
                        if (placebet34 >= gh) {
                            degree = 3600 + 152;
                        }
                        if (placebet35 >= gh) {
                            degree = 3600 + 294;
                        }
                        if (placebet36 >= gh) {
                            degree = 3600 + 477;
                        }


                    }

                    if (placebet0 == 0 && placebet00 == 0 && placebet1 == 0 && placebet2 == 0 && placebet3 == 0 && placebet4 == 0 && placebet5 == 0 && placebet6 == 0 && placebet7 == 0 && placebet8 == 0 &&
                            placebet9 == 0 && placebet10 == 0 && placebet11 == 0 && placebet12 == 0 && placebet13 == 0 && placebet14 == 0 && placebet15 == 0 && placebet16 == 0 && placebet17 == 0 && placebet18 == 0 &&
                            placebet19 == 0 && placebet20 == 0 && placebet21 == 0 && placebet22 == 0 && placebet23 == 0 && placebet24 == 0 && placebet25 == 0 && placebet26 == 0 &&
                            placebet27 == 0 && placebet28 == 0 && placebet29 == 0 && placebet30 == 0 && placebet31 == 0 && placebet32 == 0 && placebet33 == 0 && placebet34 == 0 &&
                            placebet35 == 0 && placebet36 == 0) {
                        degree = r.nextInt(3600) + 720;
                    }

                }
                if (howtoplay.equals("nw")) {
                    if (ij % 3 != 0) {
                        degree = r.nextInt(3600) + 720;

                    } else if (ij % 3 == 0) {


                        if (placebet00 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet0 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet1 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet2 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet3 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet4 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet5 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet6 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet7 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet8 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet9 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet10 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet11 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet12 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet13 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet14 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet15 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet16 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet17 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet18 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet19 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet20 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet21 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet22 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet23 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet24 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet25 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet26 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet27 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet28 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet29 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet30 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet31 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet32 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet33 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet34 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet35 > 0) {
                            hjk = hjk + 1;
                        }
                        if (placebet36 > 0) {
                            hjk = hjk + 1;
                        }
                        if (hjk == 0) {
                            hjk = 1;
                        }

                        if (tobet > 0) {
                            double gh = tobet / hjk;


                            if (placebet2 >= gh) {
                                degree = 3600 + 273;
                            }
                            if (placebet3 >= gh) {
                                degree = 3600 + 133;
                            }
                            if (placebet4 >= gh) {
                                degree = 3600 + 314;
                            }
                            if (placebet5 >= gh) {
                                degree = 3600 + 172;
                            }
                            if (placebet6 >= gh) {
                                degree = 3600 + 354;
                            }
                            if (placebet7 >= gh) {
                                degree = 3600 + 211;
                            }
                            if (placebet8 >= gh) {
                                degree = 3600 + 387;
                            }
                            if (placebet9 >= gh) {
                                degree = 3600 + 248;
                            }
                            if (placebet10 >= gh) {
                                degree = 3600 + 427;
                            }
                            if (placebet11 >= gh) {
                                degree = 3600 + 221;
                            }
                            if (placebet12 >= gh) {
                                degree = 3600 + 397;
                            }
                            if (placebet13 >= gh) {
                                degree = 3600 + 467;
                            }
                            if (placebet14 >= gh) {
                                degree = 3600 + 284;
                            }
                            if (placebet15 >= gh) {
                                degree = 3600 + 142;
                            }
                            if (placebet16 >= gh) {
                                degree = 3600 + 324;
                            }
                            if (placebet17 >= gh) {
                                degree = 3600 + 182;
                            }
                            if (placebet18 >= gh) {
                                degree = 3600 + 363;
                            }
                            if (placebet19 >= gh) {
                                degree = 3600 + 380;
                            }
                            if (placebet20 >= gh) {
                                degree = 3600 + 202;
                            }
                            if (placebet21 >= gh) {
                                degree = 3600 + 344;
                            }
                            if (placebet22 >= gh) {
                                degree = 3600 + 162;
                            }
                            if (placebet23 >= gh) {
                                degree = 3600 + 304;
                            }
                            if (placebet24 >= gh) {
                                degree = 3600 + 122;
                            }
                            if (placebet25 >= gh) {
                                degree = 3600 + 417;
                            }
                            if (placebet26 >= gh) {
                                degree = 3600 + 240;
                            }
                            if (placebet27 >= gh) {
                                degree = 3600 + 437;
                            }
                            if (placebet28 >= gh) {
                                degree = 3600 + 255;
                            }
                            if (placebet29 >= gh) {
                                degree = 3600 + 407;
                            }
                            if (placebet30 >= gh) {
                                degree = 3600 + 230;
                            }
                            if (placebet31 >= gh) {
                                degree = 3600 + 373;
                            }
                            if (placebet32 >= gh) {
                                degree = 3600 + 192;
                            }
                            if (placebet33 >= gh) {
                                degree = 3600 + 334;
                            }
                            if (placebet34 >= gh) {
                                degree = 3600 + 152;
                            }
                            if (placebet35 >= gh) {
                                degree = 3600 + 294;
                            }
                            if (placebet36 >= gh) {
                                degree = 3600 + 477;
                            }


                        }

                    }


                }else{

                    final String Userg = getIntent().getStringExtra("user");
                    final String usera = Userg.replace("@", "");
                    final String usern = usera.replace(".", "");
                    final DatabaseReference myref5;
                    FirebaseDatabase mFirebaseDatabase1 = FirebaseDatabase.getInstance();
                    myref5 = mFirebaseDatabase1.getInstance().getReference().child("Bets").child(usern);


                    Map<String, Object> updateValues1 = new HashMap<>();
                    updateValues1 = new HashMap<>();
                    for (int i = 0; i < 37; i++) {
                        updateValues1.put("/" + i, 0);
                        myref5.updateChildren(updateValues1);
                    }
                    updateValues1.put("/00", 0);
                    updateValues1.put("/2to11", 0);
                    updateValues1.put("/2to12", 0);
                    updateValues1.put("/2to13", 0);
                    updateValues1.put("/1to18A", 0);
                    updateValues1.put("/even", 0);
                    updateValues1.put("/red", 0);
                    updateValues1.put("/black", 0);
                    updateValues1.put("/odd", 0);
                    updateValues1.put("/19to36", 0);
                    updateValues1.put("/1st12", 0);
                    updateValues1.put("/2nd12", 0);
                    updateValues1.put("/3rd12", 0);

                    myref5.updateChildren(updateValues1);

                    point=point+tobet;
                    tobet=0.0;
                    FirebaseDatabase mFirebaseDatabaset = FirebaseDatabase.getInstance();
                    DatabaseReference myref=mFirebaseDatabaset.getInstance().getReference().child("Member").child(usern);
                    Map<String,Object> updateValuesr = new HashMap<>();

                    updateValuesr.put("/points",point);

                    myref.updateChildren(updateValuesr);
                    reset();

                }

                final DatabaseReference myref232;

                myref232 = mFirebaseDatabase.getInstance().getReference().child("timer");
                Map<String, Object> updateValues765 = new HashMap<>();
                updateValues765.put("/degree", degree);

                myref232.updateChildren(updateValues765);
            }
            if (seconds == 0) {

                RotateAnimation rotate = new RotateAnimation(degree_old, degree,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(3600);
                rotate.setFillAfter(true);
                rotate.setInterpolator(new DecelerateInterpolator());
                final MediaPlayer mysong2 = MediaPlayer.create(Roullete.this, R.raw.spin);

                rotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {


                        mysong2.start();
                        button0.setEnabled(false);
                        button00.setEnabled(false);
                        button1.setEnabled(false);
                        button2.setEnabled(false);
                        button3.setEnabled(false);
                        button4.setEnabled(false);
                        button5.setEnabled(false);
                        button6.setEnabled(false);
                        button7.setEnabled(false);
                        button8.setEnabled(false);
                        button9.setEnabled(false);
                        button10.setEnabled(false);
                        button11.setEnabled(false);
                        button12.setEnabled(false);
                        button13.setEnabled(false);
                        button14.setEnabled(false);
                        button15.setEnabled(false);
                        button16.setEnabled(false);
                        button17.setEnabled(false);
                        button18.setEnabled(false);
                        button19.setEnabled(false);
                        button20.setEnabled(false);
                        button21.setEnabled(false);
                        button22.setEnabled(false);
                        button23.setEnabled(false);
                        button24.setEnabled(false);
                        button25.setEnabled(false);
                        button26.setEnabled(false);
                        button27.setEnabled(false);
                        button28.setEnabled(false);
                        button29.setEnabled(false);
                        button30.setEnabled(false);
                        button31.setEnabled(false);
                        button32.setEnabled(false);
                        button33.setEnabled(false);
                        button34.setEnabled(false);
                        button35.setEnabled(false);
                        button36.setEnabled(false);
                        button1st12.setEnabled(false);
                        button2nd12.setEnabled(false);
                        button3rd12.setEnabled(false);
                        button1to18.setEnabled(false);
                        buttoneven.setEnabled(false);
                        buttonodd.setEnabled(false);
                        buttonred.setEnabled(false);
                        buttonblack.setEnabled(false);
                        button19to36.setEnabled(false);
                        button2to11.setEnabled(false);
                        button2to12.setEnabled(false);
                        button2to13.setEnabled(false);
                        buttontake.setEnabled(false);
                        bcancel.setEnabled(false);


                        final DatabaseReference myref2;
                        FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
                        final String Userg = getIntent().getStringExtra("user");
                        final String usera = Userg.replace("@", "");
                        final String usern = usera.replace(".", "");
                        myref2 = mFirebaseDatabase.getInstance().getReference().child("Member").child(usern);

                        if (winnedd > 0.0) {


                            point = point + winnedd;
                            availablep.setText("" + point);
                            winning.setText("" + 00);
                            winnedd = 0.0;
                            btake.setEnabled(false);
                            reset();


                            Map<String, Object> updateValues = new HashMap<>();
                            updateValues.put("/take", winnedd);
                            updateValues.put("/points", point);
                            myref2.updateChildren(updateValues);

                        }
                        if (winnedd < 0.0) {


                            point = point + winnedd;
                            availablep.setText("" + point);
                            winning.setText("" + 00);
                            winnedd = 0.0;
                            btake.setEnabled(false);
                            reset();


                            Map<String, Object> updateValues = new HashMap<>();
                            updateValues.put("/take", winnedd);
                            updateValues.put("/points", point);
                            myref2.updateChildren(updateValues);

                        }


                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        mysong2.stop();
                        reset();
                        button0.setEnabled(true);
                        button00.setEnabled(true);
                        button1.setEnabled(true);
                        button2.setEnabled(true);
                        button3.setEnabled(true);
                        button4.setEnabled(true);
                        button5.setEnabled(true);
                        button6.setEnabled(true);
                        button7.setEnabled(true);
                        button8.setEnabled(true);
                        button9.setEnabled(true);
                        button10.setEnabled(true);
                        button11.setEnabled(true);
                        button12.setEnabled(true);
                        button13.setEnabled(true);
                        button14.setEnabled(true);
                        button15.setEnabled(true);
                        button16.setEnabled(true);
                        button17.setEnabled(true);
                        button18.setEnabled(true);
                        button19.setEnabled(true);
                        button20.setEnabled(true);
                        button21.setEnabled(true);
                        button22.setEnabled(true);
                        button23.setEnabled(true);
                        button24.setEnabled(true);
                        button25.setEnabled(true);
                        button26.setEnabled(true);
                        button27.setEnabled(true);
                        button28.setEnabled(true);
                        button29.setEnabled(true);
                        button30.setEnabled(true);
                        button31.setEnabled(true);
                        button32.setEnabled(true);
                        button33.setEnabled(true);
                        button34.setEnabled(true);
                        button35.setEnabled(true);
                        button36.setEnabled(true);
                        button1st12.setEnabled(true);
                        button2nd12.setEnabled(true);
                        button3rd12.setEnabled(true);
                        button1to18.setEnabled(true);
                        buttoneven.setEnabled(true);
                        buttonodd.setEnabled(true);
                        buttonred.setEnabled(true);
                        buttonblack.setEnabled(true);
                        button19to36.setEnabled(true);
                        button2to11.setEnabled(true);
                        button2to12.setEnabled(true);
                        button2to13.setEnabled(true);
                        bcancel.setEnabled(true);
                        buttonexit.setEnabled(true);

                        final String Userg = getIntent().getStringExtra("user");
                        final String usera = Userg.replace("@", "");
                        final String usern = usera.replace(".", "");
                        final DatabaseReference myref5;
                        FirebaseDatabase mFirebaseDatabase1 = FirebaseDatabase.getInstance();
                        myref5 = mFirebaseDatabase1.getInstance().getReference().child("Bets").child(usern);


                        Map<String, Object> updateValues1 = new HashMap<>();
                        updateValues1 = new HashMap<>();
                        for (int i = 0; i < 37; i++) {
                            updateValues1.put("/" + i, 0);
                            myref5.updateChildren(updateValues1);
                        }
                        updateValues1.put("/00", 0);
                        updateValues1.put("/2to11", 0);
                        updateValues1.put("/2to12", 0);
                        updateValues1.put("/2to13", 0);
                        updateValues1.put("/1to18A", 0);
                        updateValues1.put("/even", 0);
                        updateValues1.put("/red", 0);
                        updateValues1.put("/black", 0);
                        updateValues1.put("/odd", 0);
                        updateValues1.put("/19to36", 0);
                        updateValues1.put("/1st12", 0);
                        updateValues1.put("/2nd12", 0);
                        updateValues1.put("/3rd12", 0);

                        myref5.updateChildren(updateValues1);


                        btake.setEnabled(true);
                        final DatabaseReference myref1;
                        FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();

                        myref1 = mFirebaseDatabase.getInstance().getReference().child("Member").child(usern);

                        temp = currentNumber(360 - (degree % 360));
                        EditText5.setText(EditText4.getText().toString());
                        if (EditText5.getText().toString().equals("18") || EditText5.getText().toString().equals("21") || EditText5.getText().toString().equals("16") || EditText5.getText().toString().equals("23") || EditText5.getText().toString().equals("14") || EditText5.getText().toString().equals("9") || EditText5.getText().toString().equals("30") || EditText5.getText().toString().equals("7") || EditText5.getText().toString().equals("32") || EditText5.getText().toString().equals("5") || EditText5.getText().toString().equals("34") || EditText5.getText().toString().equals("3") || EditText5.getText().toString().equals("36") || EditText5.getText().toString().equals("1") || EditText5.getText().toString().equals("27") || EditText5.getText().toString().equals("25") || EditText5.getText().toString().equals("12") || EditText5.getText().toString().equals("19")) {
                            EditText5.setBackgroundColor(Color.RED);
                        } else if (EditText5.getText().toString().equals("6") || EditText5.getText().toString().equals("33") || EditText5.getText().toString().equals("4") || EditText5.getText().toString().equals("35") || EditText5.getText().toString().equals("2") || EditText5.getText().toString().equals("28") || EditText5.getText().toString().equals("26") || EditText5.getText().toString().equals("11") || EditText5.getText().toString().equals("20") || EditText5.getText().toString().equals("17") || EditText5.getText().toString().equals("22") || EditText5.getText().toString().equals("15") || EditText5.getText().toString().equals("24") || EditText5.getText().toString().equals("13") || EditText5.getText().toString().equals("10") || EditText5.getText().toString().equals("29") || EditText5.getText().toString().equals("8") || EditText5.getText().toString().equals("31")) {
                            EditText5.setBackgroundColor(Color.BLACK);
                            EditText5.setTextColor(Color.WHITE);
                        } else if (EditText5.getText().toString().equals("0") || EditText5.getText().toString().equals("00")) {
                            EditText5.setBackgroundColor(Color.GREEN);
                        }

                        EditText4.setText(EditText3.getText().toString());
                        if (EditText4.getText().toString().equals("18") || EditText4.getText().toString().equals("21") || EditText4.getText().toString().equals("16") || EditText4.getText().toString().equals("23") || EditText4.getText().toString().equals("14") || EditText4.getText().toString().equals("9") || EditText4.getText().toString().equals("30") || EditText4.getText().toString().equals("7") || EditText4.getText().toString().equals("32") || EditText4.getText().toString().equals("5") || EditText4.getText().toString().equals("34") || EditText4.getText().toString().equals("3") || EditText4.getText().toString().equals("36") || EditText4.getText().toString().equals("1") || EditText4.getText().toString().equals("27") || EditText4.getText().toString().equals("25") || EditText4.getText().toString().equals("12") || EditText4.getText().toString().equals("19")) {
                            EditText4.setBackgroundColor(Color.RED);
                        } else if (EditText4.getText().toString().equals("6") || EditText4.getText().toString().equals("33") || EditText4.getText().toString().equals("4") || EditText4.getText().toString().equals("35") || EditText4.getText().toString().equals("2") || EditText4.getText().toString().equals("28") || EditText4.getText().toString().equals("26") || EditText4.getText().toString().equals("11") || EditText4.getText().toString().equals("20") || EditText4.getText().toString().equals("17") || EditText4.getText().toString().equals("22") || EditText4.getText().toString().equals("15") || EditText4.getText().toString().equals("24") || EditText4.getText().toString().equals("13") || EditText4.getText().toString().equals("10") || EditText4.getText().toString().equals("29") || EditText4.getText().toString().equals("8") || EditText4.getText().toString().equals("31")) {
                            EditText4.setBackgroundColor(Color.BLACK);
                            EditText4.setTextColor(Color.WHITE);
                        } else if (EditText4.getText().toString().equals("0") || EditText4.getText().toString().equals("00")) {
                            EditText4.setBackgroundColor(Color.GREEN);
                        }
                        EditText3.setText(EditText2.getText().toString());
                        if (EditText3.getText().toString().equals("18") || EditText3.getText().toString().equals("21") || EditText3.getText().toString().equals("16") || EditText3.getText().toString().equals("23") || EditText3.getText().toString().equals("14") || EditText3.getText().toString().equals("9") || EditText3.getText().toString().equals("30") || EditText3.getText().toString().equals("7") || EditText3.getText().toString().equals("32") || EditText3.getText().toString().equals("5") || EditText3.getText().toString().equals("34") || EditText3.getText().toString().equals("3") || EditText3.getText().toString().equals("36") || EditText3.getText().toString().equals("1") || EditText3.getText().toString().equals("27") || EditText3.getText().toString().equals("25") || EditText3.getText().toString().equals("12") || EditText3.getText().toString().equals("19")) {
                            EditText3.setBackgroundColor(Color.RED);

                        } else if (EditText3.getText().toString().equals("6") || EditText3.getText().toString().equals("33") || EditText3.getText().toString().equals("4") || EditText3.getText().toString().equals("35") || EditText3.getText().toString().equals("2") || EditText3.getText().toString().equals("28") || EditText3.getText().toString().equals("26") || EditText3.getText().toString().equals("11") || EditText3.getText().toString().equals("20") || EditText3.getText().toString().equals("17") || EditText3.getText().toString().equals("22") || EditText3.getText().toString().equals("15") || EditText3.getText().toString().equals("24") || EditText3.getText().toString().equals("13") || EditText3.getText().toString().equals("10") || EditText3.getText().toString().equals("29") || EditText3.getText().toString().equals("8") || EditText3.getText().toString().equals("31")) {
                            EditText3.setBackgroundColor(Color.BLACK);
                            EditText3.setTextColor(Color.WHITE);
                        } else if (EditText3.getText().toString().equals("0") || EditText3.getText().toString().equals("00")) {
                            EditText3.setBackgroundColor(Color.GREEN);
                        }
                        EditText2.setText(EditText1.getText().toString());
                        if (EditText2.getText().toString().equals("18") || EditText2.getText().toString().equals("21") || EditText2.getText().toString().equals("16") || EditText2.getText().toString().equals("23") || EditText2.getText().toString().equals("14") || EditText2.getText().toString().equals("9") || EditText2.getText().toString().equals("30") || EditText2.getText().toString().equals("7") || EditText2.getText().toString().equals("32") || EditText2.getText().toString().equals("5") || EditText2.getText().toString().equals("34") || EditText2.getText().toString().equals("3") || EditText2.getText().toString().equals("36") || EditText2.getText().toString().equals("1") || EditText2.getText().toString().equals("27") || EditText2.getText().toString().equals("25") || EditText2.getText().toString().equals("12") || EditText2.getText().toString().equals("19")) {
                            EditText2.setBackgroundColor(Color.RED);
                        } else if (EditText2.getText().toString().equals("6") || EditText2.getText().toString().equals("33") || EditText2.getText().toString().equals("4") || EditText2.getText().toString().equals("35") || EditText2.getText().toString().equals("2") || EditText2.getText().toString().equals("28") || EditText2.getText().toString().equals("26") || EditText2.getText().toString().equals("11") || EditText2.getText().toString().equals("20") || EditText2.getText().toString().equals("17") || EditText2.getText().toString().equals("22") || EditText2.getText().toString().equals("15") || EditText2.getText().toString().equals("24") || EditText2.getText().toString().equals("13") || EditText2.getText().toString().equals("10") || EditText2.getText().toString().equals("29") || EditText2.getText().toString().equals("8") || EditText2.getText().toString().equals("31")) {
                            EditText2.setBackgroundColor(Color.BLACK);
                            EditText2.setTextColor(Color.WHITE);
                        } else if (EditText2.getText().toString().equals("0") || EditText2.getText().toString().equals("00")) {
                            EditText2.setBackgroundColor(Color.GREEN);
                        }
                        EditText1.setText(currentNumber(360 - (degree % 360)));
                        if (EditText1.getText().toString().equals("18") || EditText1.getText().toString().equals("21") || EditText1.getText().toString().equals("16") || EditText1.getText().toString().equals("23") || EditText1.getText().toString().equals("14") || EditText1.getText().toString().equals("9") || EditText1.getText().toString().equals("30") || EditText1.getText().toString().equals("7") || EditText1.getText().toString().equals("32") || EditText1.getText().toString().equals("5") || EditText1.getText().toString().equals("34") || EditText1.getText().toString().equals("3") || EditText1.getText().toString().equals("36") || EditText1.getText().toString().equals("1") || EditText1.getText().toString().equals("27") || EditText1.getText().toString().equals("25") || EditText1.getText().toString().equals("12") || EditText1.getText().toString().equals("19")) {
                            EditText1.setBackgroundColor(Color.RED);

                        } else if (EditText1.getText().toString().equals("6") || EditText1.getText().toString().equals("33") || EditText1.getText().toString().equals("4") || EditText1.getText().toString().equals("35") || EditText1.getText().toString().equals("2") || EditText1.getText().toString().equals("28") || EditText1.getText().toString().equals("26") || EditText1.getText().toString().equals("11") || EditText1.getText().toString().equals("20") || EditText1.getText().toString().equals("17") || EditText1.getText().toString().equals("22") || EditText1.getText().toString().equals("15") || EditText1.getText().toString().equals("24") || EditText1.getText().toString().equals("13") || EditText1.getText().toString().equals("10") || EditText1.getText().toString().equals("29") || EditText1.getText().toString().equals("8") || EditText1.getText().toString().equals("31")) {
                            EditText1.setBackgroundColor(Color.BLACK);
                            EditText1.setTextColor(Color.WHITE);
                        } else if (EditText1.getText().toString().equals("0") || EditText1.getText().toString().equals("00")) {
                            EditText1.setBackgroundColor(Color.GREEN);
                            EditText1.setTextColor(Color.BLACK);
                        }

                        Integer openbe = Integer.parseInt(EditText1.getText().toString());

                        final DatabaseReference myref6;

                        myref6 = mFirebaseDatabase.getInstance().getReference().child("timer");

                        Map<String, Object> updateValues = new HashMap<>();
                        updateValues.put("1", EditText1.getText().toString());
                        updateValues.put("2", EditText2.getText().toString());
                        updateValues.put("3", EditText3.getText().toString());
                        updateValues.put("4", EditText4.getText().toString());
                        updateValues.put("5", EditText5.getText().toString());


                        myref6.updateChildren(updateValues);


                        if (EditText1.getText().toString().equals(00)) {
                            Won00 = placebet00 * 36;
                        }
                        if (EditText1.getText().toString().equals(0)) {
                            Won0 = placebet0 * 36;


                        }
                        if (openbe == 1) {
                            Won1 = placebet1 * 36;
                            Won1h = placebet1h * 36;


                        }
                        if (openbe == 2) {
                            Won2 = placebet2 * 36;
                            Won2h = placebet2h * 36;


                        }
                        if (openbe == 3) {
                            Won3 = placebet3 * 36;
                            Won3h = placebet3h * 36;


                        }
                        if (openbe == 4) {
                            Won4 = placebet4 * 36;
                            Won4h = placebet4h * 36;


                        }
                        if (openbe == 5) {
                            Won5 = placebet5 * 36;
                            Won5h = placebet5h * 36;


                        }
                        if (openbe == 6) {
                            Won6 = placebet6 * 36;
                            Won6h = placebet6h * 36;


                        }
                        if (openbe == 7) {
                            Won7 = placebet7 * 36;
                            Won7h = placebet7h * 36;


                        }
                        if (openbe == 8) {
                            Won8 = placebet8 * 36;
                            Won8h = placebet8h * 36;


                        }
                        if (openbe == 9) {
                            Won9 = placebet9 * 36;
                            Won9h = placebet9h * 36;


                        }
                        if (openbe == 10) {
                            Won10 = placebet10 * 36;
                            Won10h = placebet10h * 36;


                        }
                        if (openbe == 11) {
                            Won11 = placebet11 * 36;
                            Won11h = placebet11h * 36;


                        }
                        if (openbe == 12) {
                            Won12 = placebet12 * 36;
                            Won12h = placebet12h * 36;


                        }
                        if (openbe == 13) {
                            Won13 = placebet13 * 36;
                            Won13h = placebet13h * 36;


                        }
                        if (openbe == 14) {
                            Won14 = placebet14 * 36;
                            Won14h = placebet14h * 36;


                        }
                        if (openbe == 15) {
                            Won15 = placebet15 * 36;
                            Won15h = placebet15h * 36;


                        }
                        if (openbe == 16) {
                            Won16 = placebet16 * 36;
                            Won16h = placebet16h * 36;


                        }
                        if (openbe == 17) {
                            Won17 = placebet17 * 36;
                            Won17h = placebet17h * 36;


                        }
                        if (openbe == 18) {
                            Won18 = placebet18 * 36;
                            Won18h = placebet18h * 36;


                        }
                        if (openbe == 19) {
                            Won19 = placebet19 * 36;
                            Won19h = placebet19h * 36;

                        }
                        if (openbe == 20) {
                            Won20 = placebet20 * 36;
                            Won20h = placebet20h * 36;


                        }
                        if (openbe == 21) {
                            Won21 = placebet21 * 36;
                            Won21h = placebet21h * 36;

                        }
                        if (openbe == 22) {
                            Won22 = placebet22 * 36;
                            Won22h = placebet22h * 36;

                        }
                        if (openbe == 23) {
                            Won23 = placebet23 * 36;
                            Won23h = placebet23h * 36;


                        }
                        if (openbe == 24) {
                            Won24 = placebet24 * 36;
                            Won24h = placebet24h * 36;


                        }
                        if (openbe == 25) {
                            Won25 = placebet25 * 36;
                            Won25h = placebet25h * 36;

                        }
                        if (openbe == 26) {
                            Won26 = placebet26 * 36;
                            Won26h = placebet26h * 36;


                        }
                        if (openbe == 27) {
                            Won27 = placebet27 * 36;
                            Won27h = placebet27h * 36;


                        }
                        if (openbe == 28) {
                            Won28 = placebet28 * 36;
                            Won28h = placebet28h * 36;


                        }
                        if (openbe == 29) {
                            Won29 = placebet29 * 36;
                            Won29h = placebet29h * 36;


                        }
                        if (openbe == 30) {
                            Won30 = placebet30 * 36;
                            Won30h = placebet30h * 36;


                        }
                        if (openbe == 31) {
                            Won31 = placebet31 * 36;
                            Won31h = placebet31h * 36;


                        }
                        if (openbe == 32) {
                            Won32 = placebet32 * 36;
                            Won32h = placebet32h * 36;


                        }
                        if (openbe == 33) {
                            Won33 = placebet33 * 36;
                            Won33h = placebet33h * 36;


                        }
                        if (openbe == 34) {
                            Won34 = placebet34 * 36;
                            Won34h = placebet34h * 36;


                        }
                        if (openbe == 35) {
                            Won35 = placebet35 * 36;
                            Won35h = placebet35h * 36;


                        }
                        if (openbe == 36) {
                            Won36 = placebet36 * 36;
                            Won36h = placebet36h * 36;


                        }


                        placebet0 = 0.0;
                        placebet00 = 0.0;
                        placebet1 = 0.0;
                        placebet2 = 0.0;
                        placebet3 = 0.0;
                        placebet4 = 0.0;
                        placebet5 = 0.0;
                        placebet6 = 0.0;
                        placebet7 = 0.0;
                        placebet8 = 0.0;
                        placebet9 = 0.0;
                        placebet10 = 0.0;
                        placebet11 = 0.0;
                        placebet12 = 0.0;
                        placebet13 = 0.0;
                        placebet14 = 0.0;
                        placebet15 = 0.0;
                        placebet16 = 0.0;
                        placebet17 = 0.0;
                        placebet18 = 0.0;
                        placebet19 = 0.0;
                        placebet20 = 0.0;
                        placebet21 = 0.0;
                        placebet22 = 0.0;
                        placebet23 = 0.0;
                        placebet24 = 0.0;
                        placebet25 = 0.0;
                        placebet26 = 0.0;
                        placebet27 = 0.0;
                        placebet28 = 0.0;
                        placebet29 = 0.0;
                        placebet30 = 0.0;
                        placebet31 = 0.0;
                        placebet32 = 0.0;
                        placebet33 = 0.0;
                        placebet34 = 0.0;
                        placebet35 = 0.0;
                        placebet36 = 0.0;
                        placebet1h = 0.0;
                        placebet2h = 0.0;
                        placebet3h = 0.0;
                        placebet4h = 0.0;
                        placebet5h = 0.0;
                        placebet6h = 0.0;
                        placebet7h = 0.0;
                        placebet8h = 0.0;
                        placebet9h = 0.0;
                        placebet10h = 0.0;
                        placebet11h = 0.0;
                        placebet12h = 0.0;
                        placebet13h = 0.0;
                        placebet14h = 0.0;
                        placebet15h = 0.0;
                        placebet16h = 0.0;
                        placebet17h = 0.0;
                        placebet18h = 0.0;
                        placebet19h = 0.0;
                        placebet20h = 0.0;
                        placebet21h = 0.0;
                        placebet22h = 0.0;
                        placebet23h = 0.0;
                        placebet24h = 0.0;
                        placebet25h = 0.0;
                        placebet26h = 0.0;
                        placebet27h = 0.0;
                        placebet28h = 0.0;
                        placebet29h = 0.0;
                        placebet30h = 0.0;
                        placebet31h = 0.0;
                        placebet32h = 0.0;
                        placebet33h = 0.0;
                        placebet34h = 0.0;
                        placebet35h = 0.0;
                        placebet36h = 0.0;


                        placebet2to11 = 0.0;
                        placebet2to12 = 0.0;
                        placebet2to13 = 0.0;
                        placebet1st12 = 0.0;
                        placebet2nd12 = 0.0;
                        placebet3rd12 = 0.0;
                        placebet1to18 = 0.0;
                        placebeteven = 0.0;
                        placebetr = 0.0;
                        placebetb = 0.0;
                        placebetodd = 0.0;
                        placebet19to36 = 0.0;
                        tobet = 0.0;
                        double bd = Won0 + Won00 + Won1 + Won2 + Won3 + Won4 + Won5 + Won6 +
                                Won7 + Won8 + Won9 + Won10 + Won11 + Won12 + Won13 + Won14 + Won15 +
                                Won16 + Won17 + Won18 + Won19 + Won20 +
                                Won21 + Won22 + Won23 + Won24 + Won25 + Won26 +
                                Won27 + Won28 + Won29 + Won30 + Won31 + Won32 + Won34 + Won33 + Won35 + Won36 + Won1h + Won2h + Won3h + Won4h + Won5h + Won6h +
                                Won7h + Won8h + Won9h + Won10h + Won11h + Won12h + Won13h + Won14h + Won15h +
                                Won16h + Won17h + Won18h + Won19h + Won20h +
                                Won21h + Won22h + Won23h + Won24h + Won25h + Won26h +
                                Won27h + Won28h + Won29h + Won30h + Won31h + Won32h + Won34h + Won33h + Won35h + Won36h;
                        double winned = Math.round(bd);


                        winning.setText("" + winned);
                        if (winned > 0.0) {
                            Toast.makeText(Roullete.this, "Please Take The Amount", Toast.LENGTH_SHORT).show();
                            button0.setEnabled(false);
                            button00.setEnabled(false);
                            button1.setEnabled(false);
                            button2.setEnabled(false);
                            button3.setEnabled(false);
                            button4.setEnabled(false);
                            button5.setEnabled(false);
                            button6.setEnabled(false);
                            button7.setEnabled(false);
                            button8.setEnabled(false);
                            button9.setEnabled(false);
                            button10.setEnabled(false);
                            button11.setEnabled(false);
                            button12.setEnabled(false);
                            button13.setEnabled(false);
                            button14.setEnabled(false);
                            button15.setEnabled(false);
                            button16.setEnabled(false);
                            button17.setEnabled(false);
                            button18.setEnabled(false);
                            button19.setEnabled(false);
                            button20.setEnabled(false);
                            button21.setEnabled(false);
                            button22.setEnabled(false);
                            button23.setEnabled(false);
                            button24.setEnabled(false);
                            button25.setEnabled(false);
                            button26.setEnabled(false);
                            button27.setEnabled(false);
                            button28.setEnabled(false);
                            button29.setEnabled(false);
                            button30.setEnabled(false);
                            button31.setEnabled(false);
                            button32.setEnabled(false);
                            button33.setEnabled(false);
                            button34.setEnabled(false);
                            button35.setEnabled(false);
                            button36.setEnabled(false);
                            button1st12.setEnabled(false);
                            button2nd12.setEnabled(false);
                            button3rd12.setEnabled(false);
                            button1to18.setEnabled(false);
                            buttoneven.setEnabled(false);
                            buttonodd.setEnabled(false);
                            buttonred.setEnabled(false);
                            buttonblack.setEnabled(false);
                            button19to36.setEnabled(false);
                            button2to11.setEnabled(false);
                            button2to12.setEnabled(false);
                            button2to13.setEnabled(false);
                            buttontake.setEnabled(true);
                            buttontake.setBackgroundColor(Color.YELLOW);

                            bcancel.setEnabled(false);
                        }
                        if (winned == 0) {
                            reset();
                        }
                        winnedd = winned;
                        Map<String, Object> updateValues11 = new HashMap<>();
                        updateValues11.put("/take", winned);
                        updateValues11.put("/points", point);

                        myref1.updateChildren(updateValues11);
                        winned = 0.0;


                        Won0 = 0.0;
                        Won00 = 0.0;
                        Won1 = 0.0;
                        Won2 = 0.0;
                        Won3 = 0.0;
                        Won4 = 0.0;
                        Won5 = 0.0;
                        Won6 = 0.0;
                        Won7 = 0.0;
                        Won8 = 0.0;
                        Won9 = 0.0;
                        Won10 = 0.0;
                        Won11 = 0.0;
                        Won12 = 0.0;
                        Won13 = 0.0;
                        Won14 = 0.0;
                        Won15 = 0.0;
                        Won16 = 0.0;
                        Won17 = 0.0;
                        Won18 = 0.0;
                        Won19 = 0.0;
                        Won20 = 0.0;
                        Won21 = 0.0;
                        Won22 = 0.0;
                        Won23 = 0.0;
                        Won24 = 0.0;
                        Won25 = 0.0;
                        Won26 = 0.0;
                        Won27 = 0.0;
                        Won28 = 0.0;
                        Won29 = 0.0;
                        Won30 = 0.0;
                        Won31 = 0.0;
                        Won32 = 0.0;
                        Won34 = 0.0;
                        Won33 = 0.0;
                        Won35 = 0.0;
                        Won36 = 0.0;


                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {


                    }


                });iv_wheel.startAnimation(rotate);
            } else if (seconds == 10) {
                Toast.makeText(Roullete.this, "Bet Time Over", Toast.LENGTH_SHORT).show();

                button0.setEnabled(false);
                button00.setEnabled(false);
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);
                button10.setEnabled(false);
                button11.setEnabled(false);
                button12.setEnabled(false);
                button13.setEnabled(false);
                button14.setEnabled(false);
                button15.setEnabled(false);
                button16.setEnabled(false);
                button17.setEnabled(false);
                button18.setEnabled(false);
                button19.setEnabled(false);
                button20.setEnabled(false);
                button21.setEnabled(false);
                button22.setEnabled(false);
                button23.setEnabled(false);
                button24.setEnabled(false);
                button25.setEnabled(false);
                button26.setEnabled(false);
                button27.setEnabled(false);
                button28.setEnabled(false);
                button29.setEnabled(false);
                button30.setEnabled(false);
                button31.setEnabled(false);
                button32.setEnabled(false);
                button33.setEnabled(false);
                button34.setEnabled(false);
                button35.setEnabled(false);
                button36.setEnabled(false);
                button1st12.setEnabled(false);
                button2nd12.setEnabled(false);
                button3rd12.setEnabled(false);
                button1to18.setEnabled(false);
                buttoneven.setEnabled(false);
                buttonodd.setEnabled(false);
                buttonred.setEnabled(false);
                buttonblack.setEnabled(false);
                button19to36.setEnabled(false);
                button2to11.setEnabled(false);
                button2to12.setEnabled(false);
                button2to13.setEnabled(false);
                buttontake.setEnabled(false);
                bcancel.setEnabled(false);

            }
            String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);


            countdown.setText(timeLeftFormatted);
        }
        catch (Exception e){
            final String Userg = getIntent().getStringExtra("user");
            final String usera = Userg.replace("@", "");
            final String usern = usera.replace(".", "");
            final DatabaseReference myref5;
            FirebaseDatabase mFirebaseDatabase1 = FirebaseDatabase.getInstance();
            myref5 = mFirebaseDatabase1.getInstance().getReference().child("Bets").child(usern);


            Map<String, Object> updateValues1 = new HashMap<>();
            updateValues1 = new HashMap<>();
            for (int i = 0; i < 37; i++) {
                updateValues1.put("/" + i, 0);
                myref5.updateChildren(updateValues1);
            }
            updateValues1.put("/00", 0);
            updateValues1.put("/2to11", 0);
            updateValues1.put("/2to12", 0);
            updateValues1.put("/2to13", 0);
            updateValues1.put("/1to18A", 0);
            updateValues1.put("/even", 0);
            updateValues1.put("/red", 0);
            updateValues1.put("/black", 0);
            updateValues1.put("/odd", 0);
            updateValues1.put("/19to36", 0);
            updateValues1.put("/1st12", 0);
            updateValues1.put("/2nd12", 0);
            updateValues1.put("/3rd12", 0);

            myref5.updateChildren(updateValues1);

            point=point+tobet;
            tobet=0.0;
            FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference myref=mFirebaseDatabase.getInstance().getReference().child("Member").child(usern);
            Map<String,Object> updateValues = new HashMap<>();

            updateValues.put("/points",point);

            myref.updateChildren(updateValues);
            reset();
        }




    }




    private void reset(){
        tbet.setText("0");
        hjk=0;
        tobet=0.0;

        Won0=0.0; Won00=0.0; Won1=0.0; Won2=0.0; Won3=0.0; Won4=0.0; Won5=0.0; Won6=0.0;
        Won7=0.0; Won8=0.0; Won9=0.0; Won10=0.0; Won11=0.0; Won12=0.0; Won13=0.0; Won14=0.0; Won15=0.0;
        Won16=0.0; Won17=0.0; Won18=0.0; Won19=0.0; Won20=0.0;
        Won21=0.0; Won22=0.0; Won23=0.0; Won24=0.0; Won25=0.0; Won26=0.0;
        Won27=0.0; Won28=0.0; Won29=0.0; Won30=0.0; Won31=0.0; Won32=0.0; Won34=0.0; Won33=0.0; Won35=0.0; Won36=0.0;
        Won1h=0.0; Won2h=0.0; Won3h=0.0; Won4h=0.0; Won5h=0.0; Won6h=0.0;
        Won7h=0.0; Won8h=0.0; Won9h=0.0; Won10h=0.0; Won11h=0.0; Won12h=0.0; Won13h=0.0; Won14h=0.0; Won15h=0.0;
        Won16h=0.0; Won17h=0.0; Won18h=0.0; Won19h=0.0; Won20h=0.0;
        Won21h=0.0; Won22h=0.0; Won23h=0.0; Won24h=0.0; Won25h=0.0; Won26h=0.0;
        Won27h=0.0; Won28h=0.0; Won29h=0.0; Won30h=0.0; Won31h=0.0; Won32h=0.0; Won34h=0.0; Won33h=0.0; Won35h=0.0; Won36h=0.0;

        ;

        winned=0.0;
        button0.setTextColor(Color.WHITE);
        button00.setTextColor(Color.WHITE);
        button1.setTextColor(Color.WHITE);
        button2.setTextColor(Color.WHITE);
        button3.setTextColor(Color.WHITE);
        button4.setTextColor(Color.WHITE);
        button5.setTextColor(Color.WHITE);
        button6.setTextColor(Color.WHITE);
        button7.setTextColor(Color.WHITE);
        button8.setTextColor(Color.WHITE);
        button9.setTextColor(Color.WHITE);
        button10.setTextColor(Color.WHITE);
        button11.setTextColor(Color.WHITE);
        button12.setTextColor(Color.WHITE);
        button13.setTextColor(Color.WHITE);
        button14.setTextColor(Color.WHITE);
        button15.setTextColor(Color.WHITE);
        button16.setTextColor(Color.WHITE);
        button17.setTextColor(Color.WHITE);
        button18.setTextColor(Color.WHITE);
        button19.setTextColor(Color.WHITE);
        button20.setTextColor(Color.WHITE);
        button21.setTextColor(Color.WHITE);
        button22.setTextColor(Color.WHITE);
        button23.setTextColor(Color.WHITE);
        button24.setTextColor(Color.WHITE);
        button25.setTextColor(Color.WHITE);
        button26.setTextColor(Color.WHITE);
        button27.setTextColor(Color.WHITE);
        button28.setTextColor(Color.WHITE);
        button29.setTextColor(Color.WHITE);
        button30.setTextColor(Color.WHITE);
        button31.setTextColor(Color.WHITE);
        button32.setTextColor(Color.WHITE);
        button33.setTextColor(Color.WHITE);
        button34.setTextColor(Color.WHITE);
        button35.setTextColor(Color.WHITE);
        button36.setTextColor(Color.WHITE);
        button2to11.setTextColor(Color.WHITE);
        button2to12.setTextColor(Color.WHITE);
        button2to13.setTextColor(Color.WHITE);
        button1st12.setTextColor(Color.WHITE);
        button2nd12.setTextColor(Color.WHITE);
        button3rd12.setTextColor(Color.WHITE);
        button1to18.setTextColor(Color.WHITE);
        buttoneven.setTextColor(Color.WHITE);
        buttonred.setTextColor(Color.WHITE);
        buttonblack.setTextColor(Color.WHITE);
        buttonodd.setTextColor(Color.WHITE);
        button19to36.setTextColor(Color.WHITE);

        button0.setText("0");
        button00.setText("00");
        button1.setText("1");
        button2.setText("2");
        button3.setText("3");
        button4.setText("4");
        button5.setText("5");
        button6.setText("6");
        button7.setText("7");
        button8.setText("8");
        button9.setText("9");
        button10.setText("10");
        button11.setText("11");
        button12.setText("12");
        button13.setText("13");
        button14.setText("14");
        button15.setText("15");
        button16.setText("16");
        button17.setText("17");
        button18.setText("18");
        button19.setText("19");
        button20.setText("20");
        button21.setText("21");
        button22.setText("22");
        button23.setText("23");
        button24.setText("24");
        button25.setText("25");
        button26.setText("26");
        button27.setText("27");
        button28.setText("28");
        button29.setText("29");
        button30.setText("30");
        button31.setText("31");
        button32.setText("32");
        button33.setText("33");
        button34.setText("34");
        button35.setText("35");
        button36.setText("36");
        button2to11.setText("2 TO 1");
        button2to12.setText("2 TO 1");
        button2to13.setText("2 TO 1");
        button1st12.setText("1ST 12");
        button2nd12.setText("2ND 12");
        button3rd12.setText("3RD 12");
        button1to18.setText("1 TO 18");
        buttoneven.setText("EVEN");
        buttonred.setText("R");
        buttonblack.setText("B");
        buttonodd.setText("ODD");
        button19to36.setText("19 TO 36");








        placebet0=0.0; placebet00=0.0; placebet1=0.0; placebet2=0.0; placebet3=0.0; placebet4=0.0; placebet5=0.0; placebet6=0.0
        ; placebet7=0.0; placebet8=0.0; placebet9=0.0; placebet10=0.0; placebet11=0.0; placebet12=0.0; placebet13=0.0; placebet14=0.0
        ; placebet15=0.0; placebet16=0.0; placebet17=0.0; placebet18=0.0; placebet19=0.0; placebet20=0.0; placebet21=0.0; placebet22=0.0
        ; placebet23=0.0; placebet24=0.0; placebet25=0.0; placebet26=0.0; placebet27=0.0; placebet28=0.0; placebet29=0.0; placebet30=0.0
        ; placebet31=0.0; placebet32=0.0; placebet33=0.0; placebet34=0.0; placebet35=0.0; placebet36=0.0; placebet2to11=0.0; placebet2to12=0.0
        ; placebet2to13=0.0; placebet1st12=0.0; placebet2nd12=0.0; placebet3rd12=0.0; placebet1to18=0.0; placebeteven=0.0; placebetr=0.0; placebetb=0.0
        ; placebetodd=0.0; placebet19to36=0.0; placebet1h=0.0; placebet2h=0.0; placebet3h=0.0; placebet4h=0.0; placebet5h=0.0; placebet6h=0.0
        ; placebet7h=0.0; placebet8h=0.0; placebet9h=0.0; placebet10h=0.0; placebet11h=0.0; placebet12h=0.0; placebet13h=0.0; placebet14h=0.0
        ; placebet15h=0.0; placebet16h=0.0; placebet17h=0.0; placebet18h=0.0; placebet19h=0.0; placebet20h=0.0; placebet21h=0.0; placebet22h=0.0
        ; placebet23h=0.0; placebet24h=0.0; placebet25h=0.0; placebet26h=0.0; placebet27h=0.0; placebet28h=0.0; placebet29h=0.0; placebet30h=0.0
        ; placebet31h=0.0; placebet32h=0.0; placebet33h=0.0; placebet34h=0.0; placebet35h=0.0; placebet36h=0.0;








    }

/*private int  deg(){
    degree = r.nextInt(3600) + 720;
    int g = Integer.parseInt(currentNumber(360 - (degree % 360)));
    if (g <= 12) {
        deg();
    }
    return degree;
}
    private int  deg4(){
        degree = r.nextInt(3600) + 720;
        int g = Integer.parseInt(currentNumber(360 - (degree % 360)));
        if (g > 12 || g==0||g==00 ) {
            deg4();
        }
        return degree;
    }
    private int  deg5(){
        degree = r.nextInt(3600) + 720;
        int g = Integer.parseInt(currentNumber(360 - (degree % 360)));
        if (g > 24 || g<13|| g==0||g==00) {
            deg5();
        }
        return degree;
    }
    private int  deg6(){
        degree = r.nextInt(3600) + 720;
        int g = Integer.parseInt(currentNumber(360 - (degree % 360)));
        if ( g<25|| g==0||g==00) {
            deg6();
        }
        return degree;
    }
    private int  deg2(){
        degree = r.nextInt(3600) + 720;
        int g = Integer.parseInt(currentNumber(360 - (degree % 360)));
        if (g <= 36||g>24) {
            deg2();
        }
        return degree;
    }
    private int  deg1(){
        degree = r.nextInt(3600) + 720;
        int g = Integer.parseInt(currentNumber(360 - (degree % 360)));
        if (g >12 ||g<25) {
            deg1();
        }
        return degree;
    }*/


    private String currentNumber(int degrees){
        String text = "";

        if(degrees >= (FACTOR * 1) && degrees < (FACTOR *3)){
            text = "6";
        }
        if(degrees >= (FACTOR * 3) && degrees < (FACTOR *5)){
            text = "21";
        }
        if(degrees >= (FACTOR * 5) && degrees < (FACTOR *7)){
            text = "33";
        }
        if(degrees >= (FACTOR * 7) && degrees < (FACTOR *9)){
            text = "16";
        }
        if(degrees >= (FACTOR * 9) && degrees < (FACTOR *11)){
            text = "4";
        }
        if(degrees >= (FACTOR * 11) && degrees < (FACTOR *13)){
            text = "23";
        }
        if(degrees >= (FACTOR * 13) && degrees < (FACTOR *15)){
            text = "35";
        }
        if(degrees >= (FACTOR * 15) && degrees < (FACTOR *17)){
            text = "14";
        }
        if(degrees >= (FACTOR * 17) && degrees < (FACTOR *19)){
            text = "2";
        }
        if(degrees >= (FACTOR * 19) && degrees < (FACTOR *21)){
            text = "0";
        }
        if(degrees >= (FACTOR * 21) && degrees < (FACTOR *23)){
            text = "28";
        }
        if(degrees >= (FACTOR * 23) && degrees < (FACTOR *25)){
            text = "9";
        }
        if(degrees >= (FACTOR * 25) && degrees < (FACTOR *27)){
            text = "26";
        }
        if(degrees >= (FACTOR * 27) && degrees < (FACTOR *29)){
            text = "30";
        }
        if(degrees >= (FACTOR * 29) && degrees < (FACTOR *31)){
            text = "11";
        }
        if(degrees >= (FACTOR * 31) && degrees < (FACTOR *33)){
            text = "7";
        }
        if(degrees >= (FACTOR * 33) && degrees < (FACTOR *35)){
            text = "20";
        }
        if(degrees >= (FACTOR * 35) && degrees < (FACTOR *37)){
            text = "32";
        }
        if(degrees >= (FACTOR * 37) && degrees < (FACTOR *39)){
            text = "17";
        }
        if(degrees >= (FACTOR * 39) && degrees < (FACTOR *41)){
            text = "5";
        }
        if(degrees >= (FACTOR * 41) && degrees < (FACTOR *43)){
            text = "22";
        }
        if(degrees >= (FACTOR * 43) && degrees < (FACTOR *45)){
            text = "34";
        }
        if(degrees >= (FACTOR * 45) && degrees < (FACTOR *47)){
            text = "15";
        }
        if(degrees >= (FACTOR * 47) && degrees < (FACTOR *49)){
            text = "3";
        }
        if(degrees >= (FACTOR * 49) && degrees < (FACTOR *51)){
            text = "24";
        }
        if(degrees >= (FACTOR * 51) && degrees < (FACTOR *53)){
            text = "36";
        }
        if(degrees >= (FACTOR * 53) && degrees < (FACTOR *55)){
            text = "13";
        }
        if(degrees >= (FACTOR * 55) && degrees < (FACTOR *57)){
            text = "1";
        }
        if(degrees >= (FACTOR * 57) && degrees < (FACTOR *59)){
            text = "00";
        }
        if(degrees >= (FACTOR * 59) && degrees < (FACTOR *61)){
            text = "27";
        }
        if(degrees >= (FACTOR * 61) && degrees < (FACTOR *63)){
            text = "10";
        }
        if(degrees >= (FACTOR * 63) && degrees < (FACTOR *65)){
            text = "25";
        }
        if(degrees >= (FACTOR * 65) && degrees < (FACTOR *67)){
            text = "29";
        }if(degrees >= (FACTOR * 67) && degrees < (FACTOR *69)){
            text = "12";
        }
        if(degrees >= (FACTOR * 69) && degrees < (FACTOR *71)){
            text = "8";
        }
        if(degrees >= (FACTOR * 71) && degrees < (FACTOR *73)){
            text = "19";
        }
        if(degrees >= (FACTOR * 73) && degrees < (FACTOR *75)){
            text = "31";
        }
        if((degrees >= (FACTOR * 75) && degrees < 360) || (degrees >= 0 && degrees < (FACTOR * 1))){
            text = "18";
        }




        return text;
    }
    public void checkConnection() {
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
        if (null != activeNetwork) {




        } else {

            Intent intLog = new Intent(Roullete.this, Login_form.class);
            startActivity(intLog);


            Toast.makeText(Roullete.this, "Please Connect To Internet", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder a_builder = new AlertDialog.Builder(this);
            a_builder.setMessage("Please Connect To Internet!!!").setCancelable(false).setPositiveButton("Exit!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }
            }).setNegativeButton("Retry", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intLoginUp = new Intent(Roullete.this, Login_form.class);
                    startActivity(intLoginUp);


                }

            });


        }

    }




    @Override
    public void onBackPressed() {

        if(backpressedtime+2000>System.currentTimeMillis()){
            super.onBackPressed();


            try {
                String email = getIntent().getStringExtra("user");
                Intent intToHome = new Intent(Roullete.this, Home.class);
                intToHome.putExtra("email", email);
                intToHome.putExtra("skey",(getIntent().getStringExtra("skey")));
                startActivity(intToHome);
                Roullete.this.onDestroy();


            }catch (Exception e){
                Toast.makeText(getBaseContext(),"Some Problem Encountered",Toast.LENGTH_SHORT).show();
            }
            return;
        }else{
            Toast.makeText(getBaseContext(),"Press Back Again To Exit",Toast.LENGTH_SHORT).show();
        }

        backpressedtime=System.currentTimeMillis();
    }
}

