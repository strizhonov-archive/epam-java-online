package stringasobject;

public class Sixth {

    public static void doubleSymbols(String text){

        StringBuilder stringBuilder = new StringBuilder(text);
        for (int i = 0; i < stringBuilder.length(); i += 2){
            stringBuilder.insert(i + 1, stringBuilder.charAt(i));
        }
        System.out.println(stringBuilder);
    }
}
