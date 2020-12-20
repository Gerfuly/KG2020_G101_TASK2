package com.company.LineDrawers;

import com.company.LineDrawer;
import java.awt.*;
import com.company.PixelDrawer;

public class WuLineDrawer implements LineDrawer {
    private PixelDrawer pd;


    public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }
    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        Color c = Color.black;
        boolean flag = true;
        float dx = x2 - x1;
        float dy = y2 - y1;
        float gradient = 0;
        int tr = c.getRed(), tg = c.getGreen(), tb = c.getBlue();
        if (dx == 0){
            for (int y = y1; y < y2; ++y){
                pd.drawPixel(x1, y, c);
                flag = false;
            }
        }
        if (dy == 0){
            for (int x = x1; x < x2; ++x){
                pd.drawPixel(x, y1, c);
                flag = false;
            }
        }
        if ((Math.abs(dx) > Math.abs(dy)) && flag) {
            if (x1 > x2) {
                int t = x1;
                x1 = x2;
                x2 = t;
                t = y1;
                y1 = y2;
                y2 = t;
            }
            gradient = (float) dy / dx;
            float intery = y1 + gradient;
            pd.drawPixel(x1,y1,c);
            for (int x = x1; x < x2; ++x) {
                pd.drawPixel(x, (int)intery,new Color(tr, tg, tb, (int) (255 - fractionalPart(intery) * 255)));//Меняем прозрачность
                pd.drawPixel(x, (int)intery + 1,new Color(tr, tg, tb, (int) (fractionalPart(intery) * 255)));
                intery += gradient;
            }
            pd.drawPixel(x2,y2,c);
        }
        else {
            if (y1 > y2) {
                int t = y1;
                y1 = y2;
                y2 = t;
                t = x1;
                x1 = x2;
                x2 = t;
            }
            gradient = (float) dx / dy;
            float interx = x1 + gradient;
            pd.drawPixel(x1,y1,c);
            for (int y = y1; y < y2; ++y) {
                pd.drawPixel((int)interx, y,new Color(tr, tg, tb, (int) (255 - fractionalPart(interx) * 255)));
                pd.drawPixel((int)interx + 1, y, new Color(tr, tg, tb, (int) (fractionalPart(interx) * 255)));
                interx += gradient;
            }
            pd.drawPixel(x2,y2,c);
        }
    }

    private float fractionalPart(float x) {
        int tmp = (int) x;
        return x - tmp; //вернёт дробную часть числа
    }
    }

