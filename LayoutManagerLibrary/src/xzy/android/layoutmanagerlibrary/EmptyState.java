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
import android.view.ViewGroup;
import android.widget.Button;

/**
 * @author zhengyangxu
 * @date Nov 5, 2014 4:03:26 PM
 * TODO
 *
 */
public class EmptyState extends LayoutState {

    public interface Callbacks {
        public void onRefresh(View view);
    }

    private Callbacks mCallback;
    
    private Button mRefreshButton;
    
    public EmptyState(Context context, View view, ViewGroup parent, int stateID) {
        super(context, view, parent, stateID);
        init();
    }
    
    private void init() {
        mRefreshButton = (Button) mContentLayout.findViewById(R.id.ltm_empty_btn);
        mRefreshButton.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                if (mCallback != null) {
                    mCallback.onRefresh(v);
                }
            }
        });
    }

    @Override
    public int getDefaultResID() {
        return R.layout.ltm_emptydata;
    }

    public void setCallback(Callbacks cb) {
        mCallback = cb;
    }
    
}
