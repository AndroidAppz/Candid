package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.FacebookException;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.util.List;
import java.util.Locale;

/* compiled from: ShareContentValidation */
public class wq {
    private static wq$a a;
    private static wq$a b;

    public static void a(ShareContent content) {
        wq.a(content, wq.a());
    }

    public static void b(ShareContent content) {
        wq.a(content, wq.a());
    }

    public static void c(ShareContent content) {
        wq.a(content, wq.b());
    }

    private static wq$a a() {
        if (b == null) {
            b = new wq$a(null);
        }
        return b;
    }

    private static wq$a b() {
        if (a == null) {
            a = new wq$b(null);
        }
        return a;
    }

    private static void a(ShareContent content, wq$a validator) throws FacebookException {
        if (content == null) {
            throw new FacebookException("Must provide non-null content to share");
        } else if (content instanceof ShareLinkContent) {
            validator.a((ShareLinkContent) content);
        } else if (content instanceof SharePhotoContent) {
            validator.a((SharePhotoContent) content);
        } else if (content instanceof ShareVideoContent) {
            validator.a((ShareVideoContent) content);
        } else if (content instanceof ShareOpenGraphContent) {
            validator.a((ShareOpenGraphContent) content);
        } else if (content instanceof ShareMediaContent) {
            validator.a((ShareMediaContent) content);
        }
    }

    private static void b(ShareLinkContent linkContent, wq$a validator) {
        Uri imageUrl = linkContent.c();
        if (imageUrl != null && !vw.b(imageUrl)) {
            throw new FacebookException("Image Url must be an http:// or https:// url");
        }
    }

    private static void b(SharePhotoContent photoContent, wq$a validator) {
        List<SharePhoto> photos = photoContent.a();
        if (photos == null || photos.isEmpty()) {
            throw new FacebookException("Must specify at least one Photo in SharePhotoContent.");
        } else if (photos.size() > 6) {
            throw new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d photos.", new Object[]{Integer.valueOf(6)}));
        } else {
            for (SharePhoto photo : photos) {
                validator.a(photo);
            }
        }
    }

    private static void c(SharePhoto photo, wq$a validator) {
        if (photo == null) {
            throw new FacebookException("Cannot share a null SharePhoto");
        }
        Bitmap photoBitmap = photo.c();
        Uri photoUri = photo.d();
        if (photoBitmap != null) {
            return;
        }
        if (photoUri == null) {
            throw new FacebookException("SharePhoto does not have a Bitmap or ImageUrl specified");
        } else if (vw.b(photoUri) && !validator.a()) {
            throw new FacebookException("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
        }
    }

    private static void d(SharePhoto photo, wq$a validator) {
        wq.c(photo, validator);
        if (photo.c() != null || !vw.b(photo.d())) {
            vx.d(ud.f());
        }
    }

    private static void e(SharePhoto photo, wq$a validator) {
        if (photo == null) {
            throw new FacebookException("Cannot share a null SharePhoto");
        }
        Uri imageUri = photo.d();
        if (imageUri == null || !vw.b(imageUri)) {
            throw new FacebookException("SharePhoto must have a non-null imageUrl set to the Uri of an image on the web");
        }
    }

    private static void b(ShareVideoContent videoContent, wq$a validator) {
        validator.a(videoContent.d());
        SharePhoto previewPhoto = videoContent.c();
        if (previewPhoto != null) {
            validator.a(previewPhoto);
        }
    }

    private static void b(ShareVideo video, wq$a validator) {
        if (video == null) {
            throw new FacebookException("Cannot share a null ShareVideo");
        }
        Uri localUri = video.c();
        if (localUri == null) {
            throw new FacebookException("ShareVideo does not have a LocalUrl specified");
        } else if (!vw.c(localUri) && !vw.d(localUri)) {
            throw new FacebookException("ShareVideo must reference a video that is on the device");
        }
    }

    private static void b(ShareMediaContent mediaContent, wq$a validator) {
        List<ShareMedia> media = mediaContent.a();
        if (media == null || media.isEmpty()) {
            throw new FacebookException("Must specify at least one medium in ShareMediaContent.");
        } else if (media.size() > 6) {
            throw new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d media.", new Object[]{Integer.valueOf(6)}));
        } else {
            for (ShareMedia medium : media) {
                validator.a(medium);
            }
        }
    }

    public static void a(ShareMedia medium, wq$a validator) {
        if (medium instanceof SharePhoto) {
            validator.a((SharePhoto) medium);
        } else if (medium instanceof ShareVideo) {
            validator.a((ShareVideo) medium);
        } else {
            throw new FacebookException(String.format(Locale.ROOT, "Invalid media type: %s", new Object[]{medium.getClass().getSimpleName()}));
        }
    }

    private static void b(ShareOpenGraphContent openGraphContent, wq$a validator) {
        validator.a(openGraphContent.a());
        String previewPropertyName = openGraphContent.b();
        if (vw.a(previewPropertyName)) {
            throw new FacebookException("Must specify a previewPropertyName.");
        } else if (openGraphContent.a().a(previewPropertyName) == null) {
            throw new FacebookException("Property \"" + previewPropertyName + "\" was not found on the action. " + "The name of the preview property must match the name of an " + "action property.");
        }
    }

    private static void b(ShareOpenGraphAction openGraphAction, wq$a validator) {
        if (openGraphAction == null) {
            throw new FacebookException("Must specify a non-null ShareOpenGraphAction");
        } else if (vw.a(openGraphAction.a())) {
            throw new FacebookException("ShareOpenGraphAction must have a non-empty actionType");
        } else {
            validator.a(openGraphAction, false);
        }
    }

    private static void b(ShareOpenGraphObject openGraphObject, wq$a validator) {
        if (openGraphObject == null) {
            throw new FacebookException("Cannot share a null ShareOpenGraphObject");
        }
        validator.a(openGraphObject, true);
    }

    private static void b(ShareOpenGraphValueContainer valueContainer, wq$a validator, boolean requireNamespace) {
        for (String key : valueContainer.c()) {
            wq.a(key, requireNamespace);
            Object o = valueContainer.a(key);
            if (o instanceof List) {
                for (Object objectInList : (List) o) {
                    if (objectInList == null) {
                        throw new FacebookException("Cannot put null objects in Lists in ShareOpenGraphObjects and ShareOpenGraphActions");
                    }
                    wq.a(objectInList, validator);
                }
                continue;
            } else {
                wq.a(o, validator);
            }
        }
    }

    private static void a(String key, boolean requireNamespace) {
        if (requireNamespace) {
            String[] components = key.split(":");
            if (components.length < 2) {
                throw new FacebookException("Open Graph keys must be namespaced: %s", key);
            }
            for (String component : components) {
                if (component.isEmpty()) {
                    throw new FacebookException("Invalid key found in Open Graph dictionary: %s", key);
                }
            }
        }
    }

    private static void a(Object o, wq$a validator) {
        if (o instanceof ShareOpenGraphObject) {
            validator.a((ShareOpenGraphObject) o);
        } else if (o instanceof SharePhoto) {
            validator.a((SharePhoto) o);
        }
    }
}
