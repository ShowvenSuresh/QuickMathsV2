
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
            JOptionPane.showMessageDialog(null,"System Updated","Done",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"An Error has Occured ","Error",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public ArrayList<Rankings> readRankings (String sql){
        ArrayList<Rankings> rank = new ArrayList<>();
        
        
        return rank;
    }
    
    
}
