package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    String Name;
    float money;
    List<String> hands;
    int[] priority_num = {0, 0, 0};
    int priority_type = 0;

    Player(String Name, float money, List<String> hands) {
        this.Name = Name;
        this.money = money;
        this.hands = hands;
    }

    public int getIndex(List<String> cardRanks, int priorityindex) {
        for (String b : cardRanks) {
            if (b.equals(this.hands.get(priorityindex)))
                return cardRanks.indexOf(b) + 1;
        }
        return -1;
    }

    public void sortedHands() {
        List<String> emptylist = new ArrayList<>();
        List<Integer> templist = new ArrayList<>();
        templist.add(this.priority_num[0]);
        templist.add(this.priority_num[1]);
        templist.add(this.priority_num[2]);
        int highest;
        for (int i = 0; i < 3; i++) {
            highest = returnHighest(templist);
            emptylist.add(this.hands.get(highest));
            this.hands.remove(highest);
            templist.remove(highest);
        }
        this.hands = emptylist;

    }

    public int returnHighest(List<Integer> templist) {
        {
            int highest = 0;
            for (int i = 0; i < this.hands.size(); i++) {
                if (templist.get(i) > templist.get(highest))
                    highest = i;
            }
            return highest;

        }
    }
}
