/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
public class ij {
    public static String a(long l2) {
        return ij.a(l2, false);
    }

    public static String a(long l2, boolean bl2) {
        long l3 = System.currentTimeMillis() / 1000;
        if (l3 - l2 < 30) {
            return "Just now";
        }
        if (l3 - l2 < 120) {
            if (bl2) {
                return "1m ago";
            }
            return "1 min ago";
        }
        if (l3 - l2 < 3600) {
            if (bl2) {
                return "" + (l3 - l2) / 60 + "m ago";
            }
            return "" + (l3 - l2) / 60 + " mins ago";
        }
        if (l3 - l2 < 7200) {
            if (bl2) {
                return "1h ago";
            }
            return "1 hour ago";
        }
        if (l3 - l2 < 86400) {
            if (bl2) {
                return "" + (l3 - l2) / 3600 + "h ago";
            }
            return "" + (l3 - l2) / 3600 + " hours ago";
        }
        if (l3 - l2 < 172800) {
            if (bl2) {
                return "1d ago";
            }
            return "1 day ago";
        }
        if (l3 - l2 < 604800) {
            if (bl2) {
                return "" + (l3 - l2) / 86400 + "d ago";
            }
            return "" + (l3 - l2) / 86400 + " days ago";
        }
        if (l3 - l2 < 1209600) {
            if (bl2) {
                return "1w ago";
            }
            return "1 week ago";
        }
        if (l3 - l2 < 4233600) {
            if (bl2) {
                return "" + (l3 - l2) / 604800 + "w ago";
            }
            return "" + (l3 - l2) / 604800 + " weeks ago";
        }
        if (l3 - l2 < 5184000) {
            if (bl2) {
                return "1mo ago";
            }
            return "1 month ago";
        }
        if (l3 - l2 < 31536000) {
            if (bl2) {
                return "" + (l3 - l2) / 2592000 + "mo ago";
            }
            return "" + (l3 - l2) / 2592000 + " months ago";
        }
        if (bl2) {
            return "" + (l3 - l2) / 31536000 + "y ago";
        }
        return "" + (l3 - l2) / 31536000 + " years ago";
    }
}

