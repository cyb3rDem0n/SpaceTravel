package cyberdemon.spacetravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextMessage;

    private View view_home;
    private View view_inizia;
    private View view_info;

    private View view_SS;
    private View view_NS;

    private Button toSS;
    private Button toNS;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    view_home.setVisibility(View.VISIBLE);
                    view_info.setVisibility(View.GONE);
                    view_inizia.setVisibility(View.GONE);

                    return true;
                case R.id.navigation_start:
                    mTextMessage.setText(R.string.title_inizia);
                    view_home.setVisibility(View.GONE);
                    view_inizia.setVisibility(View.VISIBLE);
                    view_info.setVisibility(View.GONE);

                    return true;
                case R.id.navigation_info:
                    mTextMessage.setText(R.string.title_informazioni);
                    view_home.setVisibility(View.GONE);
                    view_inizia.setVisibility(View.GONE);
                    view_info.setVisibility(View.VISIBLE);

                    return true;
            }
            return false;
        }

    };

    @Override
    public void onBackPressed() {
        view_home.setVisibility(View.VISIBLE);
        view_info.setVisibility(View.GONE);
        view_inizia.setVisibility(View.GONE);
        view_SS.setVisibility(View.GONE);
        view_NS.setVisibility(View.GONE);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        view_home = (View)findViewById(R.id.home_layout);
        view_inizia = (View)findViewById(R.id.scrollView_main);
        view_info = (View)findViewById(R.id.info_view);

        view_SS = (View)findViewById(R.id.scrollView_ss);
        view_NS = (View)findViewById(R.id.layout_near_stars);

        // mi sposto all'interno del sistema solare
        toSS = (Button)findViewById(R.id.button_sistema_solare);
        toSS.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                view_home.setVisibility(View.GONE);
                view_info.setVisibility(View.GONE);
                view_inizia.setVisibility(View.GONE);
                view_NS.setVisibility(View.GONE);
                view_SS.setVisibility(View.VISIBLE);
            }
        });

        // mi sposto all'interno dei sistemi solari vicini
        toNS = (Button)findViewById(R.id.button_sistemi_solari_vicini);
        toNS.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                view_home.setVisibility(View.GONE);
                view_info.setVisibility(View.GONE);
                view_inizia.setVisibility(View.GONE);
                view_SS.setVisibility(View.GONE);
                view_NS.setVisibility(View.VISIBLE);


            }
        });

        Button toSun = (Button)findViewById(R.id.button_sole);
        toSun.setOnClickListener(this);

        Button toMercury = (Button)findViewById(R.id.button_mercurio);
        toMercury.setOnClickListener(this);

        Button toVenus = (Button)findViewById(R.id.button_venere);
        toVenus.setOnClickListener(this);

        Button toMoon = (Button)findViewById(R.id.button_luna);
        toMoon.setOnClickListener(this);

        Button toMars = (Button)findViewById(R.id.button_marte);
        toMars.setOnClickListener(this);

        Button toJupiter = (Button)findViewById(R.id.button_giove);
        toJupiter.setOnClickListener(this);

        Button toSaturn = (Button)findViewById(R.id.button_saturno);
        toSaturn.setOnClickListener(this);

        Button toUranus = (Button)findViewById(R.id.button_urano);
        toUranus.setOnClickListener(this);

        Button toNeptune = (Button)findViewById(R.id.button_nettuno);
        toNeptune.setOnClickListener(this);

        Button toPluto = (Button)findViewById(R.id.button_plutone);
        toPluto.setOnClickListener(this);



        /*
        toSun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), VehicleActivity.class);
                intent.putExtra("choose", "sole");
                startActivity(intent);
            }
        });
        */
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button_sole:
                Intent intent1 = new Intent(getBaseContext(), VehicleActivity.class);
                intent1.putExtra("choose", "sole");
                startActivity(intent1);
                break;

            case R.id.button_mercurio:
                Intent intent2 = new Intent(getBaseContext(), VehicleActivity.class);

                intent2.putExtra("choose", "mercurio");
                startActivity(intent2);
                break;

            case R.id.button_venere:
                Intent intent3 = new Intent(getBaseContext(), VehicleActivity.class);

                intent3.putExtra("choose", "venere");
                startActivity(intent3);
                break;

            case R.id.button_luna:
                Intent intent4 = new Intent(getBaseContext(), VehicleActivity.class);

                intent4.putExtra("choose", "luna");
                startActivity(intent4);
                break;

            case R.id.button_marte:
                Intent intent5 = new Intent(getBaseContext(), VehicleActivity.class);

                intent5.putExtra("choose", "marte");
                startActivity(intent5);
                break;

            case R.id.button_giove:
                Intent intent6 = new Intent(getBaseContext(), VehicleActivity.class);

                intent6.putExtra("choose", "giove");
                startActivity(intent6);
                break;

            case R.id.button_saturno:
                Intent intent7 = new Intent(getBaseContext(), VehicleActivity.class);

                intent7.putExtra("choose", "saturno");
                startActivity(intent7);
                break;

            case R.id.button_urano:
                Intent intent8 = new Intent(getBaseContext(), VehicleActivity.class);

                intent8.putExtra("choose", "urano");
                startActivity(intent8);
                break;

            case R.id.button_nettuno:
                Intent intent9 = new Intent(getBaseContext(), VehicleActivity.class);

                intent9.putExtra("choose", "nettuno");
                startActivity(intent9);
                break;

            case R.id.button_plutone:
                Intent intent0 = new Intent(getBaseContext(), VehicleActivity.class);

                intent0.putExtra("choose", "plutone");
                startActivity(intent0);
                break;

            default:
                break;

        }
    }
}
