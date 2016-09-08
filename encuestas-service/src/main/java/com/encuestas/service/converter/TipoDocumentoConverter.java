/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import com.encuestas.data.bean.AreaBean;
import com.encuestas.data.bean.EmpresaBean;
import com.encuestas.data.bean.TipoDocumentoBean;
import com.encuestas.data.model.Area;
import com.encuestas.data.model.Empresa;
import com.encuestas.data.model.TipoDocumento;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author e00309
 */
public class TipoDocumentoConverter implements DataConverter<TipoDocumento, TipoDocumentoBean> {

    @Override
    public List<TipoDocumentoBean> convertList(List<TipoDocumento> dataList) {
        List<TipoDocumentoBean> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (TipoDocumento area : dataList) {
            data.add(convert(area));
        }
        return data;
    }

    @Override
    public TipoDocumentoBean convert(TipoDocumento tipoDocumento) {
        if (tipoDocumento == null) {
            return null;
        }
        TipoDocumentoBean tipoDocumentoBean = new TipoDocumentoBean();
        tipoDocumentoBean.setCoTipoDocumento(tipoDocumento.getCoTipoDocumento());
        tipoDocumentoBean.setDeCorto(tipoDocumento.getDeCorto());
        tipoDocumentoBean.setDeLarga(tipoDocumento.getDeLarga());
        
   
        return tipoDocumentoBean;
    }
    
}
