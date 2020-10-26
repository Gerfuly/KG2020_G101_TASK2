package com.company.LineDrawers;

import com.company.LineDrawer;
import com.company.PixelDrawer;

import java.awt.*;

public class BresenhalmLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public BresenhalmLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int dx, dy;
        if (x2 - x1 >= 0) {
            dx = 1;
        } else {
            dx = -1;
        }
        if (y2 - y1 >= 0) {
            dy = 1;
        } else {
            dy = -1;
        }
        int lengthX = Math.abs(x2 - x1);
        int lengthY = Math.abs(y2 - y1);
        int length = Math.max(lengthX, lengthY);
        if (length == 0) {
            pd.drawPixel(x1, y1, Color.black);
        }

        if (lengthY <= lengthX) {
            // Начальные значения
            int x = x1;
            int y = y1;
            int d = -lengthX;

            // Основной цикл
            length += 1;
            while (length > 0) {
                pd.drawPixel(x, y, Color.GREEN);
                x += dx;
                d += 2 * lengthY;
                if (d > 0) {
                    d -= 2 * lengthX;
                    y += dy;
                }
                length -= 1;
            }
        } else {
            // Начальные значения
            int x = x1;
            int y = y1;
            int d = -lengthY;

            // Основной цикл
            length++;
            while (length > 0) {
                pd.drawPixel(x, y, Color.black);
                y += dy;
                d += 2 * lengthX;
                if (d > 0) {
                    d -= 2 * lengthY;
                    x += dx;
                }
                length--;
            }
        }
    }
}
