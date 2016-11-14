package defpackage;

import com.becandid.candid.data.Group;
import java.util.Comparator;

/* compiled from: GroupAutocompleteAdapter */
class hg$1 implements Comparator<Group> {
    final /* synthetic */ hg a;

    hg$1(hg this$0) {
        this.a = this$0;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((Group) obj, (Group) obj2);
    }

    public int a(Group lhs, Group rhs) {
        Integer rts = Integer.valueOf(rhs.t_last_post);
        if (rts == null) {
            rts = Integer.valueOf(rhs.t_joined);
        } else {
            rts = Integer.valueOf(rts.intValue() + 2592000);
        }
        Integer lts = Integer.valueOf(lhs.t_last_post);
        if (lts == null) {
            lts = Integer.valueOf(lhs.t_joined);
        } else {
            lts = Integer.valueOf(lts.intValue() + 2592000);
        }
        return rts.compareTo(lts);
    }
}
