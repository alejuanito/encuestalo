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
public class TipoDocumentoBeanConverter implements DataConverter<TipoDocumentoBean, TipoDocumento> {

    @Override
    public List<TipoDocumento> convertList(List<TipoDocumentoBean> dataList) {
        List<TipoDocumento> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (TipoDocumentoBean area : dataList) {
            data.add(convert(area));
        }
        return data;
    }

    @Override
    public TipoDocumento convert(TipoDocumentoBean tipoDocumento) {
        if (tipoDocumento == null) {
            return null;
        }
        TipoDocumento tipoDocumentoBean = new TipoDocumento();
        tipoDocumentoBean.setCoTipoDocumento(tipoDocumento.getCoTipoDocumento());
        tipoDocumentoBean.setDeCorto(tipoDocumento.getDeCorto());
        tipoDocumentoBean.setDeLarga(tipoDocumento.getDeLarga());
        
   
        return tipoDocumentoBean;
    }
    
}
