package com.hikvision.demo.algorithm;

import java.util.*;

public class StackHandle {

    private List<Integer> list = null;

    public Integer pop() {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Integer in = map.get(list.get(i));
            if (in != null) {
                map.put(list.get(i), ++in);
            } else {
                map.put(list.get(i), 0);
            }

        }
        Collection<Integer> values = map.values();
        List<Integer> treeList = new ArrayList<>();
        for (Integer in : values) {
            treeList.add(in);
        }
        Collections.sort(treeList);
        Integer max = treeList.get(treeList.size() - 1);
        Integer maxValue = null ;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue()==max){
                maxValue = entry.getKey();
                break;
            }
        }
        for (int c = list.size() - 1; c >= 0; c--) {
           if (list.get(c) == maxValue){
               return list.get(c);
           }
        }
        return null;

    }

    public void push(Integer in) {

        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(in);
    }
}
