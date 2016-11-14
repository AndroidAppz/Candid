package defpackage;

/* compiled from: DateTimeConverter */
public class ij {
    public static String a(long timestamp) {
        return ij.a(timestamp, false);
    }

    public static String a(long timestamp, boolean shortTime) {
        long now = System.currentTimeMillis() / 1000;
        if (now - timestamp < 30) {
            return "Just now";
        }
        if (now - timestamp < 120) {
            if (shortTime) {
                return "1m ago";
            }
            return "1 min ago";
        } else if (now - timestamp < 3600) {
            if (shortTime) {
                return ((now - timestamp) / 60) + "m ago";
            }
            return ((now - timestamp) / 60) + " mins ago";
        } else if (now - timestamp < 7200) {
            if (shortTime) {
                return "1h ago";
            }
            return "1 hour ago";
        } else if (now - timestamp < 86400) {
            if (shortTime) {
                return ((now - timestamp) / 3600) + "h ago";
            }
            return ((now - timestamp) / 3600) + " hours ago";
        } else if (now - timestamp < 172800) {
            if (shortTime) {
                return "1d ago";
            }
            return "1 day ago";
        } else if (now - timestamp < 604800) {
            if (shortTime) {
                return ((now - timestamp) / 86400) + "d ago";
            }
            return ((now - timestamp) / 86400) + " days ago";
        } else if (now - timestamp < 1209600) {
            if (shortTime) {
                return "1w ago";
            }
            return "1 week ago";
        } else if (now - timestamp < 4233600) {
            if (shortTime) {
                return ((now - timestamp) / 604800) + "w ago";
            }
            return ((now - timestamp) / 604800) + " weeks ago";
        } else if (now - timestamp < 5184000) {
            if (shortTime) {
                return "1mo ago";
            }
            return "1 month ago";
        } else if (now - timestamp < 31536000) {
            if (shortTime) {
                return ((now - timestamp) / 2592000) + "mo ago";
            }
            return ((now - timestamp) / 2592000) + " months ago";
        } else if (shortTime) {
            return ((now - timestamp) / 31536000) + "y ago";
        } else {
            return ((now - timestamp) / 31536000) + " years ago";
        }
    }
}
