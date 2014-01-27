package com.heiji

import javax.imageio.ImageIO

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

import com.gmongo.GMongo
import com.mongodb.gridfs.GridFS
import com.mongodb.gridfs.GridFSInputFile

class Base {

	static main(args) {
		def   mongo = new GMongo("127.0.0.1:27017")
		def    db = mongo.getDB("zuaamaid")
		def GridFS myFS = new GridFS(db);
		def path="C:\\AAAAAA_pic"
		1037.times {
			def url="http://jandan.net/ooxx/page-${it}#comments"
			println "${url}开始处理"
			readUrlImage( url,path,myFS);
		}
	}


	static readUrlImage(url,path,myFS){
		try{
			Document  doc = Jsoup.connect(url).timeout(8000).get()
			doc.getElementsByTag("img").each{
				if(it.attr("abs:src")!=""){
					def name ="${System.currentTimeMillis()}.jpg"
					getFileAndSave(path,name,it.attr("abs:src"),myFS);
					new File("${path}/${name}").delete();
				}
			}
		}catch(e){
		}
	}
	/**
	 * 保存网络资源
	 * @param path
	 * @param name
	 * @param address
	 * @return
	 */
	static getFile(path,name,address){
		new File("${path}/${name}").withOutputStream { out ->
			out << new URL(address).openStream()
		}
		if(!getImageInfo(path,name,200,200)){
			println "删除像素低的图片"
			new File("${path}/${name}").delete();
		}
	}

	static getFileAndSave(path,name,address,myFS){
		new File("${path}/${name}").withOutputStream { out ->
			out << new URL(address).openStream()
		}
		if(!getImageInfo(path,name,200,200)){
			println "删除像素低的图片"
			new File("${path}/${name}").delete();
		}else{
			saveFileToMongodb(path,name,myFS)
		}
	}
	/**
	 * 保存文件到，mongodb
	 * @param path
	 * @param name
	 * @param myFS
	 * @return
	 */
	static saveFileToMongodb(path,name,myFS){
		if(myFS.find(name).size()>0){
			println "已经存在 ${name}"
		}else{
			File f =new File("${path}\\${name}");
			if(f.isFile()){
				GridFSInputFile inputFile = myFS.createFile(f);
				inputFile.setFilename(name);
				inputFile.save();
			}
		}
	}

	static getImageInfo(path,name,w,h){

		def img = ImageIO.read(new File("${path}\\${name}"));

		println img.getWidth() +"|||" +img.getHeight()
		if(w!=0){
			if(h!=0){
				return img.getWidth()>w && img.getHeight()>h
			}else{
				return img.getWidth()>w
			}
		}else{
			return false;
		}
	}
}
