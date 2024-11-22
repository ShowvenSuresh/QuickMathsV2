
package quickmathv2;
import java.util.List;
import java.util.ArrayList;

public class Sorting {
    public void sort(List<Rankings> rank){
        if(rank.size()<2){
            return;
        }
        
        int arrLength = rank.size();
        int mid = arrLength/2;
        List <Rankings> left = new ArrayList<>(rank.subList(0,mid));
        List <Rankings> right = new ArrayList<>(rank.subList(mid,rank.size()));
        
      
        sort(left);
        sort(right);
        merge(rank,left,right);
        
        
    }
    
    public void merge(List<Rankings> rank,List<Rankings> left, List<Rankings> right ){
        int i=0,j=0,k=0;
        
        while(i<left.size()&&j<right.size()){
            if(left.get(i).getScore()>right.get(j).getScore()){
                rank.set(k, left.get(i));
                i++;
            }
            else{
                rank.set(k,right.get(j));
                 j++;
            }
            k++;
        }
        
        while (i<left.size()){
            rank.set(k, left.get(i));
            i++;
            k++;
        }
        
        while(j<right.size()){
            rank.set(k, right.get(j));
            j++;
            k++;
        }
        
    }
    
    public void nameSort(List<Rankings> rank){
        if(rank.size()<2){
            return;
        }
        
        int arrLength = rank.size();
        int mid = arrLength/2;
        List <Rankings> left = new ArrayList<>(rank.subList(0,mid));
        List <Rankings> right = new ArrayList<>(rank.subList(mid,rank.size()));
        
      
        nameSort(left);
        nameSort(right);
        nameMerge(rank,left,right);
        
        
    }
    
    public void nameMerge(List<Rankings> rank,List<Rankings> left, List<Rankings> right ){
        int i=0,j=0,k=0;
        
        while(i<left.size()&&j<right.size()){
            if(left.get(i).getName().compareTo(right.get(j).getName())<0){
                rank.set(k, left.get(i));
                i++;
            }
            else{
                rank.set(k,right.get(j));
                 j++;
            }
            k++;
        }
        
        while (i<left.size()){
            rank.set(k, left.get(i));
            i++;
            k++;
        }
        
        while(j<right.size()){
            rank.set(k, right.get(j));
            j++;
            k++;
        }
        
    }
    
    
}
