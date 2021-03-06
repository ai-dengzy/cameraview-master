/*
 * Copyright (C) 2016 The Android Open Source Project
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

package com.google.android.cameraview.demo;

import android.app.Application;
import android.os.Environment;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;

public class DemoApplication extends Application {
    public static final String APP_ID = "ab8cf50692";
    @Override
    public void onCreate() {
        super.onCreate();
        //版本2升级测试
        /***** Beta高级设置 *****/
        /**
         * true表示app启动自动初始化升级模块;
         * false不会自动初始化;
         * 开发者如果担心sdk初始化影响app启动速度，可以设置为false，
         * 在后面某个时刻手动调用Beta.init(getApplicationContext(),false);
         */
        Beta.autoInit = true;

        /**
         * true表示初始化时自动检查升级;
         * false表示不会自动检查升级,需要手动调用Beta.checkUpgrade()方法;
         */
        Beta.autoCheckUpgrade = true;

        /**
         * 设置升级检查周期为60s(默认检查周期为0s)，60s内SDK不重复向后台请求策略);
         */
        Beta.upgradeCheckPeriod = 60 * 1000;

        /**
         * 设置启动延时为1s（默认延时3s），APP启动1s后初始化SDK，避免影响APP启动速度;
         */
        Beta.initDelay = 1 * 1000;

        /**
         * 设置通知栏大图标，largeIconId为项目中的图片资源;
         */
        Beta.largeIconId = R.mipmap.ic_launcher;

        /**
         * 设置状态栏小图标，smallIconId为项目中的图片资源Id;
         */
        Beta.smallIconId = R.mipmap.ic_launcher;

        /**
         * 设置更新弹窗默认展示的banner，defaultBannerId为项目中的图片资源Id;
         * 当后台配置的banner拉取失败时显示此banner，默认不设置则展示“loading“;
         */
        Beta.defaultBannerId = R.mipmap.ic_launcher;

        /**
         * 设置sd卡的Download为更新资源保存目录;
         * 后续更新资源会保存在此目录，需要在manifest中添加WRITE_EXTERNAL_STORAGE权限;canShowUpgradeActs
         */
        Beta.storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        /**
         * 点击过确认的弹窗在APP下次启动自动检查更新时会再次显示;
         */
        Beta.showInterruptedStrategy = true;
        //Beta.autoDownloadOnWifi = true;
        /**
         * 只允许在MainActivity上显示更新弹窗，其他activity上不显示弹窗;
         * 不设置会默认所有activity都可以显示弹窗;
         */
        //Beta.canShowUpgradeActs.add(MainActivity.class);

        /*设置自定义升级对话框UI布局
        * 注意：因为要保持接口统一，需要用户在指定控件按照以下方式设置tag，
        * 否则会影响您的正常使用： - 特性图片：beta_upgrade_banner，如：android:tag="beta_upgrade_banner"
        标题：beta_title，如：android:tag="beta_title"
        升级信息：beta_upgrade_info 如： android:tag="beta_upgrade_info"
        更新属性：beta_upgrade_feature 如： android:tag="beta_upgrade_feature"
        取消按钮：beta_cancel_button 如：android:tag="beta_cancel_button"
        确定按钮：beta_confirm_button 如：android:tag="beta_confirm_button"
        * */
        //Beta.upgradeDialogLayoutId = R.layout.upgrade_layout;

        /***** 统一初始化Bugly产品，包含Beta *****/
        //Bugly.init(this, APP_ID, false);

    }
}
