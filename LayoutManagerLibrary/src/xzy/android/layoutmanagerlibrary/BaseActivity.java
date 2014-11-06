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

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/**
 * @author zhengyangxu
 * @date Nov 4, 2014 4:28:08 PM TODO
 */
public class BaseActivity extends ActionBarActivity implements
        LayoutStateHelper.ButtonClickCallbacks {

    private LayoutStateHelper mLayoutStateHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        mLayoutStateHelper = new ActivityLayoutHelper(this);
        ((ActivityLayoutHelper) mLayoutStateHelper).setButtonClickCallbacks(this);
    }

    @Override
    protected void onDestroy() {
        mLayoutStateHelper.clear();
        super.onDestroy();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(mLayoutStateHelper.setContentView(layoutResID, null, null));
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(mLayoutStateHelper.setContentView(view, null, null), params);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(mLayoutStateHelper.setContentView(view, null, null));
    }

    public void showLayoutState(int stateID) {
        mLayoutStateHelper.showLayoutState(stateID);
    }

    public ActivityLayoutHelper getLayoutHelper() {
        return (ActivityLayoutHelper) mLayoutStateHelper;
    }

    /*
     * (non-Javadoc)
     * @see
     * xzy.android.layoutmanagerlibrary.ActivityLayoutHelper.ButtonClickCallbacks
     * #onEmptyStateRefresh(android.view.View)
     */
    @Override
    public void onEmptyStateRefresh(View view) {
        // TODO Auto-generated method stub

    }
}
