package com.becandid.candid.adapters;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import defpackage.ii;
import java.util.List;

public class ContactsAdapter extends Adapter<c> {
    private List<a> a;
    private b b;

    public interface b {
        void invite(a aVar, int i);
    }

    public static class c extends ViewHolder {
        public c(View itemView) {
            super(itemView);
        }

        public void a(a contact, int position) {
        }
    }

    public class ContactsHolder extends c implements OnClickListener {
        a a;
        @BindView(2131624334)
        View animalBgView;
        GradientDrawable b = new GradientDrawable();
        int c;
        @BindView(2131624337)
        TextView contactName;
        @BindView(2131624335)
        TextView contactPhoto;
        final /* synthetic */ ContactsAdapter d;
        @BindView(2131624336)
        Button invite;

        ContactsHolder(ContactsAdapter this$0, View itemView) {
            this.d = this$0;
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.invite.setOnClickListener(this);
            this.contactPhoto.setTypeface(ii.b());
            this.b.setShape(1);
            this.animalBgView.setBackground(this.b);
        }

        public void a(a contact, int position) {
            this.a = contact;
            this.c = position;
            this.contactName.setText(Html.fromHtml("<b>" + contact.c + "</b> " + contact.d));
            this.contactPhoto.setText(ii.a(contact.a));
            int color = Color.parseColor(contact.b);
            this.contactPhoto.setTextColor(color);
            this.b.setColor((16777215 & color) | 1040187392);
            if (contact.h) {
                this.invite.setBackground(this.invite.getContext().getResources().getDrawable(2130837986));
                this.invite.setText("Invited");
                return;
            }
            this.invite.setBackground(this.invite.getContext().getResources().getDrawable(2130838146));
            this.invite.setText("Invite");
        }

        public void onClick(View v) {
            if (this.d.b != null && this.a != null) {
                this.d.b.invite(this.a, this.c);
            }
        }
    }

    public class LetterHolder extends c {
        final /* synthetic */ ContactsAdapter a;
        @BindView(2131624338)
        TextView letter;

        LetterHolder(ContactsAdapter this$0, View itemView) {
            this.a = this$0;
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void a(a contact, int position) {
            this.letter.setText(contact.g);
        }
    }

    public static class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public boolean h;
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        a((c) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return a(viewGroup, i);
    }

    public void a(List<a> contacts) {
        this.a = contacts;
        notifyDataSetChanged();
    }

    public c a(ViewGroup parent, int viewType) {
        if (viewType == 2) {
            return new ContactsHolder(this, LayoutInflater.from(parent.getContext()).inflate(2130968639, parent, false));
        }
        if (viewType == 1) {
            return new LetterHolder(this, LayoutInflater.from(parent.getContext()).inflate(2130968640, parent, false));
        }
        return null;
    }

    public void a(c holder, int position) {
        holder.a((a) this.a.get(position), position);
    }

    public int getItemViewType(int position) {
        return ((a) this.a.get(position)).g == null ? 2 : 1;
    }

    public int getItemCount() {
        return this.a != null ? this.a.size() : 0;
    }

    public void a(b inviteListener) {
        this.b = inviteListener;
    }
}
