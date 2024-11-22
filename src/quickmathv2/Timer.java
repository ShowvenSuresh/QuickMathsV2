/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quickmathv2;

import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class Timer {
    private int second = 0; // 计时器秒数
    private boolean start = false; // 控制计时开关
    private Thread timerThread; // 独立线程处理计时

    public synchronized void resetTime() {
        start = false;
        second = 0;
    }

    public synchronized void startTime(JLabel displayLabel) {
        if (start) return;
        start = true;

        timerThread = new Thread(() -> {
            try {
                while (start) {
                    Thread.sleep(1000); 
                    incrementTime();
                    displayLabel.setText(getTime());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        timerThread.start();
    }

    public synchronized void stopTime() {
        start = false;
        if (timerThread != null) {
            timerThread.interrupt(); 
        }
    }

    public synchronized String getTime() {
        return formatTime(second);
    }

    private String formatTime(int totalSeconds) {
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private synchronized void incrementTime() {
        second++;
    }
    
}

