package search.codekon.de.search.activitiy;

import android.support.v4.view.MenuItemCompat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.ArrayList;
import search.codekon.de.search.R;
import search.codekon.de.search.controller.CustomListViewAdapter;
import search.codekon.de.search.utils.City;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    private ArrayList<City> mcities;
    private CustomListViewAdapter mCustomListViewAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listView);

        fillListView();

        mListView.setAdapter(mCustomListViewAdapter);
        mListView.setTextFilterEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String searchQuery) {

                mCustomListViewAdapter.filter(searchQuery.toString().trim());
                mListView.invalidate();

                return true;
            }
        });

        return true;
    }

    /**
     * Fill ListView with city names and areaCode
     *
     */
    private void fillListView(){

        mcities = new ArrayList<City>();

        mcities.add(new City("Adana", "322"));
        mcities.add(new City("Adiyaman", "416"));
        mcities.add(new City("Afyon", "272"));
        mcities.add(new City("Agri", "472"));
        mcities.add(new City("Aksaray", "382"));
        mcities.add(new City("Amasya", "358"));
        mcities.add(new City("Ankara", "312"));
        mcities.add(new City("Antalya", "242"));
        mcities.add(new City("Ardahan", "478"));
        mcities.add(new City("Artvin", "466"));
        mcities.add(new City("Aydin", "256"));

        mcities.add(new City("Balikesir", "266"));
        mcities.add(new City("Bartin", "378"));
        mcities.add(new City("Batman", "488"));
        mcities.add(new City("Bayburt", "458"));
        mcities.add(new City("Bilecik", "228"));
        mcities.add(new City("Bingöl", "426"));
        mcities.add(new City("Bitlis", "434"));
        mcities.add(new City("Bolu", "374"));
        mcities.add(new City("Burdur", "248"));
        mcities.add(new City("Bursa", "224"));

        mcities.add(new City("Canakkale", "286"));
        mcities.add(new City("Cankiri", "376"));
        mcities.add(new City("Corum", "364"));

        mcities.add(new City("Denizli", "258"));
        mcities.add(new City("Diyarbakir", "412"));
        mcities.add(new City("Düzce", "380"));

        mcities.add(new City("Edirne", "284"));
        mcities.add(new City("Elazig", "424"));
        mcities.add(new City("Erzincan", "446"));
        mcities.add(new City("Erzurum", "442"));
        mcities.add(new City("Eskisehir", "222"));

        mcities.add(new City("Gaziantep", "342"));
        mcities.add(new City("Giresun", "454"));
        mcities.add(new City("Gümüshane", "456"));

        mcities.add(new City("Hakkari", "438"));
        mcities.add(new City("Hatay", "326"));

        mcities.add(new City("Igdir", "476"));
        mcities.add(new City("Isparta", "246"));
        mcities.add(new City("Icel", "324"));
        mcities.add(new City("Istanbul-Avr", "212"));
        mcities.add(new City("Istanbul-And", "216"));
        mcities.add(new City("Izmir", "232"));

        mcities.add(new City("Kahramanmaras", "344"));
        mcities.add(new City("Karabük", "370"));
        mcities.add(new City("Karaman", "338"));
        mcities.add(new City("Kars", "474"));
        mcities.add(new City("Kastamonu", "366"));
        mcities.add(new City("Kayseri", "352"));
        mcities.add(new City("Kirikkale", "318"));
        mcities.add(new City("Kirklareli", "288"));
        mcities.add(new City("Kirsehir", "86"));
        mcities.add(new City("Kilis", "348"));
        mcities.add(new City("Kocaeli", "262"));
        mcities.add(new City("Konya", "332"));
        mcities.add(new City("Kütahya", "274"));

        mcities.add(new City("Malatya", "422"));
        mcities.add(new City("Manisa", "236"));
        mcities.add(new City("Mardin", "482"));
        mcities.add(new City("Mus", "436"));

        mcities.add(new City("Nevsehir", "384"));
        mcities.add(new City("Nigde", "388"));

        mcities.add(new City("Ordu", "452"));
        mcities.add(new City("Osmaniye", "328"));

        mcities.add(new City("Rize", "464"));

        mcities.add(new City("Sakarya", "264"));
        mcities.add(new City("Samsun", "362"));
        mcities.add(new City("Siirt", "484"));
        mcities.add(new City("Sinop", "368"));
        mcities.add(new City("Sivas", "346"));

        mcities.add(new City("Sanliurfa", "414"));
        mcities.add(new City("Sirnak", "486"));

        mcities.add(new City("Tekirdag", "282"));
        mcities.add(new City("Tokat", "356"));
        mcities.add(new City("Trabzon", "462"));
        mcities.add(new City("Tunceli", "428"));

        mcities.add(new City("Usak", "276"));

        mcities.add(new City("Van", "432"));

        mcities.add(new City("Yalova", "226"));
        mcities.add(new City("Yozgat", "354"));

        mcities.add(new City("Zonguldak", "372"));

        mCustomListViewAdapter=new CustomListViewAdapter(MainActivity.this, mcities/**/);
    }

}
