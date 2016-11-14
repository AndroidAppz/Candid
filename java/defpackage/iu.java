package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.GradientDrawable;
import android.media.ExifInterface;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.ListPopupWindow;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Group;
import com.becandid.candid.util.ViewUtils$8;
import com.becandid.candid.views.TagBox;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

/* compiled from: ViewUtils */
public class iu {
    public static final int a = Color.parseColor("#50000000");
    public static final int b = AppState.config.getInt("android_max_chars", 140);
    public static final float c = AppState.config.getFloat("android_max_char_mult", 1.6f);

    public static LinearLayout a(Context context, String label) {
        return new TagBox(context, label);
    }

    public static int a(int dps, Context context) {
        return (int) ((((float) dps) * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void a(Context ctx) {
        InputMethodManager inputManager = (InputMethodManager) ctx.getSystemService("input_method");
        View v = ((Activity) ctx).getCurrentFocus();
        if (v != null) {
            inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

    public static void a(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void a(View view, String backgroundColor) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(0);
        shape.setCornerRadius(20.0f);
        if (backgroundColor != null) {
            shape.setColor(Color.parseColor(backgroundColor));
        }
        view.setBackground(shape);
    }

    public static void a(View view) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(0);
        shape.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 20.0f, 20.0f, 20.0f, 20.0f});
        shape.setColor(a);
        view.setBackground(shape);
    }

    public static String a(String color, float percent) {
        float p;
        int f = Integer.parseInt(color.substring(1), 16);
        int t = percent < 0.0f ? 0 : 255;
        if (percent < 0.0f) {
            p = percent * -1.0f;
        } else {
            p = percent;
        }
        int R = f >> 16;
        int G = (f >> 8) & 255;
        int B = f & 255;
        return "#" + Integer.toString(((16777216 + ((Math.round(((float) (t - R)) * p) + R) * 65536)) + ((Math.round(((float) (t - G)) * p) + G) * 256)) + (Math.round(((float) (t - B)) * p) + B), 16).substring(1);
    }

    public static void a(Activity context, RelativeLayout container, List<String> tags) {
        if (tags == null || tags.isEmpty()) {
            tags = AppState.tags;
            rb.a(new Exception("GROUP TAGS is null or empty"));
        }
        DisplayMetrics metrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenWidth = metrics.widthPixels;
        int i = 0;
        int j = 0;
        while (i < tags.size()) {
            LinearLayout row = new LinearLayout(context);
            LayoutParams rowParam = new LayoutParams(-2, -1);
            rowParam.addRule(14);
            if (j != 0) {
                rowParam.addRule(3, context.getResources().getIdentifier(Integer.toString(j - 1), "id", context.getPackageName()));
            }
            row.setLayoutParams(rowParam);
            row.setId(j + 1);
            LinearLayout tag = iu.a((Context) context, (String) tags.get(i));
            tag.measure(0, 0);
            while (row.getMeasuredWidth() + tag.getMeasuredWidth() < screenWidth) {
                row.addView(tag);
                i++;
                row.measure(0, 0);
                if (i >= tags.size()) {
                    break;
                }
                tag = iu.a((Context) context, (String) tags.get(i));
                tag.measure(0, 0);
            }
            container.addView(row);
            j += 2;
        }
    }

    public static Spannable a(String caption, int color) {
        return iu.a(caption, color, 0, 0);
    }

    public static Spannable a(String caption, int color, int overrideMaxSize, int overrideMaxLines) {
        int maxSize;
        int maxLines;
        int i;
        if (overrideMaxSize <= 0) {
            maxSize = b;
        } else {
            maxSize = overrideMaxSize;
        }
        if (overrideMaxLines <= 0) {
            maxLines = 4;
        } else {
            maxLines = overrideMaxLines;
        }
        int preNewlineCount = 0;
        int postNewlineCount = 0;
        for (i = 0; i < caption.length(); i++) {
            if (caption.charAt(i) == '\n') {
                if (i >= maxSize || preNewlineCount >= maxLines) {
                    postNewlineCount++;
                } else {
                    preNewlineCount++;
                }
            }
        }
        if (Float.compare((float) caption.length(), ((float) maxSize) * c) < 0 && (preNewlineCount < maxLines || postNewlineCount < maxLines - 1)) {
            return new SpannableString(caption);
        }
        caption = caption.trim();
        int newlines = 0;
        int charCount = 0;
        int charIndex = 0;
        for (i = 0; i < caption.length(); i++) {
            if (caption.charAt(i) == '\n') {
                newlines++;
            } else {
                charCount++;
            }
            if (newlines == maxLines || charCount == maxSize) {
                charIndex = i;
                break;
            }
        }
        i = charIndex;
        while (i < caption.length() && i <= charIndex + 15) {
            if (caption.charAt(i) == ' ') {
                charIndex = i;
                break;
            }
            i++;
        }
        caption = caption.substring(0, charIndex) + "... " + "See More";
        Spannable spannable = new SpannableString(caption);
        spannable.setSpan(new ForegroundColorSpan(color), (caption.length() - "See More".length()) - 4, caption.length(), 33);
        spannable.setSpan(new RelativeSizeSpan(0.85f), caption.length() - "See More".length(), caption.length(), 33);
        return spannable;
    }

    public static Builder a(Context context, String title, String message, String positiveBtn, String negativeBtn, int iconAttrId, boolean isReport, ih$a onPositiveClick) {
        Builder builder = new Builder(context);
        builder.setTitle(title).setPositiveButton(positiveBtn, new iu$1(onPositiveClick)).setNegativeButton(negativeBtn, null);
        if (message != null) {
            builder.setMessage(message);
        }
        if (iconAttrId != -1) {
            builder.setIconAttribute(iconAttrId);
        }
        if (isReport) {
            builder.setSingleChoiceItems(new CharSequence[]{"Pornographic", "Solicitation and Spam", "Hate Speech", "Off Topic"}, -1, new iu$3());
        }
        return builder;
    }

    public static void a(Context context, int selectedPosition, int commentId) {
        String reason;
        switch (selectedPosition) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                reason = "nsfw";
                break;
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                reason = "spam";
                break;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                reason = "hate";
                break;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                reason = "offtopic";
                break;
            default:
                reason = "";
                break;
        }
        Map params = new HashMap();
        params.put("comment_id", Integer.toString(commentId));
        params.put("reason", reason);
        ie.a().g(params).b(Schedulers.io()).a(apn.a()).b(new iu$4(context, commentId, reason));
    }

    public static void b(Context context, int commentId, int postId) {
        Map params = new HashMap();
        params.put("comment_id", Integer.toString(commentId));
        ie.a().f(params).b(Schedulers.io()).a(apn.a()).b(new iu$5(context, commentId, postId));
    }

    public static void a(Context context, int selectedPosition, int commentId, int postId) {
        String reason;
        switch (selectedPosition) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                reason = "nsfw";
                break;
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                reason = "spam";
                break;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                reason = "hate";
                break;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                reason = "offtopic";
                break;
            default:
                reason = "";
                break;
        }
        Map params = new HashMap();
        params.put("comment_id", Integer.toString(commentId));
        params.put("reason", reason);
        ie.a().f(params).b(Schedulers.io()).a(apn.a()).b(new iu$6(context, commentId, postId));
    }

