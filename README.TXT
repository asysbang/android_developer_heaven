
1.asynctask with custom  threadpool  WakeLock

    packages/apps/Messaging/src/com/android/messaging/util/SafeAsyncTask.java

    sWakeLock.acquire(Factory.get().getApplicationContext(), intent, WAKELOCK_OP);

    ???data sync control

    how to stop  asynctask


2.Circle image view


3.loader  and  loadermanager


4.logical     wifi scan list   wifi 状态变化   连接开始  连接成功



5.android  test

6.一套线程处理的

    区分是否需要同时允许多个任务进行

        VCard的导入导出是不允许同时进行的

    怎么停止运行中的


    ThreadFactory  和  Executors    ExecutorService   ThreadPoolExecutor

    启动的线程过多怎么处理

    怎么传递参数



========================================
1.getInstance 是否要考虑线程安全？？？移动端是否会出现同时多个请求

    Calendar.getInstance   不可以用来参考吗，这个每次都返回新的实例对象

    CallList  InCallVideoCallCallbackNotifier  GalleryBitmapPool 直接在static 时 new的


    public static synchronized xxxx getInstance 的有

    InCallPresenter.java
    ContactInfoCache
    ResourceHelper
    CookieSyncManager.java  !!!系统的类


==================
AuthenticationCache.java
RefreshStatusMonitor.java

LocalBroadcastManager.java

    Analytics.java
    private static Tracker sInstance;

    private Analytics() {
    }

    public static Tracker getInstance() {
        synchronized (Analytics.class) {
            if (sInstance == null) {
                sInstance = new StubTracker();
            }
        }
        return sInstance;
    }

    public static void setTracker(Tracker t) {
        synchronized (Analytics.class) {
            sInstance = t;
        }
    }


    TelecomAdapter.java  没做任何处理
    Index.java





2.线程池使用
   cached  共4处
   fixed   共9处 其中去掉重复类的 只有6处

   高低优先级的线程池可以参考 Camera2 下面的 AndroidPriorityThread.java





