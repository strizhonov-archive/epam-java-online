package regex.firsttask;

import java.util.regex.Pattern;

public class Utils {

    public static String sortParagraphs(String text) {

        // Getting array of paragraphs
        String[] paragraphs = getParagraphs(text);

        // Getting array of paragraphs' length (in sentences)
        int[] parLen = new int[paragraphs.length];

        for (int i = 0; i < paragraphs.length; i++) {
            parLen[i] = getSentences(paragraphs[i]).length;
        }

        // Sorting paragraphs' array by length
        for (int i = 0; i < parLen.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < parLen.length; j++) {
                if (parLen[j] < parLen[minIndex]) {
                    minIndex = j;
                }
            }
            int buf = parLen[i];
            parLen[i] = parLen[minIndex];
            parLen[minIndex] = buf;

            String sBuf = paragraphs[i];
            paragraphs[i] = paragraphs[minIndex];
            paragraphs[minIndex] = sBuf;
        }

        // Creating string from sorted paragraphs
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paragraphs.length; i++) {
            sb.append(i + 1)
                    .append(" paragraph, ")
                    .append(parLen[i])
                    .append(" sentence(s):\n")
                    .append(paragraphs[i].trim())
                    .append("\n");
        }

        return sb.toString();
    }


    public static String sortWordsByLength(String text) {

        StringBuilder sb = new StringBuilder();

        String[] sentences = getSentences(text);

        for (int i = 0; i < sentences.length; i++) {

            // Getting array of words from sentence
            String[] words = getWords(sentences[i]);

            // Getting array of words' length
            int[] wordLen = new int[words.length];
            for (int j = 0; j < words.length; j++) {
                wordLen[j] = words[j].length();
            }

            // Sorting words by length
            for (int j = 0; j < wordLen.length; j++) {
                int minIndex = j;
                for (int k = j + 1; k < wordLen.length; k++) {
                    if (wordLen[k] < wordLen[minIndex]) {
                        minIndex = k;
                    }
                }
                int buf = wordLen[j];
                wordLen[j] = wordLen[minIndex];
                wordLen[minIndex] = buf;

                String sBuf = words[j];
                words[j] = words[minIndex];
                words[minIndex] = sBuf;
            }

            // Creating string from sorted words
            sb.append(i + 1)
                    .append(" sentence's words:\n");
            for (int j = 0; j < words.length; j++) {
                if (words[j].length() != 0) {
                    sb.append(words[j]);
                    if (j != words.length - 1) {
                        sb.append(" ");
                    }

                }
            }
            sb.append(".\n\n");
        }

        return sb.toString();
    }


    public static String sortLexemes(String text, char symbol) {

        StringBuilder stringBuilder = new StringBuilder();

        String[] sentences = getSentences(text);

        for (int h = 0; h < sentences.length; h++) {

            // Getting array of lexemes in sentence
            String[] lexemes = getWords(sentences[h]);

            // Getting array of passed symbol quantity in every lexeme
            int[] counts = new int[lexemes.length];
            for (int i = 0; i < lexemes.length; i++) {
                counts[i] = countChar(lexemes[i], symbol);
            }

            // Sorting lexeme by passed symbol quantity
            for (int i = 0; i < counts.length; i++) {
                int maxIndex = i;
                for (int j = i + 1; j < counts.length; j++) {
                    if (counts[j] > counts[maxIndex]
                            || (counts[j] == counts[maxIndex] && lexemes[j].compareTo(lexemes[maxIndex]) < 0)) {
                        maxIndex = j;
                    }
                }
                int buf = counts[i];
                counts[i] = counts[maxIndex];
                counts[maxIndex] = buf;

                String sBuf = lexemes[i];
                lexemes[i] = lexemes[maxIndex];
                lexemes[maxIndex] = sBuf;

            }

            // Creating string from sorted words
            stringBuilder.append(h + 1)
                    .append(" sentence's words:\n");
            for (int i = 0; i < lexemes.length; i++) {
                stringBuilder.append(lexemes[i]);
                stringBuilder.append(" ");
            }
            stringBuilder.append("\n\n");

        }

        return stringBuilder.toString();
    }


    private static String[] getParagraphs(String text) {
        Pattern pattern = Pattern.compile("\\n");
        return pattern.split(text);
    }

    private static String[] getSentences(String text){
        Pattern pattern = Pattern.compile("[...]|[?..]|[!!!]|[???]\\.|!|\\?");
        return pattern.split(text);
    }

    private static int countChar(String word, char symbol) {
        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == symbol) {
                counter++;
            }
        }
        return counter;
    }

    private static String[] getWords(String text){

        Pattern pattern = Pattern.compile("[\\s.]+");
        String[] words = pattern.split(text);

        int voidCounter = 0;
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[,\\.^!\\?<>:;\"\'\\n\\-\\—]$", "").trim().toLowerCase();
            if ("".equals(words[i])) {
                voidCounter++;
            }
        }

        if (voidCounter > 0) {
            String[] wordsWithoutVoid = new String[words.length - voidCounter];
            for (int i = 0, j = 0; i < words.length; i++, j++) {
                if ("".equals(words[i])) {
                    j--;
                } else {
                    wordsWithoutVoid[j] = words[i];
                }
            }
            words = wordsWithoutVoid;
        }

        return words;
    }

}
