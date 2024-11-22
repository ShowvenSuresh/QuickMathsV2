/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quickmathv2;
import java.util.Random;
/**
 *
 * @author USER
 */
public class QuestionGenerator {
   
    public QuestionSet generateAdditionQuestion(int maxNumber){
        Random random = new Random();
        int randomNum1 = random.nextInt(maxNumber);
        int randomNum2 = random.nextInt(maxNumber);
        int ans = randomNum1 + randomNum2;
        String question = randomNum1 + " + " + randomNum2 + " = ?";
        
        int[] selection = generateSelection(maxNumber * 2, ans);
        return new QuestionSet(question, selection[0],selection[1],selection[2],selection[3],ans);
    }
    
    
    public QuestionSet generateSubstractionQuestion(int maxNumber){
        Random random = new Random();
        int randomNum1 = random.nextInt(maxNumber);
        int randomNum2 = random.nextInt(maxNumber);
        int ans = randomNum1 - randomNum2;
        String question = randomNum1 + " - " + randomNum2 + " = ?";
        
        int[] selection = generateSelection(maxNumber * 2, ans);
        return new QuestionSet(question, selection[0],selection[1],selection[2],selection[3],ans);
    }
    
    public QuestionSet generateMultiplicationQuestion(int maxNumber){
        Random random = new Random();
        int randomNum1 = random.nextInt(maxNumber);
        int randomNum2 = random.nextInt(maxNumber);
        int ans = randomNum1 * randomNum2;
        String question = randomNum1 + " x " + randomNum2 + " = ?";
        
        int[] selection = generateSelection(maxNumber * maxNumber, ans);
        return new QuestionSet(question, selection[0],selection[1],selection[2],selection[3],ans);
    }
    
    public QuestionSet generateDivisionQuestion(int maxNumber){
        Random random = new Random();
        int randomNum2 = random.nextInt(maxNumber / 10) + 1;
        int randomNum1 = randomNum2 * random.nextInt(maxNumber / randomNum2); 
        int ans = randomNum1 / randomNum2;
        String question = randomNum1 + " / " + randomNum2 + " = ?";
        
        int[] selection = generateSelection(maxNumber, ans);
        return new QuestionSet(question, selection[0],selection[1],selection[2],selection[3],ans);
    }
    
    public int[] generateSelection(int maxNumber, int ans){
        int[] selection = new int[4];
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int select;
            boolean repeat;
            do {
                repeat = false;
                select = random.nextInt(maxNumber);
                for (int j = 0; j < i; j++) {
                    if (selection[j] == select) {
                        repeat = true;
                        break;
                    }
                }
            } while (repeat);
            selection[i] = select;
        }
        
        boolean ansFound = false;
        for(int i = 0; i<4;i++){
            if(selection[i] == ans){
                ansFound = true;
                break;
            }
        }
        if(!ansFound){
            selection[random.nextInt(4)] = ans;
        }
        return selection;
    }
}
