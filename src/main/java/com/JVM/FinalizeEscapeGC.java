package com.JVM;

/**
 * 〈一句话功能简述〉<br>
 * 〈对象在GC时候自我统计〉
 *
 * @author baiwc
 * @date 2019-11-06 13:32
 * @since 2019.11.06
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("Yes,I am still alive :");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed !!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次拯救自己
        System.gc();

        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK .isAlive();
        } else {
            System.out.println("I am dead !!");
        }
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK .isAlive();
        } else {
            System.out.println("no,I am dead !!");
        }
    }
}