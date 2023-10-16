import java.util.*;

class task1 {
    public static void main(String[] args) {
        int answer, guess;
        final int MAX = 100;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter max number of tries you want to take: ");
        int maxTries = sc.nextInt();
        String reRun = "yes";
        while (reRun.toLowerCase().equals("yes")) {
            Random rand = new Random();
            answer = rand.nextInt(MAX) + 1;
            int usedTries = 0;
            boolean correct = false;
            while (!correct) {
                if (usedTries == maxTries) {
                    System.out.println("You've reached your max number of tries.");
                    break;
                }
                System.out.print("Guess a number between 1 and 100: ");
                guess = sc.nextInt();
                usedTries++;
                if (guess > answer) {
                    System.out.println("Too high, guess again.");
                } else if (guess < answer) {
                    System.out.println("Too low, guess again.");
                } else {
                    System.out.println("Yes, you guessed the number.");
                    correct = true;
                }
            }
            System.out.print("Wanna try again?: ");
            reRun = sc.next();
        }
        sc.close();
    }
}