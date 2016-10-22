package pl.agh.id.tripsettlement.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class DateUtil {

    private static final Logger logger = Logger.getLogger(DateUtil.class.toString());

    public static Date convertStringToDate(String s) {

        Date date = null;
        if (s == null) {
            return null;
        }
        //zmień s
        s = s.replaceAll("T", " "); //pozbywamy się T
        s = s.replaceAll("Z", ""); //pozbywamy się Z
        if (s.length() > 19) {
            s = s.substring(0, 19);
        }

        if (s.length() == 10) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = dateFormat.parse(s);
            } catch (ParseException e) {
                //ignore
            }
        } else if (s.length() == 16) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                date = dateFormat.parse(s);
            } catch (ParseException e) {
                //ignore
            }
        } else if (s.length() == 19) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                date = dateFormat.parse(s);
            } catch (ParseException e) {
                //ignore
            }
        } else if (s.length() > 19) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            try {
                date = dateFormat.parse(s);
            } catch (ParseException e) {
                //ignore
            }
        }

        return date;
    }

    /**
     * Konwersja daty do Stringa w formacie: yyyy-MM-ddTHH:mm:ss.SSSZ
     *
     * np .2015-11-26T06:26:00.207Z
     *
     * @param date data
     * @return string w formacie daty ISO 8601
     */
    public static String convertDateToString(Date date) {
        String s = null;
        if (date == null) {
            return "";
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        s = dateFormat.format(date);

        s = s.replace(" ", "T");
        s = s.concat("Z");

        return s;
    }

    public static Long convertTimeStringFormatToLong(String s) {
        DateFormat dateFormat = new SimpleDateFormat("mm:ss");
        try {
            Date date = dateFormat.parse(s);
            Date reference = dateFormat.parse("00:00:00");
            Long seconds = (date.getTime() - reference.getTime())/1000L;
            return seconds;
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Przy złej konwersji zwraca 0 seconds.
        }
    }


}
