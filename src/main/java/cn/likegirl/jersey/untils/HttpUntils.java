package cn.likegirl.jersey.untils;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HD on 2017/7/26.
 */
public class HttpUntils {

    public Map<String,Object> restfull(){
        Map<String,Object> result = new HashMap<String, Object>();


        return  result;
    }
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        Date datetime = sim.parse(sim.format(new Date()));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        long sum =  new Date().getTime() - datetime.getTime();
        System.out.println("sum:"+sum);

        System.out.println("今天：这个月的第"+calendar.get(Calendar.WEEK_OF_MONTH)+"周");
        int weekNum = calendar.get(Calendar.DAY_OF_WEEK);
        switch (weekNum){
            case 1:
                System.out.println("星期日");
                break;
            default:
                System.out.println("星期"+(weekNum-1));
        }
       // System.out.println("星期："+calendar.get(Calendar.DAY_OF_WEEK));
        int year = calendar.get(Calendar.YEAR);
        int mon = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("year:"+year+",mon:"+mon+",day:"+day);
    }
}
