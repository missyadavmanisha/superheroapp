package com.codingblocks.customlistview2;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
int count=0;
String str="",str1="",str2="";
Button btn;
     EditText edit;
    EditText edit1;
    EditText edit2;
    String newSuperHero;
    String newSuperHero1;
    String newSuperHero2;
    ArrayList<SuperHero> superHeroes=SuperHero.getrand();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loaddata();
        ListView listView = findViewById(R.id.ListView);
        btn=findViewById(R.id.button);
        edit=findViewById(R.id.edit);
        edit1=findViewById(R.id.edit1);
        edit2=findViewById(R.id.edit2);
        Button button =(Button) findViewById(R.id.button1);



        btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              newSuperHero = edit.getText().toString();
              newSuperHero1  = edit1.getText().toString();
              newSuperHero2  = edit2.getText().toString();
              superHeroes.add(new SuperHero(newSuperHero,newSuperHero1,newSuperHero2));


          }

      });
        SuperheroAdapter superheroAdapter = new SuperheroAdapter();

        listView.setAdapter(superheroAdapter);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onsavedata();

            }
        });





    }

    private void onsavedata(){
        SharedPreferences sharedPreferences = getSharedPreferences("superhero",MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson=new Gson();
        String json=   gson.toJson(superHeroes);
        editor.putString("supersum",json);
        editor.apply();


    }

    private void loaddata() {
        SharedPreferences sharedPreferences = getSharedPreferences("superhero",MODE_PRIVATE);
        Gson gson=new Gson();
        String json=sharedPreferences.getString("supersum",null);
        Type type=new TypeToken<ArrayList<SuperHero>>() {}.getType();
        superHeroes=gson.fromJson(json,type);
        /*if(superHeroes==null)
        {
         superHeroes=new ArrayList<>();
        }
*/
    }

    public class SuperheroAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return superHeroes.size();
        }

        @Override
        public SuperHero getItem(int position) {
            return superHeroes.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

//        LayoutInflater layoutInflater = (LayoutInflater)
//                ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View inflatedView=getLayoutInflater().inflate(R.layout.layout_row,parent,false);

            SuperHero currentHero = getItem(position);

            TextView name = inflatedView.findViewById(R.id.superheroName);
            TextView universe = inflatedView.findViewById(R.id.superheroUniverse);
            TextView power = inflatedView.findViewById(R.id.superheroPower);

            name.setText(currentHero.getName());
            universe.setText(currentHero.getUniverse());
            power.setText(currentHero.getSuperPower());

            return inflatedView;
        }

    }
}