package com.heiji.fenling


class LofterShengling extends Base implements Shengling {

	@Override
	public List<Ling> getAllUrl(Ling ling) {
		def re=[]
		if(ling==null){
			return null;
		}

		def allList=readUrlForA(ling?.link)+readUrlForImage(ling?.link)

		allList.each{
			Ling _Ling=new Ling();
			if(isList(it)){
				//级别没有超出范围
				println level() +"|"+ling.getLevel()
				if(level()>ling.getLevel()){

					//是列表
					_Ling.setLing(false)
					//升级level
					_Ling.setLevel(ling.getLevel()+1);
					_Ling.setLink(it);
					re<<_Ling;
				}
			}else if(isLink(it)){
				_Ling.setLing(true)
				_Ling.setLevel(-1);
				_Ling.setLink(it);
				re<<_Ling;
			}
		}
		return re;
	}

	@Override
	public int level() {
		return 10;
	}

	@Override
	public boolean isList(String url) { 
		if(url.contains("lofter.com")&&url.contains("page=")){
			return true;
		}else{
			return false;
		} 
	}

	@Override
	public boolean isLink(String url) {
		if(url.contains(".lofter.com/post")){
			return true;
		}else{

			return false;
		} 
	} 
	static main(args) {
		LofterShengling _LofterShengling=new LofterShengling();
		Ling ling =new Ling()
		ling.setLink("http://moody1988.lofter.com/")
		ling.setLevel(1);
		_LofterShengling.getAllUrl(ling).each{ println it.link +"|"+it.level };
	}

}
