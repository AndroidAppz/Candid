package defpackage;

import android.content.Context;

/* compiled from: GenericTranscodeRequest */
public class jo<ModelType, DataType, ResourceType> extends jn<ModelType, DataType, ResourceType, ResourceType> {
    private final mj<ModelType, DataType> g;
    private final Class<DataType> h;
    private final Class<ResourceType> i;
    private final jr$c j;

    private static <A, T, Z, R> pu<A, T, Z, R> a(jp glide, mj<A, T> modelLoader, Class<T> dataClass, Class<Z> resourceClass, ox<Z, R> transcoder) {
        return new pt(modelLoader, transcoder, glide.b((Class) dataClass, (Class) resourceClass));
    }

    jo(Context context, jp glide, Class<ModelType> modelClass, mj<ModelType, DataType> modelLoader, Class<DataType> dataClass, Class<ResourceType> resourceClass, pl requestTracker, pg lifecycle, jr$c optionsApplier) {
        super(context, modelClass, jo.a(glide, modelLoader, dataClass, resourceClass, oz.b()), resourceClass, glide, requestTracker, lifecycle);
        this.g = modelLoader;
        this.h = dataClass;
        this.i = resourceClass;
        this.j = optionsApplier;
    }
}
