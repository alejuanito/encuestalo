package com.encuestas.service;

import java.util.List;

import com.encuestas.data.bean.RolBean;
import com.encuestas.service.exception.DataValidationErrorException;

public interface RolService {

    public List<RolBean> listAll ();
    
    public RolBean load (Integer idRol);

    public RolBean create (RolBean rolBean) throws DataValidationErrorException;

    public RolBean update (RolBean rolBean) throws DataValidationErrorException;
}
