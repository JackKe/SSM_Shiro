package cn.likegirl.jersey.untils;


import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by HD on 2017/8/8.
 */
public class HttpUntils {


    @Test
    public void test01() {
        /*String str = "18672548400";
        str = str.replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)", "$1****$3$4");
        str = str.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        System.out.println(str);*/

        String str = "陈柯133";
        str = str.replaceAll("(\\S)(\\S*)", "*$2");
        //str = str.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        System.out.println(str);
    }

    @Test
    public void test02() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 30);
        System.out.println(simpleDateFormat.format(calendar.getTime()));

    }

    @Test
    public void test03() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentTime = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
        System.out.println(currentTime);
    }


    private int a = 0;
    private volatile boolean flag = false;

    void write() {
        a = 2;
        flag = true;
    }

    void read() {
        if (flag) {
            int n = a * a;
            System.out.println("why?" + n);
        }
    }

    @Test
    public void test04() {
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(5);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 20, 200, TimeUnit.MINUTES, workQueue);
        threadPoolExecutor.execute(() -> write());
        threadPoolExecutor.execute(() -> read());
    }

    @Test
    public void test05() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.remove(list.get(0));
        list.add("d");
        for (String s :
                list) {
            System.out.println("source:" + s);
        }
        for (String s :
                list.subList(0, 2)) {
            System.out.println("data:" + s);
        }
        for (String s :
                list.subList(2, 3)) {
            System.out.println(s);
        }

    }


    @Test
    public void test06() {
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(5);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 20, 200, TimeUnit.MINUTES, workQueue);
    }

    @Test
    public void test07() {
        System.out.println(Double.toString(Math.random()).substring(6));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 800; i++) {
            if(stringBuilder.length() > 0){
                stringBuilder.append(",").append(Double.toString(Math.random()).substring(6));
            }else{
                stringBuilder.append(Double.toString(Math.random()).substring(6));
            }
        }
        System.out.println(stringBuilder.toString());
    }

    @Test
    public void test08(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        //设置为12月31日
//        calendar.set(Calendar.MONTH, 11);
//        calendar.set(Calendar.DAY_OF_MONTH, 31);
        calendar.setTime(new Date());
        System.out.println("现在日期：" + simpleDateFormat.format(calendar.getTime()));
        //再增加一天
        calendar.add(Calendar.MONTH, -12);
        System.out.println("增加后的日期：" + simpleDateFormat.format(calendar.getTime()));
    }
}