public class Pascal_Triangle_Recursive1 {
    public static void main(String[] args){
        int n =5;
        for(int row =0; row<n;row++){
            for(int column=0;column<=row;column++){
                System.out.print(PascalTriangle(row,column));
            }
            System.out.println();
        }
    }
    public static int PascalTriangle(int row,int column){
        if((column==0) || (column==row) || row ==0){
            return 1;
        }
        return PascalTriangle(row-1,column)+PascalTriangle(row-1,column-1);
    }
}
