/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import java.util.List;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author e00309
 */
public interface DataConverter<S, T> extends Converter<S, T>{
    
    public List<T> convertList (List<S> dataList);
    
}
