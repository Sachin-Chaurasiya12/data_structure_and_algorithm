package algorithm;

public class searching {
    public boolean linearsearch(int[] arr,int val){
        int i=0;
        for(i=0;i<arr.length;i++){
            if(arr[i] == val){
                return true;
            }
        }
        return false;
    }
    public int binarysearch(int[]arr,int val){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(arr[mid] == val){
                return mid;
            }else if(arr[mid] < val){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        searching s = new searching();
        int[] arr = {1,3,2,6,4,5,9,8,7,10};
        int val = 5;
        int search = s.binarysearch(arr, val);
        System.out.println(search);
    }
}
