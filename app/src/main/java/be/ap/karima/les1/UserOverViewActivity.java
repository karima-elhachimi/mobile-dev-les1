package be.ap.karima.les1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;

public class UserOverViewActivity extends AppCompatActivity {

    public static final int SUB_ACTIVITY_CREATE_USER = 10; //dit is een eigen verzonnen activity code

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_overview);
        boolean userExists = false;

        if(!userExists) {

            Intent intent = new Intent(this,
                    CreateUserActivity.class);

            startActivityForResult(intent, SUB_ACTIVITY_CREATE_USER);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);

        if( requestCode == SUB_ACTIVITY_CREATE_USER ) {
            Bundle extras = data.getExtras();
            if( extras != null) {
                String name = extras.getString(User.USER_NAME);
                boolean gender = extras.getBoolean(User.USER_GENDER);
                user = new User(name, gender);
                updateUserInterface();
            }

        }
    }

    private void updateUserInterface(){

    }
}
