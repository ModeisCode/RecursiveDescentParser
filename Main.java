public class Main {
    public static void main(String[] args) {
        String a="(sum+47)/total";
        RecurdiveDescentParser parser1 = new RecurdiveDescentParser("(sum+47)/total");
        System.out.println("Tokens of the expression: " + a);
        parser1.rdParser();
        System.out.println();

        String b = ("a*2//(b+3)+c+2d");
        RecurdiveDescentParser parser2 = new RecurdiveDescentParser("a*2//(b+3)+c+2d");
        System.out.println("Tokens of the expression: " + b);
        parser2.rdParser();


    }
}