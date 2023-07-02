import java.util.HashMap;

public class Pascal_Triangle_Memoization {
    public static void main(String[] args){
        int n =5;
        HashMap<String,Integer> cache_map = new HashMap<>();
        for(int row =0; row<n;row++){
            for(int column=0;column<=row;column++){
                if(cache_map.containsKey((String.format("%s%s",row,column)))){
                    System.out.print(cache_map.get((String.format("%s%s",row,column))));
                }else{
                    cache_map.put(String.format("%s%s",row,column),PascalTriangle(row,column));
                    System.out.print(cache_map.get((String.format("%s%s",row,column))));
                }
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
