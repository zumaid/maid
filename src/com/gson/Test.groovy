package com.gson
import com.google.gson.Gson;
class Test {

	static main(args) {
		Gson _gson = new Gson();
		def a=[:]
		a["a"]=111
		a["a2"]=111
		
		a["a3"]=111
		a["a4"]=111
		a["a5"]=111
		a["a6"]=111
		a["a7"]=111
		println _gson.toJson(a);
	}

}
