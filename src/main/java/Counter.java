/**
 * Created by supervisor on 08.09.2016.
 */
public class Counter {
    private String size_err = "Wrong array size!";
    private String no_elem = "No element in array!";

    public int countElem(int value, int[] array)
    {
        int count=0;
        if (array.length <= 0) {System.out.print(size_err);}
        boolean check = isValue(array, value);
        if (check == true)
        {
            for (int i=0; i<array.length; i++)
            {
                if (array[i] == value) {
                    count++;
                }
            }
        }
        if (check == false) {System.out.print(no_elem);}
        return count;
    }

    public static boolean isValue(int[] arr, int value)
    {
        boolean isValueInArray=false;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == value) {
                isValueInArray = true;
            }
        }
        return isValueInArray;
    }

    public static int[] getInts(int[] arr, int value, int count) {
        int[] arrElemIndex = new int[count];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                arrElemIndex[k] = i;
                k++;
            }
        }
        return arrElemIndex;
    }
}
