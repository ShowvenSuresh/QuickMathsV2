
package quickmathv2;

public class Rankings {
    private String name;
    private String level;
    private String timeTaken;
    private String score;
    
    public Rankings (String name,String level,String timeTaken,String score){
        setName(name);
        setLevel(level);
        setTimeTaken(timeTaken);
        setScore(score);
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setLevel(String level){
        this.level=level;
    }
    
    public String getLevel(){
        return level;
    }
    
    public void setTimeTaken(String timeTaken){
        this.timeTaken=timeTaken;
    }
    
    public String getTimeTaken(){
        return timeTaken;
    }
    
    public void setScore(String score){
        this.score=score;
    }
    
    public String getScore(){
        return score;
    }
}
