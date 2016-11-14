package com.becandid.candid.views;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import defpackage.ha$a;
import java.util.HashMap;

public class StickerKeyboard extends RecyclerView {
    static HashMap<String, Integer> b = new HashMap();
    static String[] c;
    public a a;

    public interface a {
        void clickSticker(String str);
    }

    public class b extends ViewHolder implements OnClickListener {
        ImageView a;
        String b;
        final /* synthetic */ StickerKeyboard c;

        public b(StickerKeyboard this$0, View view) {
            this.c = this$0;
            super(view);
            this.a = (ImageView) view;
            this.a.setOnClickListener(this);
        }

        public void onClick(View v) {
            if (this.b != null) {
                this.c.a.clickSticker(this.b);
            }
        }
    }

    public StickerKeyboard(Context context) {
        super(context);
        a();
    }

    public StickerKeyboard(Context context, AttributeSet attrs) {
        super(context, attrs);
        a();
    }

    public StickerKeyboard(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        a();
    }

    static {
        String[] strArr = new String[ha$a.AppCompatTheme_editTextStyle];
        strArr[0] = "happy";
        strArr[1] = "sad";
        strArr[2] = "shock";
        strArr[3] = "angelic";
        strArr[4] = "angry";
        strArr[5] = "cool";
        strArr[6] = "laugh";
        strArr[7] = "love";
        strArr[8] = "crying";
        strArr[9] = "dead";
        strArr[10] = "devilish";
        strArr[11] = "dizzy";
        strArr[12] = "tears";
        strArr[13] = "uhhh";
        strArr[14] = "upset";
        strArr[15] = "wink";
        strArr[16] = "shy";
        strArr[17] = "worried";
        strArr[18] = "kissright";
        strArr[19] = "kissleft";
        strArr[20] = "photoop";
        strArr[21] = "ghost";
        strArr[22] = "ambition";
        strArr[23] = "grinning";
        strArr[24] = "gross";
        strArr[25] = "hmph";
        strArr[26] = "sneaky";
        strArr[27] = "studious";
        strArr[28] = "hot";
        strArr[29] = "cold";
        strArr[30] = "sick";
        strArr[31] = "ninja";
        strArr[32] = "zombie";
        strArr[33] = "alien";
        strArr[34] = "robot";
        strArr[35] = "luchador";
        strArr[36] = "policeofficer";
        strArr[37] = "fire";
        strArr[38] = "balloons";
        strArr[39] = "heart";
        strArr[40] = "heartbreak";
        strArr[41] = "baseball";
        strArr[42] = "basketball";
        strArr[43] = "soccer";
        strArr[44] = "tennis";
        strArr[45] = "bowling";
        strArr[46] = "iceskate";
        strArr[47] = "burger";
        strArr[48] = "icecream";
        strArr[49] = "pizza";
        strArr[50] = "ramen";
        strArr[51] = "sushi";
        strArr[52] = "cake";
        strArr[53] = "popcorn";
        strArr[54] = "cappuccino";
        strArr[55] = "beer";
        strArr[56] = "wine";
        strArr[57] = "champagne";
        strArr[58] = "hotdrink";
        strArr[59] = "apple";
        strArr[60] = "orange";
        strArr[61] = "redcup";
        strArr[62] = "retrohandheld";
        strArr[63] = "gamecontroller";
        strArr[64] = "laptop";
        strArr[65] = "smartphone";
        strArr[66] = "clock";
        strArr[67] = "tablet";
        strArr[68] = "notebook";
        strArr[69] = "camera_sticker";
        strArr[70] = "present";
        strArr[71] = "books";
        strArr[72] = "teddybear";
        strArr[73] = "backpack";
        strArr[74] = "locker";
        strArr[75] = "schoolbus";
        strArr[76] = "luggage";
        strArr[77] = "lifepreserver";
        strArr[78] = "airplane";
        strArr[79] = "taxi";
        strArr[80] = "tickets";
        strArr[81] = "palmtree";
        strArr[82] = "paintset";
        strArr[83] = "envelope";
        strArr[84] = "shuriken";
        strArr[85] = "trophy";
        strArr[86] = "jersey";
        strArr[87] = "lipstick";
        strArr[88] = "compactmirror";
        strArr[89] = "necklace";
        strArr[90] = "purse";
        strArr[91] = "stiletto";
        strArr[92] = "crown";
        strArr[93] = "diamond";
        strArr[94] = "weddingring";
        strArr[95] = "rose";
        strArr[96] = "mask";
        strArr[97] = "lipprint";
        strArr[98] = "eighthnote";
        strArr[99] = "sun";
        strArr[100] = "moon";
        strArr[ha$a.AppCompatTheme_buttonStyleSmall] = "male";
        strArr[ha$a.AppCompatTheme_checkboxStyle] = "female";
        strArr[ha$a.AppCompatTheme_checkedTextViewStyle] = "rainbow";
        c = strArr;
        b.put("airplane", Integer.valueOf(2130837582));
        b.put("alien", Integer.valueOf(2130837583));
        b.put("ambition", Integer.valueOf(2130837585));
        b.put("angelic", Integer.valueOf(2130837586));
        b.put("angry", Integer.valueOf(2130837587));
        b.put("apple", Integer.valueOf(2130837588));
        b.put("backpack", Integer.valueOf(2130837591));
        b.put("balloons", Integer.valueOf(2130837592));
        b.put("baseball", Integer.valueOf(2130837593));
        b.put("basketball", Integer.valueOf(2130837594));
        b.put("beer", Integer.valueOf(2130837595));
        b.put("books", Integer.valueOf(2130837598));
        b.put("bowling", Integer.valueOf(2130837600));
        b.put("burger", Integer.valueOf(2130837601));
        b.put("cake", Integer.valueOf(2130837602));
        b.put("camera_sticker", Integer.valueOf(2130837604));
        b.put("cappuccino", Integer.valueOf(2130837609));
        b.put("champagne", Integer.valueOf(2130837610));
        b.put("clock", Integer.valueOf(2130837613));
        b.put("cold", Integer.valueOf(2130837617));
        b.put("compactmirror", Integer.valueOf(2130837692));
        b.put("cool", Integer.valueOf(2130837695));
        b.put("crown", Integer.valueOf(2130837699));
        b.put("crying", Integer.valueOf(2130837700));
        b.put("dead", Integer.valueOf(2130837701));
        b.put("devilish", Integer.valueOf(2130837704));
        b.put("diamond", Integer.valueOf(2130837705));
        b.put("dizzy", Integer.valueOf(2130837706));
        b.put("eighthnote", Integer.valueOf(2130837708));
        b.put("envelope", Integer.valueOf(2130837711));
        b.put("female", Integer.valueOf(2130837717));
        b.put("fire", Integer.valueOf(2130837718));
        b.put("gamecontroller", Integer.valueOf(2130837973));
        b.put("ghost", Integer.valueOf(2130837974));
        b.put("grinning", Integer.valueOf(2130837989));
        b.put("gross", Integer.valueOf(2130837990));
        b.put("happy", Integer.valueOf(2130838000));
        b.put("heart", Integer.valueOf(2130838002));
        b.put("heartbreak", Integer.valueOf(2130838010));
        b.put("hmph", Integer.valueOf(2130838014));
        b.put("hot", Integer.valueOf(2130838015));
        b.put("hotdrink", Integer.valueOf(2130838016));
        b.put("icecream", Integer.valueOf(2130838020));
        b.put("iceskate", Integer.valueOf(2130838021));
        b.put("jersey", Integer.valueOf(2130838030));
        b.put("kissleft", Integer.valueOf(2130838032));
        b.put("kissright", Integer.valueOf(2130838033));
        b.put("laptop", Integer.valueOf(2130838034));
        b.put("laugh", Integer.valueOf(2130838035));
        b.put("lifepreserver", Integer.valueOf(2130838036));
        b.put("lipprint", Integer.valueOf(2130838038));
        b.put("lipstick", Integer.valueOf(2130838039));
        b.put("locker", Integer.valueOf(2130838041));
        b.put("love", Integer.valueOf(2130838042));
        b.put("luchador", Integer.valueOf(2130838043));
        b.put("luggage", Integer.valueOf(2130838044));
        b.put("male", Integer.valueOf(2130838045));
        b.put("mask", Integer.valueOf(2130838046));
        b.put("moon", Integer.valueOf(2130838065));
        b.put("necklace", Integer.valueOf(2130838068));
        b.put("ninja", Integer.valueOf(2130838070));
        b.put("notebook", Integer.valueOf(2130838071));
        b.put("orange", Integer.valueOf(2130838144));
        b.put("paintset", Integer.valueOf(2130838150));
        b.put("palmtree", Integer.valueOf(2130838151));
        b.put("photoop", Integer.valueOf(2130838152));
        b.put("pizza", Integer.valueOf(2130838153));
        b.put("policeofficer", Integer.valueOf(2130838157));
        b.put("popcorn", Integer.valueOf(2130838158));
        b.put("present", Integer.valueOf(2130838163));
        b.put("purse", Integer.valueOf(2130838164));
        b.put("rainbow", Integer.valueOf(2130838168));
        b.put("ramen", Integer.valueOf(2130838169));
        b.put("redcup", Integer.valueOf(2130838172));
        b.put("retrohandheld", Integer.valueOf(2130838174));
        b.put("robot", Integer.valueOf(2130838175));
        b.put("rose", Integer.valueOf(2130838176));
        b.put("sad", Integer.valueOf(2130838180));
        b.put("schoolbus", Integer.valueOf(2130838181));
        b.put("shock", Integer.valueOf(2130838189));
        b.put("shuriken", Integer.valueOf(2130838190));
        b.put("shy", Integer.valueOf(2130838191));
        b.put("sick", Integer.valueOf(2130838192));
        b.put("smartphone", Integer.valueOf(2130838194));
        b.put("sneaky", Integer.valueOf(2130838195));
        b.put("soccer", Integer.valueOf(2130838196));
        b.put("stiletto", Integer.valueOf(2130838220));
        b.put("studious", Integer.valueOf(2130838221));
        b.put("sun", Integer.valueOf(2130838222));
        b.put("sushi", Integer.valueOf(2130838223));
        b.put("tablet", Integer.valueOf(2130838225));
        b.put("taxi", Integer.valueOf(2130838230));
        b.put("tears", Integer.valueOf(2130838231));
        b.put("teddybear", Integer.valueOf(2130838232));
        b.put("tennis", Integer.valueOf(2130838233));
        b.put("tickets", Integer.valueOf(2130838234));
        b.put("trophy", Integer.valueOf(2130838238));
        b.put("uhhh", Integer.valueOf(2130838239));
        b.put("upset", Integer.valueOf(2130838243));
        b.put("weddingring", Integer.valueOf(2130838246));
        b.put("wine", Integer.valueOf(2130838252));
        b.put("wink", Integer.valueOf(2130838253));
        b.put("worried", Integer.valueOf(2130838254));
        b.put("zombie", Integer.valueOf(2130838255));
    }

    private void a() {
        setLayoutManager(new GridLayoutManager(getContext(), 2, 0, false));
        final int numColumns = c.length;
        setAdapter(new Adapter<b>(this) {
            final /* synthetic */ StickerKeyboard b;

            public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
                a((b) viewHolder, i);
            }

            public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                return a(viewGroup, i);
            }

            public b a(ViewGroup parent, int viewType) {
                return new b(this.b, LayoutInflater.from(parent.getContext()).inflate(2130968737, parent, false));
            }

            public void a(b holder, int position) {
                String stickerName = StickerKeyboard.c[position];
                if (!stickerName.equals(holder.b)) {
                    holder.b = stickerName;
                    holder.a.setImageResource(((Integer) StickerKeyboard.b.get(stickerName)).intValue());
                }
            }

            public int getItemCount() {
                return numColumns;
            }
        });
    }

    public boolean fling(int velocityX, int velocityY) {
        return super.fling((int) (((double) velocityX) * 0.8d), velocityY);
    }
}