    public static void b(String uri, int orientation) {
        iu.a(uri, orientation, null);
    }

    public static void a(String uri, int orientation, String outUri) {
        if (uri.endsWith(".jpg") || uri.endsWith(".png")) {
            FileOutputStream out;
            Bitmap bitmap = BitmapFactory.decodeFile(uri);
            if (outUri != null) {
                try {
                    out = new FileOutputStream(outUri);
                } catch (FileNotFoundException e) {
                    rb.a(e);
                    Toast.makeText(GossipApplication.a().getApplicationContext(), "Can't upload this picture. Please try another one!", 0).show();
                    return;
                } catch (IOException e2) {
                    rb.a(e2);
                    Toast.makeText(GossipApplication.a().getApplicationContext(), "Can't upload this picture. Please try another one!", 0).show();
                    return;
                } catch (Exception e3) {
                    rb.a(e3);
                    Toast.makeText(GossipApplication.a().getApplicationContext(), "Can't upload this picture. Please try another one!", 0).show();
                    return;
                }
            }
            out = new FileOutputStream(uri);
            if (uri.endsWith(".jpg")) {
                bitmap.compress(CompressFormat.JPEG, 100, out);
            } else if (uri.endsWith(".png")) {
                bitmap.compress(CompressFormat.PNG, 100, out);
            }
            ExifInterface exif = new ExifInterface(uri);
            exif.setAttribute("Orientation", Integer.toString(orientation));
            exif.saveAttributes();
        }
    }

