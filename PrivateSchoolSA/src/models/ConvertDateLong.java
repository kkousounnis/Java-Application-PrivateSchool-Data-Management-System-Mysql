package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ConvertDateLong {

    public static long convertDate(String string_date) {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        long milliseconds = 0;
        try {
            Date d = f.parse(string_date);
            milliseconds = d.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return milliseconds;
    }
    //converting long to a string date with more information 10-january-2019
    public static String convertLong(long date) {
        Date d = new Date(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
        return dateFormat.format(d);
    }
    //coverting long to original input like this dd/mm/yyyy
    public static String convertLongToOriginalFormat(long date) {
        Date d = new Date(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(d);
    }

    public static LocalDate convertStringToLocaleDate(String stringdate) {
        boolean correctFormat = false;

        DateTimeFormatter formatter;
        LocalDate localDate = null;
        Date date; 

        try {
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            date = new SimpleDateFormat("dd/MM/yyyy").parse(stringdate);
            localDate = LocalDate.parse(stringdate, formatter);

            //if date hase a correct format the program shall continue
            correctFormat = true;

        } catch (ParseException e) {

            correctFormat = false;
        }
        //i return date of birth as a string and 

        return localDate;
    }
}
