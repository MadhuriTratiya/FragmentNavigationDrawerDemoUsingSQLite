
package madhuri.com.craftzone.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import madhuri.com.craftzone.DatabaseHelper;
import madhuri.com.craftzone.R;
import madhuri.com.craftzone.databinding.ActivitySignUpBinding;

public class SignUp extends AppCompatActivity {
    ActivitySignUpBinding binding;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_sign_up);
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);
        binding.signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.signupUsername.getText().toString();
                String password = binding.signupPassword.getText().toString();

                if(email.equals(" ")|| password.equals(" ")){
                    Toast.makeText(SignUp.this, "All Fields are Mandatory", Toast.LENGTH_SHORT).show();
                }
                else {
                           Boolean insert = databaseHelper.insertdata(email,password);
                           if(insert){
                               Toast.makeText(SignUp.this, "SignUp Successfully", Toast.LENGTH_SHORT).show();
                               Intent  intent = new Intent(getApplicationContext(), Login.class);
                               startActivity(intent);
                           }
                           else {
                               Toast.makeText(SignUp.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                           }
                       }
                       }
        });
        binding.loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });
    }
}