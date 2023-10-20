import java.util.*;

class NumberGame {
    public static void main(String[] args) {
        int answer, guess;
        final int MAX = 100;
        Scanner sc = new Scanner(System.in);
        System.out.println("<=================================================>");
        System.out.println("\t    Welcome To The Number Game");
        System.out.println("<=================================================>");
        System.out.print("\tEnter max tries you want to take: ");
        int maxTries = sc.nextInt();
        String reRun = "yes";
        while (reRun.toLowerCase().equals("yes")) {
            Random rand = new Random();
            answer = rand.nextInt(MAX) + 1;
            int usedTries = 0;
            boolean correct = false;
            while (!correct) {
                if (usedTries == maxTries) {
                    System.out.println("\tYou've reached your max number of tries.");
                    break;
                }
                System.out.print("\tGuess a number between 1 and 100: ");
                guess = sc.nextInt();
                usedTries++;
                if (guess > answer) {
                    System.out.println("\t\tToo high, guess again.");
                } else if (guess < answer) {
                    System.out.println("\t\tToo low, guess again.");
                } else {
                    System.out.println("\t    Yes, you guessed the number.");
                    correct = true;
                }
                System.out.println("<=================================================>");
            }
            System.out.print("\t\tWanna try again?: ");
            reRun = sc.next();
        }
        sc.close();
    }
}