package br.com.ufcg.sacc2017;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import br.com.ufcg.sacc2017.fragments.FragmentApoioTabs;
import br.com.ufcg.sacc2017.fragments.FragmentProgramacao;
import br.com.ufcg.sacc2017.fragments.FragmentSACC;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setVisibility(View.GONE);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, FragmentSACC.newInstance());
        transaction.commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;

                        switch (item.getItemId()) {
                            case R.id.action_sacc:
                                selectedFragment = FragmentSACC.newInstance();

                                break;
                            case R.id.action_programacao:
                                selectedFragment = FragmentProgramacao.newInstance();

                                break;
                            case R.id.action_apoio:
                                selectedFragment = FragmentApoioTabs.newInstance();

                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

    }


}
