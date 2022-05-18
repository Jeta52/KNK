package database;

public class FilterQueryBuilder extends AbstractQueryBuilder {
	public static FilterQueryBuilder create(String tableName) {
		return new FilterQueryBuilder(tableName);
	}
	
	private FilterQueryBuilder(String tableName) {
		super.tableName = tableName;
	}
	
	
	@Override
	public String getQuery() {
		
		if(this.whereValues.size() == 0) {
			return "SELECT * FROM " + super.tableName;
		}
		
		String whereAdditionalQuery = " WHERE ";
		String lastElement = (String) this.whereValues.get(this.whereValues.size() - 1)[0];
	
		
		for(Object[] e : this.whereValues)
		{
		    boolean isLastElement = e[0] == lastElement;
		    whereAdditionalQuery += e[0] + " = ? ";
		    if(!isLastElement) {
		    	whereAdditionalQuery += " AND ";
		    }
		}
		
		return "SELECT * FROM " + super.tableName +  whereAdditionalQuery; 
	}
	
	public String getTypes() {
		return this.whereTypes;
	}
	
	public Object[] getValues(){
		Object[] values = new Object[this.whereValues.size()];
		for(int i = 0; i < values.length; i++) {
			values[i] = this.whereValues.get(i)[1];
		}
		return values;
	}
}
