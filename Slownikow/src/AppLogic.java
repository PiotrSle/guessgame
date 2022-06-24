import java.util.Scanner;

public class AppLogic {
    Scanner input = new Scanner(System.in);
    private static int GAMES_TO_PLAY = 5;

    public void printLine(String text) {
        System.out.println(text);
    }

    public  void compareWords() {
        for (int i = 0; i < 5; i++) {
            String gamerWord;
            do {
                    System.out.println("Podaj swoje słowo: ");
                    gamerWord = input.nextLine().toUpperCase();
                 if((gamerWord.length() != Word.WORD_TO_GUESS.length())){
                    System.out.println("Podaj słowo składające się z PIĘCIU liter!!!");
                }
            }while (gamerWord.length() != Word.WORD_TO_GUESS.length());

            if (gamerWord.equals(Word.WORD_TO_GUESS)) {
                System.out.println("Trafiłeś słowo: " + gamerWord + " - Wygrałeś talon!");
                System.out.println("!!!Koniec gry!!!");
                break;
            } else if (GAMES_TO_PLAY > 0) {
                System.out.println("Twoje słowo to: " + gamerWord);
                compareCharacters(gamerWord);
                System.out.println("Postaraj się bardziej, zostało Ci już tylko " + --GAMES_TO_PLAY + " " + "gier!");
                takeTheHint(gamerWord);
                finishThatGame();
            }
        }input.close();
    }

    public void helloStranger() {
        printLine("Aby rozpoczą grę podaj swoje imię i wciśnij ENTER: ");
        String gamerName = input.nextLine();
        printLine("Cześć " + gamerName + "!");
        printLine("Słowo składa się z 5 liter. Masz 5 szans na odgadnięcie. Jeśli chcesz, dla ułatwienia, " +
                "możesz zapisywać swoje słowa na kartce, tak by wiedzieć jakie literki już wykorzystałeś. Przygotuj się i zaczynamy!");
    }

    private void finishThatGame() {
        if (GAMES_TO_PLAY == 0) {
            System.out.println("Niestety nie udało Ci się odgadnąć! - Przegrałeś - gra skończona!");
        }
    }

    private void takeTheHint (String gamerWord) {
            if (GAMES_TO_PLAY == 2 && (!gamerWord.equals(Word.WORD_TO_GUESS))) {
                String option;
                do {
                    printLine("Czy potrzebujesz podpowiedzi? Pamiętaj zostały Ci już tylko: " + GAMES_TO_PLAY + " próby");
                    printLine("Wpisz: TAK/NIE");
                    option = input.nextLine().toUpperCase();

                    switch (option) {
                        case "TAK":
                            printLine("Wybrałeś grę z pomocą, oto Twoja podpowiedź: " + Word.HINT);
                            break;
                        case "NIE":
                            printLine("Wybrałeś grę bez pomocy! :) ");
                            break;
                        default:
                            printLine("Wybrana opcja nie istnieje - spróbuj ponownie!");
                            break;
                    }
                } while (!(option.equals("TAK") || option.equals("NIE")));
            }
        }

        private void compareCharacters (String gamerWord){
                        String[] split = gamerWord.split("");
                        String[] wordToGuess = Word.WORD_TO_GUESS.split("");
                        if (split[0].equals(wordToGuess[0])) {
                            printLine("Trafiłeś pierwszą literkę: " + split[0]);
                        } else if (split[0].equals(wordToGuess[1]) || split[0].equals(wordToGuess[2]) || split[0].equals(wordToGuess[3])
                                || split[0].equals(wordToGuess[4])) {
                            printLine("Trafiłeś literkę, ale nie jej położenie: " + split[0]);
                        } else
                            printLine("Nie trafiłeś pierwszej literki");

                        if (split[1].equals(wordToGuess[1])) {
                            printLine("Trafiłeś drugą literę: " + split[1]);
                        } else if (split[1].equals(wordToGuess[0]) || split[1].equals(wordToGuess[2]) || split[1].equals(wordToGuess[3])
                                || split[1].equals(wordToGuess[4])) {
                            printLine("Trafiłeś literkę, ale nie jej położenie: " + split[1]);
                        } else
                            printLine("Niestety, nie trafiłeś drugiej litery");

                        if (split[2].equals(wordToGuess[2])) {
                            printLine("Trafiłeś trzecią literę: " + split[2]);
                        } else if (split[2].equals(wordToGuess[0]) || split[2].equals(wordToGuess[1]) || split[2].equals(wordToGuess[3])
                                || split[2].equals(wordToGuess[4])) {
                            printLine("Trafiłeś literkę, ale nie jej położenie: " + split[2]);
                        } else
                            printLine("Niestety, nie trafiłeś trzeciej litery");

                        if (split[3].equals(wordToGuess[3])) {
                            printLine("Trafiłeś czwartą literę: " + split[3]);
                        } else if (split[3].equals(wordToGuess[0]) || split[3].equals(wordToGuess[2]) || split[3].equals(wordToGuess[1])
                                || split[3].equals(wordToGuess[4])) {
                            printLine("Trafiłeś literkę, ale nie jej położenie: " + split[3]);
                        } else
                            printLine("Niestety, nie trafiłeś czwartej litery");

                        if (split[4].equals(wordToGuess[4])) {
                            printLine("Trafiłeś piątą literę: " + split[4]);
                        } else if (split[4].equals(wordToGuess[0]) || split[4].equals(wordToGuess[2]) || split[4].equals(wordToGuess[3])
                                || split[4].equals(wordToGuess[1])) {
                            printLine("Trafiłeś literkę, ale nie jej położenie: " + split[4]);
                        } else
                            printLine("Niestety, nie trafiłeś piątej litery");
                    }

                }


