/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.graphics.Typeface
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 */
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import com.becandid.candid.GossipApplication;
import java.util.HashMap;

public class ii {
    public static HashMap<String, String> a;
    private static Typeface b;
    private static ii c;

    public ii() {
        b = Typeface.createFromAsset((AssetManager)GossipApplication.a.getAssets(), (String)"fonts/CandidAnimals.ttf");
        a = new HashMap();
        a.put((Object)"ant", (Object)"A");
        a.put((Object)"badger", (Object)"B");
        a.put((Object)"bat", (Object)"C");
        a.put((Object)"bear", (Object)"D");
        a.put((Object)"bee", (Object)"E");
        a.put((Object)"cat", (Object)"I");
        a.put((Object)"chicken", (Object)"K");
        a.put((Object)"chimp", (Object)"L");
        a.put((Object)"chipmunk", (Object)"M");
        a.put((Object)"cobra", (Object)"N");
        a.put((Object)"crab", (Object)"P");
        a.put((Object)"crocodile", (Object)"Q");
        a.put((Object)"crow", (Object)"R");
        a.put((Object)"duck", (Object)"V");
        a.put((Object)"eagle", (Object)"W");
        a.put((Object)"frog", (Object)"Z");
        a.put((Object)"gerboa", (Object)"a");
        a.put((Object)"hippo", (Object)"h");
        a.put((Object)"horse", (Object)"i");
        a.put((Object)"jelly", (Object)"k");
        a.put((Object)"kiwi", (Object)"m");
        a.put((Object)"koala", (Object)"n");
        a.put((Object)"lion", (Object)"r");
        a.put((Object)"moose", (Object)"x");
        a.put((Object)"moth", (Object)"y");
        a.put((Object)"mouse", (Object)"z");
        a.put((Object)"ram", (Object)"\"");
        a.put((Object)"turtle", (Object)"\\");
        a.put((Object)"owl", (Object)"2");
        a.put((Object)"panda", (Object)"3");
        a.put((Object)"urchin", (Object)"]");
        a.put((Object)"mandrill", (Object)"u");
        a.put((Object)"shark", (Object)"(");
        a.put((Object)"sparrow", (Object)"+");
        a.put((Object)"walrus", (Object)"^");
        a.put((Object)"rhino", (Object)"&");
        a.put((Object)"wolf", (Object)"`");
        a.put((Object)"goat", (Object)"c");
        a.put((Object)"sloth", (Object)")");
        a.put((Object)"penguin", (Object)"6");
        a.put((Object)"salamander", (Object)"'");
        a.put((Object)"bunny", (Object)"G");
        a.put((Object)"rat", (Object)"$");
        a.put((Object)"butterfly", (Object)"H");
        a.put((Object)"dragonfly", (Object)"U");
        a.put((Object)"hammerhead", (Object)"e");
        a.put((Object)"marten", (Object)"w");
        a.put((Object)"ray", (Object)"%");
        a.put((Object)"starfish", (Object)".");
        a.put((Object)"chameleon", (Object)"J");
        a.put((Object)"toad", (Object)"[");
        a.put((Object)"kangaroo", (Object)"l");
        a.put((Object)"elephant", (Object)"X");
        a.put((Object)"leopard", (Object)"q");
        a.put((Object)"spider", (Object)",");
        a.put((Object)"tiger", (Object)"/");
        a.put((Object)"possum", (Object)"9");
        a.put((Object)"giraffe", (Object)"b");
        a.put((Object)"jackalope", (Object)"j");
        a.put((Object)"bull", (Object)"F");
        a.put((Object)"whale", (Object)"_");
        a.put((Object)"pig", (Object)"7");
        a.put((Object)"raptor", (Object)"#");
        a.put((Object)"racoon", (Object)"!");
        a.put((Object)"ladybug", (Object)"o");
        a.put((Object)"cow", (Object)"O");
        a.put((Object)"cuckoo", (Object)"S");
        a.put((Object)"snake", (Object)"*");
        a.put((Object)"squid", (Object)"-");
        a.put((Object)"lemur", (Object)"p");
        a.put((Object)"panther", (Object)"4");
        a.put((Object)"dog", (Object)"T");
        a.put((Object)"fox2", (Object)"Y");
        a.put((Object)"gorilla", (Object)"d");
        a.put((Object)"hamster", (Object)"f");
        a.put((Object)"hedgehog", (Object)"g");
        a.put((Object)"lynx", (Object)"s");
        a.put((Object)"mammoth", (Object)"t");
        a.put((Object)"mantis", (Object)"v");
        a.put((Object)"octopus", (Object)"0");
        a.put((Object)"otter", (Object)"1");
        a.put((Object)"parrot", (Object)"5");
        a.put((Object)"platypus", (Object)"8");
    }

    public static ii a() {
        if (c == null) {
            c = new ii();
        }
        return c;
    }

    public static String a(String string2) {
        return (String)a.get((Object)string2);
    }

    public static Typeface b() {
        return b;
    }
}

