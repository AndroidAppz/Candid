package defpackage;

import android.content.SharedPreferences.Editor;

/* compiled from: EditorCompatGingerbread */
class bi {
    public static void a(Editor editor) {
        try {
            editor.apply();
        } catch (AbstractMethodError e) {
            editor.commit();
        }
    }
}
