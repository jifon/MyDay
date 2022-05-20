package com.example.myday.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myday.R;
import com.example.myday.data.ModelDao;
import com.example.myday.data.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnGo;
    TextView activity;
    TextView price;
    TextView link;
    TextView type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
//        onClick();

        btnGo.setOnClickListener(v->{
            RetrofitBuilder.getInstance().getActivities().enqueue(new Callback<ModelDao>() {
                @Override
                public void onResponse(Call<ModelDao> call, Response<ModelDao> response) {
                    if(response.isSuccessful() && response.body() != null){
                        activity.setText(response.body().getActivity());
                        price.setText(String.valueOf(response.body().getPrice()+" dollars"));
                        type.setText(response.body().getType());
                        link.setText(response.body().getLink());
                    }
                }

                @Override
                public void onFailure(Call<ModelDao> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                }
            });
        });
//        onClick();
    }

    void init(){
        btnGo = findViewById(R.id.btnGo);
        activity = findViewById(R.id.activity);
        price = findViewById(R.id.price);
        link = findViewById(R.id.link);
        type = findViewById(R.id.type);
    }


    void onClick(){
        btnGo.setOnClickListener(v->{
            Log.d("CHECKonClick", "Button is clicked");
        });
    }
}