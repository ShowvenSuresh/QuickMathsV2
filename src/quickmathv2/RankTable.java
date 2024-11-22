
package quickmathv2;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class RankTable extends DataBaseManager{
    public RankTable(){
        super.dbConnect();
    }
    
    public void addRanking(String sql){
        try{
            Statement s= connectDB.createStatement();
            int add = s.executeUpdate(sql);
            System.out.println("System Updated");
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"An Error has Occured ","Error",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public ArrayList<Rankings> readRankings (String sql){
        ArrayList<Rankings> rank = new ArrayList<>();
        try{
            Statement s = connectDB.createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()){
                //iterate through the result set and add it to  the array list
                Rankings r = new Rankings(rs.getString("u_name"),rs.getString("lvl"),rs.getInt("score"),rs.getString("timetaken"));
                rank.add(r);
            }
            
            
        }catch(SQLException e){
            e.printStackTrace();
            
        }
        
        //sort the list
        Sorting sort =new Sorting();
        //sort.nameSort(rank);
        sort.sort(rank);
        
        return rank;
    }
    
    
}
