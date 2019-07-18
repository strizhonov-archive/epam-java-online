package stringasobject;

public class First {


    public static void countMaxSpaces(String s) {
        String [] spacesArray = s.split("\\S");

        int max = 0;
        for (String space : spacesArray){
            if (space.length() > max){
                max = space.length();
            }
        }

        System.out.println(max);
    }
}
