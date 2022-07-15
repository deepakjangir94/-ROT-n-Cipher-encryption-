import java.io.*;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {
        
        public static char encryption(char c, int n) {
                int x = 0;
                char y = 'A';

                if (0 <= (c - 'a') && (c - 'a') <= 25) {
                        x = c - 'a';
                        x = (x + n) % 26;
                        x = 65 + x;
                        y = (char) x;
                } else if (0 <= (c - 'A') && (c - 'A') <= 25) {
                        x = c - 'A';
                        x = (x + n) % 26;
                        x = 65 + x;
                        y = (char) x;
                } else {
                        y = c;
                }
                return y;
        }

        public static void main(String[] args) {

                String location = "G:\\Encryption assignment\\";

                boolean runon = true;
                while (runon) {

                        String inputValue = JOptionPane.showInputDialog(null,
                                        "Welcome to the ROT-n Cipher! \n" +
                                                        "This program will encrypt any given plain text into a cipher text using the ROT-n cipher. \n"
                                                        +
                                                        "How would you like to input the plain text? \n" +
                                                        "Enter the number of your selection\n" +
                                                        "\n1: Entar plain text manually \n" +
                                                        "2: plain text from file",
                                        "ROT-n Cipher",
                                        3);

                        switch(inputValue){
                                case "1":
                                        String message = JOptionPane.showInputDialog(null,
                                                        "Enter the plain text:",
                                                        "ROT-n Cipher",
                                                        1);
                                        // System.out.println(message);

                                        String num1 = JOptionPane.showInputDialog(null,
                                                        "Enter a value for n from 1 to 25:",
                                                        "ROT-n Cipher",
                                                        1);
                                        // System.out.println(num1);
                                        int number1 = Integer.parseInt(num1);
                                        // System.out.println(number1);

                                        String encryptedMessage1 = "";
                                        for (int i = 0; i < message.length(); i++) {
                                                encryptedMessage1 = encryptedMessage1
                                                                + encryption(message.charAt(i), number1);
                                        }
                                        // System.out.println(encryptedMessage1);

                                        JOptionPane.showMessageDialog(
                                                        null,
                                                        "Encrypted " + message.length() + " characters.",
                                                        "ROT-n Cipher",
                                                        JOptionPane.PLAIN_MESSAGE);

                                        String outputType1 = JOptionPane.showInputDialog(null,
                                                        "How would you like to output the cipher text? \n" +
                                                                        "Enter the number of your selection. \n" +
                                                                        "1: Output cipher text to screen. \n" +
                                                                        "2: Output cipher text to a file\n",
                                                        "ROT-n Cipher",
                                                        3);

                                        JOptionPane.showMessageDialog(
                                                        null,
                                                        encryptedMessage1,
                                                        "ROT-n Cipher",
                                                        JOptionPane.PLAIN_MESSAGE);

                                        String repeat1 = JOptionPane.showInputDialog(null,
                                                        "Encrypt another plain text? (yes or no) \n",
                                                        "ROT-n Cipher",
                                                        3);
                                        // System.out.println(repeat1);
                                        if (repeat1.equals("no")) {
                                                runon = false;
                                        }
                                break;

                                case "2":
                                        String fileName = JOptionPane.showInputDialog(null,
                                                        "Enter the file name:",
                                                        "ROT-n Cipher",
                                                        1);
                                        // System.out.println(fileName);

                                        String num2 = JOptionPane.showInputDialog(null,
                                                        "Enter a value for n from 1 to 25:",
                                                        "ROT-n Cipher",
                                                        1);
                                        // System.out.println(num2);
                                        int number2 = Integer.parseInt(num2);
                                        // System.out.println(number2);
                                        int count = 0;

                                        try {
                                                BufferedReader br = new BufferedReader(
                                                                new FileReader(location + fileName));
                                                BufferedWriter bw = new BufferedWriter(
                                                                new FileWriter(location + "output.txt"));
                                                String s;
                                                while (((s = br.readLine()) != null)) {
                                                        //System.out.println(s);
                                                        String encryptedMessage2 = "";
                                                        count = count + s.length();
                                                        for (int i = 0; i < s.length(); i++) {
                                                                encryptedMessage2 = encryptedMessage2
                                                                                + encryption(s.charAt(i), number2);
                                                        }
                                                        // System.out.println(encryptedMessage2);
                                                        bw.write(encryptedMessage2 + "\n");
                                                }
                                                br.close();
                                                bw.close();
                                        } catch (IOException e) {
                                                e.printStackTrace(); // prints exception if any
                                        }

                                        JOptionPane.showMessageDialog(
                                                        null,
                                                        "Encrypted " + count + " characters.",
                                                        "ROT-n Cipher",
                                                        JOptionPane.PLAIN_MESSAGE);

                                        String outputType2 = JOptionPane.showInputDialog(null,
                                                        "How would you like to output the cipher text? \n" +
                                                                        "Enter the number of your selection. \n" +
                                                                        "1: Output cipher text to screen. \n" +
                                                                        "2: Output cipher text to a file\n",
                                                        "ROT-n Cipher",
                                                        3);

                                        String outputFile = JOptionPane.showInputDialog(null,
                                                        "Enter the output file name:",
                                                        "ROT-n Cipher",
                                                        3);
                                        // System.out.println(outputFile);

                                        File file = new File(
                                                        location + "output.txt");
                                        File rename = new File(
                                                        location + outputFile);
                                        boolean flag = file.renameTo(rename);

                                        if (flag == true) {
                                                // System.out.println("File Successfully Rename");
                                        } else {
                                                // System.out.println("Operation Failed");
                                        }

                                        String repeat2 = JOptionPane.showInputDialog(null,
                                                        "Encrypt another plain text? (yes or no) \n",
                                                        "ROT-n Cipher",
                                                        3);
                                        // System.out.println(repeat2);
                                        if (repeat2.equals("no")) {
                                                runon = false;
                                        }
                                break;

                                default:
                                        // System.out.println("It doesnot work");        
                                break;
                        }

                }
        }
}