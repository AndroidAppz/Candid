/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentManager
 *  android.support.v4.app.FragmentPagerAdapter
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class hn
extends FragmentPagerAdapter {
    private final List<Fragment> a = new ArrayList();
    private final List<CharSequence> b = new ArrayList();

    public hn(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public Fragment a(String string2) {
        for (int i2 = 0; i2 < this.b.size(); ++i2) {
            if (!((CharSequence)this.b.get(i2)).equals((Object)string2)) continue;
            return (Fragment)this.a.get(i2);
        }
        return null;
    }

    public void a(Fragment fragment, CharSequence charSequence) {
        this.a.add((Object)fragment);
        this.b.add((Object)charSequence);
    }

    public int getCount() {
        return this.a.size();
    }

    public Fragment getItem(int n2) {
        return (Fragment)this.a.get(n2);
    }

    public CharSequence getPageTitle(int n2) {
        return (CharSequence)this.b.get(n2);
    }
}

