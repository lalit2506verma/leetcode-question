package problems.ImplementationClasses;

import java.util.HashMap;

public class Spreadsheet {
    HashMap<String, Integer> map;

    public Spreadsheet(int rows) {
        map = new HashMap<>();

//        // setting values as default 0
//        for(char i = 'A'; i <= 'Z'; i++){
//
//            for(int j = 1; j <= rows; j++){
//                String key = i + String.valueOf(j);
//                map.put(key, 0);
//            }
//        }
    }

    public void setCell(String cell, int value) {
        map.put(cell, value);
    }

    public void resetCell(String cell) {
        map.remove(cell);
    }

    public int getValue(String formula) {
        String[] operand = formula.substring(1).split("\\+");

        // check whether operand are cell reference or value
        int a = Character.isDigit(operand[0].charAt(0)) ? Integer.parseInt(operand[0]) : map.getOrDefault(operand[0], 0);
        int b = Character.isDigit(operand[1].charAt(0)) ? Integer.parseInt(operand[1]) : map.getOrDefault(operand[1], 0);

        return a + b;
    }
}
