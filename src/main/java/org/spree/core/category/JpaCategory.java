package org.spree.core.category;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "category")
@Table(name = "categories", schema = "events")
public class JpaCategory implements Category {

    @Id
    private String name;

    public JpaCategory() {
    }

    public JpaCategory(Category category) {
        name = category.getName();
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
