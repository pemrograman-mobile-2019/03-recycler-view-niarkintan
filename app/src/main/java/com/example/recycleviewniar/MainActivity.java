package com.example.recycleviewniar;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recycleviewniar.adapter.ContactsAdapter;
import com.example.recycleviewniar.models.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.rvContacts);
        contacts = Contact.createContactsList(10);
        ContactsAdapter contactsAdapter = new ContactsAdapter(contacts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setAdapter(contactsAdapter);
        rv.setLayoutManager(layoutManager);
    }
}
