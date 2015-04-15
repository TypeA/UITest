package com.livejournal.uitests.friends.useful.manage_friends_groups;

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
            indexMoveUp = (int) (Math.random() * size + 2);
            indexMoveDown = (int) (Math.random() * (size - 1) + 2);
            while (indexMoveUp == indexMoveDown) {
                indexMoveDown = (int) (Math.random() * (size - 1) + 2);
            }
        }
        this.getIndexMoveDown();
        this.getIndexMoveUp();
    }

    public int getIndexMoveDown() {
        return indexMoveDown;
    }

    public int getIndexMoveUp() {
        return indexMoveUp;
    }
}
