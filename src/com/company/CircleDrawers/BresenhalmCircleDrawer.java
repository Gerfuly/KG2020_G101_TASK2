package com.company.CircleDrawers;

import com.company.CircleDrawer;
import com.company.PixelDrawer;

import java.awt.*;

public class BresenhalmCircleDrawer implements CircleDrawer {
    private PixelDrawer pd;

    public BresenhalmCircleDrawer(PixelDrawer pd) {
        this.pd = pd;
    }


    public void drawCircle(int x, int y, int r, Color c){
        int n = (int) (2*Math.PI*r);
        double da = 2 * Math.PI / n;
        for (int i = 0; i < n; i++) {
            double dx = r * Math.cos(da * i);
            double dy = r * Math.sin(da * i);
            pd.drawPixel(x + (int) dx, y + (int) dy, c);
        }
    }

    @Override
    public void drawEllips(int x1, int y1, int rx, int ry, Color c) {
        for (int i=-rx; i<=rx; i++){
            for (int j=-ry; j<=ry; j++){
                if ((i*i*ry*ry+j*j*rx*rx>(rx-0.8)*(rx-0.6)*(ry-0.8)*(ry-0.6))&&(i*i*ry*ry+j*j*rx*rx<=rx*rx*ry*ry)){
                    pd.drawPixel(x1+i,y1+j,c);
                }
            }
        }
    }
}
