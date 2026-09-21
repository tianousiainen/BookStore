package homework.bookstore.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int _categoryid;
    private String _name;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "_category")
    private List<Book> books;


    public Category(String name) {
        _name = name;
    }

    public Category(){
        _name = null;
    }

    public void setCategoryid(int categoryid) {
        _categoryid = categoryid;
    }

    public void setName(String name) {
        _name = name;
    }

    public int getCategoryid() {
        return _categoryid;
    }

    public String getName() {
        return _name;
    }

    @Override
    public String toString() {
        return "Category [_categoryid=" + _categoryid + ", _name=" + _name + "]";
    }
}
