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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengyangxu
 * @date Oct 26, 2014 4:47:51 PM TODO
 */
public abstract class LayoutStateHelper {

    public final static int STATE_CONTENT_VIEW = 0;
    public final static int STATE_EMPTY_DATA = STATE_CONTENT_VIEW + 1;
    public final static int STATE_NET_ERROR = STATE_EMPTY_DATA + 1;
    public final static int STATE_LOADING = STATE_NET_ERROR + 1;
    public final static int STATE_UNKNOW_ERROR = STATE_LOADING + 1;

    public interface ButtonClickCallbacks {
        public void onEmptyStateRefresh(View view);
    }

    protected ButtonClickCallbacks mCallback;

    protected Context mContext;

    private List<LayoutState> mLayoutStates;

    private final static int INVALID_STATE = -1;

    protected int mCurrentState = INVALID_STATE;

    protected int mPreviousState = INVALID_STATE;

    public LayoutStateHelper() {
        init();
    }

    private void init() {
        mLayoutStates = new ArrayList<LayoutState>();
    }

    public LayoutState getLayoutState(int stateID) {
        for (int i = 0; i < mLayoutStates.size(); i++) {
            if (mLayoutStates.get(i).mStateID == stateID) {
                Log.i("xzy", "i # " + i + " size is : " + mLayoutStates.size());
                return mLayoutStates.get(i);
            }
        }
        return null;
    }

    /**
     * @param state
     * @return false : already contain this state true : add state for this
     *         LayoutStateManager
     */
    public boolean addLayoutState(LayoutState state) {
        boolean containState = false;

        for (int i = 0; i < mLayoutStates.size(); i++) {
            // if (mLayoutStates.get(i).getClass().getSimpleName()
            // .equals(state.getClass().getSimpleName())) {
            if (mLayoutStates.get(i).mStateID == state.mStateID) {
                containState = true;
                break;
            }
        }

        if (containState) {
            return false;
        } else {
            mLayoutStates.add(state);
            return true;
        }
    }

    /*
     * if contains given state, this method will replace old state by create new
     */
    public void updateLayoutState(LayoutState state) {
        boolean containState = false;

        for (int i = 0; i < mLayoutStates.size(); i++) {
            // if (mLayoutStates.get(i).getClass().getSimpleName()
            // .equals(state.getClass().getSimpleName())) {
            if (mLayoutStates.get(i).mStateID == state.mStateID) {
                containState = true;
                break;
            }
        }

        if (containState) {
            removeLayoutState(state.mStateID);
        }
        mLayoutStates.add(state);
    }

    public void removeLayoutState(int stateID) {
        for (int i = 0; i < mLayoutStates.size(); i++) {
            if (mLayoutStates.get(i).mStateID == stateID) {
                mLayoutStates.remove(i);
                break;
            }
        }
    }

    public void removeAllLayoutState() {
        mLayoutStates.clear();
    }

    /**
     * Activity/Fragment销毁的时候调用
     */
    public void clear() {
        for (int i = 0; i < mLayoutStates.size(); i++) {
            mLayoutStates.get(i).clear();
        }
        removeAllLayoutState();
    }

    public void showLayoutState(final int stateID) {
        if (mCurrentState == stateID) {
            return;
        }
        mPreviousState = mCurrentState;
        mCurrentState = stateID;

        Log.i("xzy", "mCurrentState # " + mCurrentState + " PreviousState # " + mPreviousState);
        setLayoutShown(mCurrentState, true);
        setLayoutShown(mPreviousState, false);
    }

    /**
     * @param stateID
     * @param shown
     * @return true shown success,
     */
    private void setLayoutShown(int stateID, boolean shown) {
        if (stateID == INVALID_STATE) {
            return;
        }
        LayoutState layoutState = getLayoutState(stateID);
        if (layoutState != null) {
            layoutState.setLayoutShown(shown);
            return;
        } else {
            layoutState = createLayoutState(mContext, null, stateID);
            if (layoutState == null) {
                throw new IllegalStateException("this state has not been added.");
            }
            addLayoutState(layoutState);
            layoutState.setLayoutShown(shown);

        }
    }

    public void setButtonClickCallbacks(ButtonClickCallbacks cb) {
        mCallback = cb;
    }

    public void showPreviousState() {
        showLayoutState(mPreviousState);
    }

    abstract public void onLayoutStateChanged(LayoutState oldState, LayoutState newState);

    abstract public LayoutState createLayoutState(Context context, View view, int stateIDS);

    abstract public View setContentView(int resID, ViewGroup parent, LayoutInflater inflater);

    abstract public View setContentView(View view, ViewGroup parent, LayoutInflater inflater);
}
