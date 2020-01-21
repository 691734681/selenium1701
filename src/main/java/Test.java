import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args){
        SimpleDateFormat si=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time=si.format(new Date());
        time = time.trim().replaceAll("\\s+","_");
        System.out.println(time);
//        String filename = time+".jpg";
//        filename.trim().replaceAll("2","x");
//        System.out.println(filename);
    }
}
