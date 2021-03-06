package com.harsh.ecare;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jay on 10-03-2017.
 */

public class PrescriptionAdapterPatient extends RecyclerView.Adapter<PrescriptionAdapterPatient.ViewHolder> {

    @Override
    public PrescriptionAdapterPatient.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_prescription_patient, parent, false);

        // Return a new holder instance
        PrescriptionAdapterPatient.ViewHolder viewHolder = new PrescriptionAdapterPatient.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PrescriptionAdapterPatient.ViewHolder holder, int position) {
        // Get the data model based on position
        Prescription contact = mContacts.get(position);

        // Set item views based on your views and data model
        TextView docName = holder.prescriptionDate;
        docName.setText(contact.getDateTime());
        TextView date = holder.prescriptionText;
        date.setText(contact.getPrescription());
        TextView prescriptionBy = holder.prescriptionBy;
        prescriptionBy.setText(contact.getDoctorName());
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
        public TextView prescriptionDate;
        public TextView prescriptionText;
        public TextView prescriptionBy;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            prescriptionDate = (TextView) itemView.findViewById(R.id.prescription_date);
            prescriptionText = (TextView) itemView.findViewById(R.id.prescription_text);
            prescriptionBy = (TextView) itemView.findViewById(R.id.prescription_by);
        }
    }

    // Store a member variable for the contacts
    private List<Prescription> mContacts;
    // Store the context for easy access
    private Context mContext;

    // Pass in the contact array into the constructor
    public PrescriptionAdapterPatient(Context context, List<Prescription> contacts) {
        mContacts = contacts;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }
}

