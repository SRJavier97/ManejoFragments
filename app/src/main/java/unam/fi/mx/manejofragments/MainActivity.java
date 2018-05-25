package unam.fi.mx.manejofragments;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import unam.fi.mx.manejofragments.Fragments.Fragment1;
import unam.fi.mx.manejofragments.Fragments.Fragment2;
import unam.fi.mx.manejofragments.Fragments.PageAdapter;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.mitoolbar);
        tabLayout = findViewById(R.id.miTablayout);
        viewPager = findViewById(R.id.viewPager);
        setUpViewPager();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    private ArrayList<Fragment> Agregarfragments(){
        //creando lista de fragments
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        //devolviendo lista
        return fragments;
    }

    private void setUpViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),Agregarfragments()));
        tabLayout.setupWithViewPager(viewPager);
    }
}