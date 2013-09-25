package com.dandd.tools;/**
 * Created with IntelliJ IDEA.
 * User: xuping
 * Date: 13-9-25
 * Time: 下午12:53
 * To change this template use File | Settings | File Templates.
 */
class DragonConstant {

    //宗族
    static race=["龙裔","矮人","雅灵","精灵","半身人","人类","提夫林"]
    //职业
    static profession=["牧师","战士","圣武士","游侠","游荡者","法术师","战术家","法师"]
    //属性
    static property=["力量","体质","敏捷","智力","感知","魅力"]
    static main(args) {
        println initproperty()



        def a=[:]
        property.each {
            a[it]= initproperty()
        }
        println(a)
    }



    //产生一个属性值
    static initproperty(){
        //4 次 1D6  三个最大值取和
        Random r1=new Random();
        int temp= r1.nextInt(6)+1;
       // println(temp+"----")
        int re =0;
        3.times {
            int a=r1.nextInt(6)+1
        //    println(a+"----")
            if(a>=temp){
               re=re+a;
            }else{
                re=re+temp;
                temp=a;
            }
        }

        return re;
    }

}