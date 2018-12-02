package soexample.umeng.com.myapplication;

import android.content.Context;

/**
 * Created by mumu on 2018/11/1.
 * 保持单例
 */

public class DaoManager {
    private static DaoManager daoManager;
    private DaoSession daoSession;

    private DaoManager(Context context) {
        daoSession = DaoMaster.newDevSession(context, "person.db");
    }

    public static DaoManager getInstance(Context context) {
        if (daoManager == null) {
            synchronized (DaoManager.class) {
                if (daoManager == null) {
                    daoManager = new DaoManager(context);
                }
            }
        }
        return daoManager;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
