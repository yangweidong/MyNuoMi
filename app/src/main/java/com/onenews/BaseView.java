/*
 * Copyright 2016, The Android Open Source Project
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

package com.onenews;

public interface BaseView<T> {

    void setPresenter(T presenter);

//    /**
//     * 加载中布局
//     */
//    void displayLoadingView();
//    /**
//     * 显示内容布局, 在网络成功后回调
//     */
//    void displayContentView();
//
//    /**
//     * 显示错误布局, 获取网络数据失败或者错误
//     */
//    void displayErrorView();
//
//
//    /**
//     * 空布局
//     */
//    void displayEmptyView();

}
