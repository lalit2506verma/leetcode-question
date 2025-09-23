import problems.ImplementationClasses.FoodRatings;
import problems.ImplementationClasses.Spreadsheet;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Spreadsheet st = new Spreadsheet(3);

        System.out.println(st.getValue("=5+7"));
        st.setCell("A1", 10);
        System.out.println(st.getValue("=A1+6"));
        st.setCell("B2", 15);
        System.out.println(st.getValue("=A1+B2"));
        st.resetCell("A1");
        System.out.println(st.getValue("=A1+B2"));

    }
}
