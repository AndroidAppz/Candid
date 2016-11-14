package defpackage;

import android.content.Context;
import com.becandid.candid.GossipApplication;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BadgeFactory */
public class ib {
    private static volatile ib a;
    private Map<String, ib$a> b = new HashMap();

    private ib() {
        Context context = GossipApplication.a().getApplicationContext();
        String badgeName = "new";
        this.b.put(badgeName, new ib$a(this, badgeName, "Newbie", 2130838069, context.getString(2131230803), "#ff9999"));
        badgeName = "allstar";
        this.b.put(badgeName, new ib$a(this, badgeName, "All Star", 2130837584, context.getString(2131230797), "#00ccff"));
        badgeName = "explorer";
        this.b.put(badgeName, new ib$a(this, badgeName, "Explorer", 2130837712, context.getString(2131230798), "#f4df2a"));
        badgeName = "giver";
        this.b.put(badgeName, new ib$a(this, badgeName, "Giver", 2130837975, context.getString(2131230799), "#78eeee"));
        badgeName = "gossip";
        this.b.put(badgeName, new ib$a(this, badgeName, "Gossip", 2130837976, context.getString(2131230800), "#41ee8f"));
        badgeName = "hater";
        this.b.put(badgeName, new ib$a(this, badgeName, "Hater", 2130838001, context.getString(2131230801), "#f33c2c"));
        badgeName = "influencer";
        this.b.put(badgeName, new ib$a(this, badgeName, "Influencer", 2130838022, context.getString(2131230802), "#ffd176"));
        badgeName = "positive";
        this.b.put(badgeName, new ib$a(this, badgeName, "Positive", 2130838159, context.getString(2131230804), "#fca3ff"));
        badgeName = "social";
        this.b.put(badgeName, new ib$a(this, badgeName, "Socializer", 2130838197, context.getString(2131230805), "#83d9ff"));
    }

    public static ib a() {
        if (a == null) {
            synchronized (ib.class) {
                if (a == null) {
                    a = new ib();
                }
            }
        }
        return a;
    }

    public ib$a a(String name) {
        return (ib$a) this.b.get(name);
    }

    public List<ib$a> b() {
        Collection<ib$a> collection = this.b.values();
        if (collection instanceof List) {
            return (List) collection;
        }
        return new ArrayList(collection);
    }
}
