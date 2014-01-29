package com.heiji.fenling

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

import com.google.gson.Gson
import com.tools.HttpUtils
import com.tools.Json

class Base {

	def readUrl(String url){
		return HttpUtils.get(url.toString());
	}
	
	def readUrlForImage(url){ 
		Document  doc =   Jsoup.parse(readUrl(url));
		def srcList=[]
		doc.getElementsByTag("img").each{
			if(it.attr("abs:src")!=""){
				srcList<<it.attr("abs:src")
			}
		}
		return srcList;
	}
	 
	def readUrlForA(url){
		Document  doc =   Jsoup.parse(readUrl(url));
		def srcList=[]
		doc.getElementsByTag("a").each{
			if(it.attr("abs:href")!=""){
				srcList<<it.attr("abs:href")
			}
		}
		return srcList;
	}
	 
	def Object2Map(object){ 
		Gson _gson = new Gson();
		String json=_gson.toJson(object);
		return  Json.parseData(json);
	}
	
	static main(args) {
		Base _Base =new Base();
		println _Base.readUrlForImage("http://moody1988.lofter.com/")
		
		println _Base.readUrlForA("http://moody1988.lofter.com/")
	}
}