    public static Bitmap a(String filePath) {
        Options options = new Options();
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Config.RGB_565;
        options.inDither = true;
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), iu.a(bitmap, ((float) Math.max(bitmap.getWidth(), bitmap.getHeight())) / 1920.0f, filePath), true);
    }

    public static Matrix a(Bitmap mBitmap, float scaleDown, String filePath) {
        int scaledWidth = (int) (((float) mBitmap.getWidth()) / scaleDown);
        int scaledHeight = (int) (((float) mBitmap.getHeight()) / scaleDown);
        Matrix matrix = new Matrix();
        matrix.postRotate(0.0f);
        matrix.postScale(((float) scaledWidth) / ((float) mBitmap.getWidth()), ((float) scaledHeight) / ((float) mBitmap.getHeight()));
        try {
            int orientation = new ExifInterface(filePath).getAttributeInt("Orientation", 0);
            if (orientation == 6) {
                matrix.postRotate(90.0f);
            } else if (orientation == 3) {
                matrix.postRotate(180.0f);
            } else if (orientation == 8) {
                matrix.postRotate(270.0f);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matrix;
    }

    public static void a(CharSequence s, EditText view, ListPopupWindow popup, hg adapter) {
        Layout layout = view.getLayout();
        if (layout != null) {
            int pos = view.getSelectionStart();
            float y = (float) layout.getLineBaseline(layout.getLineForOffset(pos));
            popup.setHorizontalOffset((int) layout.getPrimaryHorizontal(pos));
            popup.setVerticalOffset((int) (((float) (-layout.getHeight())) + y));
            if (s.length() <= 0 || !s.toString().contains("#")) {
                popup.dismiss();
                return;
            }
            int endIndex = 0;
            for (String sub : s.toString().split("(?=#)")) {
                int startIndex = endIndex;
                endIndex += sub.length();
                if (startIndex + 1 < pos && pos <= endIndex && sub.length() > 2) {
                    CharSequence tag = s.subSequence(startIndex + 1, pos);
                    adapter.a().filter(tag);
                    ArrayList<Group> groups = adapter.a(tag.toString());
                    if (groups.isEmpty()) {
                        popup.dismiss();
                    } else {
                        if (groups.size() <= 3) {
                            if (popup.getHeight() != -2) {
                                popup.setHeight(-2);
                            }
                        } else if (popup.getHeight() != iu.a(90, view.getContext())) {
                            popup.setHeight(iu.a(90, view.getContext()));
                        }
                        if (!popup.isShowing()) {
                            popup.show();
                        }
                    }
                } else if (startIndex <= pos && pos <= endIndex && sub.length() <= 2) {
                    popup.dismiss();
                }
            }
        }
    }

    public static ClickableSpan a(String color, int postId, Context context, boolean seeMore, String opColor) {
        return new iu$7(context, seeMore, postId, opColor, color);
    }

    public static StyleSpan a() {
        return new ViewUtils$8(1);
    }

    public static ClickableSpan a(String color, int groupId, Context context) {
        return new iu$8(context, groupId, color);
    }

    public static ClickableSpan b(String color, int groupId, Context context) {
        return new iu$2(context, groupId, color);
    }
}
