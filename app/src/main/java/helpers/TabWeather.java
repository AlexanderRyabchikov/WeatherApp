package helpers;

import android.view.View;
import android.widget.TabHost;

import com.example.skender.weatherapp.R;

public class TabWeather {

    public void setup(View view){
        TabHost tabHost = (TabHost) view;
        tabHost.setup();

        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec("tagNow");
        tabSpec.setIndicator("Сегодня");
        tabSpec.setContent(R.id.tvTab1);
        tabHost.addTab(tabSpec);


        tabSpec = tabHost.newTabSpec("TheeDayTag");
        tabSpec.setIndicator("На 3 дня");
        tabSpec.setContent(R.id.tvTab2);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("FiveDayTag");
        tabSpec.setIndicator("На 5 дней");
        tabSpec.setContent(R.id.tvTab3);
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTabByTag("tagNow");
    }
}
