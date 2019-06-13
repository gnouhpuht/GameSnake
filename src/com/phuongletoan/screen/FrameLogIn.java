package com.phuongletoan.screen;

import com.phuongletoan.interf.Constant;
import com.phuongletoan.interf.IRemoveLogin;
import com.phuongletoan.log_in.PanelLogIn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class FrameLogIn extends JFrame implements Constant {
    private PanelLogIn logIn;
    public FrameLogIn(){
        logIn=new PanelLogIn();
        setSize(WIDTH_LOG,HEIGHT_LOG);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setFocusable(true);

        IRemoveLogin rm=new IRemoveLogin() {
            @Override
            public void removeLogin() {
                removeLoginShowMenu();
            }
        };
        logIn.setRemove(rm);
        add(logIn);
    }

    private void removeLoginShowMenu() {
        WindowEvent windowClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClosingEvent);

    }

}
