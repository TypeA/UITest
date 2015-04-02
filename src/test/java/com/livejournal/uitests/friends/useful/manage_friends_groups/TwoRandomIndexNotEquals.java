package com.livejournal.uitests.friends.useful.manage_friends_groups;

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
