package com.example.class263;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText name, email, phone;
    ProgressBar progressBar;
    AppCompatButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.username);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        progressBar = findViewById(R.id.progressBar);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String myName = name.getText().toString();
                String myEmail = email.getText().toString();
                String myPhone = phone.getText().toString();

                if (myName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill the Name", Toast.LENGTH_SHORT).show();
                    return;
                } else if ( myEmail.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill the Email", Toast.LENGTH_SHORT).show();
                    return;
                } else if (myPhone.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill the Phone", Toast.LENGTH_SHORT).show();
                    return;
                }

                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "http://192.168.0.161/Apps/data.php?n=" + myName + "&e=" + myEmail + "&p=" + myPhone;

                Log.d("MainActivity", "URL: " + url);

                progressBar.setVisibility(View.VISIBLE);
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(MainActivity.this, "Data saved!", Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "Error: " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });



                queue.add(stringRequest);




            }
        });
    }
}













//package com.example.class263;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ProgressBar;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.AppCompatButton;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//import com.google.android.material.textfield.TextInputEditText;
//
//public class MainActivity extends AppCompatActivity {
//
//    TextInputEditText name, email, phone;
//    ProgressBar progressBar;
//    AppCompatButton btn;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        name = findViewById(R.id.username);
//        email = findViewById(R.id.email);
//        phone = findViewById(R.id.phone);
//        progressBar = findViewById(R.id.progressBar);
//        btn = findViewById(R.id.btn);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//
//                String myName = name.getText().toString();
//                String myEmail = email.getText().toString();
//                String myPhone = phone.getText().toString();
//
//                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
//                String url = "http://192.168.0.161/Apps/data.php?n="+myName+"&e="+myEmail+"&p="+myPhone;
//
//                progressBar.setVisibility(View.VISIBLE);
//                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//
//                                progressBar.setVisibility(View.GONE);
//                                Toast.makeText(MainActivity.this, "Data saved!", Toast.LENGTH_SHORT).show();
//
//
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                });
//
//
//                queue.add(stringRequest);
//
//            }
//        });
//
//
//
//
//    }//end onCreate bundle
//}//end AppCompatActivity