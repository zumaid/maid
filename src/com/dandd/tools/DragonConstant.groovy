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

    //阵营
    static alignments=["善良","守序善良","邪恶","混乱邪恶","无阵营","神"]
//语言
    static language=["通用语","地底语","龙语","矮人语","精灵语","巨人语","地精语","原始语","天界语","深渊语"]
    static main(args) {
        println initproperty()
        println(createRoleProperty())

        println(createRole())
    }

    static createRole(){
        def role=[:];
        role["name"]=RandomListValue(Name.firstName())+RandomListValue(Name.secondName())
        role["property"]=createRoleProperty()
        role["alignments"]=RandomListValue(alignments)
        role["language"]=RandomListValue(language)
        role["profession"]=RandomListValue(profession)
        role["race"]=RandomListValue(race)

        role["姓名"]  = role["name"]
        role["属性值"]= role["property"]
        role["阵营"] =  role["alignments"]
        role["语言"]=  role["language"]
        role["职业"]=   role["profession"]
        role["种族"]= role["race"]
        return role;
    }

    static RandomListValue(def list){
        Random r1=new Random();
        return  list[r1.nextInt(list.size())]
    }

    /**
     * 创建角色的属性值
     * @return
     */
    static createRoleProperty()
    {
        def a=[:]
        property.each {
            a[it]= initproperty()
        }
        return a;
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