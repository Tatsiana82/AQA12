package HW_lesson_15;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task_2_OpenFivePages {
    public static void main(String[] args) throws InterruptedException {
        List<String> urls = new ArrayList<>();
        urls.add("http://www.automationpractice.pl/index.php");
        urls.add("https://zoo.waw.pl/");
        urls.add("https://www.w3schools.com/");
        urls.add("https://www.clickspeedtester.com/click-counter/");
        urls.add("https://andersenlab.com/");

        List<Process> processes = new ArrayList<>();

        for (String url : urls) {
            openWebPage(url, processes);
            System.out.println("Page is open: " + getTitle(url) + " (" + url + ")");
            Thread.sleep(2000);
        }

            for (int i = 0; i < urls.size(); i++) {
            String url = urls.get(i);
            System.out.println("Turn to page: " + getTitle(url) + " (" + url + ")");
            Thread.sleep(2000);
        }

        for (int i = 0; i < urls.size(); i++) {
            String url = urls.get(i);
            if (getTitle(url).contains("Zoo")) {
                closeWebPage(processes.get(i));
                System.out.println("Page is closed: " + getTitle(url) + " (" + url + ")");
            }
        }
    }

    private static void openWebPage(String url, List<Process> processes) {
        try {
            Process process = new ProcessBuilder("rundll32", "url.dll,FileProtocolHandler", url).start();
            processes.add(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeWebPage(Process process) {
        process.destroy();
    }

    private static String getTitle(String url) {

        if (url.contains("automationpractice")) return "Automation Practice";
        if (url.contains("zoo")) return "Zoo";
        if (url.contains("w3schools")) return "W3Schools";
        if (url.contains("clickspeedtester")) return "Click Speed Tester";
        if (url.contains("andersenlab")) return "Andersen Lab";
        return "Unknown";
    }
}