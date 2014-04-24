import java.util.Random;
public class Array {
    public int [][] arrays;
    public final int n=11;
    public Array(int min, int step){
        arrays=new int[n][];
        int c=0;
        for(int i=min; i<min+step*n; i=i+step){
            arrays[c]=new int[i];
            ++c;
        }
    }
    public void fillRandom(){
        Random r=new Random();
        for(int i=0;i<n;i++){
            for(int j=0;j<arrays[i].length;j++){
                arrays[i][j]=r.nextInt();
            }
        }
    }
    public void fillInc(){
        for(int i=0;i<n;i++){
            for(int j=0;j<arrays[i].length;j++){
                arrays[i][j]=j;
            }
        }
    }
    public void fillDec(){
        for(int i=0;i<n;i++){
            for(int j=0;j<arrays[i].length;j++){
                arrays[i][j]=arrays[i].length-j;
            }
        }
    }
}