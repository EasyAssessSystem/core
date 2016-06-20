package com.stardust.easyassess.core.query;

public interface SelectionQueryProvider<T> {
    T toQueryObject(Selection selection);
}
