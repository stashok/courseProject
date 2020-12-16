package stashkevich.bstu.mycontactmanager.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import stashkevich.bstu.mycontactmanager.models.Contact;
import stashkevich.bstu.mycontactmanager.models.Sms;
import stashkevich.bstu.mycontactmanager.models.db.DBHandler;
import stashkevich.bstu.mycontactmanager.recyclers.sms.SmsData;
import stashkevich.bstu.mycontactmanager.services.SmsNotificationService;
import stashkevich.bstu.mycontactmanager.views.activities.ContactSmsActivity;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;



public class SmsReceiver extends BroadcastReceiver {
    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private static final String PDUS = "pdus";
    public static final String SMS_HEADER = "sms_header";
    public static final String SMS_CONTENT = "sms_content";
    public static final String SMS_TYPE = "sms_type";
    public static final String NOTIF_TITLE = "notification_title";
    public static final String NOTIF_MESSAGE = "notification_message";

    Contact contact;
    StringBuilder sb;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(SMS_RECEIVED)) {
            DBHandler db = DBHandler.getInstance(context);

            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Object[] pdus = (Object[]) bundle.get(PDUS);
                if (pdus.length == 0) {
                    return;
                }
                SmsMessage[] messages = new SmsMessage[pdus.length];
                sb = new StringBuilder();
                for (int i = 0; i < pdus.length; i++) {
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    sb.append(messages[i].getMessageBody());
                }

                String message = sb.toString();
                String phone = messages[0].getOriginatingAddress();
                contact = db.getContactByPhone(phone);
                if (contact == null) {
                    phone = messages[0].getOriginatingAddress();//.replace("+33", "0");
                    contact = db.getContactByPhone(phone);
                    if (contact == null) {
                        db.addContact(new Contact(null, phone.replaceAll("\\s+",""),
                                phone.replaceAll("\\s+",""), "", ""));
                    }
                }

                DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,
                        DateFormat.MEDIUM, Locale.getDefault());
                contact = db.getContactByPhone(phone);
                Sms sms = new Sms(df.format(new Date()), message, contact.getId(), Sms.RECEIVED);
                db.addSms(sms);

                Intent intentService = new Intent(context, SmsNotificationService.class);
                intentService.putExtra(NOTIF_TITLE, contact.getName());
                intentService.putExtra(NOTIF_MESSAGE, message);
                context.startService(intentService);

                Intent intentBroadcast = new Intent(ContactSmsActivity.SMS_RECEIVED);
                intentBroadcast.putExtra(SMS_HEADER, sms.getHeader());
                intentBroadcast.putExtra(SMS_CONTENT, sms.getContent());
                intentBroadcast.putExtra(SMS_TYPE, sms.getType());
                context.sendBroadcast(intentBroadcast);

            }
        }
    }
}
