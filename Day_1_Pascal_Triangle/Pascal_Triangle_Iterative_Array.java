public class Pascal_Triangle_Iterative_Array {
    public static void main(String[] args){
        int n =10;
        int[] arr = new int[n];
        int[] arrUpdate = new int[n];
        for(int row= 0; row< n ; row++){
            for( int column =0; column <= row; column++){
                if((column==0) || (column==row)){
                    arrUpdate[column]=1;
                }else{
                    arrUpdate[column]=arr[column-1] + arr[column];
                }
                System.out.print(arrUpdate[column]);
            }
            arr=arrUpdate.clone();
            System.out.println();
        }
    }

}
