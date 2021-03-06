package com.sha.photoviewersample;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PhotoOverlay extends RelativeLayout {

    private TextView tvDescription;

    private String sharingText;

    public PhotoOverlay(Context context) {
        super(context);
        init();
    }

    public PhotoOverlay(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PhotoOverlay(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setDescription(String description) {
        tvDescription.setText(description);
    }

    public void setShareText(String text) {
        this.sharingText = text;
    }

    private void sendShareIntent() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, sharingText);
        sendIntent.setType("text/plain");
        getContext().startActivity(sendIntent);
    }

    private void init() {
        View view = inflate(getContext(), R.layout.view_photo_overlay, this);
        tvDescription = view.findViewById(R.id.tvDescription);
        view.findViewById(R.id.btnShare).setOnClickListener(v -> sendShareIntent());
    }
}
