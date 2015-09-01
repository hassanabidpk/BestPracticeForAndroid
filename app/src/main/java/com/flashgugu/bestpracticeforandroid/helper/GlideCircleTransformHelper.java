package com.flashgugu.bestpracticeforandroid.helper;

import android.content.Context;
import android.graphics.Bitmap;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.flashgugu.bestpracticeforandroid.util.ImageUtils;

/**
 * This Class is example for HelperClass
 * HelperClass not use Static. I recommand this link
 * http://stackoverflow.com/questions/12192050/what-are-the-differences-between-helper-and-utility-classes
 */

public class GlideCircleTransformHelper extends BitmapTransformation {
    public GlideCircleTransformHelper(Context context) {
        super(context);
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap source, int outWidth, int outHeight) {
        return ImageUtils.getCircularBitmapImage(source);
    }

    @Override
    public String getId() {
        return "Glide_Circle_Transformation";
    }
}
