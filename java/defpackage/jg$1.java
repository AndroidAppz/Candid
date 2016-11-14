package defpackage;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: DynamicLayoutInflator */
class jg$1 implements OnClickListener {
    final /* synthetic */ ViewGroup a;
    final /* synthetic */ String b;

    jg$1(ViewGroup viewGroup, String str) {
        this.a = viewGroup;
        this.b = str;
    }

    public void onClick(View view) {
        ViewGroup root = this.a;
        jg$a info = null;
        while (root != null && (root.getParent() instanceof ViewGroup)) {
            if (root.getTag() != null && (root.getTag() instanceof jg$a)) {
                info = (jg$a) root.getTag();
                if (info.b != null) {
                    break;
                }
            }
            root = (ViewGroup) root.getParent();
        }
        if (info == null || info.b == null) {
            Log.e("DynamicLayoutInflator", "Unable to find valid delegate for click named " + this.b);
        } else {
            a(info.b, this.b, false, view);
        }
    }

    private void a(Object delegate, String methodName, boolean withView, View view) {
        int i;
        Object[] args = null;
        String finalMethod = methodName;
        if (methodName.endsWith(")")) {
            String[] parts = methodName.split("[(]", 2);
            finalMethod = parts[0];
            try {
                String argText = parts[1].replace("&quot;", "\"");
                JSONArray arr = new JSONArray("[" + argText.substring(0, argText.length() - 1) + "]");
                args = new Object[arr.length()];
                for (i = 0; i < arr.length(); i++) {
                    args[i] = arr.get(i);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (withView) {
            args = new Object[]{view};
        }
        Class<?> klass = delegate.getClass();
        Class<?>[] argClasses = null;
        if (args != null) {
            try {
                if (args.length > 0) {
                    argClasses = new Class[args.length];
                    if (withView) {
                        argClasses[0] = View.class;
                    } else {
                        for (i = 0; i < args.length; i++) {
                            Class<?> argClass = args[i].getClass();
                            if (argClass == Integer.class) {
                                argClass = Integer.TYPE;
                            }
                            argClasses[i] = argClass;
                        }
                    }
                }
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return;
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
                if (!withView) {
                    if (!methodName.endsWith(")")) {
                        a(delegate, methodName, true, view);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        klass.getMethod(finalMethod, argClasses).invoke(delegate, args);
    }
}
