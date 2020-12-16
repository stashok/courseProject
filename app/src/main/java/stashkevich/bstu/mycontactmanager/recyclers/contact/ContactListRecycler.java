package stashkevich.bstu.mycontactmanager.recyclers.contact;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import stashkevich.bstu.mycontactmanager.R;

import java.util.List;

public class ContactListRecycler extends RecyclerView.Adapter<ContactViewHolder> implements View.OnClickListener {

    private List<ContactData> data;

    public ContactListRecycler(List<ContactData> data) {
        this.data = data;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        ContactData contactData = data.get(position);
        holder.bind(contactData);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View view) {

    }
}
