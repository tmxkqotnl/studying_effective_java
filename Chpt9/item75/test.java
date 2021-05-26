package Chpt9.item75;

import java.util.*;
import Chpt9.item75.IndexOutOfBoundsException;

public class test {
  public static void main(String[] args){
      ArrayList<Integer> list = new ArrayList<>();
      list.add(Integer.valueOf(0));
      list.add(Integer.valueOf(1));
      list.add(Integer.valueOf(2));

      try{
        for(int i=0;i<=list.size();i++){
          System.out.println(list.get(i));
        }
      }catch(Exception e){
        IndexOutOfBoundsException err = new IndexOutOfBoundsException(0, list.size()-1,list.size());
        System.out.println(err.getMessage());
      }
    }
  
}
