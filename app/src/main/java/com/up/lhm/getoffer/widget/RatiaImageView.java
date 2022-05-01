package com.up.lhm.getoffer.widget;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.up.lhm.hmtools.system.Log;

/**
 * 宽度是精确，高会自动按比例缩放
 *
 */
public class RatiaImageView extends ImageView {

	public RatiaImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		Drawable drawable = getDrawable();	// 拿到图片对象
		if (drawable != null) {
			int pictureRealWidth = drawable.getMinimumWidth();	// 获取图片真实的宽
			int pictureRealHeight = drawable.getMinimumHeight();// 获取图片真实的高
			// 比例 = 真实图片高 / 真实图片宽
			float scale = (float) pictureRealHeight / pictureRealWidth;	// 两个int相除是不会有小数点的

			int width = MeasureSpec.getSize(widthMeasureSpec);	// 取出宽度测量规格中的size
			int mheight = MeasureSpec.getSize(heightMeasureSpec);	// 取出高度测量规格中的size

			// ImageView显示的宽 x 比例= 35;
			int height = (int) (width * scale);
			float scale2 = (float) height / width;	// 两个int相除是不会有小数点的

			Log.d("RatiaImageView",
					"真实的宽"+pictureRealWidth+";图片真实的高"+pictureRealHeight+"比例"+scale+";宽度测量"+width+ ";高度测量 "+mheight+";最终高度"+height+";;"+scale2);
			heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
		}
		
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	
}
