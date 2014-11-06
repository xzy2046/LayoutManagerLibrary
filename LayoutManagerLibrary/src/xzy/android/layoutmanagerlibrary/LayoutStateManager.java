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

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengyangxu
 * @date Oct 26, 2014 4:17:42 PM 管理LayoutState,考虑onSaveInstance恢复状态。
 * @deprecated
 */
public abstract class LayoutStateManager {

    private List<LayoutState> mLayoutStates;
    
    public LayoutStateManager() {
        init();
    }
    
    private void init() {
        mLayoutStates = new ArrayList<LayoutState>();
    }

    /**
     * 
     * @param state
     * @return false : already contain this state
     *         true : add state for this LayoutStateManager
     */
    public boolean addLayoutState(LayoutState state) {
        boolean containState = false;

        for (int i = 0; i < mLayoutStates.size(); i++) {
//            if (mLayoutStates.get(i).getClass().getSimpleName()
//                    .equals(state.getClass().getSimpleName())) {
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
}
