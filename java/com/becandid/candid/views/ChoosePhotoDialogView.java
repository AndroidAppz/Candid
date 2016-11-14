package com.becandid.candid.views;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.becandid.candid.GossipApplication;
import defpackage.aib;
import defpackage.aif;
import defpackage.apj;
import defpackage.apn;
import defpackage.ie;
import defpackage.io;
import defpackage.jl;
import rx.schedulers.Schedulers;

public class ChoosePhotoDialogView extends LinearLayout {
    private a a;
    private aib b;
    private b c = new b(this);
    @BindView(2131624296)
    ProgressBar spinny;
    @BindView(2131624295)
    RecyclerView suggestedPhotoView;

    public class PhotoSuggestionHolder extends ViewHolder {
        final /* synthetic */ ChoosePhotoDialogView a;
        @BindView(2131624300)
        ImageView imageView;

        public PhotoSuggestionHolder(ChoosePhotoDialogView this$0, View itemView) {
            this.a = this$0;
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void a(aif data) {
            if (this.imageView != null) {
                if (data.a("thumb_width") && data.a("thumb_height")) {
                    LayoutParams lp = (LayoutParams) this.imageView.getLayoutParams();
                    lp.width = (int) (((float) lp.height) * (data.b("thumb_width").e() / data.b("thumb_height").e()));
                    this.imageView.setLayoutParams(lp);
                }
                jl<String> imageBuilder = GossipApplication.c.a(data.b("thumb_url").c()).b();
                if (data.a("already_loaded")) {
                    imageBuilder = imageBuilder.d();
                }
                data.a("already_loaded", Boolean.valueOf(true));
                imageBuilder.a(this.imageView);
            }
        }
    }

    public interface a {
        void b();

        void c();

        void choosePhoto(String str, int i, int i2);

        void d();
    }

    public class b extends Adapter<PhotoSuggestionHolder> {
        final /* synthetic */ ChoosePhotoDialogView a;

        public b(ChoosePhotoDialogView this$0) {
            this.a = this$0;
        }

        public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
            a((PhotoSuggestionHolder) viewHolder, i);
        }

        public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return a(viewGroup, i);
        }

        public PhotoSuggestionHolder a(ViewGroup parent, int viewType) {
            return new PhotoSuggestionHolder(this.a, ((Activity) this.a.getContext()).getLayoutInflater().inflate(2130968633, parent, false));
        }

        public void a(PhotoSuggestionHolder holder, int position) {
            holder.a(this.a.b.a(position).m());
        }

        public int getItemCount() {
            return this.a.b != null ? this.a.b.a() : 0;
        }
    }

    public void setDelegate(a delegate) {
        this.a = delegate;
    }

    public ChoosePhotoDialogView(Context context) {
        super(context);
        setOrientation(1);
        ((Activity) context).getLayoutInflater().inflate(2130968632, this);
        ButterKnife.bind(this);
        LinearLayoutManager layout = new LinearLayoutManager(context);
        layout.setOrientation(0);
        this.suggestedPhotoView.setLayoutManager(layout);
        this.suggestedPhotoView.setAdapter(this.c);
        this.suggestedPhotoView.addOnItemTouchListener(new io(this, context) {
            final /* synthetic */ ChoosePhotoDialogView a;

            public void onItemClick(View v, int position) {
                if (this.a.a != null && this.a.b != null && position < this.a.b.a()) {
                    aif result = this.a.b.a(position).m();
                    this.a.a.choosePhoto(result.b("source_url").c(), result.b("width").g(), result.b("height").g());
                    this.a.a.d();
                }
            }
        });
    }

    public void setQuery(String query) {
        if (query == null || query.trim().length() == 0) {
            this.suggestedPhotoView.setVisibility(8);
            this.spinny.setVisibility(8);
            return;
        }
        this.suggestedPhotoView.setVisibility(8);
        this.spinny.setVisibility(0);
        ie.a().i(query).b(Schedulers.io()).a(apn.a()).b(new apj<aif>(this) {
            final /* synthetic */ ChoosePhotoDialogView a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((aif) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                this.a.spinny.setVisibility(8);
                Toast.makeText(this.a.getContext(), "Unable to suggest images based on your group's name", 1).show();
            }

            public void a(aif result) {
                this.a.spinny.setVisibility(8);
                if (result.b("success").h() && result.a("images") && result.c("images").a() > 0) {
                    this.a.suggestedPhotoView.setVisibility(0);
                    this.a.b = result.c("images");
                    this.a.c.notifyDataSetChanged();
                    return;
                }
                String message = "Unable to suggest images based on your group's name";
                if (result.a("error")) {
                    message = result.b("error").c();
                }
                if (message.length() > 0) {
                    Toast.makeText(this.a.getContext(), message, 1).show();
                }
            }
        });
    }

    @OnClick({2131624297})
    public void takePhoto(View v) {
        if (this.a != null) {
            this.a.b();
            this.a.d();
        }
    }

    @OnClick({2131624298})
    public void library(View v) {
        if (this.a != null) {
            this.a.c();
            this.a.d();
        }
    }

    @OnClick({2131624299})
    public void cancel(View v) {
        if (this.a != null) {
            this.a.d();
        }
    }
}
