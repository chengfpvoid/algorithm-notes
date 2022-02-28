package org.cheng.algo;

import java.util.ArrayList;
import java.util.List;

public class SonCounts {
    private int count = 0;
    private int getSonsNumber(int id) {
      count = 0;
      int ret =  getSonsCount(id);
      count = 0;
      return ret;
    }


    private int getSonsCount(int id) {
        List<Integer> ids = queryNextIds(id);

        if (ids.size() == 0) {
            return count;
        }
        count += ids.size();
        for (int i = 0; i < ids.size(); i++) {
            getSonsCount(ids.get(i));
        }
        return count;
    }




    private List<Integer> queryNextIds(int id) {
        if (id == 1) {
            ArrayList<Integer> ids = new ArrayList<>();
            ids.add(2);
            ids.add(4);
            return ids;
        }
        if (id == 2) {
            ArrayList<Integer> ids = new ArrayList<>();
            ids.add(3);
            ids.add(5);
            return ids;
        }
        if (id == 3) {
            ArrayList<Integer> ids = new ArrayList<>();
            ids.add(7);
            ids.add(8);
            return ids;
        }
        if (id == 4) {
            return new ArrayList<>();
        }
        if (id == 5) {
            ArrayList<Integer> ids = new ArrayList<>();
            ids.add(6);
            return ids;
        }
        if (id == 6) {
            return new ArrayList<>();
        }
        if (id == 7) {
            return new ArrayList<>();
        }
        if (id == 8) {
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        SonCounts sonCounts = new SonCounts();
        System.out.println(sonCounts.getSonsNumber(5));
        System.out.println(sonCounts.getSonsNumber(1));
    }

}
