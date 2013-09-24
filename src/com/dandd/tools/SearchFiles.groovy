package com.dandd.tools;/**
 * Created with IntelliJ IDEA.
 * User: xuping
 * Date: 13-9-24
 * Time: 上午11:27
 * To change this template use File | Settings | File Templates.
 */
class SearchFiles {

    static main(args) {

        new File('E:\\temp\\qic\\web').eachFile{
            if(it.name.endsWith('.jsp')){
                println it.name
            }
        }

    }




}