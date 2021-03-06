/*
 * Copyright (c) 2008-2018 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.cuba.web.gui.components.table;

import com.haulmont.cuba.gui.components.data.TreeTableSource;
import com.haulmont.cuba.web.widgets.data.TreeTableContainer;

import java.util.Collection;
import java.util.List;

public class TreeTableDataContainer<I> extends SortableDataContainer<I> implements TreeTableContainer {

    // vaadin8 aggregation
    protected List<Object> aggregationProperties = null;

    public TreeTableDataContainer(TreeTableSource<I> tableDataSource,
                                  TableSourceEventsDelegate<I> dataEventsDelegate) {
        super(tableDataSource, dataEventsDelegate);
    }

    @Override
    public int getLevel(Object itemId) {
        return getItemLevel(itemId);
    }

    protected int getItemLevel(Object itemId) {
        Object parentId;
        if ((parentId = getParent(itemId)) == null) {
            return 0;
        }
        return getItemLevel(parentId) + 1;
    }

    @Override
    public Collection<?> getChildren(Object itemId) {
        return getTreeTableSource().getChildren(itemId);
    }

    protected TreeTableSource<Object> getTreeTableSource() {
        return (TreeTableSource<Object>) tableSource;
    }

    @Override
    public Object getParent(Object itemId) {
        return getTreeTableSource().getParent(itemId);
    }

    @Override
    public Collection<?> rootItemIds() {
        return getTreeTableSource().getRootItemIds();
    }

    @Override
    public boolean setParent(Object itemId, Object newParentId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean areChildrenAllowed(Object itemId) {
        return getTreeTableSource().hasChildren(itemId);
    }

    @Override
    public boolean setChildrenAllowed(Object itemId, boolean areChildrenAllowed) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isRoot(Object itemId) {
        return getTreeTableSource().isRoot(itemId);
    }

    @Override
    public boolean hasChildren(Object itemId) {
        return getTreeTableSource().hasChildren(itemId);
    }
}