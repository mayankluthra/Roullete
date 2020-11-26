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
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class signup extends AppCompatActivity {
    EditText emailId,password,cpassword;
    Button createacc;
    TextView btlogin;
    FirebaseAuth mFirebaseAuth;
    DatabaseReference reff;
    member member;
    DatabaseReference myref91;
    FirebaseDatabase mFirebaseDatabase=FirebaseDatabase.getInstance();
    int tak;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId =  findViewById(R.id.emailsignup);
        password = findViewById(R.id.passwordsignup);
        cpassword =findViewById(R.id.cpasswordsignup);
       createacc = findViewById(R.id.createaccount);
        final MediaPlayer mysong =MediaPlayer.create(signup.this,R.raw.button);


       btlogin = findViewById(R.id.btlogin);
       member=new member();


       reff= FirebaseDatabase.getInstance().getReference().child("Member");
        myref91=mFirebaseDatabase.getInstance().getReference().child("Totalusers");
        myref91.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                 tak = Integer.parseInt(dataSnapshot.child("count").getValue().toString());





            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(signup.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });

        createacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mysong.start();




                final String email = emailId.getText().toString();
                final String pwd = password.getText().toString();
                String cpwd = cpassword.getText().toString();

                final String usera =email.replace("@","");
                final String usern =usera.replace(".","");
                if(email.isEmpty()){
                    emailId.setError("Please enter email id");
                    emailId.requestFocus();
                }
                else if(pwd.isEmpty()){
                    password.setError("Please enter your Password");
                    password.requestFocus();
                }
                else if(cpwd.isEmpty()){
                    password.setError("Please enter your Confirm Password");
                    password.requestFocus();
                }

                else if(email.isEmpty() && pwd.isEmpty() && cpwd.isEmpty() ){
                    Toast.makeText(signup.this, "Fields Are Empty!",Toast.LENGTH_SHORT).show();
                }
                else if(!email.isEmpty() && !pwd.isEmpty() && !cpwd.isEmpty()){
                    if(pwd.equals(cpwd)) {
                        if(pwd.length()>5) {
                            createacc.setEnabled(false);
                            emailId.setEnabled(false);
                            password.setEnabled(false);
                            cpassword.setEnabled(false);


                            mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(signup.this, new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(signup.this, "SignUp Unsuccessful, Please Try Again", Toast.LENGTH_SHORT).show();
                                        createacc.setEnabled(true);
                                        emailId.setEnabled(true);
                                        password.setEnabled(true);
                                        cpassword.setEnabled(true);

                                    } else {
                                        member.setEmail(email);
                                        member.setPassword(pwd);
                                        member.setTake(0L);
                                        member.setPoints("1");
                                        reff.child(usern).setValue(member);

                                        final DatabaseReference myref6, myref9, myref10, myref15, myref19, myref20;
                                        FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();

                                        myref6 = mFirebaseDatabase.getInstance().getReference().child("Received").child(usern).child("1");
                                        myref9 = mFirebaseDatabase.getInstance().getReference().child("Received").child(usern).child("2");
                                        myref10 = mFirebaseDatabase.getInstance().getReference().child("transfered").child(usern).child("1");
                                        myref15 = mFirebaseDatabase.getInstance().getReference().child("transfered").child(usern).child("2");
                                        myref20 = mFirebaseDatabase.getInstance().getReference().child("Totalusers");
                                        myref19 = mFirebaseDatabase.getInstance().getReference().child("users");

                                        Map<String, Object> updateValues = new HashMap<>();
                                        updateValues.put("/Email", "Game ID");
                                        updateValues.put("/points", "0");
                                        myref6.updateChildren(updateValues);
                                        myref9.updateChildren(updateValues);
                                        myref10.updateChildren(updateValues);
                                        myref15.updateChildren(updateValues);
                                        Map<String, Object> updateValues1 = new HashMap<>();
                                        int tak1 = tak + 1;
                                        updateValues1.put("/" + tak1, usern);
                                        myref19.updateChildren(updateValues1);
                                        Map<String, Object> updateValues2 = new HashMap<>();
                                        updateValues2.put("/count", tak1);
                                        myref20.updateChildren(updateValues2);


                                        startActivity(new Intent(signup.this, Login_form.class));
                                        Toast.makeText(signup.this, "SignUp Successful, Please Login", Toast.LENGTH_SHORT).show();

                                    }

                                }
                            });
                        }else{
                            Toast.makeText(signup.this, "Password Length is Short", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(signup.this, "Password & Confirm Password are Different", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(signup.this,"Error Occured!",Toast.LENGTH_SHORT).show();

                }
            }
        });
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mysong.start();
                startActivity(new Intent(signup.this, Login_form.class));

            }
        });




        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


}
