/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
import android.content.Context;
import com.becandid.candid.GossipApplication;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ib {
    private static volatile ib a;
    private Map<String, a> b = new HashMap();

    private ib() {
        Context context = GossipApplication.a().getApplicationContext();
        this.b.put((Object)"new", (Object)new a("new", "Newbie", 2130838069, context.getString(2131230803), "#ff9999"));
        this.b.put((Object)"allstar", (Object)new a("allstar", "All Star", 2130837584, context.getString(2131230797), "#00ccff"));
        this.b.put((Object)"explorer", (Object)new a("explorer", "Explorer", 2130837712, context.getString(2131230798), "#f4df2a"));
        this.b.put((Object)"giver", (Object)new a("giver", "Giver", 2130837975, context.getString(2131230799), "#78eeee"));
        this.b.put((Object)"gossip", (Object)new a("gossip", "Gossip", 2130837976, context.getString(2131230800), "#41ee8f"));
        this.b.put((Object)"hater", (Object)new a("hater", "Hater", 2130838001, context.getString(2131230801), "#f33c2c"));
        this.b.put((Object)"influencer", (Object)new a("influencer", "Influencer", 2130838022, context.getString(2131230802), "#ffd176"));
        this.b.put((Object)"positive", (Object)new a("positive", "Positive", 2130838159, context.getString(2131230804), "#fca3ff"));
        this.b.put((Object)"social", (Object)new a("social", "Socializer", 2130838197, context.getString(2131230805), "#83d9ff"));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static ib a() {
        if (a != null) return a;
        reference var1 = ib.class;
        // MONITORENTER : ib.class
        if (a == null) {
            a = new ib();
        }
        // MONITOREXIT : var1
        return a;
    }

    public a a(String string2) {
        return (a)this.b.get((Object)string2);
    }

    public List<a> b() {
        Collection collection = this.b.values();
        if (collection instanceof List) {
            return (List)collection;
        }
        return new ArrayList(collection);
    }

    public class a {
        public String a;
        public String b;
        public int c;
        public String d;
        public String e;

        public a(String string2, String string3, int n2, String string4, String string5) {
            this.a = string2;
            this.b = string3;
            this.c = n2;
            this.d = string4;
            this.e = string5;
        }
    }

}

