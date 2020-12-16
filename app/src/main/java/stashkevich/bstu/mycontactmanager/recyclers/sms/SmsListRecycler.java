package stashkevich.bstu.mycontactmanager.recyclers.sms;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import stashkevich.bstu.mycontactmanager.R;

import java.util.List;



public class SmsListRecycler extends RecyclerView.Adapter<SmsViewHolder> {

    private List<SmsData> data;

    public SmsListRecycler(List<SmsData> data) {
        this.data = data;
    }

    @Override
    public SmsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_sms, parent, false);
        return new SmsViewHolder(parent.getContext(), view);
    }

    @Override
    public void onBindViewHolder(SmsViewHolder holder, int position) {
        SmsData smsData = data.get(position);
        holder.bind(smsData);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
