package JavaCollectionsFramework2;

public class Continue {

    public static void main(String[] args) {
        for (int i = -2; i <= 10; i+=1) {
            System.out.print(i + " ");
            if (i % 2 == 0) {
                continue;
            }
            System.out.println();
        }
    }
}