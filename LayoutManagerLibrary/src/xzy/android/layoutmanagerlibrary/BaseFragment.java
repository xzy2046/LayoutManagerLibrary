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

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author zhengyangxu
 * @date Nov 5, 2014 9:35:27 PM TODO
 */
public abstract class BaseFragment extends Fragment implements
        LayoutStateHelper.ButtonClickCallbacks {

    private LayoutStateHelper mLayoutStateHelper;

    @Override
    public void onActivityCreated(@Nullable
    Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
    ViewGroup container, @Nullable
    Bundle savedInstanceState) {
        return mLayoutStateHelper.setContentView(getContentViewID(), container, inflater);
    }

    abstract public int getContentViewID();

    @Override
    public void onViewCreated(View view, @Nullable
    Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onViewCreated(view, savedInstanceState);
    }

    private void init(Context context) {
        if (mLayoutStateHelper == null) {
            mLayoutStateHelper = new FragmentLayoutHelper(context);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        init(activity);
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        // do some clear job
        mLayoutStateHelper.clear();
        super.onDestroy();
    }

    public void showLayoutState(int stateID) {
        mLayoutStateHelper.showLayoutState(stateID);
    }

    public FragmentLayoutHelper getLayoutHelper() {
        return (FragmentLayoutHelper) mLayoutStateHelper;
    }

}
