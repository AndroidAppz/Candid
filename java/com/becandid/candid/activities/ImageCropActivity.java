package com.becandid.candid.activities;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.thirdparty.nocropper.CropperView;
import defpackage.iu;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCropActivity extends BaseActivity {
    public static String ASPECT_X = "aspectX";
    public static String ASPECT_Y = "aspectY";
    public static String IMAGE_PATH = "image_path";
    public static String USE_FULL_IMAGE = "use_full_image";
    private boolean b = false;
    private Bitmap c;
    private Handler d;
    private int e = 5;
    private int f = 6;
    private String g;
    @BindView(2131624184)
    ImageView mCropButton;
    @BindView(2131624181)
    RelativeLayout mCropContainer;
    @BindView(2131624182)
    FrameLayout mCropperFrameLayout;
    @BindView(2131624183)
    CropperView mImageView;
    @BindView(2131624185)
    ProgressBar mProgressBar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968612);
        ButterKnife.bind(this);
        this.d = new Handler(getMainLooper());
        this.e = getIntent().getIntExtra(ASPECT_X, 1);
        this.f = getIntent().getIntExtra(ASPECT_Y, 1);
        this.g = getIntent().getStringExtra(IMAGE_PATH);
        this.mProgressBar.setVisibility(0);
        this.mCropButton.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ImageCropActivity a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.a();
            }
        });
        this.mCropContainer.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ ImageCropActivity a;

            {
                this.a = this$0;
            }

            public void onGlobalLayout() {
                this.a.mCropContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                this.a.a(this.a.mCropContainer.getWidth(), this.a.mCropContainer.getHeight());
                this.a.d.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 a;

                    {
                        this.a = this$1;
                    }

                    public void run() {
                        this.a.a.a(this.a.a.g);
                    }
                });
            }
        });
    }

    protected void onResume() {
        super.onResume();
    }

    private void a(String filePath) {
        try {
            this.c = BitmapFactory.decodeFile(filePath);
            float scale1280 = ((float) Math.max(this.c.getWidth(), this.c.getHeight())) / 1280.0f;
            if (this.mImageView.getWidth() != 0) {
                this.mImageView.setMaxZoom(((float) (this.mImageView.getWidth() * 2)) / 1280.0f);
            } else {
                this.mImageView.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                    final /* synthetic */ ImageCropActivity a;

                    {
                        this.a = this$0;
                    }

                    public boolean onPreDraw() {
                        this.a.mImageView.getViewTreeObserver().removeOnPreDrawListener(this);
                        this.a.mImageView.setMaxZoom(((float) (this.a.mImageView.getWidth() * 2)) / 1280.0f);
                        return true;
                    }
                });
            }
            this.c = Bitmap.createBitmap(this.c, 0, 0, this.c.getWidth(), this.c.getHeight(), a(this.c, scale1280, filePath), true);
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ImageCropActivity a;

                {
                    this.a = this$0;
                }

                public void run() {
                    this.a.mImageView.setImageBitmap(this.a.c);
                    this.a.mProgressBar.setVisibility(8);
                }
            });
        } catch (Exception e) {
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ImageCropActivity a;

                {
                    this.a = this$0;
                }

                public void run() {
                    Toast.makeText(this.a, "Could not process the image...  Please try again.", 0).show();
                    this.a.finish();
                }
            });
        }
    }

    private Matrix a(Bitmap mBitmap, float scale1280, String filePath) {
        int scaledWidth = (int) (((float) mBitmap.getWidth()) / scale1280);
        int scaledHeight = (int) (((float) mBitmap.getHeight()) / scale1280);
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

    private void a(int availableWidth, int availableHeight) {
        TypedArray styleAttributes = getTheme().obtainStyledAttributes(new int[]{16843499});
        int actionBarSize = (int) styleAttributes.getDimension(0, 0.0f);
        styleAttributes.recycle();
        int marginForButtons = (int) (((double) ((((float) (availableHeight - this.mCropperFrameLayout.getHeight())) - ((float) this.mCropButton.getHeight())) / 2.0f)) + 0.5d);
        if (marginForButtons > 0) {
            ((LayoutParams) this.mCropButton.getLayoutParams()).setMargins(0, 0, 0, marginForButtons);
        }
        this.mCropContainer.requestLayout();
    }

    private void a() {
        Intent intent = new Intent();
        intent.putExtra(USE_FULL_IMAGE, false);
        Bitmap bitmap = this.mImageView.getCroppedBitmap();
        if (bitmap != null) {
            try {
                String filePath = Environment.getExternalStorageDirectory() + "/crop_test.jpg";
                a(bitmap, new File(filePath), 100);
                intent.putExtra(IMAGE_PATH, filePath);
                intent.putExtra(ASPECT_X, bitmap.getWidth());
                intent.putExtra(ASPECT_Y, bitmap.getHeight());
                setResult(-1, intent);
                iu.b(filePath, new ExifInterface(filePath).getAttributeInt("Orientation", 1));
            } catch (Exception e) {
                Toast.makeText(this, "Error while processing photo...", 0).show();
                setResult(0);
            }
        } else {
            Toast.makeText(this, "Error while processing photo...", 0).show();
            setResult(0);
        }
        bitmap.recycle();
        finish();
    }

    private void a(Bitmap bm, File file, int quality) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        bm.compress(CompressFormat.JPEG, quality, fos);
        fos.flush();
        fos.close();
    }

    public void onBackPressed() {
    }
}
