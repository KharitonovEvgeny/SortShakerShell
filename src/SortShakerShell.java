import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Kharitonov Evgeny
 */
public class SortShakerShell {

    public static void main(String[] args) {
        String [][] result;
        int min = 10000;
        int step = 1000;
        Array data = new Array(min,step);
        result=new String[data.n+1][8];
        Sorter r=new Sorter();
        result[0][0]="size";
        result[0][1]="inc";
        result[0][2]="dec";
        result[0][3]="random";
        for (int i = 0;i<data.n;i++)
            result[i+1][0] = Integer.toString(data.arrays[i].length);
        data.fillInc();
        for (int i = 0;i<data.n;i++)
            result[i+1][1] = Integer.toString(r.shell(data.arrays[i]));
        data.fillDec();
        for (int i = 0;i<data.n;i++)
            result[i+1][2] = Integer.toString(r.shell(data.arrays[i]));
        data.fillRandom();
        for (int i = 0;i<data.n;i++)
            result[i+1][3] = Integer.toString(r.shell(data.arrays[i]));
        result[0][4]="size";
        result[0][5]="inc";
        result[0][6]="dec";
        result[0][7]="random";
        for (int i = 0;i<data.n;i++)
            result[i+1][4] = Integer.toString(data.arrays[i].length);
        data.fillInc();
        for (int i = 0;i<data.n;i++)
            result[i+1][5] = Integer.toString(r.shaker(data.arrays[i]));
        data.fillDec();
        for (int i = 0;i<data.n;i++)
            result[i+1][6] = Integer.toString(r.shaker(data.arrays[i]));
        data.fillRandom();
        for (int i = 0;i<data.n;i++)
            result[i+1][7] = Integer.toString(r.shaker(data.arrays[i]));
        writeToFile(result);
    }
    public static void writeToFile(String[][] a){
        BufferedWriter br=null;
        try {
            String path = System.getProperty("user.dir")+"/output.csv";
            br = new BufferedWriter(new FileWriter(path));
            for (String[] array: a){
                StringBuilder sb=new StringBuilder();
                for(String elem: array){
                    sb.append(elem);
                    sb.append(";");
                }
                sb.append("\n");
                br.write(sb.toString());
            }
            br.close();
            System.out.println(path);
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
