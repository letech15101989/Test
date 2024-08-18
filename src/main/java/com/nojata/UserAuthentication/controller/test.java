/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nojata.UserAuthentication.controller;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Shamsher
 */
public class test {
    public static void main(String []args){
        List<Integer> data =  Arrays.asList(1,2,3,2,1,5,45,2,8);
        long count = data.stream().count();
        System.out.println("count:"+count);
    }
}
