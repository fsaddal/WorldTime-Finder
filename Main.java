import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Map<String, String> TIMEZONES = new HashMap<>();

    static {
        TIMEZONES.put("japan", "Asia/Tokyo");
        TIMEZONES.put("usa", "America/New_York");
        TIMEZONES.put("united states", "America/New_York");
        TIMEZONES.put("new york", "America/New_York");
        TIMEZONES.put("los angeles", "America/Los_Angeles");
        TIMEZONES.put("uk", "Europe/London");
        TIMEZONES.put("united kingdom", "Europe/London");
        TIMEZONES.put("england", "Europe/London");
        TIMEZONES.put("india", "Asia/Kolkata");
        TIMEZONES.put("australia", "Australia/Sydney");
        TIMEZONES.put("sydney", "Australia/Sydney");
        TIMEZONES.put("germany", "Europe/Berlin");
        TIMEZONES.put("france", "Europe/Paris");
        TIMEZONES.put("canada", "America/Toronto");
        TIMEZONES.put("toronto", "America/Toronto");
        TIMEZONES.put("vancouver", "America/Vancouver");
        TIMEZONES.put("brazil", "America/Sao_Paulo");
        TIMEZONES.put("mexico", "America/Mexico_City");
        TIMEZONES.put("china", "Asia/Shanghai");
        TIMEZONES.put("beijing", "Asia/Shanghai");
        TIMEZONES.put("south africa", "Africa/Johannesburg");
        TIMEZONES.put("egypt", "Africa/Cairo");
        TIMEZONES.put("russia", "Europe/Moscow");
        TIMEZONES.put("moscow", "Europe/Moscow");
        TIMEZONES.put("italy", "Europe/Rome");
        TIMEZONES.put("spain", "Europe/Madrid");
        TIMEZONES.put("argentina", "America/Argentina/Buenos_Aires");
        TIMEZONES.put("saudi arabia", "Asia/Riyadh");
        TIMEZONES.put("uae", "Asia/Dubai");
        TIMEZONES.put("dubai", "Asia/Dubai");
        TIMEZONES.put("indonesia", "Asia/Jakarta");
        TIMEZONES.put("south korea", "Asia/Seoul");
        TIMEZONES.put("seoul", "Asia/Seoul");
        TIMEZONES.put("nigeria", "Africa/Lagos");
        TIMEZONES.put("turkey", "Europe/Istanbul");
        TIMEZONES.put("pakistan", "Asia/Karachi");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🌍 Welcome to WorldTimeFinder!");
        System.out.print("Enter a country or city name: ");
        String input = scanner.nextLine().toLowerCase();

        if (TIMEZONES.containsKey(input)) {
            String zoneId = TIMEZONES.get(input);
            ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of(zoneId));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a, EEEE, MMMM dd yyyy");

            System.out.println("Current time in " + capitalize(input) + ": " + currentTime.format(formatter));
        } else {
            System.out.println(" Try another one");
        }

        scanner.close();
    }

    private static String capitalize(String str) {
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }
}
