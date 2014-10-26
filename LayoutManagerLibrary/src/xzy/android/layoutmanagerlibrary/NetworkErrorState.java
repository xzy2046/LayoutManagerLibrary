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

/**
 * @author zhengyangxu
 * @date Oct 25, 2014 5:10:51 PM TODO TODO
 */
public class NetworkErrorState extends LayoutState {

    private CharSequence mPromptTitle;
    private CharSequence mPromptSummary;

    public NetworkErrorState(Context context) {
        this(context, null);

    }

    public NetworkErrorState(Context context, View view) {
        super(context, view);
        // default view
        if (view == null) {
            View contentView = LayoutInflater.from(context).inflate(R.layout.state_network_err,
                    null);
            this.setView(contentView);
        }
    }

     public void setPrompt(CharSequence title, CharSequence summary) {
         mPromptTitle = title;
         mPromptSummary = summary;
     }

}
