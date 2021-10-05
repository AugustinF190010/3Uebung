import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NumberTester {
    NumberTest palindromeTester;
    NumberTest primeTester;
    NumberTest oddTester;
    BufferedReader reader;
    public NumberTester(String fileName){
        try {
            FileReader fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setOddEvenTester(NumberTest oddTester){
        this.oddTester = oddTester;
    }

    public void setPrimeTester (NumberTest primeTester){
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester){
         this.palindromeTester = palindromeTester;
    }

    public void testFile(){
        setOddEvenTester((int i) -> i%2==0);
        setPrimeTester((int j) -> isPrime(j));
        setPalindromeTester((int l) -> isPalindrom(l));


        try {
            int n = Integer.valueOf(reader.readLine());
            for (int i = 0; i <n;i++){
                String st = reader.readLine();
                String [] arr = st.split(" ");
                switch (Integer.valueOf(arr[0])){
                    case 1:
                        System.out.println(oddTester.testNumber(Integer.valueOf(arr[1])) ? "EVEN" : "ODD");

                        break;

                    case 2:
                        System.out.println(primeTester.testNumber(Integer.valueOf(arr[1])) ? "PRIME" : "NO PRIME");
                        break;

                    case 3:
                        System.out.println(palindromeTester.testNumber(Integer.valueOf(arr[1]))? "PALINDROME" : "NO PALINDROME");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       NumberTester tester = new NumberTester("zahlen.txt");
       tester.testFile();


    }

    public boolean isPrime(int pPrime){
        for (int i = 2; i<pPrime;i++){
            if(pPrime%i == 0){
                return false;

            }
        }
        return true;
    }

    public boolean isPalindrom(int pPalindrom){
        String palindrom = String.valueOf(pPalindrom);
        char[] liste= palindrom.toCharArray();


        for (int i = 0; i<liste.length;i++){
            if(liste[i]!=liste[(liste.length-1)-i]){
                return false;
            }
        }

        return true;
    }



}
