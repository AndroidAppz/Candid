package defpackage;

/* compiled from: JsonAdapterAnnotationTypeAdapterFactory */
public final class ajb implements aik {
    private final air a;

    public ajb(air constructorConstructor) {
        this.a = constructorConstructor;
    }

    public <T> aij<T> a(ahz gson, ajm<T> targetType) {
        aim annotation = (aim) targetType.getRawType().getAnnotation(aim.class);
        if (annotation == null) {
            return null;
        }
        return ajb.a(this.a, gson, targetType, annotation);
    }

    static aij<?> a(air constructorConstructor, ahz gson, ajm<?> fieldType, aim annotation) {
        aij<?> typeAdapter;
        Class<?> value = annotation.a();
        if (aij.class.isAssignableFrom(value)) {
            typeAdapter = (aij) constructorConstructor.a(ajm.get((Class) value)).a();
        } else if (aik.class.isAssignableFrom(value)) {
            typeAdapter = ((aik) constructorConstructor.a(ajm.get((Class) value)).a()).a(gson, fieldType);
        } else {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
        }
        if (typeAdapter != null) {
            return typeAdapter.a();
        }
        return typeAdapter;
    }
}
