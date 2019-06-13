package com.phuongletoan.interf;

public interface Constant {
    int SIZE=20;
    int WIDTH_F=800;
    int HEIGHT_F=600;
    int HEIGHT_SCORE=100;
    int LENGTH_S=(WIDTH_F/SIZE)*(HEIGHT_F-HEIGHT_SCORE)/SIZE-3;
    int WIDTH_LOG=400;
    int HEIGHT_LOG=300;
    int X=WIDTH_F/SIZE;
    int Y=(HEIGHT_F-HEIGHT_SCORE)/SIZE;

}
