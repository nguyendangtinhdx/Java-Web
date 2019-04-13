package model;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Utils {
    /**
     *  chuyển chuỗi kiểu hh:mm MM/dd/yyyy sang thành dạng timestamp
     * @param stDateTime
     * @return
     * @throws ParseException 
     */
    public static Timestamp parseFromString(String stDateTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm dd/MM/yyyy");
        java.util.Date ngayGio = sdf.parse(stDateTime);
        return new Timestamp(ngayGio.getTime());
    }
}
