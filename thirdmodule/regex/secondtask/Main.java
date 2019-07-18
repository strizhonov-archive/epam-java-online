package regex.secondtask;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static int deepCounter = 0;

    private static final String STRING_XML = "<notes>\n" +
            "\t" + "<note id = \"1\">\n" +
            "\t\t<to>Вася</to>\n" +
            "\t\t<from>Света</from>\n" +
            "\t\t" + "<heading>Напоминание</heading>\n" +
            "\t\t<body>Позвони мне завтра!</body>\n" +
            "\t</note>\n" +
            "\t" + "<note id = \"2\">\n" +
            "\t\t<to>Петя</to>\n" +
            "\t\t" + "<body/>\n" +
            "\t\t<from>Маша</from>\n" +
            "\t\t<heading>Важное напоминание</heading>\n" +

            "\t</note>\n" +
            "</notes>";

    private static final String PATTERN = "<(\\S+)(.*?)>([\\s\\S]*?)<(/\\1)>|(?<noBody><.+?/>)";

    public static void main(String[] args){

        String contents = STRING_XML;

        Dialog dialog = new Dialog();

        Pattern pattern = Pattern.compile(PATTERN);

        lookInside(contents, pattern, dialog);


    }

    private static void lookInside(String contents, Pattern pattern, Dialog dialog) {

        deepCounter++;

        if (dialog.askUserToContinue()) {
            Matcher matcher = pattern.matcher(contents);
            while (matcher.find()) {
                if (matcher.group(5) != null) {
                    System.out.println("Tag without body: \"" + matcher.group(5) + "\"");
                    System.out.println();
                } else {
                    System.out.println("Opening tag is: \"" + matcher.group(1) + "\"");
                    System.out.println("Attributes are: \"" + matcher.group(2) + "\"");
                    System.out.println("Closing tag is: \"" + matcher.group(4) + "\"");
                    System.out.println("Contents are: " + matcher.group(3));
                    System.out.println();
                    contents = matcher.group(3);
                }
                lookInside(contents, pattern, dialog);
            }

            deepCounter--;

            if (deepCounter == 0) {
                System.out.println("No more elements in the XML");
            }

        } else {
            deepCounter = 0;
        }


    }


}