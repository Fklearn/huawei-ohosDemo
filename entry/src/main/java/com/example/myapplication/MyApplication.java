package com.example.myapplication;

import ohos.aafwk.ability.AbilityPackage;

public class MyApplication extends AbilityPackage {
    @Override
    public void onInitialize() {
        super.onInitialize();
        Logs.i("MyApplication.onInitialize");
    }
}