package test;

public class test1 {
    public int find_max(int[] array, int start, int end){
        if (start == end)return array[start];
        if (start+1 == end)return Math.max(array[start],array[end]);
        int mid = (start+end) >> 1;
        int mid1 = mid;
        int mid2 = mid;
        while (mid1>start&&array[mid1]==array[mid1-1]){
            mid1--;
            if (mid1 == start){
                return find_max(array, mid, end);
            }
        }
        while (mid2<end&&array[mid2]==array[mid2+1]){
            mid2++;
            if (mid2 == end){
                return find_max(array, start, mid);
            }
        }
        if (array[mid2] > array[mid2+1]&&array[mid1]> array[mid-1]){
            return array[mid];
        }else if(array[mid2] > array[mid2+1]){
            return find_max(array, start, mid1);
        }else if(array[mid1]> array[mid1-1]){
            return find_max(array, mid2, end);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array1 = new  int[]{1,1,1,1,1,1,1,2,2,1};
        test1 t = new test1();
        System.out.println(t.find_max(array1,0, array1.length-1));
    }
}
