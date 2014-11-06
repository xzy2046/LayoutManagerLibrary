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

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import xzy.android.layoutmanagerlibrary.BaseActivity;
import xzy.android.layoutmanagerlibrary.LayoutStateHelper;

//import android.support.v7.app.ActionBarActivity;

/**
 * @author zhengyangxu
 * @date Nov 4, 2014 7:20:54 PM TODO
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // View view = LayoutInflater.from(this).inflate(R.layout.first, null);
        setContentView(R.layout.base_content);
//        showLayoutState(LayoutStateHelper.STATE_CONTENT_VIEW);

        initViews();
    }

    private void initViews() {

        findViewById(R.id.show_loading).setOnClickListener(new OnClickListener() {

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

        findViewById(R.id.show_net_error).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                showLayoutState(LayoutStateHelper.STATE_NET_ERROR);
            }
        });

        findViewById(R.id.show_empty_data).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                showLayoutState(LayoutStateHelper.STATE_EMPTY_DATA);
            }
        });

        findViewById(R.id.start_fragment_activity).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this,
                        FragmentActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        getLayoutHelper().showPreviousState();
    }

    @Override
    public void onEmptyStateRefresh(View view) {
        showLayoutState(LayoutStateHelper.STATE_LOADING);
        super.onEmptyStateRefresh(view);
    }

}
