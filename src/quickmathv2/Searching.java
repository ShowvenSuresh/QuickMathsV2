
package quickmathv2;
import java.util.List;

public class Searching {
    public int searchName(List<Rankings> rank, String target){
        int low=0, high=rank.size();
        
          while (low<=high)
        {
            int mid = (low+high)/2;
            
           int cmp= rank.get(mid).getName().compareTo(target);
           System.out.println(mid+" "+low+" "+high+" "+cmp);
           
           if (cmp==0){
               return mid;
           }
           
           else if (cmp>0){
               low = mid +1;
           }
           
           else if (cmp<0){
               high = mid-1;
           }
            
        }
        
        return -1;
    }
}
