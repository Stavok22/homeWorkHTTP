package homeworkhttp;


import java.util.Scanner;

public class HttpImageStatusCli {


    public void askStatus() throws Exception{
        System.out.println("Please enter HTTP status code");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
        String code = scanner.next();

        if (code.matches("[^\\d]+")) {
            System.out.println("Please enter correct number");
            System.out.println("Please enter HTTP status code");
            continue;
        }

        new HttpStatusImageDownloader().downloadStatusImage(Integer.parseInt(code));

            System.out.println("Do you want to upload more images? (yes or no)");
            boolean isCorrectAnswer = false;
            while (!isCorrectAnswer) {
                String answer = scanner.next();
                if (answer.equalsIgnoreCase("yes")) {
                    System.out.println("Please, enter HTTP status code");
                    isCorrectAnswer = true;
                } else if (answer.equalsIgnoreCase("no")) {
                    return;
                } else {
                    System.out.println("Please, enter correct answer.");
                }
            }

        }
        scanner.close();
    }
}

