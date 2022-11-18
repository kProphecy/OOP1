package cs.vsu.ru.ismagilova;

import java.util.Random;

public class Main {


    public static void main(String[] args) {
        Table table = new Table();
        table.insertValue(5, 5,"5");
        table.insertValue(3, 5,"1");
        table.insertValue(1, 2,"10");
        table.insertValue(1, 3,"0");
        table.printTable();
        System.out.println("-------------------------\n");
        table.printValue(5, 5);
        table.printValue(5, 4);
        table.printValue(3, 5);
        System.out.println("-------------------------\n");
        table.printRow(1);

        System.out.println("-------------------------\n");

        Table tt = new Table();

        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 4; j++){
                tt.insertValue(i,j, String.valueOf(new Random().nextInt(1, 40)));
            }
        }
        tt.printTable();

        System.out.println("-------------------------\n");

        tt.printRow(5);

    }
}