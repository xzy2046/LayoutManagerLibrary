/*                                                                                                                                    
 * Copyright (C) 2014 zhengyang.xu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package xzy.android.layoutmanagerlibrary;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;

/**
 * @author zhengyangxu
 * @date Oct 25, 2014 5:08:43 PM 
 * TODO
 */
public class LayoutState {

    private View mContentLayout;
    private Context mContext;
    private int mEnterAnimation;
    private int mExitAnimation;
    boolean mShown;
    

    public LayoutState(Context context) {
        this(context, null);
    }

    public LayoutState(Context context, View view) {
        mContentLayout = view;
        mContext = context;
        mEnterAnimation = android.R.anim.fade_in;
        mExitAnimation = android.R.anim.fade_out;
    }

    public void overridePendingTransition(int enterAnim, int exitAnim) {
        mEnterAnimation = enterAnim;
        mExitAnimation = exitAnim;
    }

    public void setView(View view) {
        mContentLayout = view;
    }
    
    public View getView() {
        return mContentLayout;
    }

    public void setLayoutShown(boolean shown) {
        setLayoutShown(shown, true);
    }
    
    public void setLayoutShownNoAnimation(boolean shown) {
        setLayoutShown(shown, false);
    }
    
    /**
     * 切换状态
     * 
     * @param shown 是否显示
     * @param animate 是否动画
     */
    public void setLayoutShown(boolean shown, boolean animate) {
        mShown = shown;
        if (mContentLayout == null) {
            throw new IllegalStateException("Content layout not yet created");
        }
        if (shown) {
            if (animate) {
                mContentLayout.startAnimation(AnimationUtils.loadAnimation(
                        mContext, mEnterAnimation));
            } else {
                mContentLayout.clearAnimation();
            }
            mContentLayout.setVisibility(View.VISIBLE);
            mContentLayout.requestFocus();
        } else {
            if (animate) {
                mContentLayout.startAnimation(AnimationUtils.loadAnimation(
                        mContext, mExitAnimation));
            } else {
                mContentLayout.clearAnimation();
            }
            mContentLayout.setVisibility(View.GONE);
        }
    }

    /**
     * recycle resources 必要的时候，例如Activity configuration changed
     * 回收Listener等。。。。。。。
     */
    void unbind() {
        ;
    }

}
