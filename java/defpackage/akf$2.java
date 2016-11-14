package defpackage;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: CountryPicker */
class akf$2 implements TextWatcher {
    final /* synthetic */ akf a;

    akf$2(akf this$0) {
        this.a = this$0;
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void afterTextChanged(Editable s) {
        this.a.b(s.toString());
    }
}
