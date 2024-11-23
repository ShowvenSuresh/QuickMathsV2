/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quickmathv2;

import java.awt.Color;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class QuetionManager {
    static private JLabel lblQuestion;
    static private JLabel lblSelection1;
    static private JLabel lblSelection2;
    static private JLabel lblSelection3;
    static private JLabel lblSelection4;
    
    static public boolean additionTerms = false;
    static public boolean substractionTerms = false;
    static public boolean multiplicationTerms = false;
    static public boolean divitionTerms = false;
    
    static public boolean learningMode = true;
    
    static public int level = 1;
    static public int questionNum = 5;
    
    public int correct = 0;
    public int notCorrect = 0;
    
    
    public QuetionManager(JLabel lblQuestion, JLabel lblSelection1, JLabel lblSelection2, JLabel lblSelection3, JLabel lblSelection4){
        QuetionManager.lblQuestion = lblQuestion;
        QuetionManager.lblSelection1 = lblSelection1;
        QuetionManager.lblSelection2 = lblSelection2;
        QuetionManager.lblSelection3 = lblSelection3;
        QuetionManager.lblSelection4 = lblSelection4;
        generateQuestion();
        SetNextQuestion();
    }
    
    public QuetionManager(){
        generateQuestion();
        //SetNextQuestion();
    }
    private QuestionSet currentQuestion; 
    public void SetNextQuestion(){
        ansCorrectFirstTime = true;
        lblSelection1.setForeground(Color.black);
        lblSelection2.setForeground(Color.black);
        lblSelection3.setForeground(Color.black);
        lblSelection4.setForeground(Color.black);
        currentQuestion = questionQueue.deQueue();
        if(currentQuestion != null){
            lblQuestion.setText(currentQuestion.question);
            lblSelection1.setText(currentQuestion.selection1+"");
            lblSelection2.setText(currentQuestion.selection2+"");
            lblSelection3.setText(currentQuestion.selection3+"");
            lblSelection4.setText(currentQuestion.selection4+"");
        }else{
            
        }
    }
    
    private boolean ansCorrectFirstTime = true;
    public void CheckAns(int selectBox){
        boolean correct = false;
        switch (selectBox){
            case 0:
                correct = (currentQuestion.anser == currentQuestion.selection1);
                lblSelection1.setForeground(Color.red);
                break;
            case 1:
                correct = (currentQuestion.anser == currentQuestion.selection2);
                lblSelection2.setForeground(Color.red);
                break;
            case 2:
                correct = (currentQuestion.anser == currentQuestion.selection3);
                lblSelection3.setForeground(Color.red);
                break;
            case 3:
                correct = (currentQuestion.anser == currentQuestion.selection4);
                lblSelection4.setForeground(Color.red);
                break;
        }
        
        if(learningMode){
            if(correct){
                if(ansCorrectFirstTime)
                    this.correct++;
                else
                    notCorrect++;
                SetNextQuestion();
            }else{
                ansCorrectFirstTime = false;
                if(currentQuestion.anser == currentQuestion.selection1){
                   lblSelection1.setForeground(Color.green);
                }
                if(currentQuestion.anser == currentQuestion.selection2){
                   lblSelection2.setForeground(Color.green);
                }
                if(currentQuestion.anser == currentQuestion.selection3){
                   lblSelection3.setForeground(Color.green);
                }
                if(currentQuestion.anser == currentQuestion.selection4){
                   lblSelection4.setForeground(Color.green);
                }
            }
        }else{
            if(correct){
                this.correct++;
                SetNextQuestion();
            }else{
                this.notCorrect++;
                SetNextQuestion();
            }
        }
        
    }
    
    public Queue questionQueue = new Queue();
    private void generateQuestion(){
        int maxNum = 10;
        switch (level){
            case 1:
                maxNum = 10;
                break;
            case 2:
                maxNum = 20;
                break;
            case 3:
                maxNum = 30;
                break;
        }
        
        QuestionGenerator generator = new QuestionGenerator();
        for(int i = 0; i<questionNum; i++){
            System.out.println(i+" "+questionQueue.count());
            Random random = new Random();
            switch (random.nextInt(4)){
                case 0:
                    if(additionTerms)
                        questionQueue.enQueue(generator.generateAdditionQuestion(maxNum));
                    else
                        i--;
                    break;
                case 1:
                    if(substractionTerms)
                        questionQueue.enQueue(generator.generateSubstractionQuestion(maxNum));
                    else
                        i--;
                    break;
                case 2:
                    if(multiplicationTerms)
                        questionQueue.enQueue(generator.generateMultiplicationQuestion(maxNum));
                    else
                        i--;
                    break;
                case 3:
                    if(divitionTerms)
                        questionQueue.enQueue(generator.generateDivisionQuestion(maxNum * maxNum));
                    else
                        i--;
                    break;
            }
        }
    }
}
