package com.phuongletoan.screen;


import com.phuongletoan.interf.Constant;
import com.phuongletoan.interf.IBackHelp;
import com.phuongletoan.interf.IRemoveMenu;

import javax.swing.*;
import java.awt.*;

public class FrameGame extends JFrame implements Constant {
    private MenuPanel menuPanel;
    private HelpPanel helpPanel;
    private GamePanelPlay play;
    private GamePanelScore score;

    public FrameGame(){
        setBackground(Color.gray);
        setSize(WIDTH_F,HEIGHT_F);

        setTitle("Game snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        play=new GamePanelPlay();
        score=new GamePanelScore();

        menuPanel=new MenuPanel();
        IRemoveMenu rm=new IRemoveMenu() {
            @Override
            public void removePlay() {
                removeMenuShowPanel();
            }

            @Override
            public void removeHelp() {
                showHelp();
            }
        };
        menuPanel.setRemove(rm);
        add(menuPanel);

    }

    private void showHelp() {
        helpPanel=new HelpPanel();
        helpPanel.setRemove(new IBackHelp(){
            @Override
            public void backHelp() {
                backHelpGUI();
            }
        });
        remove(menuPanel);
        menuPanel=null;
        add(helpPanel);
        repaint();
    }

    private void backHelpGUI() {
        menuPanel=new MenuPanel();
        add(menuPanel);
        remove(helpPanel);
        helpPanel=null;
        IRemoveMenu rm=new IRemoveMenu() {
            @Override
            public void removePlay() {
                removeMenuShowPanel();
            }

            @Override
            public void removeHelp() {
                showHelp();
            }
        };
        menuPanel.setRemove(rm);
        repaint();
    }

    private void removeMenuShowPanel() {
        remove(menuPanel);
        menuPanel=null;
        play.setUpdateScore(score);
        add(play);
        add(score);
        repaint();
        play.setRequestFocusEnabled(true);
        play.setFocusable(true);
        play.requestFocus(true);
    }
}
