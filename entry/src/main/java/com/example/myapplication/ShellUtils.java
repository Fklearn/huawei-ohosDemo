package com.example.myapplication;


import java.io.*;
import java.net.HttpURLConnection;
import java.nio.channels.FileLock;

/**
 * @Copyright © 2020/2/12 analysys Inc. All rights reserved.
 * @Description: shell工具类
 * @Version: 1.0
 * @Create: 2020/2/12 15:23
 * @author: sanbo
 */
public class ShellUtils {


    public static String exec(String cmd) {
        String result = "";
        Process proc = null;
        BufferedInputStream in = null;
        BufferedReader br = null;
        InputStreamReader is = null;
        InputStream ii = null;
        StringBuilder sb = new StringBuilder();
        DataOutputStream os = null;
        OutputStream pos = null;
        try {
            proc = Runtime.getRuntime().exec("sh");
            pos = proc.getOutputStream();
            os = new DataOutputStream(pos);

            // donnot use os.writeBytes(commmand), avoid chinese charset error
            os.write(cmd.getBytes());
            os.writeBytes("\n");
            os.flush();
            // exitValue
            os.writeBytes("exit\n");
            os.flush();
            ii = proc.getInputStream();
            in = new BufferedInputStream(ii);
            is = new InputStreamReader(in);
            br = new BufferedReader(is);
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            if (sb.length() > 0) {
                return sb.substring(0, sb.length() - 1);
            }
            result = String.valueOf(sb);
            if (result != "" && result.length() > 0) {
                result = result.trim();
            }

        } catch (Throwable e) {

        } finally {
            safeClose(pos, ii, br, is, in, os);
        }

        return result;
    }

    public static void safeClose(Object... os) {
        if (os != null && os.length > 0) {
            for (Object o : os) {
                if (o != null) {
                    try {
                        if (o instanceof HttpURLConnection) {
                            ((HttpURLConnection) o).disconnect();
                        } else if (o instanceof Closeable) {
                            ((Closeable) o).close();
                        } else if (o instanceof FileLock) {
                            ((FileLock) o).release();
                        }
                    } catch (Throwable e) {
                    }
                }
            }
        }
    }

}
