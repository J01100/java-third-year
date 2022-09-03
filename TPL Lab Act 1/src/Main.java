import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a word/phrase: ");
        String wordOrPhrase = sc.nextLine();

        if (isPalindrome(wordOrPhrase))
            System.out.println(wordOrPhrase + " is a palindrome");
        else
            System.out.println(wordOrPhrase + " is NOT a palindrome");
    }

    public static boolean isPalindrome(String str){
        String original = str.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s","");
        String reversed = "";

        for (int c = original.length()-1; c >= 0; c--)
            reversed += original.charAt(c);

        return (original.equalsIgnoreCase(reversed));
    }
}
