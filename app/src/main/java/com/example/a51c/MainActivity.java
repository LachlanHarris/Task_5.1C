package com.example.a51c;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements VerticalRecyclerViewAdapter.OnRowClickListener{

    RecyclerView horizontalRecycler;
    RecyclerView verticalRecycler;

    VerticalRecyclerViewAdapter recyclerViewAdapter;
    HorizontalRecyclerViewAdapter horizontalRecyclerViewAdapter;

    List<Places> placesList = new ArrayList<>();
    List<TopDestinations> destinationsList = new ArrayList<>();

    int[] placeImages = {R.drawable.download,R.drawable.arc,R.drawable.soh,R.drawable.petra};
    String[] placesTitles = {"Colosseum","Arc de triomphe","Sydney Opera House","Petra"};
    int[] placesDescriptions = {R.string.colDescription,R.string.arcDescription,R.string.sohDescription,R.string.petraDescription};

    int[] destinationImages = {R.drawable.prague,R.drawable.new_york,R.drawable.tokyo,R.drawable.venice};
    String[] destinationsTitle = {"Prague","New York","Tokyo","Venice"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        horizontalRecycler = findViewById(R.id.horizontalRecycler);
        verticalRecycler = findViewById(R.id.verticalRecycler);

        horizontalRecyclerViewAdapter = new HorizontalRecyclerViewAdapter(destinationsList, this);
        horizontalRecycler.setAdapter(horizontalRecyclerViewAdapter);
        horizontalRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        recyclerViewAdapter = new VerticalRecyclerViewAdapter(placesList, this, this);
        verticalRecycler.setAdapter(recyclerViewAdapter);
        verticalRecycler.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < placesTitles.length; i++)
        {
            Places place =  new Places(i, placesTitles[i], placesDescriptions[i], placeImages[i]);
            placesList.add(place);
        }

        for (int i = 0; i < destinationsTitle.length; i++)
        {
            TopDestinations destination =  new TopDestinations(i, destinationsTitle[i] , destinationImages[i]);
            destinationsList.add(destination);
        }

    }

    @Override
    public void onItemClick(int position)
    {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new ColosseumFragment();;
                break;
            case 1:
                fragment = new ArcFragment();
                break;
            case 2:
                fragment = new SohFragment();
                break;
            case 3:
                fragment = new PetraFragment();;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment).commit();
    }
}