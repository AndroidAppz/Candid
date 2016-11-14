/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Color
 *  android.graphics.Matrix
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.media.ExifInterface
 *  android.os.IBinder
 *  android.support.v7.app.AlertDialog
 *  android.support.v7.app.AlertDialog$Builder
 *  android.support.v7.widget.ListPopupWindow
 *  android.text.Layout
 *  android.text.Spannable
 *  android.text.SpannableString
 *  android.text.TextPaint
 *  android.text.style.ClickableSpan
 *  android.text.style.ForegroundColorSpan
 *  android.text.style.RelativeSizeSpan
 *  android.text.style.StyleSpan
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.LinearLayout
 *  android.widget.ListView
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.Toast
 *  com.becandid.candid.util.ViewUtils
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  rx.schedulers.Schedulers
 */
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.ExifInterface;
import android.os.IBinder;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.ListPopupWindow;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.becandid.candid.activities.GroupDetailsActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.Group;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.util.ViewUtils;
import com.becandid.candid.views.TagBox;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class iu {
    public static final int a = Color.parseColor((String)"#50000000");
    public static final int b = AppState.config.getInt("android_max_chars", 140);
    public static final float c = AppState.config.getFloat("android_max_char_mult", 1.6f);

    public static int a(int n2, Context context) {
        return (int)(0.5f + context.getResources().getDisplayMetrics().density * (float)n2);
    }

    public static Bitmap a(String string2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inDither = true;
        Bitmap bitmap = BitmapFactory.decodeFile((String)string2);
        Matrix matrix = iu.a(bitmap, (float)Math.max((int)bitmap.getWidth(), (int)bitmap.getHeight()) / 1920.0f, string2);
        return Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)bitmap.getWidth(), (int)bitmap.getHeight(), (Matrix)matrix, (boolean)true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Matrix a(Bitmap bitmap, float f2, String string2) {
        int n2 = (int)((float)bitmap.getWidth() / f2);
        int n3 = (int)((float)bitmap.getHeight() / f2);
        Matrix matrix = new Matrix();
        matrix.postRotate(0.0f);
        matrix.postScale((float)n2 / (float)bitmap.getWidth(), (float)n3 / (float)bitmap.getHeight());
        try {
            int n4 = new ExifInterface(string2).getAttributeInt("Orientation", 0);
            if (n4 == 6) {
                matrix.postRotate(90.0f);
                return matrix;
            }
            if (n4 == 3) {
                matrix.postRotate(180.0f);
                return matrix;
            }
            if (n4 != 8) return matrix;
            {
                matrix.postRotate(270.0f);
                return matrix;
            }
        }
        catch (IOException var8_7) {
            var8_7.printStackTrace();
            return matrix;
        }
    }

    public static AlertDialog.Builder a(Context context, String string2, String string3, String string4, String string5, int n2, boolean bl2, final ih.a a2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle((CharSequence)string2).setPositiveButton((CharSequence)string4, new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n2) {
                if (((AlertDialog)dialogInterface).getListView() != null) {
                    a2.d = ((AlertDialog)dialogInterface).getListView().getCheckedItemPosition();
                }
                iq.a().a(a2);
            }
        }).setNegativeButton((CharSequence)string5, null);
        if (string3 != null) {
            builder.setMessage((CharSequence)string3);
        }
        if (n2 != -1) {
            builder.setIconAttribute(n2);
        }
        if (bl2) {
            builder.setSingleChoiceItems(new CharSequence[]{"Pornographic", "Solicitation and Spam", "Hate Speech", "Off Topic"}, -1, new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialogInterface, int n2) {
                    ((AlertDialog)dialogInterface).getButton(-1).setEnabled(true);
                }
            });
        }
        return builder;
    }

    public static Spannable a(String string2, int n2) {
        return iu.a(string2, n2, 0, 0);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static Spannable a(String var0_1, int var1, int var2_3, int var3_2) {
        var4_4 = var2_3 <= 0 ? iu.b : var2_3;
        var5_5 = var3_2 <= 0 ? 4 : var3_2;
        var6_6 = 0;
        var7_7 = 0;
        for (var8_8 = 0; var8_8 < var0_1.length(); ++var8_8) {
            if (var0_1.charAt(var8_8) != '\n') continue;
            if (var8_8 < var4_4 && var6_6 < var5_5) {
                ++var6_6;
                continue;
            }
            ++var7_7;
        }
        var9_9 = (float)var4_4 * iu.c;
        if (Float.compare((float)var0_1.length(), (float)var9_9) < 0) {
            if (var6_6 < var5_5) return new SpannableString((CharSequence)var0_1);
            if (var7_7 < var5_5 - 1) {
                return new SpannableString((CharSequence)var0_1);
            }
        }
        var10_10 = var0_1.trim();
        var11_11 = 0;
        var12_12 = 0;
        var13_13 = 0;
        do {
            var14_15 = var10_10.length();
            var15_14 = 0;
            if (var13_13 >= var14_15) break;
            if (var10_10.charAt(var13_13) == '\n') {
                ++var11_11;
            } else {
                ++var12_12;
            }
            if (var11_11 == var5_5 || var12_12 == var4_4) {
                var15_14 = var13_13;
                break;
            }
            ++var13_13;
        } while (true);
        var16_16 = var15_14;
        do {
            if (var16_16 >= var10_10.length() || var16_16 > var15_14 + 15) ** GOTO lbl39
            if (var10_10.charAt(var16_16) == ' ') {
                var15_14 = var16_16;
lbl39: // 2 sources:
                var17_17 = var10_10.substring(0, var15_14) + "... " + "See More";
                var18_18 = new SpannableString((CharSequence)var17_17);
                var18_18.setSpan((Object)new ForegroundColorSpan(var1), -4 + (var17_17.length() - "See More".length()), var17_17.length(), 33);
                var18_18.setSpan((Object)new RelativeSizeSpan(0.85f), var17_17.length() - "See More".length(), var17_17.length(), 33);
                return var18_18;
            }
            ++var16_16;
        } while (true);
    }

    public static ClickableSpan a(final String string2, final int n2, final Context context) {
        return new ClickableSpan(){

            public void onClick(View view) {
                Intent intent = new Intent(context, (Class)GroupDetailsActivity.class);
                intent.putExtra("group_id", n2);
                context.startActivity(intent);
            }

            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(Color.parseColor((String)string2));
                textPaint.setUnderlineText(true);
            }
        };
    }

    public static ClickableSpan a(final String string2, final int n2, final Context context, final boolean bl2, final String string3) {
        return new ClickableSpan(){

            public void onClick(View view) {
                if (!(context instanceof PostDetailsActivity) && !bl2) {
                    PostDetailsActivity.startPostDetailsActivity(n2, context, string3);
                }
            }

            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(Color.parseColor((String)string2));
                textPaint.setUnderlineText(false);
            }
        };
    }

    public static StyleSpan a() {
        return new StyleSpan(1){

            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(true);
            }
        };
    }

    public static LinearLayout a(Context context, String string2) {
        return new TagBox(context, string2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String a(String string2, float f2) {
        int n2 = Integer.parseInt((String)string2.substring(1), (int)16);
        int n3 = f2 < 0.0f ? 0 : 255;
        float f3 = f2 < 0.0f ? f2 * -1.0f : f2;
        int n4 = n2 >> 16;
        int n5 = 255 & n2 >> 8;
        int n6 = n2 & 255;
        return "#" + Integer.toString((int)(16777216 + 65536 * (n4 + Math.round((float)(f3 * (float)(n3 - n4)))) + 256 * (n5 + Math.round((float)(f3 * (float)(n3 - n5)))) + (n6 + Math.round((float)(f3 * (float)(n3 - n6))))), (int)16).substring(1);
    }

    public static void a(Activity activity, RelativeLayout relativeLayout, List<String> list) {
        if (list == null || list.isEmpty()) {
            list = AppState.tags;
            rb.a((Throwable)new Exception("GROUP TAGS is null or empty"));
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int n2 = displayMetrics.widthPixels;
        int n3 = 0;
        int n4 = 0;
        while (n3 < list.size()) {
            LinearLayout linearLayout = new LinearLayout((Context)activity);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams.addRule(14);
            if (n4 != 0) {
                layoutParams.addRule(3, activity.getResources().getIdentifier(Integer.toString((int)(n4 - 1)), "id", activity.getPackageName()));
            }
            linearLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            linearLayout.setId(n4 + 1);
            LinearLayout linearLayout2 = iu.a((Context)activity, (String)list.get(n3));
            linearLayout2.measure(0, 0);
            while (linearLayout.getMeasuredWidth() + linearLayout2.getMeasuredWidth() < n2) {
                linearLayout.addView((View)linearLayout2);
                linearLayout.measure(0, 0);
                if (++n3 >= list.size()) break;
                linearLayout2 = iu.a((Context)activity, (String)list.get(n3));
                linearLayout2.measure(0, 0);
            }
            relativeLayout.addView((View)linearLayout);
            n4 += 2;
        }
    }

    public static void a(Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager)context.getSystemService("input_method");
        View view = ((Activity)context).getCurrentFocus();
        if (view == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(final Context context, int n2, final int n3) {
        String string2;
        switch (n2) {
            default: {
                string2 = "";
                break;
            }
            case 0: {
                string2 = "nsfw";
                break;
            }
            case 1: {
                string2 = "spam";
                break;
            }
            case 2: {
                string2 = "hate";
                break;
            }
            case 3: {
                string2 = "offtopic";
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"comment_id", (Object)Integer.toString((int)n3));
        hashMap.put((Object)"reason", (Object)string2);
        ie.a().g((Map<String, String>)hashMap).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(){

            public void a(NetworkData networkData) {
                iq.a().a(new ih.s(n3, string2));
                Toast.makeText((Context)context, (CharSequence)context.getResources().getString(2131230951), (int)0).show();
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rb.a(throwable);
                Toast.makeText((Context)context, (CharSequence)throwable.toString(), (int)1).show();
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((NetworkData)object);
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(final Context context, int n2, final int n3, final int n4) {
        String string2;
        switch (n2) {
            default: {
                string2 = "";
                break;
            }
            case 0: {
                string2 = "nsfw";
                break;
            }
            case 1: {
                string2 = "spam";
                break;
            }
            case 2: {
                string2 = "hate";
                break;
            }
            case 3: {
                string2 = "offtopic";
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"comment_id", (Object)Integer.toString((int)n3));
        hashMap.put((Object)"reason", (Object)string2);
        ie.a().f((Map<String, String>)hashMap).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(){

            public void a(NetworkData networkData) {
                iq.a().a(new ih.l(n3, n4));
                Toast.makeText((Context)context, (CharSequence)context.getResources().getString(2131230948), (int)0).show();
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rb.a(throwable);
                Toast.makeText((Context)context, (CharSequence)throwable.toString(), (int)1).show();
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((NetworkData)object);
            }
        });
    }

    public static void a(Context context, View view) {
        ((InputMethodManager)context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void a(View view) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 20.0f, 20.0f, 20.0f, 20.0f});
        gradientDrawable.setColor(a);
        view.setBackground((Drawable)gradientDrawable);
    }

    public static void a(View view, String string2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(20.0f);
        if (string2 != null) {
            gradientDrawable.setColor(Color.parseColor((String)string2));
        }
        view.setBackground((Drawable)gradientDrawable);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(CharSequence charSequence, EditText editText, ListPopupWindow listPopupWindow, hg hg2) {
        Layout layout = editText.getLayout();
        if (layout == null) {
            return;
        }
        int n2 = editText.getSelectionStart();
        int n3 = layout.getLineBaseline(layout.getLineForOffset(n2));
        float f2 = layout.getPrimaryHorizontal(n2);
        float f3 = n3;
        listPopupWindow.setHorizontalOffset((int)f2);
        listPopupWindow.setVerticalOffset((int)(f3 + (float)(- layout.getHeight())));
        if (charSequence.length() <= 0 || !charSequence.toString().contains((CharSequence)"#")) {
            listPopupWindow.dismiss();
            return;
        }
        String[] arrstring = charSequence.toString().split("(?=#)");
        int n4 = 0;
        int n5 = arrstring.length;
        int n6 = 0;
        while (n6 < n5) {
            String string2 = arrstring[n6];
            int n7 = n4;
            if (n7 + 1 < n2 && n2 <= (n4 += string2.length()) && string2.length() > 2) {
                CharSequence charSequence2 = charSequence.subSequence(n7 + 1, n2);
                hg2.a().filter(charSequence2);
                ArrayList<Group> arrayList = hg2.a(charSequence2.toString());
                if (arrayList.isEmpty()) {
                    listPopupWindow.dismiss();
                } else {
                    if (arrayList.size() <= 3) {
                        if (listPopupWindow.getHeight() != -2) {
                            listPopupWindow.setHeight(-2);
                        }
                    } else if (listPopupWindow.getHeight() != iu.a(90, editText.getContext())) {
                        listPopupWindow.setHeight(iu.a(90, editText.getContext()));
                    }
                    if (!listPopupWindow.isShowing()) {
                        listPopupWindow.show();
                    }
                }
            } else if (n7 <= n2 && n2 <= n4 && string2.length() <= 2) {
                listPopupWindow.dismiss();
            }
            ++n6;
        }
    }

    /*
     * Exception decompiling
     */
    public static void a(String var0_1, int var1, String var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    public static ClickableSpan b(final String string2, final int n2, final Context context) {
        return new ClickableSpan(){

            public void onClick(View view) {
                Intent intent = new Intent(context, (Class)GroupDetailsActivity.class);
                intent.putExtra("group_id", n2);
                context.startActivity(intent);
            }

            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(Color.parseColor((String)string2));
                textPaint.setUnderlineText(true);
                textPaint.setTypeface(Typeface.DEFAULT_BOLD);
            }
        };
    }

    public static void b(final Context context, final int n2, final int n3) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"comment_id", (Object)Integer.toString((int)n2));
        ie.a().f((Map<String, String>)hashMap).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(){

            public void a(NetworkData networkData) {
                iq.a().a(new ih.l(n2, n3));
                Toast.makeText((Context)context, (CharSequence)context.getResources().getString(2131230948), (int)0).show();
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rb.a(throwable);
                Toast.makeText((Context)context, (CharSequence)throwable.toString(), (int)1).show();
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((NetworkData)object);
            }
        });
    }

    public static void b(String string2, int n2) {
        iu.a(string2, n2, null);
    }

}

