package com.example.imageswitcher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ActionBar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    private ImageSwitcher imgSwitcher;
    private Button btnIncre,btnDecre;
    int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        imgSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in));
        imgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));
        btnDecre = (Button) findViewById(R.id.btnDecre);
        btnIncre = (Button) findViewById(R.id.btnIncre);

        imgSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                myView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));
                return myView;
            }
        });

        imgSwitcher.setImageResource(R.mipmap.luffy);

        btnDecre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (num >= 0){
                    num--;
                }
                switchImg();
            }
        });
        btnIncre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Switched to Luffy"
                        ,Toast.LENGTH_LONG).show();
                if (num <= 4){
                    num++;
                }
                switchImg();
            }
        });
    }

    public void switchImg(){
        if (num == 0){
            Toast.makeText(getApplicationContext()
                    , "Luffy",Toast.LENGTH_LONG).show();
            imgSwitcher.setImageResource(R.mipmap.luffy);
        } else if (num == 1){
            Toast.makeText(getApplicationContext()
                    , "Zoro",Toast.LENGTH_LONG).show();
            imgSwitcher.setImageResource(R.mipmap.zoro);
        } else if (num == 2){
            Toast.makeText(getApplicationContext()
                    , "Nami",Toast.LENGTH_LONG).show();
            imgSwitcher.setImageResource(R.mipmap.nami);
        } else if (num == 3){
            Toast.makeText(getApplicationContext()
                    , "Usopp",Toast.LENGTH_LONG).show();
            imgSwitcher.setImageResource(R.mipmap.usopp);
        } else if (num == 4){
            Toast.makeText(getApplicationContext()
                    , "Sanji",Toast.LENGTH_LONG).show();
            imgSwitcher.setImageResource(R.mipmap.sanji);
        } else {
            Toast.makeText(getApplicationContext()
                    , "Cannot switch anymore",Toast.LENGTH_LONG).show();
        }
    }

    public void makeView(){
        imgSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                myView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));
                return myView;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.item1){
            Intent i = new Intent(MainActivity.this, GridActivity.class);
            startActivity(i);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
