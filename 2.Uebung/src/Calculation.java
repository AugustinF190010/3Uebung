import java.util.Scanner;

public class Calculation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RationalCalculator rational = new RationalCalculator((a, b) -> new Number(a.getA()+b.getA(),a.getB()+b.getB()),
                                                             (a, b) -> new Number(a.getA()-b.getA(),a.getB()-b.getB()),
                                                             (a, b) -> new Number(a.getA()*b.getA(),a.getB()*b.getB()),
                                                             (a, b) -> new Number(a.getA()/b.getA(),a.getB()/b.getB()));

        VectorCalculator vector = new VectorCalculator((a, b) -> new Number(a.getA()+b.getA(),a.getB()+b.getB()),
                                                       (a, b) -> new Number(a.getA()-b.getA(),a.getB()-b.getB()),
                                                       (a, b) -> new Number(a.getA()*b.getB(),a.getB()*b.getA()),
                                                       (a, b) -> new Number(a.getA()*a.getB(),b.getB()*b.getA()));
        ComplexCalculator complex = new ComplexCalculator((a, b) -> new Number(a.getA()+b.getA(),a.getB()+b.getB()),
                                                          (a, b) -> new Number(a.getA()-b.getA(),a.getB()-b.getB()),
                (a,b)-> new Number(a.getA() * b.getA() - a.getB() * b.getB(),a.getA() * b.getB() - a.getB() * b.getA()),
                (a,b) -> new Number((a.getA() * b.getA() + a.getB() * b.getB()) / (Math.pow(b.getA(), 2) + Math.pow(b.getB(), 2)),(a.getB() * b.getA() - a.getA() * b.getB()) / (Math.pow(b.getA(), 2) + Math.pow(b.getB(), 2))));

        int eingabe = -0;
        int eingabeRechnung = -0;
        System.out.println("Bitte geben sie die erste Nummer für alle Rechner ein");
        Number number1 = new Number(Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
        System.out.println("Bitte geben sie die zweite Nummer für alle Rechner ein ein");
        Number number2 = new Number(Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
        Number [] arr = new Number[2];
        Number numberRationalA = number1;
        Number numberRationalB = number2;
        Number numberVectorA = number1;
        Number numberVectorB = number2;
        Number numberComplexA = number1;
        Number numberComplexB = number2;

        boolean b = true;
        while (b){
           calculatorMenu();
           eingabe = Integer.parseInt(sc.nextLine());
            if(eingabe!=4){
                operationMenu();

                eingabeRechnung = Integer.parseInt(sc.nextLine());
            }

           switch(eingabe){
               case 1:
                   arr = choose(rational,  eingabeRechnung, numberRationalA, numberRationalB);
                   numberRationalA = arr[0];
                   numberRationalB = arr[1];
               break;

               case 2:
                   arr = choose(vector,  eingabeRechnung, numberVectorA, numberVectorB);
                   numberVectorA = arr[0];
                   numberVectorB = arr[1];
               break;

               case 3:
                  arr = choose(complex,eingabeRechnung,numberComplexA,numberComplexB);
                   numberComplexA = arr[0];
                   numberComplexB = arr[1];
               break;

               case 4:
                   System.out.println("Auf Wiedersehen!");
                   b = false;
               break;

               default:
                   System.out.println("Bitte zahl zwischen 1 und 4 eingeben");
                   break;
           }


        }
    }










    public static void calculatorMenu(){
        System.out.println("1   Relational calculator");
        System.out.println("2   Vector calulator");
        System.out.println("3   Complex calculator");
        System.out.println("4   Exit program");
    }

    public static void operationMenu(){
        System.out.println("1   add");
        System.out.println("2   subtract");
        System.out.println("3   multiply");
        System.out.println("4   divide");
        System.out.println("5   enter numbers again");
     }

     public static Number[] choose(AbstractCalculator calculator, int eingabe,Number n1, Number n2){
        Number[] arr = new Number[2];
        Number m;
        switch(eingabe){
            case 1:
                  m= calculator.add.calc(n1, n2);
                ausgabe(calculator,m);
                break;

            case 2:
                m=calculator.subtract.calc(n1, n2);
                ausgabe(calculator,m);
                break;

            case 3:
                m = calculator.multiply.calc(n1, n2);
                ausgabe(calculator,m);
                break;

            case 4:
                m  = calculator.divide.calc(n1, n2);
               ausgabe(calculator,m);
                break;

            case 5:

                if(calculator instanceof RationalCalculator){
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Bitte geben sie die erste Nummer ein");
                    n1 = new Number(Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
                    System.out.println("Bitte geben sie die zweite Nummer ein");
                    n2 = new Number(Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
                }else if(calculator instanceof ComplexCalculator){
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Bitte geben sie die erste Nummer ein:");
                    System.out.println("Rationale Zahl:");
                    int rationalA = Integer.parseInt(sc.nextLine());
                    System.out.println("Complex Zahl:");
                    int complexA = Integer.parseInt(sc.nextLine());
                    n1 = new Number(rationalA, complexA);
                    System.out.println("Bitte geben sie die zweite Nummer ein");

                    System.out.println("Rationale Zahl:");
                    int rationalB = Integer.parseInt(sc.nextLine());
                    System.out.println("Complex Zahl:");
                    int complexB = Integer.parseInt(sc.nextLine());
                    n2 = new Number(rationalB, complexB);
                }else{
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Bitte geben sie die erste Nummer ein:");
                    System.out.println("X:");
                    int rationalA = Integer.parseInt(sc.nextLine());
                    System.out.println("Y:");
                    int complexA = Integer.parseInt(sc.nextLine());
                    n1 = new Number(rationalA, complexA);
                    System.out.println("Bitte geben sie die zweite Nummer ein");

                    System.out.println("X:");
                    int rationalB = Integer.parseInt(sc.nextLine());
                    System.out.println("Y:");
                    int complexB = Integer.parseInt(sc.nextLine());
                    n2 = new Number(rationalB, complexB);
                }
                break;

            default:
                System.out.println("Bitte zahl zwischen 1 und 4 eingeben");
                break;


        }
         arr[0] = n1;
         arr[1] = n2;

        return arr;
     }

     public static void ausgabe(AbstractCalculator calculator, Number m){
        if(calculator instanceof RationalCalculator){
            System.out.println("a: " +m.getA());
            System.out.println("b: " +m.getB());
        }else if(calculator instanceof VectorCalculator){
            System.out.println("["+m.getA()+"|"+m.getB()+"]");
        }else {
            System.out.println("Rational: " +m.getA());
            System.out.println("Complex: " +m.getB()+"i");
        }
     }

}
