package com.tsystems.javaschool.tasks;
import java.util.List;

public class SubsequenceImpl implements Subsequence {
    @Override
    public boolean find(List x, List y) {
        int control=0;                                     // Variable for control index of 'List y'
        for (int i=0; i < x.size(); i++){
            for (int j=control; j < y.size(); j++){
                if (x.get(i).equals(y.get(j))){            // If element of 'List x' equals element of 'List y' remember index of 'y' and
                                                           // going to search next element from 'List x'
                    control = j++;
                    break;
                }
                control = j+1;
            }
            if (control == y.size())                      // If 'List y' is over but no one element from this equals element from 'List x'
                return false;
        }

        return true;
    }
}
