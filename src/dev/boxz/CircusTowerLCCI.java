/**
 * https://leetcode-cn.com/problems/circus-tower-lcci/
 */

package dev.boxz;

import java.util.Arrays;

public class CircusTowerLCCI {
    public static int Solution(int[] height, int[] weight) {
        Person[] people= new Person[height.length];
        for (int i=0;i<height.length;i++){
            Person person=new Person (height[i],weight[i]);
            people[i]=person;
        }
        people=Person.sortHeight(people);
        int[] dp=new int[height.length];
        Arrays.fill (dp,1);
        int max=1;

        for (int i=1;i<height.length;i++){
            for (int j=0;j<i;j++){
                if ((people[j].getWeight ()<people[i].getWeight ())&&(people[j].getHeight ()<people[i].getHeight ())){
                    dp[i]=Math.max (dp[j]+1,dp[i]);
                    max=Math.max (dp[i],max);
                }
            }
        }

        return max;
    }
}
class Person{
    private int height;
    private int weight;

    public int getHeight () {
        return height;
    }

    public void setHeight (int height) {
        this.height = height;
    }

    public int getWeight () {
        return weight;
    }

    public void setWeight (int weight) {
        this.weight = weight;
    }

    public Person (int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public static Person[] sortHeight(Person[] people){
        for (int i=0;i< people.length-1;i++){
            for (int j=i+1;j< people.length;j++){
                if (people[j].height<people[i].height){
                    Person t=people[i];
                    people[i]=people[j];
                    people[j]=t;
                }
            }
        }
        return people;
    }
}