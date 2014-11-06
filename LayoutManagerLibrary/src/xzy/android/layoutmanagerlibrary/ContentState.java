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

/**
 * @author zhengyangxu
 * @date Nov 4, 2014 5:51:36 PM
 * TODO
 *
 */
public class ContentState extends LayoutState {

    public ContentState(Context context, View view, ViewGroup parent, int stateID) {
        super(context, view, parent, stateID);
        // TODO Auto-generated constructor stub
    }

    @Override
    public int getDefaultResID() {
        return 0;
    }

}
