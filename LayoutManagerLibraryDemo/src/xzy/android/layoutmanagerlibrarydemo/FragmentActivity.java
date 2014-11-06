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
import android.support.v4.app.Fragment;

import xzy.android.layoutmanagerlibrary.BaseActivity;

/**
 * @author zhengyangxu
 * @date Nov 6, 2014 4:56:53 PM
 * TODO
 *
 */
public class FragmentActivity extends BaseActivity {
    
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.fragment_activity);
        
        if(saveInstanceState == null){
            Fragment fragment = new MyFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.content, fragment).commit();
            
        }
        
    }
}
