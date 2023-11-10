package com.general.data.responseModel;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Group {
    private Object key;
    private List<Object> items;
    private Integer count;
    private Object[] summary;
}
