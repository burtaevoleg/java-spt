package Practice07.Proxy;

public class TimetableElectricTrainsProxy implements TimetableTrains{

    private TimetableTrains timetableTrains = new TimetableElectricTrains();

    private String[] timetableCache = null;

    @Override
    public String[] getTimetable() {
        if(timetableCache == null) {
            timetableCache = timetableTrains.getTimetable();
        }
        return timetableCache;
    }

    @Override
    public String getTrainDepartureTime(String trainId) {
        if(timetableCache == null) {
            timetableCache = timetableTrains.getTimetable();
        }
        for (String s : timetableCache) {
            if (s.startsWith(trainId + ";")) return s;
        }
        return "";
    }

    public void clearCache() {
        timetableTrains = null;
    }
}
