package stashkevich.bstu.mycontactmanager.services;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import java.util.concurrent.Executor;



import stashkevich.bstu.mycontactmanager.views.activities.MainActivity;
import stashkevich.bstu.mycontactmanager.views.activities.SplashActivity;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;


public class FingerPrintService {
    public BiometricPrompt.PromptInfo promptInfo;

    private Executor executor;
    private BiometricPrompt biometricPrompt;

    public FingerPrintService(final Context context, FragmentActivity fragmentActivity) {
        final Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
        executor = ContextCompat.getMainExecutor(context);

        biometricPrompt = new BiometricPrompt(fragmentActivity,
                executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode,
                                              @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(context,
                        "Authentication error: " + errString, Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onAuthenticationSucceeded(
                    @NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                context.startActivity(intent);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(context, "Authentication failed",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biometric login")
                .setSubtitle("Log in using your biometric credential")
                .setNegativeButtonText("Cancel")
                .build();

    }

    public void auth() {
        biometricPrompt.authenticate(promptInfo);
    }
}
