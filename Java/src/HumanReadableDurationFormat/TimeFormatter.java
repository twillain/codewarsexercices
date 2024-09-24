package HumanReadableDurationFormat;

public class TimeFormatter {

    public static String formatDuration(int seconds){
        if (seconds == 0) return "now";

        int[] values = {31536000,86400,3600,60,1};
        String[] time = {"year","day","hour","minute","second"};
        int count = 0;
        for (int i=0; i<values.length; i++){
            int temp = seconds / values[i];
            if (temp != 0) count++;
            seconds %= values[i];
            values[i] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i < values.length ; i++){
            if (values[i] > 0) sb.append(values[i]).append(' ').append(time[i]);
            if (values[i] > 1) sb.append("s");

            if (count > 2 && values[i] > 0){
                sb.append(", ");
                count--;
            } else if (count == 2 && values[i] > 0){
                sb.append(" and ");
                count--;
            }
        }

        return sb.toString();
    }

    public static void main(String... args){
        System.out.println(formatDuration(3600));
    }
}
