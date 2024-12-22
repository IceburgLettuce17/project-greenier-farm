package com.facebook.widget;

import android.database.CursorIndexOutOfBoundsException;
import com.facebook.model.GraphObject;
import java.util.ArrayList;
import java.util.Collection;

class SimpleGraphObjectCursor<T extends GraphObject> implements GraphObjectCursor<T> {
    private boolean closed;
    private boolean fromCache;
    private ArrayList<T> graphObjects;
    private boolean moreObjectsAvailable;
    private int pos;

    SimpleGraphObjectCursor() {
        this.pos = -1;
        this.closed = false;
        this.graphObjects = new ArrayList<>();
        this.moreObjectsAvailable = false;
        this.fromCache = false;
    }

    SimpleGraphObjectCursor(SimpleGraphObjectCursor<T> simpleGraphObjectCursor) {
        this.pos = -1;
        this.closed = false;
        this.graphObjects = new ArrayList<>();
        this.moreObjectsAvailable = false;
        this.fromCache = false;
        this.pos = simpleGraphObjectCursor.pos;
        this.closed = simpleGraphObjectCursor.closed;
        this.graphObjects = new ArrayList<>();
        this.graphObjects.addAll(simpleGraphObjectCursor.graphObjects);
        this.fromCache = simpleGraphObjectCursor.fromCache;
    }

    public void addGraphObjects(Collection<T> collection, boolean z) {
        this.graphObjects.addAll(collection);
        this.fromCache |= z;
    }

    @Override
    public boolean areMoreObjectsAvailable() {
        return this.moreObjectsAvailable;
    }

    @Override
    public void close() {
        this.closed = true;
    }

    @Override
    public int getCount() {
        return this.graphObjects.size();
    }

    @Override
    public T getGraphObject() {
        if (this.pos < 0) {
            throw new CursorIndexOutOfBoundsException("Before first object.");
        }
        if (this.pos >= this.graphObjects.size()) {
            throw new CursorIndexOutOfBoundsException("After last object.");
        }
        return this.graphObjects.get(this.pos);
    }

    @Override
    public int getPosition() {
        return this.pos;
    }

    @Override
    public boolean isAfterLast() {
        int count = getCount();
        return count == 0 || this.pos == count;
    }

    @Override
    public boolean isBeforeFirst() {
        return getCount() == 0 || this.pos == -1;
    }

    @Override
    public boolean isClosed() {
        return this.closed;
    }

    @Override
    public boolean isFirst() {
        return this.pos == 0 && getCount() != 0;
    }

    @Override
    public boolean isFromCache() {
        return this.fromCache;
    }

    @Override
    public boolean isLast() {
        int count = getCount();
        return this.pos == count + (-1) && count != 0;
    }

    @Override
    public boolean move(int i) {
        return moveToPosition(this.pos + i);
    }

    @Override
    public boolean moveToFirst() {
        return moveToPosition(0);
    }

    @Override
    public boolean moveToLast() {
        return moveToPosition(getCount() - 1);
    }

    @Override
    public boolean moveToNext() {
        return moveToPosition(this.pos + 1);
    }

    @Override
    public boolean moveToPosition(int i) {
        int count = getCount();
        if (i >= count) {
            this.pos = count;
            return false;
        }
        if (i < 0) {
            this.pos = -1;
            return false;
        }
        this.pos = i;
        return true;
    }

    @Override
    public boolean moveToPrevious() {
        return moveToPosition(this.pos - 1);
    }

    public void setFromCache(boolean z) {
        this.fromCache = z;
    }

    public void setMoreObjectsAvailable(boolean z) {
        this.moreObjectsAvailable = z;
    }
}
