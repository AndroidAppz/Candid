package com.becandid.candid.views;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.StateListDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TagBox extends LinearLayout {
    public static a b;
    Context a;
    @BindView(2131624760)
    ImageView mTagIcon;
    @BindView(2131624761)
    TextView mTagName;

    public interface a {
        void a(View view, String str);
    }

    public static void setTagClickListener(a listener) {
        b = listener;
    }

    public TagBox(Context context, final String label) {
        super(context);
        this.a = context;
        LayoutInflater.from(context).inflate(2130968739, this, true);
        ButterKnife.bind(this);
        try {
            StateListDrawable iconSL = new StateListDrawable();
            String fileName = "onboarding_tags_" + label.toLowerCase().replace(" ", "_").replace("'", "");
            iconSL.addState(new int[]{16842913}, getResources().getDrawable(getResources().getIdentifier(fileName + "_selected", "drawable", context.getPackageName())));
            iconSL.addState(new int[0], getResources().getDrawable(getResources().getIdentifier(fileName, "drawable", context.getPackageName())));
            this.mTagIcon.setImageDrawable(iconSL);
        } catch (NotFoundException e) {
            Log.d("Onboarding", "Resource not found for tag icon");
        }
        this.mTagName.setText(label);
        setTag(label);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TagBox b;

            public void onClick(View v) {
                TagBox.b.a(v, label);
            }
        });
    }

    public String getTagNameLowerCase() {
        return this.mTagName.getText().toString().toLowerCase();
    }

    public String getTagName() {
        return this.mTagName.getText().toString();
    }
}
