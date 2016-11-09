package search.codekon.de.search.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Locale;
import search.codekon.de.search.R;
import search.codekon.de.search.utils.City;

public class CustomListViewAdapter extends BaseAdapter {

    public Context mContext;
    public ArrayList<City> mCities;
    public ArrayList<City> mCityArrayList;

    /**
     * Constructor
     *
     * @param context
     * @param employeeArrayList
     */
    public CustomListViewAdapter(Context context, ArrayList<City> employeeArrayList) {
        super();

        this.mContext = context;
        this.mCities = employeeArrayList;

        mCityArrayList = new ArrayList<City>();
        mCityArrayList.addAll(employeeArrayList);
    }

    /**
     * Holder class
     */
    public class CityHolder {
        TextView city;
        TextView areaCode;
    }

    @Override
    public int getCount() {
        return mCities.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CityHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.row, parent, false);

            holder = new CityHolder();

            holder.city = (TextView) convertView.findViewById(R.id.city);
            holder.areaCode = (TextView) convertView.findViewById(R.id.areaCode);

            convertView.setTag(holder);
        } else {
            holder = (CityHolder) convertView.getTag();
        }

        holder.city.setText(mCities.get(position).getCity());
        holder.areaCode.setText(String.valueOf(mCities.get(position).getAreaCode()));

        return convertView;

    }

    /**
     * Search query
     *
     * @param charText
     */
    public void filter(String charText) {

        charText = charText.toLowerCase(Locale.getDefault());

        mCities.clear();

        if (charText.length() == 0) {
            mCities.addAll(mCityArrayList);

        } else {
            for (City cityDetail : mCityArrayList) {
                if (charText.length() != 0 && cityDetail.getCity().toLowerCase(Locale.getDefault()).contains(charText)) {
                    mCities.add(cityDetail);
                } else if (charText.length() != 0 && cityDetail.getAreaCode().toLowerCase(Locale.getDefault()).contains(charText)) {
                    mCities.add(cityDetail);
                }
            }
        }
        notifyDataSetChanged();
    }


    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

}
