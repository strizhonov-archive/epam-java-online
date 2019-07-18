package cycleprogram;

public class Second {

    public static void resolveFunction(int a, int b, int h) {

        System.out.println("Results with " + h + "*x increment:");

        for (int i = a; i <= b; i = i + h) {

            if (i <= 2) {
                System.out.println("x = " + i + "; y = " + -i);
            } else {
                System.out.println("x = " + i + "; y = " + i);
            }

        }

    }

}
