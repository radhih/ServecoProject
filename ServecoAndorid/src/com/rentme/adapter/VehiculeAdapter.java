package com.rentme.adapter;


import tn.esprit.serveco.R;

import com.rentme.entity.Vehicule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class VehiculeAdapter extends ArrayAdapter<Vehicule> {

	/**
	 * Adapter context
	 */
	Context mContext;

	/**
	 * Adapter View layout
	 */
	int mLayoutResourceId;

	public VehiculeAdapter(Context context, int layoutResourceId) {
		super(context, layoutResourceId);

		mContext = context;
		mLayoutResourceId = layoutResourceId;
	}

	
	/**
	 * Returns the view for a specific item on the list
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;

		final Vehicule currentItem = getItem(position);

		if (row == null) {
	
			LayoutInflater  inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(mLayoutResourceId, parent, false);
		}

		row.setTag(currentItem);
		final TextView textView1 = (TextView) row.findViewById(R.id.textview_vehicule_name);
		final TextView textView2 = (TextView) row.findViewById(R.id.textview_vehicule_type);
		textView1.setText(currentItem.getNomsupplier());
		textView2.setText(currentItem.getType());
		textView1.setEnabled(true);
		textView2.setEnabled(true);

		System.out.println(currentItem.getNomsupplier());

		return row;
	}

}
