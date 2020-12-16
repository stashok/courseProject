package stashkevich.bstu.mycontactmanager.views.activities;

import android.os.Bundle;
import android.view.WindowManager;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import stashkevich.bstu.mycontactmanager.R;
import stashkevich.bstu.mycontactmanager.models.Contact;
import stashkevich.bstu.mycontactmanager.utilities.Utility;
import stashkevich.bstu.mycontactmanager.views.fragments.ContactInfoFragment;
import stashkevich.bstu.mycontactmanager.views.fragments.ContactListFragment;


public class MainActivity extends AppCompatActivity implements ContactListFragment.DataPassListener {

    private ContactListFragment fragmentA;
    private ContactInfoFragment fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);

        if (findViewById(R.id.fragment_holder) != null) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            if (savedInstanceState != null) {
                fragmentA = new ContactListFragment();
                fragmentB = new ContactInfoFragment();
                return;
            }

            fragmentA = new ContactListFragment();
            fragmentB = new ContactInfoFragment();

//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.fragment_holder, fragmentA)
//                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_holder, fragmentA)
                    .commit();

            Utility.changeStatusBarColor(this);
        }
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
        } else {
            if (fragmentB.actionMenu != null) {
                fragmentB.actionMenu.close(true);
            }
            getSupportFragmentManager().popBackStack();
        }
    }

    @Override
    public void passData(Contact contact) {
        if (fragmentB != null) {
            Bundle args = new Bundle();
            args.putSerializable("contact", contact);
            fragmentB.setArguments(args);
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    .replace(R.id.fragment_holder, fragmentB)
                    .addToBackStack(null)
                    .commit();
        }
    }

}
