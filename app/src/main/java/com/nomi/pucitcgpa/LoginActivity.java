package com.nomi.pucitcgpa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    EditText _nameText , _emailText  ;
    Button _loginButton ;
    ImageView _imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container), true);
        fade.excludeTarget(android.R.id.statusBarBackground, true);
        fade.excludeTarget(android.R.id.navigationBarBackground, true);
        fade.excludeTarget(android.R.id.background , true);

        _nameText = findViewById(R.id.input_name);
        _emailText = findViewById(R.id.input_email);
        _loginButton = findViewById(R.id.btn_login);
        _imageView = findViewById(R.id.image_activity_1);
        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                if (validate()) {
                    login();

                }else{
                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public void login() {
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        Toast.makeText(LoginActivity.this, "Welcome "+_nameText.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                }, 1000);
        openCalculationActivity();

    }
    public boolean validate() {

        boolean valid = true;
        User user = User.getInstance();

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        name = name.toUpperCase();
        email = email.toUpperCase();

        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("at least 3 characters");
            valid = false;
            return false;
        } else {
            user.setUser_name(name);
            _nameText.setError(null);
        }

        if (email.isEmpty() ) {
            _emailText.setError("enter a valid email address");
            valid = false;
            return false;
        } else {
            _emailText.setError(null);
        }
        if(email.substring(0,3).equals("BIT") || email.substring(0, 3).equals("BSE") || email.substring(0, 3).equals("BCS") || email.substring(0, 3).equals("MCS") || email.substring(0, 3).equals("MIT")){
            user.setUser_degree(email.substring(0,3));
            if(email.substring(3,4).equals("F")) {
                if(email.substring(6,7).equals("A") || email.substring(6,7).equals("M")){
                    user.setShift(email.substring(6,7));
                    if(email.substring(7,8).equals("5") || email.substring(7,8).equals("0")){
                        user.setCampus(email.substring(7,8));
                        if(email.substring(10,11).equals("@")) {
                            if (email.substring(11, 16).equals("PUCIT")) {
                                if (email.substring(16,17).equals(".")) {
                                    if (email.substring(17, 20).equals("EDU")) {
                                        if (email.substring(20, 23).equals(".PK")) {
                                            valid = true;
                                            user.setUser_email(email);
                                            user.setUser_rollNo(email.substring(0, 10));
                                            user.setUser_batch(email.substring(4, 6));
                                        } else {
                                            _emailText.setError("you forget to put '.PK' after 'EDU'");
                                            valid = false; }
                                    } else {
                                        _emailText.setError("you forget to put 'EDU' after '.'");
                                        valid = false; }
                                } else {
                                    _emailText.setError("you forget to put '.' after pucit");
                                    valid = false; }
                            } else {
                                _emailText.setError("you forget to put 'PUCIT'");
                                valid = false; }
                        }else{
                            _emailText.setError("you forget to put '@' ");
                            valid = false; }
                    }else {
                        _emailText.setError("Invalid campus");
                        valid= false; }
                }else{
                    valid= false;
                    _emailText.setError("Invalid shift"); }
            }else {
                valid= false;
                _emailText.setError("Invalid fall"); }
        } else {
            valid= false;
            _emailText.setError("Invalid degree"); }

        return valid;
    }
    private void openCalculationActivity() {
        Intent intent = new Intent(this , CalculationActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(LoginActivity.this ,_imageView , Objects.requireNonNull(ViewCompat.getTransitionName(_imageView)));
        startActivity(intent , options.toBundle());
    }

}