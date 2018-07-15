package com.lequiz.practice;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Shader;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;


public class HomeActivity extends AppCompatActivity {

    protected DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    protected CircleImageView profile_header, profile_home;
    protected CardView currentAffairs, computer, mathematics, reasoning, generalScience, english, technology, sports, special, entertainment;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


// toolbar implementation
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(null);

        // user name on home page gradient
        userNameInGradient();


        // open drawer when navigation button is tapped
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_drawer_indicator);

        // implementing item of navigation drawer
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerview = navigationView.getHeaderView(0);
        profile_header = headerview.findViewById(R.id.profile_header);
        setupDrawerContent(navigationView); // default true



        currentAffairs = findViewById(R.id.current_affairs_card_view);
        computer = findViewById(R.id.computer_card_view);
        mathematics = findViewById(R.id.mathematics_card_view);
        reasoning = findViewById(R.id.reasoning_card_view);
        generalScience = findViewById(R.id.general_science_card_view);
        english = findViewById(R.id.english_card_view);
        technology = findViewById(R.id.technology_card_view);
        sports = findViewById(R.id.sports_card_view);
        special = findViewById(R.id.special_card_view);
        entertainment = findViewById(R.id.entertainment_card_view);
        profile_home = findViewById(R.id.profile_home);

        currentAffairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CurrentAffairsActivity.class);
                startActivity(intent);
            }
        });
        computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ComputerActivity.class);
                startActivity(intent);
            }
        });
        mathematics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MathematicsActivity.class);
                startActivity(intent);
            }
        });
        reasoning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ReasoningActivity.class);
                startActivity(intent);
            }
        });
        generalScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, GeneralScienceActivity.class);
                startActivity(intent);
            }
        });
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, EnglishActivity.class);
                startActivity(intent);
            }
        });
        technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, TechnologyActivity.class);
                startActivity(intent);
            }
        });
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SportsActivity.class);
                startActivity(intent);
            }
        });
        special.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SpecialActivity.class);
                startActivity(intent);
            }
        });
        entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, EntertainmentActivity.class);
                startActivity(intent);
            }
        });

        profile_header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PA = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(PA);
            }
        });
        profile_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PA = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(PA);
            }
        });


    } // onCreate method



    //show a dialog message when click back button exit of nor also drawer layout closed or not
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
            } else {
                exitByBackKey();
            }
            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {
        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setMessage("Do you want to exit application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();
                        //close();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                }).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_if = item.getItemId();
        switch (res_if) {
            case R.id.profile:
                Intent profileA = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(profileA);
                break;
            case R.id.notifications:
                Intent NavNotification = new Intent(HomeActivity.this, NavNotifications.class);
                startActivity(NavNotification);
                break;
            case R.id.leaderboard:
                Intent NavLeaderboard = new Intent(HomeActivity.this, NavLeaderboard.class);
                startActivity(NavLeaderboard);

                break;
            case R.id.lesson_factory:
                Toast.makeText(getApplicationContext(), "Lesson Factory", Toast.LENGTH_LONG).show();
                break;
            case R.id.quiz_factory:
                Toast.makeText(getApplicationContext(), "Quiz Factory", Toast.LENGTH_LONG).show();
                break;
            case R.id.invite_friends:
                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, "Le Quiz");
                    String sAux = "\nRefer this code and get 10 ₹ after successful Installation \n\n";
                    sAux = sAux + "https://play.google.com/store/apps/details?id=com.quizup.core \n\n";
                    i.putExtra(Intent.EXTRA_TEXT, sAux);
                    startActivity(Intent.createChooser(i, "Invite Friend"));
                } catch (Exception e) {
                    //e.toString();
                }
                break;
            case R.id.rate:
                Toast.makeText(getApplicationContext(), "Rate us", Toast.LENGTH_LONG).show();
                break;
            case R.id.settings:
                Intent NavSettings = new Intent(HomeActivity.this, NavSettings.class);
                startActivity(NavSettings);
                break;
        }
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return true;
    }


    private void setupDrawerContent(final NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int res_id = menuItem.getItemId();
                switch (res_id) {
                    case R.id.home_activity:
                        menuItem.setChecked(false);
                        menuItem.setCheckable(false);
                        mDrawerLayout.closeDrawers();
                        break;

                    case R.id.leaderboard:
                        Intent navLeaderboard = new Intent(HomeActivity.this, NavLeaderboard.class);
                        startActivity(navLeaderboard);
                        break;

                    case R.id.notifications:
                        Intent navNotification = new Intent(HomeActivity.this, NavNotifications.class);
                        startActivity(navNotification);
                        break;

                    case R.id.payment:
                        Intent navPayment = new Intent(HomeActivity.this, NavPayment.class);
                        startActivity(navPayment);
                        break;

                    case R.id.settings:
                        Intent navSettings = new Intent(HomeActivity.this, NavSettings.class);
                        startActivity(navSettings);
                        break;

                    case R.id.invite_friends:
                        Intent navFriends = new Intent(HomeActivity.this,NavInviteFriends.class);
                        startActivity(navFriends);
                        break;

                    case R.id.feedback:
                        mDrawerLayout.closeDrawers();
                        makeFeedBackIntent();
                        break;

                    case R.id.about_us:
                        Intent NavAboutUs = new Intent(HomeActivity.this, NavAboutUs.class);
                        startActivity(NavAboutUs);
                        break;

                }
                menuItem.setChecked(false);
                menuItem.setCheckable(false);
                return true;
            }
        });

    }


    public void makeFeedBackIntent() {
        String osVersion = Build.VERSION.RELEASE;
        Intent chooser;
        String locale = getResources().getConfiguration().locale.getDisplayCountry();
        String manufacturerAndModal = Build.MANUFACTURER + " : " + Build.MODEL;
        String msgtxt = "-----------------------------------------------------" + "\n";
        msgtxt = msgtxt + "Support Diagnostics (Do Not Delete)" + "\n" + "-----------------------------------------------------" + "\n";
        msgtxt = msgtxt + "U: " + getString(R.string.user_name) + "\n" + "V: " + osVersion + "\n" + "M: " + manufacturerAndModal + "\n" + "S: " + Build.VERSION.SDK_INT + "\n" + "G: " + locale + "\n";
        msgtxt = msgtxt + "-----------------------------------------------------" + "\n\n";
        Intent feedbackIntent = new Intent(Intent.ACTION_SEND);
        feedbackIntent.setData(Uri.parse("mailto:"));
        String[] to = {"feedback@lequiz.com"};
        feedbackIntent.putExtra(Intent.EXTRA_EMAIL, to);
        feedbackIntent.putExtra(Intent.EXTRA_SUBJECT, "FEEDBACK FROM PRECIOUS USERS");
        feedbackIntent.putExtra(Intent.EXTRA_TEXT, msgtxt);
        feedbackIntent.setType("message/rfc822");
        chooser = Intent.createChooser(feedbackIntent, "Send Feedback Through Email");
        startActivity(chooser);
    }

    public void userNameInGradient() {
        TextView txt = findViewById(R.id.user_name);
        Shader textShader = new LinearGradient(0, 0, 180, 0,
                new int[]{getResources().getColor(R.color.blueOnHomeText), getResources().getColor(R.color.purpleOnHomeText)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        txt.getPaint().setShader(textShader);

        TextView txt1 = findViewById(R.id.wishing);
        Shader textShader1 = new LinearGradient(0, 0, 180, 0,
                new int[]{getResources().getColor(R.color.blueOnHomeText), getResources().getColor(R.color.purpleOnHomeText)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        txt1.getPaint().setShader(textShader1);
    }
} // activity class