import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test {


    public static void main(String[] args) throws ParseException {
        int i = lastDayOfMonth("2021-02-16 03:24:46");
        System.out.println(i);
    }


    static int lastDayOfMonth(String time) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-HH").parse(time);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.MONTH, 1);
        instance.set(Calendar.DAY_OF_MONTH, 0);
        return instance.get(Calendar.DAY_OF_MONTH);
    }
}

