package com.company.CircleDrawers;

import com.company.CircleDrawer;
import com.company.PixelDrawer;

import java.awt.*;

public class WuCylce implements CircleDrawer {
    private PixelDrawer pd;

    public WuCylce(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawEllips(int x1, int y1, int rx, int ry, Color c) {

    }

    public void drawCircle(int x, int y, int r, Color c){
        int n = (int) (2*Math.PI*r);
        double da = 2 * Math.PI / n;
        int tr = c.getRed(), tg = c.getGreen(), tb = c.getBlue();
        for (int i = 0; i < n; i++) {
            double dx = r * Math.cos(da * i);
            double dy = r * Math.sin(da * i);
            pd.drawPixel(x + (int) dx, y + (int) dy, new Color(tr, tg, tb, (int) (1 * 255)));
            pd.drawPixel(1+x + (int) dx, y + (int) dy, new Color(tr, tg, tb, (int) (0.5 * 255)));
            pd.drawPixel(x + (int) dx, y+1 + (int) dy, new Color(tr, tg, tb, (int) (0.5 * 255)));
            pd.drawPixel(x + (int) dx, y-1 + (int) dy, new Color(tr, tg, tb, (int) (0.5 * 255)));
            pd.drawPixel(x-1 + (int) dx, y + (int) dy, new Color(tr, tg, tb, (int) (0.5 * 255)));


        }
    }

    @Override
    public void drawArc(int x, int y, int r, double p, double p0, Color c) {

    }

    private float fractionalPart(float x) {
        int tmp = (int) x;
        return x - tmp; //вернёт дробную часть числа
    }
}
