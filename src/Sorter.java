public class Sorter {
    public int shell(int [] array){
        int gap = array.length/2;
        long time = System.currentTimeMillis();   
        while (gap>0){
            for (int i = 0; i < (array.length - gap); i++){    
                int j=i;
                while (j >= 0 && array[j] < array[j + gap]){
                    //пока не пришли к началу массива
                    //и пока рассматриваемый элемент больше
                    //чем элемент находящийся на расстоянии шага
                        swap(array,j,j+gap); //меняем их местами
                        j-=gap; // было i--
                    }
                }
                gap = gap / 2;//уменьшаем шаг
            }
        time=System.currentTimeMillis()-time;
        return (int) (long) time;
    }
    public void swap(int array[], int i, int j){
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public int shaker(int [] array){
    int Left, Right; //границы сортировки
    Left = 0;
    Right = array.length -1;
    long time = System.currentTimeMillis();
    do
    {
        //Сдвигаем к началу массива "легкие элементы"
        for (int i = Right; i > Left; i--){ //было >= перед Left
            if (array[i -1]>array[i])
                swap(array, i, i-1);
        }
        Left++;
        //Сдвигаем к концу массива "тяжелые элементы"
        for (int i = Left; i <= Right; i++){
            if (array[i - 1] > array[i])
                swap(array, i, i-1);
        }
        Right--;
    }
    while (Left <= Right);
    time=System.currentTimeMillis()-time;
    return (int) (long) time;
    }
}
