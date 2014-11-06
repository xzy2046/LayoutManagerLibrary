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

package xzy.android.layoutmanagerlibrarydemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;

import xzy.android.layoutmanagerlibrary.BaseFragment;
import xzy.android.layoutmanagerlibrary.LayoutStateHelper;

/**
 * @author zhengyangxu
 * @date Nov 6, 2014 4:58:54 PM TODO
 */
public class MyFragment extends BaseFragment {

    @Override
    public int getContentViewID() {
        return R.layout.base_content;
    }

    @Override
    public void onViewCreated(View view, @Nullable
    Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {

        view.findViewById(R.id.show_loading).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                showLayoutState(LayoutStateHelper.STATE_LOADING);
                v.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        showLayoutState(LayoutStateHelper.STATE_CONTENT_VIEW);
                    }
                }, 3000);
            }
        });

        view.findViewById(R.id.show_net_error).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                showLayoutState(LayoutStateHelper.STATE_NET_ERROR);
            }
        });

        view.findViewById(R.id.show_empty_data).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                showLayoutState(LayoutStateHelper.STATE_EMPTY_DATA);
            }
        });
    }

    @Override
    public void onEmptyStateRefresh(View view) {
        showLayoutState(LayoutStateHelper.STATE_LOADING);
    }

}
