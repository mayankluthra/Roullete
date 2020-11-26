package com.kingmesking.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class changepassword extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b1,b2;
    String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.changepassword);

        e1=(EditText)findViewById(R.id.cpass);
        e2=(EditText)findViewById(R.id.npass);
        e3=(EditText)findViewById(R.id.cnpass);
        b1=(Button)findViewById(R.id.changePaas);
        b2=(Button)findViewById(R.id.back);
        final DatabaseReference myref232;
        FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
        final String Userg=getIntent().getStringExtra("email");
        final String usera =Userg.replace("@","");
        final String usern =usera.replace(".","");
        myref232 = mFirebaseDatabase.getInstance().getReference().child("Member").child(usern);
        myref232.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                String password = dataSnapshot.child("password").getValue().toString();

                pass=password;










            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(changepassword.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }



        });
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                b1.setEnabled(false);
                if (e1.getText().toString().isEmpty()) {
                   b1.setEnabled(true);
                    e1.setError("Please enter Current Password");
                    e1.requestFocus();
                }if (e2.getText().toString().isEmpty()) {
                    b1.setEnabled(true);
                    e2.setError("Please enter Current Password");
                    e2.requestFocus();
                }if (e3.getText().toString().isEmpty()) {
                    b1.setEnabled(true);
                    e3.setError("Please enter Current Password");
                    e3.requestFocus();
                }if (e2.getText().toString().length()<=5) {
                    b1.setEnabled(true);
                    e2.setError("Password Length is Short");
                    e2.requestFocus();
                }if (e3.getText().toString().length()<=5) {
                    b1.setEnabled(true);
                    e3.setError("Password Length is Short");
                    e3.requestFocus();
                }if (e1.getText().toString().equals(e2.getText().toString())) {
                    b1.setEnabled(true);
                    e2.setError("Try New Password ");
                    e2.requestFocus();
                }else {
                    final MediaPlayer mysong =MediaPlayer.create(changepassword.this,R.raw.button);
                    mysong.start();
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (e1.getText().toString().equals(pass)) {
                        if (e2.getText().toString().equals(e3.getText().toString())&&e2.length()>5) {
                            String np= e3.getText().toString();
                            user.updatePassword(np).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        final String Userg=getIntent().getStringExtra("email");
                                        final String usera =Userg.replace("@","");
                                        final String usern =usera.replace(".","");
                                        FirebaseDatabase mFirebaseDatabase=FirebaseDatabase.getInstance();
                                        DatabaseReference myrefd=mFirebaseDatabase.getInstance().getReference().child("Member").child(usern);
                                        Map<String,Object> updateValues = new HashMap<>();
                                        updateValues.put("/password",e3.getText().toString());
                                        myrefd.updateChildren(updateValues);
                                        Intent intSignUp = new Intent(changepassword.this, Login_form.class);
                                        startActivity(intSignUp);
                                        changepassword.this.finish();
                                        changepassword.this.onDestroy();


                                    }else{
                                        b1.setEnabled(true);
                                        b2.setEnabled(true);
                                        Toast.makeText(changepassword.this, "Some Problem Occoured", Toast.LENGTH_SHORT);
                                    }
                                }
                            });


                        }else{
                            b1.setEnabled(true);
                            Toast.makeText(changepassword.this, "New Password & Confirm Password Are Not Same", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        b1.setEnabled(true);
                        Toast.makeText(changepassword.this, "Current Password is Wrong", Toast.LENGTH_SHORT).show();
                    }
                }


            }

        });



    }

}
