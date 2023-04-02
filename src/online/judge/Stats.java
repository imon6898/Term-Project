/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.judge;

/**
 *
 * @author Anik
 */
public class Stats {
    public String username;
    public int Problem_no;
    public String verdict;
    public Stats(String s,int n,String v){
        username=s;
        Problem_no=n;
        verdict=v;
    }
}
