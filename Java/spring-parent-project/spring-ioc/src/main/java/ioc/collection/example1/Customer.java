package ioc.collection.example1;

import java.util.*;

public class Customer {

    private List<Object> lists;
    private Set<Object> sets;
    private Map<Object, Object> maps;
    private Properties pros;

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Set<Object> getSets() {
        return sets;
    }

    public void setSets(Set<Object> sets) {
        this.sets = sets;
    }

    public Map<Object, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<Object, Object> maps) {
        this.maps = maps;
    }

    public Properties getPros() {
        return pros;
    }

    public void setPros(Properties pros) {
        this.pros = pros;
    }



    private List<Object> values ;//= new ArrayList<Object>();

    public List<Object> getValues() {
        return values;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }


    @Override
    public String toString() {
        return "Customer \n[LIST =" + lists + "\n, SET=" + sets + "\n, MAP=" + maps
                + "\n, PROPERTIES=" + pros +  "\n, ARRAY LIST=" + values +"]";
    }
}