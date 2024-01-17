package com.learning.CompanyQuestion.Tesco;

import java.util.ArrayList;
import java.util.List;

public class test {

    List<Shift> shiftList;
    test(){
        shiftList=new ArrayList<>();
        shiftList.add(new Shift(8,10));
        shiftList.add(new Shift(10,12));
        shiftList.add(new Shift(14,19));
    }
    static List<Shift>  result= new ArrayList<>();
    public void addShift(int start, int end){
        Shift newShift=new Shift(start,end);
        for(Shift existingShift: shiftList){
            if(newShift.overLappingOrnot(existingShift)){
                result.add(new Shift(existingShift.start,existingShift.end));
            }
        }

        shiftList.add(newShift);
        System.out.println("Shift add successfulley!");
    }

    public static void main(String[] args) {

        test t1=new test();
        System.out.println("Shift details betweent given time");
        t1.addShift(8,12);
        result.stream().forEach(data->{
            System.out.println("startshift : "+data.start+"End shift : "+ data.end);
        });
    }
}

class Shift{
    int start;
    int end;
    Shift( int start,int end){
        this.start=start;
        this.end=end;
    }
    public boolean overLappingOrnot(Shift shift1){
      return this.start<shift1.end && this.end>shift1.start;
    }

}
