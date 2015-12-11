package net.maxcode.trainingday.stackoverflow.data.api;

import net.maxcode.trainingday.stackoverflow.data.model.IEntity;

import java.util.List;

/**
 * Created by andreiverdes on 12/10/15.
 */

public class ApiResponse <T extends IEntity> {

    private List<T> items;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> pItems) {
        items = pItems;
    }
}
