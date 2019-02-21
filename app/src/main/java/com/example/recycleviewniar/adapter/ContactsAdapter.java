package com.example.recycleviewniar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.recycleviewniar.R;
import com.example.recycleviewniar.models.Contact;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    //atribut
    private List<Contact> mContact;

    //konstruktor
    public ContactsAdapter(List<Contact> mContact) {
        this.mContact = mContact;
    }

    @NonNull
    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //menghubungakn item_contact.xml ke adaptor
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactview = inflater.inflate(R.layout.item_contact,viewGroup,false);

        ViewHolder viewHolder = new ViewHolder(contactview);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //menghubungkan / mensetting nilai masing2 item
        Contact itemContact = mContact.get(i);
        TextView textView = viewHolder.nameTextView;
        textView.setText(itemContact.getmName());

        Button buttonContact = viewHolder.messageButton;
        buttonContact.setText(itemContact.ismOnline()? "Message" : "Offline");
        buttonContact.setEnabled(itemContact.ismOnline());
    }

    @Override
    public int getItemCount() {
        return mContact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private Button messageButton;

        public ViewHolder(View itemView) {

            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }
}
