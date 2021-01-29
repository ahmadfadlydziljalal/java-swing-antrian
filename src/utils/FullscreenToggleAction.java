/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;

/**
 *
 * @author tmsdzil
 */
public class FullscreenToggleAction extends AbstractAction {

    private JFrame frame;
    private GraphicsDevice fullscreenDevice;

    public FullscreenToggleAction(JFrame frame) {
        this(frame, GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice());
    }

    public FullscreenToggleAction(JFrame frame, GraphicsDevice fullscreenDevice) {
        this.frame = frame;
        this.fullscreenDevice = fullscreenDevice;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();

        if (frame.isUndecorated()) {
            fullscreenDevice.setFullScreenWindow(null);
            frame.setUndecorated(false);
        } else {
            frame.setUndecorated(true);
            fullscreenDevice.setFullScreenWindow(frame);
        }

        frame.setVisible(true);
        frame.repaint();
    }

}
