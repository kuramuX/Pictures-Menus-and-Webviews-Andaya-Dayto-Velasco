package com.example.imageswitcher;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        ImageView luffy = findViewById(R.id.imageView1);
        ImageView zoro = findViewById(R.id.imageView2);
        ImageView nami = findViewById(R.id.imageView3);
        ImageView usopp = findViewById(R.id.imageView4);
        ImageView sanji = findViewById(R.id.imageView5);
        ImageView chopper = findViewById(R.id.imageView6);
        ImageView robin = findViewById(R.id.imageView7);
        ImageView franky = findViewById(R.id.imageView8);
        ImageView brook = findViewById(R.id.imageView9);
        ImageView jimbei = findViewById(R.id.imageView10);

        registerForContextMenu(luffy);
        registerForContextMenu(zoro);
        registerForContextMenu(nami);
        registerForContextMenu(usopp);
        registerForContextMenu(sanji);
        registerForContextMenu(chopper);
        registerForContextMenu(robin);
        registerForContextMenu(franky);
        registerForContextMenu(brook);
        registerForContextMenu(jimbei);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.option1:
                Intent i = new Intent(GridActivity.this, WebActivity.class);
                startActivity(i);
                finish();
                return true;
        }

        return super.onContextItemSelected(item);
    }

}