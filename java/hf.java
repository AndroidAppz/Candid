/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$ViewHolder
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 */
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.MainTabsActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Comment;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.UpdatePost;
import com.becandid.candid.views.viewholders.GroupHeaderHolder;
import com.becandid.candid.views.viewholders.ImagePostViewHolder;
import com.becandid.candid.views.viewholders.LinkPostViewHolder;
import com.becandid.candid.views.viewholders.TextPostViewHolder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class hf
extends hd<Post> {
    private static HashMap<Integer, String> d = new HashMap();
    private Activity e;

    public hf(final BaseActivity baseActivity) {
        this.e = baseActivity;
        baseActivity.addToSubscriptionList(iq.a().a(ih.q.class, new apj<ih.q>(){

            public void a(ih.q q2) {
                if (!(q2.h instanceof MainTabsActivity) || !(baseActivity instanceof MainTabsActivity)) {
                    hf.this.a(q2.a, q2);
                }
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rb.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((ih.q)object);
            }
        }));
        baseActivity.addToSubscriptionList(iq.a().a(ih.am.class, new apj<ih.am>(){

            public void a(ih.am am2) {
                hf.this.a(am2.a.post_id, am2);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rb.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((ih.am)object);
            }
        }));
        baseActivity.addToSubscriptionList(iq.a().a(ih.r.class, new apj<ih.r>(){

            public void a(ih.r r2) {
                hf.this.b(r2.a);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rb.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((ih.r)object);
            }
        }));
        baseActivity.addToSubscriptionList(iq.a().a(ih.ab.class, new apj<ih.ab>(){

            public void a(ih.ab ab2) {
                hf.this.a(ab2);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rb.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((ih.ab)object);
            }
        }));
        baseActivity.addToSubscriptionList(iq.a().a(ih.l.class, new apj<ih.l>(){

            public void a(ih.l l2) {
                hf.this.a(l2);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rb.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((ih.l)object);
            }
        }));
        baseActivity.addToSubscriptionList(iq.a().a(ih.ad.class, new apj<ih.ad>(){

            public void a(ih.ad ad2) {
                hf.this.a(ad2.a, ad2.b, ad2.c);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rb.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((ih.ad)object);
            }
        }));
        baseActivity.addToSubscriptionList(iq.a().a(ih.ah.class, new apj<ih.ah>(){

            public void a(ih.ah ah2) {
                int n2 = hf.this.c(ah2.a);
                hf.this.notifyItemChanged(n2);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rb.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((ih.ah)object);
            }
        }));
    }

    @Override
    private void a(ih.ab ab2) {
        int n2 = this.c(ab2.a);
        Comment comment = ab2.d;
        if (n2 >= 0 && comment != null && this.e instanceof MainTabsActivity) {
            Post post = (Post)this.a.get(n2);
            post.comment_icon_name = comment.icon_name;
            post.comment_text = comment.comment_text;
            post.comment_time_ago = comment.comment_time_ago;
            post.comment_source_url = comment.source_url;
            post.comment_image_width = comment.small_image_width;
            post.comment_image_height = comment.small_image_height;
            post.comment_sticker_name = comment.sticker_name;
            if (post.comment_sticker_name != null && (post.comment_image_height == 0 || post.comment_image_width == 0)) {
                post.comment_image_width = 25;
                post.comment_image_height = 25;
            }
            this.notifyItemChanged(n2);
        }
    }

    @Override
    private void a(ih.l l2) {
        int n2 = this.c(l2.b);
        if (n2 >= 0) {
            Post post = (Post)this.a.get(n2);
            post.num_comments = -1 + post.num_comments;
            post.comment_icon_name = null;
            this.notifyItemChanged(n2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    private void a(List<Post> list, int n2) {
        if (list == null) {
            return;
        }
        int n3 = n2;
        boolean bl2 = false;
        Iterator iterator = list.iterator();
        do {
            if (!iterator.hasNext()) {
                if (!bl2) return;
                this.notifyDataSetChanged();
                return;
            }
            bl2 = this.c((Post)iterator.next(), n3) || bl2;
            ++n3;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     */
    public List<Post> a(int n2, int n3) {
        ArrayList arrayList = new ArrayList(n3 * 2);
        int n4 = Math.max((int)0, (int)(n2 - n3));
        while (n4 < Math.min((int)(1 + (n2 + n3)), (int)this.a.size())) {
            if (n4 != n2) {
                arrayList.add(this.a.get(n4));
            }
            ++n4;
        }
        return arrayList;
    }

    public void a(int n2, Post post) {
        this.a.set(n2, (Object)post);
        this.notifyItemChanged(n2);
        if (this.c(post, n2)) {
            this.notifyItemChanged(n2);
        }
    }

    public void a(int n2, ih.am am2) {
        Log.d((String)"FeedAdapter", (String)("Got update with num_comments: " + (Object)am2.a.updates.num_comments));
        int n3 = this.c(n2);
        if (n3 >= 0) {
            Post post = (Post)this.a.get(n3);
            UpdatePost.Updates updates = am2.a.updates;
            if (updates.num_likes != null) {
                post.num_likes = updates.num_likes;
            }
            if (updates.num_dislikes != null) {
                post.num_dislikes = updates.num_dislikes;
            }
            if (updates.num_comments != null) {
                post.num_comments = updates.num_comments;
            }
            this.notifyItemChanged(n3);
        }
    }

    public void a(int n2, ih.q q2) {
        int n3 = this.c(n2);
        if (n3 >= 0) {
            Post post = (Post)this.a.get(n3);
            post.num_likes = q2.c;
            post.num_dislikes = q2.d;
            post.like_value = q2.b;
            post.num_true = q2.e;
            post.num_false = q2.f;
            post.opinion_value = q2.g;
            this.notifyItemChanged(n3);
        }
    }

    public void a(int n2, String string2, String string3) {
        int n3 = this.c(n2);
        if (n3 >= 0) {
            Post post = (Post)this.a.get(n3);
            post.caption = string2;
            post.mentioned_groups_info = string3;
        }
        this.notifyItemChanged(n3);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(Post post) {
        super.a(post);
        if (this.e instanceof PostDetailsActivity || !this.c(post, 0)) {
            return;
        }
        this.notifyItemChanged(0);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(Post post, int n2) {
        super.b(post, n2);
        if (this.e instanceof PostDetailsActivity || !this.c(post, n2)) {
            return;
        }
        this.notifyItemChanged(n2);
    }

    public void a(Post post, List<Post> list) {
        if (AppState.feedColors == null) {
            return;
        }
        HashSet hashSet = new HashSet(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            hashSet.add((Object)((Post)iterator.next()).icon_color);
        }
        while (hashSet.contains((Object)post.icon_color)) {
            post.icon_color = (String)AppState.feedColors.get((int)(Math.random() * (double)AppState.feedColors.size()));
        }
        d.put((Object)post.post_id, (Object)post.icon_color);
    }

    @Override
    public void a(iv iv2) {
        super.onViewAttachedToWindow((RecyclerView.ViewHolder)iv2);
        try {
            int n2 = ((Post)this.a.get((int)iv2.getAdapterPosition())).post_id;
            long l2 = System.currentTimeMillis();
            if (!this.c.containsKey((Object)(Integer.toString((int)n2) + "_oldest"))) {
                this.c.put((Object)(Integer.toString((int)n2) + "_oldest"), (Object)Long.toString((long)l2));
            }
            return;
        }
        catch (Exception var2_4) {
            rb.a((Throwable)var2_4);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void a(iv iv2, int n2) {
        Post post = (Post)this.a.get(n2);
        if (post == null) {
            return;
        }
        if (iv2 instanceof GroupHeaderHolder) {
            GroupHeaderHolder groupHeaderHolder = (GroupHeaderHolder)iv2;
            groupHeaderHolder.a(groupHeaderHolder, post);
            return;
        }
        if (iv2 instanceof jb) {
            ((jb)iv2).a(post.layout_xml);
            return;
        }
        if (iv2 instanceof TextPostViewHolder) {
            TextPostViewHolder.a((TextPostViewHolder)iv2, post);
            return;
        }
        if (iv2 instanceof ImagePostViewHolder) {
            ImagePostViewHolder.a((ImagePostViewHolder)iv2, post);
            return;
        }
        if (!(iv2 instanceof LinkPostViewHolder)) return;
        LinkPostViewHolder.a((LinkPostViewHolder)iv2, post);
    }

    @Override
    public /* synthetic */ void a(Object object, int n2) {
        this.b((Post)object, n2);
    }

    @Override
    public void a(List<Post> list) {
        super.a(list);
        super.a(list, 0);
    }

    @Override
    public iv b(ViewGroup viewGroup, int n2) {
        if (n2 == 5) {
            return new GroupHeaderHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968656, viewGroup, false), this.e);
        }
        if (n2 == 4) {
            return new jb(this.e);
        }
        if (n2 == 2) {
            return new ImagePostViewHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968658, viewGroup, false), this.e);
        }
        if (n2 == 3) {
            return new LinkPostViewHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968659, viewGroup, false), this.e);
        }
        return new TextPostViewHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968660, viewGroup, false), this.e);
    }

    public void b(int n2) {
        int n3 = this.c(n2);
        if (n3 >= 0) {
            this.a.remove(n3);
            this.notifyItemRemoved(n3);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void b(Post post, int n2) {
        super.a(post, n2);
        if (this.e instanceof PostDetailsActivity || !this.c(post, n2)) {
            return;
        }
        this.notifyItemChanged(n2);
    }

    public void b(iv iv2) {
        super.onViewDetachedFromWindow((RecyclerView.ViewHolder)iv2);
        try {
            Post post = (Post)this.a.get(iv2.getAdapterPosition());
            int n2 = post.post_id;
            long l2 = System.currentTimeMillis();
            long l3 = Long.parseLong((String)((String)this.c.get((Object)(Integer.toString((int)n2) + "_oldest"))));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(post.post_id);
            stringBuilder.append("|");
            stringBuilder.append(System.currentTimeMillis());
            stringBuilder.append("|");
            stringBuilder.append((l2 - l3) / 1000);
            stringBuilder.append("|");
            this.c.put((Object)Integer.toString((int)n2), (Object)stringBuilder.toString());
            return;
        }
        catch (Exception var2_7) {
            rb.a((Throwable)var2_7);
            return;
        }
    }

    @Override
    public /* synthetic */ void b(Object object, int n2) {
        this.a((Post)object, n2);
    }

    @Override
    public void b(List<Post> list) {
        super.b(list);
        super.a(list, this.a.indexOf(list.get(0)));
    }

    public int c(int n2) {
        int n3 = 0;
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            if (((Post)iterator.next()).post_id == n2) {
                return n3;
            }
            ++n3;
        }
        return -1;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean c(Post post, int n2) {
        if (post == null) {
            rb.a((Throwable)new Exception("post in fixupPost is NULL"));
            return false;
        } else {
            if (post.layout_xml != null) return false;
            {
                List<Post> list = this.a(n2, 1);
                String string2 = post.icon_color;
                if (d.containsKey((Object)post.post_id)) {
                    post.icon_color = (String)d.get((Object)post.post_id);
                    return true;
                }
                for (Post post2 : list) {
                    if (post2.icon_color == null || !post2.icon_color.equals((Object)string2)) continue;
                    this.a(post, list);
                    return true;
                }
            }
        }
        return false;
    }

    public int d(int n2) {
        if (n2 >= this.a.size()) {
            return -1;
        }
        return ((Post)this.a.get((int)n2)).post_id;
    }

    public Post e(int n2) {
        return (Post)this.a.get(n2);
    }

    /*
     * Exception decompiling
     */
    @Override
    public int getItemViewType(int var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.CannotPerformDecode: reachable test BLOCK was exited and re-entered.
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.getFarthestReachableInRange(Misc.java:143)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:385)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:65)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:422)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n2) {
        this.a((iv)viewHolder, n2);
    }

    @Override
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n2) {
        return this.b(viewGroup, n2);
    }

    public /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        this.a((iv)viewHolder);
    }

    public /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        this.b((iv)viewHolder);
    }

}

