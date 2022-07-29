package com.example.myapplication;

import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public class Logs {

    static HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0x00201, "sanbo");
//    static HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 1, "sanbo");

    public static void i(Throwable error) {
        HiLog.info(label, HiLog.getStackTrace(error));
    }

    public static void i(String msg) {
        HiLog.info(label, msg);
    }

    public static void d(Throwable error) {
        HiLog.debug(label, HiLog.getStackTrace(error));
    }

    public static void d(String msg) {
        HiLog.debug(label, msg);
    }

    public static void w(Throwable error) {
        HiLog.warn(label, HiLog.getStackTrace(error));
    }

    public static void w(String msg) {
        HiLog.warn(label, msg);
    }

    public static void e(Throwable error) {
        HiLog.fatal(label, HiLog.getStackTrace(error));
    }

    public static void e(String msg) {
        HiLog.fatal(label, msg);
    }
}
