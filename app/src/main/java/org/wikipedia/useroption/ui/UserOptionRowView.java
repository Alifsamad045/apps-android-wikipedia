package org.wikipedia.useroption.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.wikipedia.R;
import org.wikipedia.database.http.DefaultHttpRow;
import org.wikipedia.useroption.database.UserOptionRow;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserOptionRowView extends LinearLayout {
    @Bind(R.id.view_user_option_id) TextView id;
    @Bind(R.id.view_user_option_key) TextView key;
    @Bind(R.id.view_user_option_value) TextView value;
    @Bind(R.id.view_user_option_status) TextView status;
    @Bind(R.id.view_user_option_transaction_id) TextView transactionId;
    @Bind(R.id.view_user_option_timestamp) TextView timestamp;

    public UserOptionRowView(Context context) {
        super(context);
        init();
    }

    public UserOptionRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public UserOptionRowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public UserOptionRowView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void set(long id, UserOptionRow option) {
        this.id.setText(String.valueOf(id));
        key.setText(option.key());
        value.setText(String.valueOf(option.val()));
        status.setText(option.status().toString());
        status.setVisibility(option.status().synced() ? GONE : VISIBLE);
        transactionId.setText(String.valueOf(option.transactionId()));
        transactionId.setVisibility(option.transactionId() == DefaultHttpRow.NO_TRANSACTION_ID ? GONE : VISIBLE);
        long age = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - option.timestamp());
        timestamp.setText(String.valueOf(age));
        timestamp.setVisibility(option.timestamp() == 0 ? GONE : VISIBLE);
    }

    private void init() {
        setGravity(Gravity.CENTER_VERTICAL);
        inflate(getContext(), R.layout.view_user_option_row, this);
        ButterKnife.bind(this);
    }
}