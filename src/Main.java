import java.io.*;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Main {
    public static void main(String[] args) {
        String[] links = getLinksArray(624);

        for (int i = 0; i < links.length; i++) {
            System.out.println("Request # " + i);
            System.out.println(links[i]);
            System.out.println(getLawyersNames(links[i]));
            System.out.println("Address: " + getAddress(links[i]));
        }

    }

    public static String[] getLinksArray(int size) {
        String[] result = new String[size];
        File file = new File("file.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            for (int i = 0; i < size; i++) {
                result[i] = "https://nnoapso.fparf.ru" + reader.readLine() + "/";
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    public static ArrayList<String> getLawyersNames(String URL) {
        Document doc = null;
        ArrayList<String> result = new ArrayList<>();
        try {
            doc = Jsoup.connect(URL).get();
            Elements lowers = doc.select("td");
            String address = null;
            for (Element e : lowers
            ) {
                if (e.className().equals("big-table__col big-table__col_name")) {
                    result.add(e.text());
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static ArrayList<String> getAddress(String URL) {
        Document doc = null;
        ArrayList<String> address = new ArrayList<>();

        try {
            doc = Jsoup.connect(URL).get();
            Elements lowers = doc.select("td");
            for (Element e : lowers
            ) {
                if (e.className().equals("info-table__col")) {
                    address.add(e.text());
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return address;
    }
}