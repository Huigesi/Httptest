package com.example.httptestdemo;

import java.util.jar.Attributes.Name;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.httptestdemo.R;

public class RegisterActivity extends Activity implements View.OnClickListener{
	private Button register;
	public EditText rgusernameET;
	public EditText rgpasswordET;
	public EditText emailET;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_activity);
		init();
	}

	private void init() {
	
		register=(Button) findViewById(R.id.rg_register);
		rgusernameET=(EditText) findViewById(R.id.rg_user_name);
		rgpasswordET=(EditText) findViewById(R.id.rg_user_psw);
		emailET=(EditText) findViewById(R.id.rg_user_email);
	
		register.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		String url="http://10.10.15.142:8080/web/MyServlet";
		String userName = rgusernameET.getText().toString().trim();
		String password = rgpasswordET.getText().toString().trim();
		switch(v.getId()){
		case R.id.rg_register:
			
			JSONObject jsonObj = new JSONObject();
			try {
				jsonObj.put("username", userName);
				jsonObj.put("password", password);
				System.out.println(jsonObj.toString());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			break;
		
		}
		
	}
	
}
