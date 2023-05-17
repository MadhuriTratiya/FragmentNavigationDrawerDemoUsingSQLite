package madhuri.com.craftzone.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import madhuri.com.craftzone.R;
import madhuri.com.craftzone.databinding.ActivitySplashscreenBinding;


public class splashscreen extends AppCompatActivity {
    ActivitySplashscreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashscreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
    public void signup(View view) {
        binding.signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(splashscreen.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
    public void login(View view){
        binding.loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(splashscreen.this, Login.class);
                startActivity(intent);
            }
        });
    }
    public void skipnow(View view){
        binding.skipNowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(splashscreen.this, Containmain.class);
                startActivity(intent);
            }
        });


    ImageView imageView = findViewById(R.id.craftlogo);
        Animation animation = AnimationUtils.loadAnimation(splashscreen.this,R.anim.translate);
        imageView.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashscreen.this,splashscreen.class);
                startActivity(intent);
            }
        },5000);

    }
}