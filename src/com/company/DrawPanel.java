package com.company;

import com.company.CircleDrawers.BresenhalmCircleDrawer;
import com.company.LineDrawers.BresenhalmLineDrawer;
import com.company.LineDrawers.DDaLineDrawer;
import com.company.LineDrawers.GraphicsLineDrawer;
import com.company.LineDrawers.WuLineDrawer;
import com.company.utils.drawUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener {
    private Point position = new Point(0, 0);

    public DrawPanel() {
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();
        PixelDrawer pd = new GraphicsPixelDrawer(bi_g);
        LineDrawer ld = new DDaLineDrawer(pd);
        LineDrawer ld1 = new BresenhalmLineDrawer(pd);
        LineDrawer ld2 = new WuLineDrawer(pd);
        CircleDrawer cd1 = new BresenhalmCircleDrawer(pd);
        bi_g.setColor(Color.WHITE);
        bi_g.fillRect(0, 0, getWidth(), getHeight());
        bi_g.setColor(Color.BLACK);

        drawAll(ld);
        drawAll1(ld1);
        drawAll2(ld2);
        cd1.drawCircle(110,400,100,Color.green);
        cd1.drawEllips(110,400,50,100,Color.black);
        cd1.drawEllips(110,400,100,50,Color.black);



        g.drawImage(bi, 0, 0, null);
        bi_g.dispose();


    }

    public void drawAll1(LineDrawer ld) {
        drawUtils.drawSnowflake(ld, 200, 200, 80, 20);
        ld.drawLine(200, 200, position.x, position.y);
    }
    public void drawAll2(LineDrawer ld) {
        drawUtils.drawSnowflake(ld, 400, 200, 80, 20);
        ld.drawLine(400, 200, position.x, position.y);
    }

    public void drawAll(LineDrawer ld) {
        drawUtils.drawSnowflake(ld, 600, 200, 80, 20);
        ld.drawLine(600, 200, position.x, position.y);
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        position = new Point(e.getX(), e.getY());
        repaint();
    }
}
