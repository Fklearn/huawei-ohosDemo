package com.example.myapplication;

import com.example.myapplication.slice.MainAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.bundle.BundleInfo;
import ohos.bundle.IBundleManager;
import ohos.rpc.RemoteException;

public class MainAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
        Logs.i("inside [onStart] ...");
        Logs.i(MainAbilitySlice.class.getName());

        testCmd();

        //IBundleManager类似Android中的PackageManager

        IBundleManager ibm = getBundleManager();
        Logs.d(ibm.toString());
        Logs.i("getBundleName:" + getBundleName());
        try {
            BundleInfo inf = ibm.getBundleInfo(getBundleName(), 1);
            Logs.i("getBundleInfo:" + inf.toString());
            Logs.i("getAbilityInfos:" + inf.getAbilityInfos().toString());
            Logs.i("getAppInfo:" + inf.getAppInfo().toString());


        } catch (RemoteException e) {
            Logs.d(e);
        }
//        ohos.app.Application application = new ohos.app.Application();


    }

    private void testCmd() {
        String res = ShellUtils.exec("pm list packages");
        Logs.i("packages:\r\n" + res);
        //hdc.exe shell bm get -udid
        Logs.i("UUID\r\n" + ShellUtils.exec("bm get -udid"));
        Logs.i("dump\r\n" + ShellUtils.exec("bm dump -l"));
        //多设备
        //hdc list targets
        //hdc -t <UTID> shell bm get -udid 或者 adb -s 设备序列号 shell bm get -udid
    }

    @Override
    protected void onActive() {
        super.onActive();
        Logs.i("inside [onActive] ...");
    }

    @Override
    protected void onCommand(Intent intent, boolean restart, int startId) {
        super.onCommand(intent, restart, startId);
        Logs.i("inside [onCommand] ...");
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        Logs.i("inside [onInactive] ...");
    }

    @Override
    protected void onBackPressed() {
        super.onBackPressed();
        Logs.i("inside [onBackPressed] ...");
    }

    @Override
    protected void onBackground() {
        super.onBackground();
        Logs.i("inside [onBackground] ...");
    }



    @Override
    protected void onForeground(Intent intent) {
        super.onForeground(intent);
        Logs.i("inside [onForeground] ...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logs.i("inside [onStop] ...");
    }
}
