
public class pagebean{
	    private int currentPage;//��ǰҳ��
	    private int countRecord;//�ܼ�¼��
	    private int countPage;//��ҳ����
	    private int sizePage;//ÿҳ��ʾ������
	    
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

