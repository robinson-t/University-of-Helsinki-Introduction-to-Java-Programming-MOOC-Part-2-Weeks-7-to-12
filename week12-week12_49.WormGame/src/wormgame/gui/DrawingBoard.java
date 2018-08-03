/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

/**
 *
 * @author tomro
 */
public class DrawingBoard extends JPanel implements Updatable{
    private WormGame game;
    private int pieceLength;

    public DrawingBoard(WormGame game, int pieceLength) {
        this.game = game;
        this.pieceLength = pieceLength;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        int appleX = game.getApple().getX();
        int appleY = game.getApple().getY();
        g.setColor(Color.RED);
        g.fillOval(appleX*pieceLength, appleY*pieceLength, pieceLength, pieceLength);
        
        for (Piece p : this.game.getWorm().getPieces()) {
            int pieceX = p.getX();
            int pieceY = p.getY();
            g.setColor(Color.BLACK);
            g.fill3DRect(pieceX*pieceLength, pieceY*pieceLength, pieceLength, pieceLength, true);
        }
        
    }

    @Override
    public void update() {
        repaint();
    }
    
    
}
