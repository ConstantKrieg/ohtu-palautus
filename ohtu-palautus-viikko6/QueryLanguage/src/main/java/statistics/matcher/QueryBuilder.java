
package statistics.matcher;


public class QueryBuilder {
    
    Matcher matcher;
    Matcher[] matchers;

    public QueryBuilder() {
        this.matcher = new MatcherStub();
    }

    

    
    
    public Matcher build(){
        return this.matcher;
    }
    
    public QueryBuilder hasAtLeast(int value, String category){
        this.matcher = new And(new HasAtLeast(value, category), this.matcher);
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category){
        this.matcher = new And(new HasFewerThan(value, category), this.matcher);
        return this;
    }
    
    public QueryBuilder playsIn(String team){
        this.matcher = new And(new PlaysIn(team), this.matcher);
        return this;
    }
    
    public QueryBuilder or(Matcher...matchers){
        this.matcher = new Or(matchers);
        return this;
    }
    
    
}
