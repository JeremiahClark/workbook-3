package com.pluralsight;

import java.util.Random;
import java.util.Scanner;

public class FamousQuotes{

        public static void main(String[] args) {
            String[] quotes = {
                    "Be yourself; everyone else is already taken. - Oscar Wilde",
                    "Two things are infinite: the universe and human stupidity. - Albert Einstein",
                    "So many books, so little time. - Frank Zappa",
                    "A room without books is like a body without a soul. - Marcus Tullius Cicero",
                    "You only live once, but if you do it right, once is enough. - Mae West",
                    "Be the change that you wish to see in the world. - Mahatma Gandhi",
                    "In three words I can sum up everything I've learned about life: it goes on. - Robert Frost",
                    "If you tell the truth, you don't have to remember anything. - Mark Twain",
                    "Always forgive your enemies; nothing annoys them so much. - Oscar Wilde",
                    "Live as if you were to die tomorrow. Learn as if you were to live forever. - Mahatma Gandhi"
            };

            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            boolean keepRunning = true;

            while (keepRunning) {
                System.out.println("\nChoose an option:");
                System.out.println("1 - 10: View a specific quote");
                System.out.println("0: View a random quote");
                System.out.println("Any other input: Exit");
                System.out.print("Your choice: ");

                String input = scanner.nextLine();

                try {
                    int choice = Integer.parseInt(input);

                    if (choice == 0) {
                        int randomIndex = random.nextInt(quotes.length);
                        System.out.println("\nRandom Quote:\n" + quotes[randomIndex]);
                    } else if (choice >= 1 && choice <= 10) {
                        System.out.println("\nSelected Quote:\n" + quotes[choice - 1]);
                    } else {
                        System.out.println("Invalid number. Please choose between 1 and 10, or 0 for random.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("That's not a number! Please enter a valid number.");
                }

                System.out.print("\nWould you like to see another quote? (yes/no): ");
                String again = scanner.nextLine().trim().toLowerCase();
                if (!again.equals("yes")) {
                    keepRunning = false;
                    System.out.println("Goodbye!");
                }
            }

            scanner.close();
        }
    }




























