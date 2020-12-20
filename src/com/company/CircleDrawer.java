package com.company;

import java.awt.*;

public interface CircleDrawer {
    void drawEllips(int x1, int y1, int rx, int ry, Color c);
    void drawCircle(int x, int y, int r, Color c);
    void drawArc(int x, int y, int r, double p,double p0, Color c);
}
