package com.kingmesking.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Login_form extends AppCompatActivity {
    long backpressedtime;
    EditText emailId, password;
    Button Signup, Login;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);


        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.emaillogin);
        password = findViewById(R.id.passwordlogin);
        Login = findViewById(R.id.login);
        Signup = findViewById(R.id.signup);
        final MediaPlayer mysong =MediaPlayer.create(Login_form.this,R.raw.button);
        Signup.setEnabled(true);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();


            }
        };


        Login.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                checkConnection();
                final String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                if (email.isEmpty()) {

                    emailId.setError("Please enter email id");
                    emailId.requestFocus();
                } else if (pwd.isEmpty()) {

                    password.setError("Please enter your password");
                    password.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {

                    Toast.makeText(Login_form.this, "Fields Are Empty!", Toast.LENGTH_SHORT).show();
                }else if (!email.isEmpty() && !pwd.isEmpty()) {
                    Login.setEnabled(false);
                    Signup.setEnabled(false);
                    emailId.setEnabled(false);
                    password.setEnabled(false);
                  //  if(email.equals(1) && pwd.equals(1)){

                  //  }
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(Login_form.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {

                            if (!task.isSuccessful()) {
                                Toast.makeText(Login_form.this, "Login Error, Please Login Again", Toast.LENGTH_SHORT).show();
                                Login.setEnabled(true);
                                Signup.setEnabled(true);
                                emailId.setEnabled(true);
                                password.setEnabled(true);

                            } else {
                                mysong.start();
                                Random dice = new Random();
                                int num,gf,gh,fd,ew,re;
                                num = dice.nextInt(1000);
                                gf = dice.nextInt(5000);
                                gh = dice.nextInt(10);
                                fd = dice.nextInt(100000);
                                ew = dice.nextInt(100940);
                                re = dice.nextInt(100094);
                                final String Userg=email;
                                final String usera =Userg.replace("@","");
                                final String usern =usera.replace(".","");
                                String sessionkey="ah5746"+num+"rhyetyru"+gf+fd+"kfgjjirjcns45543fnj4j3j3j3"+gh+ew+re+"i5i5o3";
                                final DatabaseReference myref232;
                                FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
                                myref232 = mFirebaseDatabase.getInstance().getReference().child("Session").child(usern);
                                Map<String, Object> updateValues765 = new HashMap<>();
                                updateValues765.put("/key", sessionkey);
                                myref232.updateChildren(updateValues765);
                                myref232.updateChildren(updateValues765);

                                go(sessionkey);

                            }
                        }
                    });
                } else {
                    Toast.makeText(Login_form.this, "Error Occured!", Toast.LENGTH_SHORT).show();
                }
            }

        });
        Signup.setOnClickListener(new View.OnClickListener() {

            @Override


            public void onClick(View v) {
                mysong.start();
                Login.setEnabled(false);
                Signup.setEnabled(false);
                emailId.setEnabled(false);
                password.setEnabled(false);
                checkConnection();
                Intent intSignUp = new Intent(Login_form.this, signup.class);
                startActivity(intSignUp);

            }

        });


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    public void checkConnection() {
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
        if (null != activeNetwork) {

                Login.setEnabled(true);
                Signup.setEnabled(true);


            }
        else {
                Login.setEnabled(false);
                Signup.setEnabled(false);
            Intent intLog = new Intent(Login_form.this, Login_form.class);
            startActivity(intLog);



                Toast.makeText(Login_form.this, "Please Connect To Internet", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder a_builder = new AlertDialog.Builder(this);
                a_builder.setMessage("Please Connect To Internet!!!").setCancelable(false).setPositiveButton("Exit!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }
                }).setNegativeButton("Retry", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intLoginUp = new Intent(Login_form.this, Login_form.class);
                    startActivity(intLoginUp);


                }

            });


            }

    }
    @Override
    protected void onPause(){
        super.onPause();
        Login_form.this.finish();
    }
    public void go(String sessionkey){
        synchronized (sessionkey) {

            String email = emailId.getText().toString();
            Intent intToHome = new Intent(Login_form.this, Home.class);
            intToHome.putExtra("email", email);
            intToHome.putExtra("skey", sessionkey);
            startActivity(intToHome);
        }
    }
    @Override
    public void onBackPressed() {

        if(backpressedtime+2000>System.currentTimeMillis()){
            super.onBackPressed();
           Login_form.this.onDestroy();
            return;
        }else{
            Toast.makeText(getBaseContext(),"Press Back Again To Exit",Toast.LENGTH_SHORT).show();
        }

        backpressedtime=System.currentTimeMillis();
    }
}
