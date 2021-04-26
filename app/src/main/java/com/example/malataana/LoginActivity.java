package com.example.malataana;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText editTextEmail, editTextPassword;
    EditText editTextRegisterEmail, editTextRegisterPassword;
    private Button btnLogin, btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        mAuth = FirebaseAuth.getInstance();
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextRegisterEmail = findViewById(R.id.edtRegisterEmail);
        editTextRegisterPassword = findViewById(R.id.edtRegisterPassword);
        btnLogin = findViewById(R.id.buttonLogin);
        btnRegister = findViewById(R.id.buttonRegister);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                if(email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Внесете лозинка и e-mail за да се најавите.",Toast.LENGTH_SHORT).show();
                    return;
                }
                login(email,password);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextRegisterEmail.getText().toString().isEmpty() || editTextRegisterPassword.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Внесете лозинка и e-mail за да се регистрирате.",Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    checkIfEmailExists(editTextRegisterEmail);
                }
            }
        });
    }

    private void checkIfEmailExists(EditText emailRegister) {
        mAuth.fetchSignInMethodsForEmail(emailRegister.getText().toString()).addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
            @Override
            public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                if (Objects.requireNonNull(task.getResult()).getSignInMethods().size() == 0){
                    // email not existed
                    register(emailRegister.getText().toString(), editTextRegisterPassword.getText().toString());
                } else {
                    // email existed
                    Toast.makeText(getApplicationContext(),"Веќе постои профил асоциран со внесениот e-mail.",Toast.LENGTH_SHORT).show();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void register(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Регистрацијата беше успешна.", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Регистрацијата не беше успешна.", Toast.LENGTH_LONG).show();
                        }
                    }
                })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                e.printStackTrace();
            }
        });;
    }
    private void login(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            navigateLoggedInUser();
                        } else {
                            Toast.makeText(LoginActivity.this, "Внесете валиден e-mail или валидна лозинка. ",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void navigateLoggedInUser() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(checkIfLoggedIn()) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        } else {
            //do toast message
            Toast.makeText(getApplicationContext(),"Најавете се пред да продолжите со користење на апликацијата.", Toast.LENGTH_SHORT);
        }
    }

    private boolean checkIfLoggedIn() {
        return mAuth.getCurrentUser() != null;
    }
}