package Practice07.Proxy;

public class Main {
    public static void main(String[] args) {
        DisplayTimetable displayTimetable = new DisplayTimetable();
        displayTimetable.printTimetable();

        displayTimetable.printTimetable();
    }
}
