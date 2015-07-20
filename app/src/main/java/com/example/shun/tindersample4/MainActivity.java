package com.example.shun.tindersample4;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.andtinder.model.CardModel;
import com.andtinder.model.Orientations;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardContainer mCardContainer = (CardContainer) findViewById(R.id.layoutview);
        mCardContainer.setOrientation(Orientations.Orientation.Disordered);
        SimpleCardStackAdapter adapter = new SimpleCardStackAdapter(this);

        for (int i = 0;i < 10;i++) {
            CardModel card = new CardModel("Title1", "Description goes here", getResources().getDrawable(R.drawable.kasumi));
            card.setOnCardDimissedListener(new CardModel.OnCardDimissedListener() {
                @Override
                public void onLike() {
                    CardContainer mCardContainer = (CardContainer) findViewById(R.id.layoutview);
                    System.out.println(mCardContainer.getAdapter().getCount());

                    System.out.println("like it!!!!!!");
                }

                @Override
                public void onDislike() {
                    System.out.println("don't like it!!!!!!");
                }
            });

            adapter.add(card);
        }

        mCardContainer.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
