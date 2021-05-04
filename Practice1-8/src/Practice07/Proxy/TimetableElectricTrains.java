package Practice07.Proxy;

import java.util.ArrayList;
import java.util.Scanner;

public class TimetableElectricTrains implements TimetableTrains {
    String test ="9B-6854;Лондон;Прага;13:43;21:15;07:32\n" +
            "BA-1404;Париж;Грац;14:25;21:25;07:00\n" +
            "9B-8710;Прага;Вена;04:48;08:49;04:01;\n" +
            "9B-8122;Прага;Грац;04:48;08:49;04:01";
    @Override
    public String[] getTimetable() {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(test);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            list.add(line);
        }
        return list.toArray(new String[list.size()]);
    }

    @Override
    public String getTrainDepartureTime(String trainId) {
        String[] timetable = getTimetable();
        for (String s : timetable) {
            if (s.startsWith(trainId + ";")) return s;
        }
        return "";
    }
}
