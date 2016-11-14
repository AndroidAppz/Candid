package defpackage;

import android.app.Activity;
import com.becandid.candid.data.Post;

/* compiled from: BusEvents */
public class ih$q {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public Activity h;

    public ih$q(Post post) {
        this.a = post.post_id;
        this.b = post.like_value;
        this.c = post.num_likes;
        this.d = post.num_dislikes;
        this.e = post.num_true;
        this.f = post.num_false;
        this.g = post.opinion_value;
    }

    public ih$q(Post post, Activity activity) {
        this.h = activity;
        this.a = post.post_id;
        this.b = post.like_value;
        this.c = post.num_likes;
        this.d = post.num_dislikes;
        this.e = post.num_true;
        this.f = post.num_false;
        this.g = post.opinion_value;
    }
}
