package com.livejournal.uitests.friends.personal.manage_friends_groups;

/**
 *
 * @author m.panferova
 */
class TwoRandomIndexNotEquals {

    public int indexMoveUp;
    public int indexMoveDown;

    public TwoRandomIndexNotEquals(int size) {
        if (size == 2) {
            indexMoveDown = 1;
            indexMoveUp = 2;
        }
        if (size > 2) {
            indexMoveUp = 2 + (int) (Math.random() * (size-2)+1);
            indexMoveDown = 2 + (int) (Math.random() * ((size - 1)-2)+1);
            while (indexMoveUp == indexMoveDown) {
                indexMoveDown = 2 + (int) (Math.random() * ((size - 1)-2)+1);
        }
    }
}
}
