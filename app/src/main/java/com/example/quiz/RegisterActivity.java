package com.example.quiz;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {


    TextView AlreadyNewAccount;
    EditText inputEmail;
    EditText inputPassword;
    EditText inputConfirmPassword;
    Button btnRegister;
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    DatabaseReference userRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        AlreadyNewAccount = findViewById(R.id.AlreadyNewAccount);

        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        inputConfirmPassword = findViewById(R.id.inputConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);

        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        AlreadyNewAccount.setOnClickListener(view -> startActivity(new Intent(RegisterActivity.this, LoginScreen.class)));

        btnRegister.setOnClickListener(view -> performAuth());
    }

    private void performAuth() {

        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        String ConfirmPassword = inputConfirmPassword.getText().toString();

        if(password.isEmpty() || password.length()<6){
            inputPassword.setError("Enter Proper Password");
        }else if(!password.equals(ConfirmPassword)){
            inputConfirmPassword.setError("Password Doesn't Match");
        }else {
            progressDialog.setMessage("Please Wait, Registration. . .");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        addUserToDatabase(email);
                    }else{
                        Toast.makeText(RegisterActivity.this, "Something is wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


        if(isEmailValid(email)){
            Toast.makeText(getApplicationContext(), "Email valid", Toast.LENGTH_SHORT).show();
        }
        else{
            inputEmail.setError("Invalid");
            Toast.makeText(getApplicationContext(), "Email invalid", Toast.LENGTH_SHORT).show();
        }
    }

    public void addUserToDatabase(String email){
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        User user = new User(email, uid, "");

        userRef = FirebaseDatabase.getInstance().getReference("Users").push();
        user.setKey(userRef.getKey());

        userRef.setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    sendUserToNextActivity();
                    Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Something is wrong", Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }
        });
    }

    private boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void sendUserToNextActivity() {
        Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}

