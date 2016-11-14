/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 */
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.becandid.candid.data.Comment;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.UpdatePost;
import com.becandid.candid.models.NetworkData;
import com.becandid.thirdparty.BlurTask;

public class ih {

    public static class a {
        public Context a;
        public int b;
        public int c;
        public int d;

        public a(Context context, int n2) {
            this.a = context;
            this.b = n2;
        }
    }

    public static class aa {
        public String a;

        public aa(String string2) {
            this.a = string2;
        }
    }

    public static class ab {
        public int a;
        public int b;
        public String c;
        public Comment d;
        public String e;
    }

    public static class ac {
        public int a;
        public int b;
        public String c;
        public String d;
        public String e;
        public int f;
        public int g;
        public String h;
        public String i;

        public ac(int n2, int n3, String string2, String string3, String string4) {
            this.a = n2;
            this.b = n3;
            this.c = string2;
            this.d = string3;
            this.e = string4;
        }
    }

    public static class ad {
        public int a;
        public String b;
        public String c;

        public ad(int n2, String string2, String string3) {
            this.a = n2;
            this.b = string2;
            this.c = string3;
        }
    }

    public static class ae
    extends a {
        public ae(Context context, int n2) {
            super(context, n2);
        }
    }

    public static class af {
        public Message a;
    }

    public static class ag {
        public NetworkData.UploadResponse a;
        public boolean b;
        public String c;

        public ag(NetworkData.UploadResponse uploadResponse, boolean bl2, String string2) {
            this.a = uploadResponse;
            this.b = bl2;
            this.c = string2;
        }
    }

    public static class ah {
        public int a;

        public ah(int n2) {
            this.a = n2;
        }
    }

    public static class ai {
    }

    public static class aj {
        public String a;
        public String b;
        public Bundle c;

        public aj(String string2, String string3) {
            this.a = string2;
            this.b = string3;
        }

        public aj(String string2, String string3, Bundle bundle) {
            this.a = string2;
            this.b = string3;
            this.c = bundle;
        }
    }

    public static class ak {
    }

    public static class al {
        public int a;
        public int b;
        public int c;
        public int d;

        public al(int n2, int n3, int n4, int n5) {
            this.a = n2;
            this.b = n3;
            this.c = n4;
            this.d = n5;
        }
    }

    public static class am {
        public UpdatePost a;

        public am(UpdatePost updatePost) {
            this.a = updatePost;
        }
    }

    public static class an {
        public int a;
        public int b;
        public boolean c = false;

        public an(int n2, int n3) {
            this.a = n2;
            this.b = n3;
        }

        public an(int n2, int n3, boolean bl2) {
            this.a = n2;
            this.b = n3;
            this.c = bl2;
        }
    }

    public static class ao {
        public String a;

        public ao(String string2) {
            this.a = string2;
        }
    }

    public static class ap {
    }

    public static class b {
        public String a;
        public BlurTask.BadgeType b;
        public String c;
        public String d;
        public String e;

        public b(String string2, BlurTask.BadgeType badgeType, String string3, String string4, String string5) {
            this.a = string2;
            this.b = badgeType;
            this.c = string3;
            this.d = string4;
            this.e = string5;
        }
    }

    public static class c {
        public String a;
        public String b;

        public c(String string2, String string3) {
            this.a = string2;
            this.b = string3;
        }
    }

    public static class d {
        public String a;

        public d(String string2) {
            this.a = string2;
        }
    }

    public static class e {
        public int a;

        public e() {
        }

        public e(int n2) {
            this.a = n2;
        }
    }

    public static class f {
    }

    public static class g {
        public int a;
        public String b;
        public String c;

        public g(int n2, String string2, String string3) {
            this.a = n2;
            this.b = string2;
            this.c = string3;
        }
    }

    public static class h
    extends a {
        public h(Context context, int n2, int n3) {
            super(context, n2);
            this.c = n3;
        }
    }

    public static class i
    extends a {
        public i(Context context, int n2, int n3) {
            super(context, n2);
            this.c = n3;
        }
    }

    public static class j {
        public int a;
        public String b;

        public j(int n2, String string2) {
            this.a = n2;
            this.b = string2;
        }
    }

    public static class k {
        public Post a;

        public k(Post post) {
            this.a = post;
        }
    }

    public static class l {
        public int a;
        public int b;

        public l(int n2, int n3) {
            this.a = n2;
            this.b = n3;
        }
    }

    public static class m {
        public Group a;

        public m() {
        }

        public m(Group group) {
            this.a = group;
        }
    }

    public static class n {
        public int a;
        public int b;

        public n(int n2, int n3) {
            this.a = n2;
            this.b = n3;
        }
    }

    public static class o {
        public int a;

        public o() {
        }

        public o(int n2) {
            this.a = n2;
        }
    }

    public static class p {
        public int a;
        public int b;

        public p(int n2, int n3) {
            this.a = n2;
            this.b = n3;
        }
    }

    public static class q {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public Activity h;

        public q() {
        }

        public q(Post post) {
            this.a = post.post_id;
            this.b = post.like_value;
            this.c = post.num_likes;
            this.d = post.num_dislikes;
            this.e = post.num_true;
            this.f = post.num_false;
            this.g = post.opinion_value;
        }

        public q(Post post, Activity activity) {
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

    public static class r {
        public int a;

        public r(int n2) {
            this.a = n2;
        }
    }

    public static class s {
        public int a;
        public String b;

        public s(int n2, String string2) {
            this.a = n2;
            this.b = string2;
        }
    }

    public static class t {
        public Group a;

        public t(Group group) {
            this.a = group;
        }
    }

    public static class u {
    }

    public static class v {
    }

    public static class w {
    }

    public static class x {
        public String a;
        public String b;
        public int c;

        public x(String string2, String string3, int n2) {
            this.a = string2;
            this.b = string3;
            this.c = n2;
        }
    }

    public static class y {
    }

    public static class z {
        public int a;

        public z(int n2) {
            this.a = n2;
        }
    }

}

