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
import android.content.Intent;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author zhengyangxu
 * @date Oct 25, 2014 5:10:51 PM
 */
public class NetworkErrorState extends LayoutState {

    private CharSequence mPromptTitle;
    private CharSequence mPromptSummary;

    private TextView mPromptTitleTextView;
    private TextView mPromptSummaryTextView;
    private Button mErrorButton;

    public NetworkErrorState(Context context, View view, ViewGroup parent, int stateID) {
        super(context, view, parent, stateID);
        init();
    }

    private void init() {
        mPromptTitleTextView = (TextView) mContentLayout
                .findViewById(R.id.state_network_err_prompt_title);
        mPromptSummaryTextView = (TextView) mContentLayout
                .findViewById(R.id.state_network_err_prompt_summary);
        mErrorButton = (Button) mContentLayout.findViewById(R.id.state_network_err_btn);
        mErrorButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                mContext.startActivity(intent);
            }
        });
    }

    public void setPrompt(CharSequence title, CharSequence summary) {
        mPromptTitle = title;
        mPromptSummary = summary;
    }

    @Override
    public int getDefaultResID() {
        return R.layout.state_network_err;
    }

}
