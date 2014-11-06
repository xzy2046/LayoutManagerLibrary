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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author zhengyangxu
 * @date Nov 4, 2014 4:09:27 PM TODO
 */
public class ActivityLayoutHelper extends LayoutStateHelper {

    private ViewGroup mContentView;

    public ActivityLayoutHelper(Context context) {
        mContext = context;
        mContentView = (ViewGroup) LayoutInflater.from(mContext).inflate(
                R.layout.activity_layout_helper_content, null);
    }

    @Override
    public void onLayoutStateChanged(LayoutState oldState, LayoutState newState) {
        // TODO Auto-generated method stub

    }

    @Override
    public View setContentView(int resID, ViewGroup parent, LayoutInflater inflater) {
        View view = LayoutInflater.from(mContext).inflate(resID, null);
        mContentView.addView(view);

        updateLayoutState(createLayoutState(mContext, view, LayoutStateHelper.STATE_CONTENT_VIEW));
        showLayoutState(LayoutStateHelper.STATE_CONTENT_VIEW);
        return mContentView;
    }

    @Override
    public View setContentView(View view, ViewGroup parent, LayoutInflater inflater) {
        mContentView.addView(view);
        updateLayoutState(createLayoutState(mContext, view, LayoutStateHelper.STATE_CONTENT_VIEW));
        showLayoutState(LayoutStateHelper.STATE_CONTENT_VIEW);
        return mContentView;
    }

    @Override
    public LayoutState createLayoutState(Context context, View view, int stateID) {
        LayoutState layoutState = null;
        View contentView = view;

        switch (stateID) {
            case STATE_CONTENT_VIEW:
                layoutState = new ContentState(context, contentView, mContentView, stateID);
                break;
            case STATE_EMPTY_DATA:
                layoutState = new EmptyState(context, contentView, mContentView, stateID);
                ((EmptyState) layoutState).setCallback(new EmptyState.Callbacks() {

                    @Override
                    public void onRefresh(View view) {
                        if (mCallback != null) {
                            mCallback.onEmptyStateRefresh(view);
                        }
                    }
                });
                break;
            case STATE_NET_ERROR:
                layoutState = new NetworkErrorState(context, contentView, mContentView, stateID);
                break;
            case STATE_LOADING:
                layoutState = new LoadingState(context, contentView, mContentView, stateID);
                break;
            case STATE_UNKNOW_ERROR:
                break;
            default:
                ;
        }
        return layoutState;
    }

}
