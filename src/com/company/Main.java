package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        String path = args[0];
        ArrayList<Integer> nums = new ArrayList<Integer>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            String string = reader.readLine();
            while (string != null){
                nums.add(Integer.parseInt(string));
                string = reader.readLine();
            }
            Collections.sort(nums);
            int median = getMedian(nums);
            int diff = 0;
            int steps = 0;
            for (int i: nums){
                diff = Math.abs(median - i);
                steps += diff;
            }
            System.out.println(steps);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static int getMedian(ArrayList<Integer> list){
        int index;
        int median;

        if(list.size()%2 == 1){
            index = list.size()/2;
            median = list.get(index);
        }
        else {
            index = (list.size()/2 - 1);
            median = Math.round((list.get(index) + list.get(index + 1))/2f);
        }
        return median;
    }
}
