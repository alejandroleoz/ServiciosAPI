package utn.tp.poi;

import java.util.HashSet;
import java.util.Set;

public abstract  class AbstractRepo<T> {
    private Set<T> items = new HashSet<T>();

    /**
     * Default constructor
     */
    public AbstractRepo() {
    }

    /**
     * Contructor with initial data
     *
     * @param initialData
     */
    public AbstractRepo(Set<T> initialData) {
        if (initialData != null) {
            items.addAll(initialData);
        }
    }

    /**
     * Adds a new entry
     *
     * @param item
     * @return
     */
    public boolean addItem(T item) {
        return this.items.add(item);
    }

    /**
     * Removes given entry
     *
     * @param item
     * @return
     */
    public boolean removeItem(T item) {
        return this.items.remove(item);
    }

    public Set<T> getItems() {
        return items;
    }
}
