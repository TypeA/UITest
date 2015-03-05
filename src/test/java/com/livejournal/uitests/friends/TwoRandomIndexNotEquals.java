/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.friends;

import java.lang.Math;

/**
 *
 * @author m.panferova
 */
class TwoRandomIndexNotEquals {

    int indexMoveUp;
    int indexMoveDown;

    TwoRandomIndexNotEquals(int i, int b) {
        indexMoveUp = i;
        indexMoveDown = b;
    }
    TwoRandomIndexNotEquals getIndexTwoGroup(int size) {
        int moveUp = (int) (Math.random() * size + 2);
        int moveDown = (int) (Math.random() * (size - 1) + 2);
        while (moveUp == moveDown) {
            moveDown = (int) (Math.random() * (size - 1) + 2);
        }
        TwoRandomIndexNotEquals result = new TwoRandomIndexNotEquals(moveUp, moveDown);
        return result;
    }
}
