package com.example.myapplication.slice;

import com.example.myapplication.Logs;
import com.example.myapplication.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        Logs.i("MainAbilitySlice. onStart");
    }

    @Override
    public void onActive() {
        super.onActive();
        Logs.i("MainAbilitySlice. onActive");
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
        Logs.i("MainAbilitySlice. onForeground");
    }
}
