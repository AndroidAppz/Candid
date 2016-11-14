package defpackage;

import com.becandid.candid.data.MessageThread;

/* compiled from: MessageThreadsAdapter */
class hj$3 extends apj<ih$j> {
    final /* synthetic */ hj a;

    hj$3(hj this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((ih$j) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rb.a(e);
    }

    public void a(ih$j deleteThread) {
        if (!this.a.a.isEmpty()) {
            for (int i = 0; i < this.a.a.size(); i++) {
                MessageThread thread = (MessageThread) this.a.a.get(i);
                if (!(thread == null || deleteThread == null)) {
                    try {
                        if (thread.post_id == deleteThread.a && thread.other_user_post_name.equals(deleteThread.b)) {
                            this.a.a.remove(i);
                            this.a.notifyItemRemoved(i);
                            return;
                        }
                    } catch (NullPointerException e) {
                        rc.c().a((rm) new rm("Display Messaging Thread").a("Thread", thread.toString()));
                    }
                }
            }
        }
    }
}
