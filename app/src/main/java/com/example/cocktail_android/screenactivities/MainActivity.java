package com.example.cocktail_android.screenactivities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageButton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.cocktail_android.R;
import com.example.cocktail_android.recycler.CocktailItem;
import com.example.cocktail_android.recycler.ItemDecoration;
import com.example.cocktail_android.recycler.StickyRecyclerView;
import com.example.cocktail_android.recycler.alcoholic.AlcoholicCocktailItemAdapter;
import com.example.cocktail_android.recycler.nonalcoholic.NonAlcoholicCocktailItemAdapter;
import com.example.cocktail_android.redis.controllers.CocktailController;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private StickyRecyclerView mRecyclerView;
    private StickyRecyclerView mRecyclerView2;
    private StickyRecyclerView.Adapter mAdapter;
    private StickyRecyclerView.LayoutManager mLayoutManager;
    private StickyRecyclerView.Adapter mAdapter2;
    private StickyRecyclerView.LayoutManager mLayoutManager2;

    public static ArrayList<CocktailItem> alcoholicCocktails = new ArrayList<>();
    public static ArrayList<CocktailItem> nonAlcoholicCocktails = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

       // CommunicationManager.establishConnection();
       // CommunicationManager.setupSubscriber();

        int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;

        if (currentNightMode == Configuration.UI_MODE_NIGHT_YES)
            setTheme(R.style.darktheme);
        else
            setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ImageButton adminPanelBt = findViewById(R.id.main_btAdminPanel);
        adminPanelBt.setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity.this, AdminPanelActivity.class);
            startActivity(intent1);
        });

        alcoholicCocktails = CocktailController.fillDummyCocktails();
        nonAlcoholicCocktails = CocktailController.fillDummyCocktails();

        mRecyclerView = findViewById(R.id.main_rv_alcoholic);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new ItemDecoration(mRecyclerView.getPaddingStart(), mRecyclerView.getPaddingEnd()));
        mLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        mAdapter = new AlcoholicCocktailItemAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(mRecyclerView);

        mRecyclerView2 = findViewById(R.id.main_rv_non_alcoholic);
        mRecyclerView2.addItemDecoration(new ItemDecoration(mRecyclerView2.getPaddingStart(), mRecyclerView2.getPaddingEnd()));
        mRecyclerView2.setHasFixedSize(true);
        mLayoutManager2 = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        mAdapter2 = new NonAlcoholicCocktailItemAdapter();
        mRecyclerView2.setAdapter(mAdapter2);
        mRecyclerView2.setLayoutManager(mLayoutManager2);
        SnapHelper snapHelper2 = new LinearSnapHelper();
        snapHelper2.attachToRecyclerView(mRecyclerView2);


    }


}