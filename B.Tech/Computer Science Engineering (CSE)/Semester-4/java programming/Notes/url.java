import java.util.Scanner;

public class WebsiteTypeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a website URL: ");
        String url = sc.nextLine().toLowerCase();

        if (url.endsWith(".com")) {
            System.out.println("This is a Commercial Website.");
        } else if (url.endsWith(".org")) {
            System.out.println("This is an Organization Website.");
        } else if (url.endsWith(".in")) {
            System.out.println("This is an Indian Website.");
        } else {
            System.out.println("Website type not identified.");
        }

        sc.close();
    }
}