package com.harsh.ecare;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jay on 19-02-2017.
 */

public class PatientsListAdapter extends RecyclerView.Adapter<PatientsListAdapter.ViewHolder> {

    @Override
    public PatientsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_patients_list, parent, false);

        // Return a new holder instance
        PatientsListAdapter.ViewHolder viewHolder = new PatientsListAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PatientsListAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Patient contact = mContacts.get(position);

        // Set item views based on your views and data model
        TextView textView = holder.patientName;
        textView.setText(contact.getName());
        TextView button = holder.prescription;
        button.setText("Prescription");
        TextView date = holder.testReport;
        date.setText("Reports");
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView patientName;
        public Button prescription;
        public Button testReport;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            patientName = (TextView) itemView.findViewById(R.id.btn_patient_name);
            prescription = (Button) itemView.findViewById(R.id.btn_prescription);
            testReport = (Button) itemView.findViewById(R.id.btn_test_reports);
        }
    }

    // Store a member variable for the contacts
    private List<Patient> mContacts;
    // Store the context for easy access
    private Context mContext;

    // Pass in the contact array into the constructor
    public PatientsListAdapter(Context context, List<Patient> contacts) {
        mContacts = contacts;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }
}
