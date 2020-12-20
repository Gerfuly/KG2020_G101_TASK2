package com.company.CircleDrawers;

import com.company.CircleDrawer;
import com.company.PixelDrawer;

import java.awt.*;

public class BresenhalmCircleDrawer implements CircleDrawer {
    private PixelDrawer pd;

    public BresenhalmCircleDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawEllips(int x1, int y1, int rx, int ry, Color c) {
        for (int i=-rx; i<=+rx; i++){
            for (int j=-ry; j<=+ry; j++){
                if (i*i*ry*ry+j*j*rx*rx<rx*rx*ry*ry){
                    pd.drawPixel(x1+i,y1+j,c);
                }
            }
        }
    }
}
