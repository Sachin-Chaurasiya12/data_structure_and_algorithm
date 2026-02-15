package algorithm;

import java.util.Arrays;

public class sorting {
    public void bubblesort(int[]A){
        for(int i=A.length-1;i>=1;i--){
            for(int j=0;j<i;j++){
                if(A[j] > A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;

                }
            }
        }
    }
    public void selectionsort(int[]A){
        for(int i=0;i<A.length - 1;i++){
            int min = i;
            for(int j=i + 1;j<A.length - 1;j++){
                if(A[j] < A[min]){
                    min = j;
                }
            }
            int temp = A[min];
            A[min] = A[i];
            A[i] = temp;
        }
    }
    public void insertionsort(int[]A){
        int i,j,k;
        for(i=1;i<A.length-1;i++){
            k = A[i];
            j = i;
            while(j >=1 && A[j-1] > k){
                A[j] = A[j-1];
                j--;
            }
            A[j] = k;
        }
    }
    public void mergesort(int[]A){
        if(A.length <= 1){
            return;
        }
        int mid = A.length/2;
        int[] left = new int[mid];
        int[] right = new int[A.length - mid];
        for(int i=0;i<mid;i++){
            left[i] = A[i];
        }
        for(int i=mid;i<A.length;i++){
            right[i - mid] = A[i];
        }
        mergesort(left);
        mergesort(right);

        merge(A, left, right);
    }
    public void merge(int[]A,int[] left,int[] right){
        int i=0,j=0,k=0;
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                A[k++] = left[i++];
            }else{
                A[k++] = right[j++];
            }
        }
        while(i < left.length){
            A[k++] = left[i++];
        }
        while(j < right.length){
            A[k++] = right[j++];
        }
    }
    public static void main(String[] args) {
        sorting s = new sorting();
        int[]A = {1,3,2,4,6,5,9,8,7,10};
        System.out.println(Arrays.toString(A));
        // s.bubblesort(A);
        // s.selectionsort(A);
        // s.insertionsort(A);
        s.mergesort(A);
        System.out.println(Arrays.toString(A));  
    }
}
