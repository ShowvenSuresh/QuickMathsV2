
package quickmathv2;

public class Rankings {
    private String name;
    private String level;
    private String timeTaken;
    private int score;
    
    public Rankings (String name,String level,int score, String timeTaken){
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
    
    public void setScore(int score){
        this.score=score;
    }
    
    public int getScore(){
        return score;
    }
    
    public String toString(){
        return "name :"+getName()+" Level :"+getLevel()+" Score : "+getScore()+" TimeTaken:"+getTimeTaken();
    }
}
