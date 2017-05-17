package cyberdemon.spacetravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Test;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by rekrux on 06/05/2017.
 */

public class VehicleActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;

    long sole = 150000000L;
    long mercurio = 91500000L;
    long venere = 42000000L;
    long terra = 1; //4 debby
    long luna = 400000L;
    long marte = 78000000L;
    long giove = 630000000L;
    long saturno = 1281000000L;
    long urano = 2721000000L;
    long nettuno = 4359000000L;
    long plutone = 6000000000L;

    obj_ss sole_obj = new obj_ss("sole", sole);
    obj_ss mercurio_obj = new obj_ss("mercurio", mercurio);
    obj_ss venere_obj = new obj_ss("venere", venere);
    obj_ss luna_obj = new obj_ss("luna", luna);
    obj_ss marte_obj = new obj_ss("marte", marte);
    obj_ss giove_obj = new obj_ss("giove", giove);
    obj_ss saturno_obj = new obj_ss("saturno", saturno);
    obj_ss urano_obj = new obj_ss("urano", urano);
    obj_ss nettuno_obj = new obj_ss("nettuno", nettuno);
    obj_ss plutone_obj = new obj_ss("plutone", plutone);

    int bici = 40;
    int utilitaria = 100;
    int sportiva = 220;
    int scooter = 60;
    int moto_sportiva = 180;
    int voyager1 = 61200;
    int apllo11 = 20000;
    int light_speed = 1079252849; // km/h

    long long_dist;

    View result;
    View hide_me;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        textView = (TextView) findViewById(R.id.durata);

        result = (View) findViewById(R.id.time_view);
        hide_me = (View) findViewById(R.id.layout_vehicle);

        String intent_dest = getIntent().getStringExtra("choose");

        LinkedList<obj_ss> list_ss = new LinkedList<>();

        list_ss.add(sole_obj);
        list_ss.add(mercurio_obj);
        list_ss.add(venere_obj);
        list_ss.add(luna_obj);
        list_ss.add(marte_obj);
        list_ss.add(giove_obj);
        list_ss.add(saturno_obj);
        list_ss.add(urano_obj);
        list_ss.add(nettuno_obj);
        list_ss.add(plutone_obj);


        for(int i =0; i < list_ss.size(); i++){
            if(list_ss.get(i).getName().equals(intent_dest)){
                long_dist = list_ss.get(i).getDts();
            }
        }

/*
        Iterator<obj_ss> iterator = list_ss.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getName().equals(intent_dest)) {
                long_dist = list_ss.iterator().next().getDts();
            }else
                Toast.makeText(getApplicationContext(), "ERRORE "+intent_dest, Toast.LENGTH_SHORT).show();
        }
*/

        Button bici = (Button) findViewById(R.id.button_bici);
        bici.setOnClickListener(this);

        Button utilitaria = (Button) findViewById(R.id.button_utilitaria);
        utilitaria.setOnClickListener(this);

        Button sportiva = (Button) findViewById(R.id.button_sportiva);
        sportiva.setOnClickListener(this);

        Button scooter = (Button) findViewById(R.id.button_scooter);
        scooter.setOnClickListener(this);

        Button moto_sportiva = (Button) findViewById(R.id.button_moto_sportiva);
        moto_sportiva.setOnClickListener(this);

        Button voyager1 = (Button) findViewById(R.id.button_voyager1);
        voyager1.setOnClickListener(this);

        Button apollo11 = (Button) findViewById(R.id.button_apollo11);
        apollo11.setOnClickListener(this);

        Button vel_luce = (Button) findViewById(R.id.button_light);
        vel_luce.setOnClickListener(this);


        /*
        toSun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), CalculationActivity.class);
                intent.putExtra("choosed_v", intent_dest);
                intent.putExtra("choosed_d", "bici");
                startActivity(intent);}});
        */
    }

    public void time_(int vehicle_speed, long intent_dest) {

        double time = 0;
        double second = 0;
        double minutes = 0;
        double hours = 0;
        double day = 0;
        double week = 0;
        double month = 0;
        double year = 0;

        time = (double) intent_dest / vehicle_speed; // sec

        if(time <= 0.0009){
            second = time * 3600;
            String result = String.format("%.1f", second);
            textView.setText(result + " secondi");

        } else if(time > 0.0009 && time <= 0.9){
            //time = (double) intent_dest / vehicle_speed;
            minutes = (time * 60) ;
            String result = String.format("%.1f", minutes);
            textView.setText(result + " minuti");

        } else if(time > 1 && time <= 24){
            hours = time;
            String result = String.format("%.1f", hours);
            textView.setText(result + " ore");

        } else if (time > 24) {
            day =  time / 24; // h in a day
            week = time / 168; // h in a week
            month = time / 730; // h in a  month
            year = time / 8760; // h in a  year

            String result = String.format("%.1f", day);
            String result_ = String.format("%.1f", week);
            String result__ = String.format("%.1f", month);
            String result___ = String.format("%.1f", year);

            textView.setText(result + " giorni"
                    + "\n\n" + result_ + " settimane"
                    + "\n\n" + result__ + " mesi"
                    + "\n\n" + result___ + " anni");
        }


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button_bici:
                time_(bici, long_dist);
                result.setVisibility(View.VISIBLE);
                hide_me.setVisibility(View.GONE);
                break;

            case R.id.button_utilitaria:
                time_(utilitaria, long_dist);
                result.setVisibility(View.VISIBLE);
                hide_me.setVisibility(View.GONE);
                break;

            case R.id.button_sportiva:
                time_(sportiva, long_dist);
                result.setVisibility(View.VISIBLE);
                hide_me.setVisibility(View.GONE);
                break;

            case R.id.button_scooter:
                time_(scooter, long_dist);
                result.setVisibility(View.VISIBLE);
                hide_me.setVisibility(View.GONE);
                break;

            case R.id.button_moto_sportiva:
                time_(moto_sportiva, long_dist);
                result.setVisibility(View.VISIBLE);
                hide_me.setVisibility(View.GONE);
                break;

            case R.id.button_voyager1:
                time_(voyager1, long_dist);
                result.setVisibility(View.VISIBLE);
                hide_me.setVisibility(View.GONE);
                break;

            case R.id.button_apollo11:
                time_(apllo11, long_dist);
                result.setVisibility(View.VISIBLE);
                hide_me.setVisibility(View.GONE);
                break;

            case R.id.button_light:
                time_(light_speed, long_dist);
                result.setVisibility(View.VISIBLE);
                hide_me.setVisibility(View.GONE);
                break;

            default:
                break;

        }
    }
}
