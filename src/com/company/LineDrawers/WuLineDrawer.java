package com.company.LineDrawers;

import com.company.LineDrawer;
import com.company.PixelDrawer;

import java.awt.*;

public class WuLineDrawer implements LineDrawer {
    private PixelDrawer pd;
    public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }
    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        if (Math.abs(dx) > Math.abs(dy)) {
            double k = dy / dx;
            if (x1 > x2) {
                int t = x1;
                x1 = x2;
                x2 = t;
                t = y1;
                y1 = y2;
                y2 = t;
            }
            for (int j = x1; j < x2; j++) {
                double i = k * (j - x1) + y1;
                pd.drawPixel(j, (int) i, Color.BLACK);
                pd.drawPixel(j,(int) i+1,new Color(128,128,128));
                pd.drawPixel(j,(int) i-1,new Color(128,128,128));
            }
        } else {
            double obrk = dx / dy;
            if (y1 > y2) {
                int t = y1;
                y1 = y2;
                y2 = t;
                t = x1;
                x1 = x2;
                x2 = t;
            }
            for (int i = y1; i < y2; i++) {
                double j = (i - y1) * obrk + x1;
                pd.drawPixel((int) j, i, Color.BLACK);
                pd.drawPixel((int) j+1, i, new Color(128,128,128));
                pd.drawPixel((int) j-1, i, new Color(128,128,128));

            }

        }
    }
}
