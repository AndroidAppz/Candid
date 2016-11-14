package defpackage;

import android.graphics.Typeface;
import com.becandid.candid.GossipApplication;
import java.util.HashMap;

/* compiled from: CandidAnimals */
public class ii {
    public static HashMap<String, String> a;
    private static Typeface b;
    private static ii c;

    public ii() {
        b = Typeface.createFromAsset(GossipApplication.a.getAssets(), "fonts/CandidAnimals.ttf");
        a = new HashMap();
        a.put("ant", "A");
        a.put("badger", "B");
        a.put("bat", "C");
        a.put("bear", "D");
        a.put("bee", "E");
        a.put("cat", "I");
        a.put("chicken", "K");
        a.put("chimp", "L");
        a.put("chipmunk", "M");
        a.put("cobra", "N");
        a.put("crab", "P");
        a.put("crocodile", "Q");
        a.put("crow", "R");
        a.put("duck", "V");
        a.put("eagle", "W");
        a.put("frog", "Z");
        a.put("gerboa", "a");
        a.put("hippo", "h");
        a.put("horse", "i");
        a.put("jelly", "k");
        a.put("kiwi", "m");
        a.put("koala", "n");
        a.put("lion", "r");
        a.put("moose", "x");
        a.put("moth", "y");
        a.put("mouse", "z");
        a.put("ram", "\"");
        a.put("turtle", "\\");
        a.put("owl", "2");
        a.put("panda", "3");
        a.put("urchin", "]");
        a.put("mandrill", "u");
        a.put("shark", "(");
        a.put("sparrow", "+");
        a.put("walrus", "^");
        a.put("rhino", "&");
        a.put("wolf", "`");
        a.put("goat", "c");
        a.put("sloth", ")");
        a.put("penguin", "6");
        a.put("salamander", "'");
        a.put("bunny", "G");
        a.put("rat", "$");
        a.put("butterfly", "H");
        a.put("dragonfly", "U");
        a.put("hammerhead", "e");
        a.put("marten", "w");
        a.put("ray", "%");
        a.put("starfish", ".");
        a.put("chameleon", "J");
        a.put("toad", "[");
        a.put("kangaroo", "l");
        a.put("elephant", "X");
        a.put("leopard", "q");
        a.put("spider", ",");
        a.put("tiger", "/");
        a.put("possum", "9");
        a.put("giraffe", "b");
        a.put("jackalope", "j");
        a.put("bull", "F");
        a.put("whale", "_");
        a.put("pig", "7");
        a.put("raptor", "#");
        a.put("racoon", "!");
        a.put("ladybug", "o");
        a.put("cow", "O");
        a.put("cuckoo", "S");
        a.put("snake", "*");
        a.put("squid", "-");
        a.put("lemur", "p");
        a.put("panther", "4");
        a.put("dog", "T");
        a.put("fox2", "Y");
        a.put("gorilla", "d");
        a.put("hamster", "f");
        a.put("hedgehog", "g");
        a.put("lynx", "s");
        a.put("mammoth", "t");
        a.put("mantis", "v");
        a.put("octopus", "0");
        a.put("otter", "1");
        a.put("parrot", "5");
        a.put("platypus", "8");
    }

    public static ii a() {
        if (c == null) {
            c = new ii();
        }
        return c;
    }

    public static String a(String animal) {
        return (String) a.get(animal);
    }

    public static Typeface b() {
        return b;
    }
}
