package madhuri.com.craftzone.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

import madhuri.com.craftzone.DatabaseHelper;
import madhuri.com.craftzone.R;
import madhuri.com.craftzone.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {
    ActivityLoginBinding binding;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_login);
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.loginUsername.getText().toString();
                String password = binding.loginPassword.getText().toString();

                if(validusername() || validpassword()){
                 Intent intent = new Intent(Login.this, Containmain.class);
                 startActivity(intent);
             }
             else {
                 checkuser();
             }
            }
        });
    }
    public Boolean validusername(){
        String val = binding.loginUsername.getText().toString();
        if(val.isEmpty()){
            binding.loginUsername.setError("Username can not be Empty");
        }
        else {
            binding.loginUsername.setError(null);
        }
        return true;
    }

    public Boolean validpassword(){
        String val = binding.loginPassword.getText().toString();
        if(val.isEmpty()){
            binding.loginPassword.setError("Password can not be Empty");
        }
        else {
            binding.loginPassword.setError(null);
        }
        return true;
    }
    public void checkuser(){
        String username = binding.loginUsername.getText().toString().trim();
        String password = binding.loginPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("customer");
        Query chekuserdata = reference.orderByChild("username").equalTo(username);

        chekuserdata.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    binding.loginUsername.setError(null);
                    String passwordfromDB = snapshot.child(username).child(password).getValue(String.class);

                    if(!Objects.equals(passwordfromDB, password)){
                        Intent intent = new Intent(Login.this, Containmain.class);
                        startActivity(intent);
                    }
                    else {
                        binding.loginPassword.setError("Invalid Credentials");
                        binding.loginPassword.requestFocus();
                    }
                }
                else {
                    binding.loginUsername.setError("User does not Exist");
                    binding.loginUsername.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        binding.signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
            }
        });
    }

}