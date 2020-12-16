package stashkevich.bstu.mycontactmanager.recyclers.contact;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import stashkevich.bstu.mycontactmanager.R;
import stashkevich.bstu.mycontactmanager.utilities.BitmapUtility;




class ContactViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView phone;
    private ImageView image;

    ContactViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.row_contact_name);
        phone = (TextView) itemView.findViewById(R.id.row_contact_phone);
        image = (ImageView) itemView.findViewById(R.id.row_contact_image);
    }

    void bind(ContactData data){
        name.setText(data.getName());
        phone.setText(data.getPhone());
        if (data.getImage() != null) {
            image.setImageDrawable(BitmapUtility.setBitmapCircular(
                    image.getResources(), data.getImage()));
        }
    }
}
