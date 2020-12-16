package stashkevich.bstu.mycontactmanager.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import stashkevich.bstu.mycontactmanager.R;
import stashkevich.bstu.mycontactmanager.services.FingerPrintService;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        FingerPrintService fingerPrintService = new FingerPrintService(getApplicationContext(), login.this);
        fingerPrintService.auth();
    }
}