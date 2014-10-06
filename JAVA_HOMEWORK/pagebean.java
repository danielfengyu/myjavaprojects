
public class pagebean{
	    private int currentPage;//当前页面
	    private int countRecord;//总记录数
	    private int countPage;//总页面数
	    private int sizePage;//每页显示的条数
	    
	    public void setAll(int _countRecord,int _sizePage){
	        this.countRecord=_countRecord;
	        this.sizePage=_sizePage;
	        if(countRecord%sizePage==0){
	            countPage=countRecord/sizePage;
	        }
	        else{
	            countPage=countRecord/sizePage+1;
	        }
	        currentPage=1;
	    }
	    public int getCurrentPage(){
	        return currentPage;
	    }
	    public int getCountPage(){
	        return countPage;
	    }
	    public int getCountRecord(){
	        return countRecord;
	    }
	    public int getSizePage(){
	        return sizePage;
	    }
	    public int perPage(){
	    	if(currentPage>1){
	    		return currentPage-1;
	    	}
	    	else{
	    		return 1;
	    	}
	    }
	    public int getNextPage(){
	    	if(currentPage<countPage){
	    		return (currentPage+1);
	    	}
	    	else{
	    		return countPage;
	    	}
	    }
	    public void setCurrentPage(int currentPage){
	        this.currentPage=currentPage;
	    }
	}

